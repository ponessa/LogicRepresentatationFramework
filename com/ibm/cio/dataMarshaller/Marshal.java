package com.ibm.cio.dataMarshaller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ibm.cio.exceptions.DataMarshalException;
import com.ibm.cio.utils.XmlDomHelpers;
/**
 * Marshalling is the process of transforming a string or memory representation of an object to a data format suitable for processing.
 * <p>
 * Data marshalling is the pulling of data from an outside source and loading it into a Java object and vice versa.  
 * The Data Marshal is a dynamic component that will allows for data transformations to occur based on the metadata returned from a 
 * BMS DaaS RESTful service; where the contents of the metadata is not know until runtime.  </p>
 * <p>
 * The metadata is returned by specifying the <code><b>md=true</b></code> parameter as part of the DaaS service URL.  The result set metadata
 * looks like this:
 * </p>
 * <pre>
 * &lt;result-set-metadata&gt;
 * 		&lt;column columnLabel="PARTITION_ID" columnName="PARTITION_ID" datatype="CHAR" nullable="0" precision="3" scale="0" schema="BMSIW" size="3" table="FORECAST_DETAIL_V"/&gt;
 * 		&lt;column columnLabel="RECORD_TYPE" columnName="RECORD_TYPE" datatype="CHAR" nullable="0...&gt;
 * 		...
 * &lt;/result-set-metadata&gt;
 * </pre>
 * <p>
 * The framework uses Java Reflection to create a reusable solution for data marshalling.  The class allows the creation of service layers that do not require compile-time 
 * knowledge of the specific systems they will support.  Reflection is the mechanism by which Java exposes the features of a class during runtime, allowing Java programs to enumerate and access a class’ methods, fields, and constructors as objects.  In other words, there are object based mirrors which reflect the Java object model, and you can use these objects to access an object&apos;s features using runtime API constructs instead of compile time language constructs.</p>
 * <p>
 * To call a service and marshal the results into a usable object, you need to have pre-defined a POJO (Plain Old Java Object).  This POJO can 
 * be generated for you using the {@link com.ibm.cio.utils.DaasDataClassGenerator}.</p>
 * <p>
 * To use the Marshaller simply</p>
 * <ol>
 * 		<li>Instantiate a Marshal instance passing the DaaS URL and the name of the target POJO</li>
 * 		<li>Call the object's <code><b>load()</b></code> method.  This returns an array of POJO objects</li>
 * 		<li>Thereafter you can use the static <code><b>Marshal.getAttribute()</b></code>, passing in the POJO object and the name of the attribute you want</li>
 * </ol>
 * @see com.ibm.cio.utils.DaasDataClassGenerator
 *
 */
public class Marshal {
	static Logger logger = Logger.getLogger("com.ibm.cio.dataMarshaller.Marshal");
	
	private SqlMap sqlMap = null;
	private String encodingSchema="utf-8";
	private String serviceUrl = null;
	private String businessObjectClassName = null;
	private boolean debug = false;
	
	public Marshal(String serviceUrl, String businessObjectClassName, boolean debug) {
		this(serviceUrl, "utf-8", businessObjectClassName, debug);
	}
	
	public Marshal(String serviceUrl, String businessObjectClassName) {
		this(serviceUrl, "utf-8", businessObjectClassName, false);
	}
	
	public Marshal(String serviceUrl, String encodingSchema, String businessObjectClassName, boolean debug) {
		this.serviceUrl = serviceUrl;
		this.encodingSchema = encodingSchema;
		this.businessObjectClassName = businessObjectClassName;
	}
	
	public static void main(String[] args) {
				
		logger.info("I0001: Marshal started at " + String.valueOf(new java.util.Date()));
		String serviceUrl = null;
		String id=null;
		String fullClassName = null;
		String testAttrName = null;
		boolean debug = false;
		boolean validParams = true;

		try {
			for (int optind = 0; optind < args.length; optind++) {
				if (args[optind].equalsIgnoreCase("-url")) {
					serviceUrl = args[++optind];	
				} else if (args[optind].equalsIgnoreCase("-c")) {
					fullClassName = args[++optind];	
				} else if (args[optind].equalsIgnoreCase("-i")) {
					id = args[++optind];	
				} else if (args[optind].equalsIgnoreCase("-testAttrNm")) {
					testAttrName = args[++optind];
				} else if (args[optind].equalsIgnoreCase("-d") || args[optind].equalsIgnoreCase("-debug")) {
					debug = true;
				} else if (args[optind].equalsIgnoreCase("-help")) {
					validParams = false;  
				} else {
					logger.error("E0001: Unknown parameter specified: " + args[optind]);
					validParams = false;                  
				}
			} //end - for (int optind = 0; optind < args.length; optind++)
		} //end try
		catch (Exception e) {
			logger.warn("W0001: Error processing input parameters.  " + e.getMessage());
			e.printStackTrace();
			validParams = false;
		}
		if (id != null) serviceUrl = "http://bms3.sby.ibm.com/bms/iw/rest/?id="+id+"&s=DaaS&f=xml&md=true";
		if (serviceUrl==null || fullClassName==null) validParams = false;

		if (!validParams) {
			logger.info("USAGE - To DaasDataClassGenerator");
			logger.info("java com.ibm.o2c.tools.RestfulServiceReader ");
			logger.info("      -url service_url");		
			logger.info("     [-e encoding_schema]");
			logger.info("     [-f format]");
			logger.info("     [-o output_file_name]");
			logger.info("     [-help|-h]");
			logger.info("Where:");
			logger.info("------");
			logger.info("-o output_file_name");
			logger.info("\tOutput file name");
			logger.info("-url service_url");
			logger.info("\tThe URL of the RESTful service.");	
			logger.info("-f format [optional | default=csv]");
			logger.info("\tThe format of the data returned from the RESTful service.");	
			logger.info("\tValues are CSV, XML, JSON, and fixed.");
			logger.info("-help|-h [optional] Help flag");
			logger.info("\tDisplays this help/usage text.");      
		} 	
		else {
			Marshal m = new Marshal(serviceUrl, fullClassName);
			ArrayList<Object> l = m.load();
			
			if (testAttrName!=null) {	
				System.out.println(Marshal.getAttribute(l.get(0), testAttrName));
			}
		}	
		
		
		/*
		MyObject myObject = new MyObject();
		myObject.setCtryCd("877");
		
		String ctryCd = (String)Marshal.getAttribute(myObject, "ctryCd");
		
		System.out.println("myObject.ctryCd = " + ctryCd);
		String owngLobCd = "Other";
		if (ctryCd.equals("897")) owngLobCd="US";
		
		Marshal.setAttribute(myObject, "owngLobCd", owngLobCd);
		
		System.out.println("set myObject.owningLobCd = "+Marshal.getAttribute(myObject, "owngLobCd"));
		
		Marshal.setAttribute(myObject, "myDoubleObjectAmt", new Double(59.22));		
		System.out.println("set myObject.myDoubleObjectAmt = "+Marshal.getAttribute(myObject, "myDoubleObjectAmt"));		
		
		Marshal.setAttribute(myObject, "myDoublePrimativeAmt", 432.21);	
		System.out.println("set myDoublePrimativeAmt = "+Marshal.getAttribute(myObject, "myDoublePrimativeAmt"));
		
		Marshal.setAttribute(myObject, "myIntegerObjectAmt", new Integer(521));	
		System.out.println("set myIntegerObjectAmt = "+Marshal.getAttribute(myObject, "myIntegerObjectAmt"));
		
		Marshal.setAttribute(myObject, "myIntegerPrimativeAmt", 125);	
		System.out.println("set myIntegerPrimativeAmt = "+Marshal.getAttribute(myObject, "myIntegerPrimativeAmt"));
		
		Marshal.setAttribute(myObject, "myBooleanObjectFlg", new Boolean(false));	
		System.out.println("set myBooleanObjectFlg = "+Marshal.getAttribute(myObject, "myBooleanObjectFlg"));
		
		Marshal.setAttribute(myObject, "myBooleanPrimativeFlg", false);	
		System.out.println("set myBooleanPrimativeFlg = "+Marshal.getAttribute(myObject, "myBooleanPrimativeFlg"));
		
		Marshal.setAttribute(myObject, "myFloatObjectFlt", new Float(99.9f));	
		System.out.println("set myFloatObjectFlt = "+Marshal.getAttribute(myObject, "myFloatObjectFlt"));
		
		Marshal.setAttribute(myObject, "myFloatPrimativeFlt", 88.8f);	
		System.out.println("set myFloatPrimativeFlt = "+Marshal.getAttribute(myObject, "myFloatPrimativeFlt"));
		
		Marshal.setAttribute(myObject, "myLongObjectLng", new Long(99l));	
		System.out.println("set myLongObjectLng = "+Marshal.getAttribute(myObject, "myLongObjectLng"));
		
		Marshal.setAttribute(myObject, "myLongPrimativeLng", 88l);	
		System.out.println("set myLongPrimativeLng = "+Marshal.getAttribute(myObject, "myLongPrimativeLng"));
		
		Marshal.setAttribute(myObject, "myShortObjectShort", new Short("8"));	
		System.out.println("set myShortObjectShort = "+Marshal.getAttribute(myObject, "myShortObjectShort"));
		
		Marshal.setAttribute(myObject, "myShortPrimativeShort", (short)88);	
		System.out.println("set myShortPrimativeShort = "+Marshal.getAttribute(myObject, "myShortPrimativeShort"));
		
		Marshal.setAttribute(myObject, "myByteObjectByt", new Byte("10"));	
		System.out.println("set myByteObjectByt = "+Marshal.getAttribute(myObject, "myByteObjectByt"));
		
		byte b = (byte)8;
		Marshal.setAttribute(myObject, "myBytePrimativeByt", b);	
		System.out.println("set myBytePrimativeByt = "+Marshal.getAttribute(myObject, "myBytePrimativeByt"));
		
		Marshal.setAttribute(myObject, "myCharObjectChr", new Character('8'));	
		System.out.println("set myCharObjectChr = "+Marshal.getAttribute(myObject, "myCharObjectChr"));
		
		Marshal.setAttribute(myObject, "myCharPrimativeChr", 'x');	
		System.out.println("set myCharPrimativeChr = "+Marshal.getAttribute(myObject, "myCharPrimativeChr"));
		
		Marshal.setAttribute(myObject, "myDate", new java.util.Date());	
		System.out.println("set myDate = "+Marshal.getAttribute(myObject, "myDate"));
		*/
	}
	
	/**
	 * Loads the returned values from the RESTful service into a list of POJO objects defined by the business class object name passed to the constructor.
	 * <p>
	 * The RESTful service URL must request that the result set metadata be returned with the result set since the method uses the attributes in the 
	 * returned metadata to construct and populate the business objects.
	 * 
	 * @return list of business class objects populated by the RESTful service
	 */
	
	public ArrayList<Object> load() throws DataMarshalException {
		ArrayList<Object> businessObjectArray = null;
		try {
			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

			String encodingSchema="utf-8";
			//Define the DaaS URL.  
			URL serviceUrl =  new URL(this.serviceUrl);
			
			/* Create a DOM Document Builder factory object that enables applications to 
			 * obtain a parser that produces DOM object trees from XML documents.  
			 * The newInstance() method of the javax.xml.parsers.DocumentBuilderFactory object 
			 * is a static method used creates a new factory instance */
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			
			/* Create a Document Builder object to obtain a DOM Document instances from an XML 
			 * document.  Using this class, the code parses and XML document and creates a 
			 * org.w3c.dom.Document object.  The newDocumentBuilder() method of the 
			 * javax.xml.parsers.DocumentBuilderFactory object creates a new instance of a 
			 * javax.xml.parsers.DocumentBuilder object using the currently configured parameters */
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			/* Create a org.w3c.dom.Document document.  
			 * Since the stream will be small we are using DOM for parsing.  Thereafter parse the 
			 * content of the given InputStream as an XML document and return a new DOM 
			 * (org.w3c.dom.Document) object */
			Document doc = db.parse(serviceUrl.openStream(), "utf-8");
			
			/* Get the root element (org.w3c.dom.Element) from the newly created Document object. */
			//Element root = doc.getDocumentElement();
			Element rootElement = doc.getDocumentElement();	
			
			Element titleElement = (Element)rootElement.getElementsByTagName("title").item(0);
			String title = (titleElement==null
								? null
								:(titleElement.getFirstChild()==null
								? null
								: titleElement.getFirstChild().getNodeValue().trim()));	
			
			HashMap map = new HashMap();
			Element rsmdElement = (Element)rootElement.getElementsByTagName("result-set-metadata").item(0);
			NodeList columnNodeList = rsmdElement.getElementsByTagName("column");
			for (int i=0; i<columnNodeList.getLength(); i++) {
				/* Retrieve the first/next element from the list */
				Element columnElement = (Element) columnNodeList.item(i);
				
				/* Use the com.ibm.02c.utils.XmlDomHelpers.getAttributeValue() static function
				 * to get the current element’s attribute’s values */
				String schema = XmlDomHelpers.getAttributeValue(columnElement,"schema");
				String tableName = XmlDomHelpers.getAttributeValue(columnElement,"table");
				String name = XmlDomHelpers.getAttributeValue(columnElement,"columnLabel");
				String columnName = XmlDomHelpers.getAttributeValue(columnElement,"columnName");
				String dataType = XmlDomHelpers.getAttributeValue(columnElement,"datatype");
				String sizeString = XmlDomHelpers.getAttributeValue(columnElement,"size");
				int size = (sizeString==null?-1:Integer.parseInt(sizeString));
				String scaleString = XmlDomHelpers.getAttributeValue(columnElement,"scale");
				int scale = (scaleString==null?-1:Integer.parseInt(scaleString));
				String precisionString = XmlDomHelpers.getAttributeValue(columnElement,"precision");
				int precision = (precisionString==null?-1:Integer.parseInt(precisionString));
				String nullableString = XmlDomHelpers.getAttributeValue(columnElement,"nullable");
				boolean nullable = false;
				if (nullableString!=null && nullableString.equalsIgnoreCase("1")) nullable=true;
				//DbColumn(String schema, String tableName, String columnName, String name, String dataType, int size, int precission, boolean nullable, int scale)
				map.put(name, new DbColumn(schema, tableName, name, columnName, dataType, size, precision, nullable, scale));
								
			} //end - for (int i=0; i<attributeNodeList.getLength(); i++)
			
			sqlMap = new SqlMap(this.serviceUrl, this.businessObjectClassName, map);
			
			Element recordGroupElement = (Element)rootElement.getElementsByTagName("record-group").item(0);
			Element detailElement = (Element)recordGroupElement.getElementsByTagName("detail").item(0);
			NodeList rowNodeList = detailElement.getElementsByTagName("row");
			for (int i=0; i<rowNodeList.getLength(); i++) {
				/* Retrieve the first/next element from the list */
				Element rowElement = (Element) rowNodeList.item(i);

				Class klass = Class.forName(this.businessObjectClassName);
				Object businessObject = klass.newInstance();	
			
				//Class[] parmType = { Certify.class };
				//Constructor constructor = klass.getConstructor(parmType);
				//Object[] constructorArgs = { certify };
				//Object businessObject = constructor.newInstance(constructorArgs);
				
				if (businessObjectArray==null) businessObjectArray = new ArrayList<Object>(rowNodeList.getLength());
				businessObjectArray.add(businessObject);
				
				Class[] paramTypes = new Class[1];
				Object[] methodArgs = new Object[1];
				Method setMethod = null; 
				
			    Node childNode = rowElement.getFirstChild();     
			    while( childNode.getNextSibling()!=null ){          
			        childNode = childNode.getNextSibling();         
			        if (childNode.getNodeType() == Node.ELEMENT_NODE) {         
			            Element childElement = (Element) childNode; 
			            
			            String dbColumnName = childElement.getNodeName();
			            String dbColumnValue = childElement.getTextContent();
			            
			            if (debug==true) System.out.println("Node Name / value: " + dbColumnName + "\t/\t" + dbColumnValue);
			            
			            DbColumn dbColumn = this.sqlMap.get(dbColumnName);
			            
						switch(dbColumn.getDataTypeEnum()) {
							case DbColumn.TYPE_CHAR:
							case DbColumn.TYPE_VARCHAR:
								paramTypes[0] = String.class;
								setMethod = klass.getMethod("set"+dbColumnName, paramTypes);
								methodArgs[0] = dbColumnValue;
								setMethod.invoke(businessObject, methodArgs);
							break;
							case DbColumn.TYPE_SMALLINT:
							case DbColumn.TYPE_INTEGER:
								paramTypes[0] = Integer.TYPE;
								setMethod = klass.getMethod("set"+dbColumnName, paramTypes);
								methodArgs[0] = new Integer(dbColumnValue);
								setMethod.invoke(businessObject, methodArgs);
							break;	
							case DbColumn.TYPE_DECIMAL:
							case DbColumn.TYPE_DOUBLE:
							case DbColumn.TYPE_REAL:
								paramTypes[0] = Double.TYPE;
								setMethod = klass.getMethod("set"+dbColumnName, paramTypes);
								methodArgs[0] = new Double(dbColumnValue);
								setMethod.invoke(businessObject, methodArgs);
							break;
							//case DbColumn.TYPE_TIMESTAMP:
							//	paramTypes[0] = Timestamp.class;
							//	setMethod = klass.getMethod("set"+dbColumnName, paramTypes);
							//	methodArgs[0] = new Timestamp();
							//	setMethod.invoke(businessObject, methodArgs);
							//break;
							case DbColumn.TYPE_DATE:
								paramTypes[0] = Date.class;
								setMethod = klass.getMethod("set"+dbColumnName, paramTypes);
								methodArgs[0] =  dateFormatter.parse(dbColumnValue);
								setMethod.invoke(businessObject, methodArgs);
							break;							
	
						} //end switch			            
			        }       
			    }
			}				
			return businessObjectArray;
		}
		catch (MalformedURLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new DataMarshalException("MalformedURLException: "+e.getMessage());
		}
		catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new DataMarshalException("MalformedURLException: "+e.getMessage());}
		catch (ParseException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new DataMarshalException("MalformedURLException: "+e.getMessage());}
		catch (NoSuchMethodException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new DataMarshalException("MalformedURLException: "+e.getMessage());}
		catch (SAXException e) {}
		catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new DataMarshalException("MalformedURLException: "+e.getMessage());}
		catch (InstantiationException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new DataMarshalException("MalformedURLException: "+e.getMessage());}
		catch (IllegalAccessException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new DataMarshalException("MalformedURLException: "+e.getMessage());}
		catch (InvocationTargetException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new DataMarshalException("MalformedURLException: "+e.getMessage());}
		catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new DataMarshalException("MalformedURLException: "+e.getMessage());
		}
		return null;
		
	}
	
	public static Object getAttribute(Object o, String attrNm) {
		StringBuilder methodNm = new StringBuilder(attrNm.length());
		//methodNm.append("get").append(attrNm.substring(0,1).toUpperCase()).append(attrNm.substring(1));
		methodNm.append("get").append(attrNm);
		try {
			//Class klass = Class.forName("com.ibm.bms.revalidation.businessObjects.MyObject");
			Class klass = o.getClass();
			
			Method getMethod = klass.getMethod(methodNm.toString(), null);
			//System.out.println(String.valueOf(getMethod.invoke(businessObject, null)).trim());
			return (Object)getMethod.invoke(o, null);
		}
		catch(IllegalAccessException e) {
			e.printStackTrace();
		}
		catch(NoSuchMethodException e) {
			e.printStackTrace();
		}
		catch(InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void setAttribute(Object o, String attrNm, Object setValue) {
		setAttribute(o, attrNm, setValue, setValue.getClass());
	}
	
	public static void setAttribute(Object o, String attrNm, double setValue) {
		setAttribute(o, attrNm, setValue, Double.TYPE);		
	}
	
	public static void setAttribute(Object o, String attrNm, float setValue) {
		setAttribute(o, attrNm, setValue, Float.TYPE);		
	}
	
	public static void setAttribute(Object o, String attrNm, long setValue) {
		setAttribute(o, attrNm, setValue, Long.TYPE);		
	}
	
	public static void setAttribute(Object o, String attrNm, short setValue) {
		setAttribute(o, attrNm, setValue, Short.TYPE);		
	}
	
	public static void setAttribute(Object o, String attrNm, int setValue) {
		setAttribute(o, attrNm, setValue, Integer.TYPE);	
	}
	
	public static void setAttribute(Object o, String attrNm, boolean setValue) {
		setAttribute(o, attrNm, setValue, Boolean.TYPE);	
	}
	
	public static void setAttribute(Object o, String attrNm, byte setValue) {
		setAttribute(o, attrNm, setValue, Byte.TYPE);	
	}
	
	public static void setAttribute(Object o, String attrNm, char setValue) {
		setAttribute(o, attrNm, setValue, Character.TYPE);	
	}
	
	private static void setAttribute(Object o, String attrNm, Object setValue, Class parmClass) {
		StringBuilder methodNm = new StringBuilder(attrNm.length());
		methodNm.append("set").append(attrNm.substring(0,1).toUpperCase()).append(attrNm.substring(1));
		try {
			//Class klass = Class.forName("com.ibm.bms.revalidation.businessObjects.MyObject");
			Class klass = o.getClass();
			
			//Object businessObject = klass.newInstance();
			Class[] paramTypes = new Class[1];
			
			paramTypes[0] = parmClass; //setValue.getClass();
			Method setMethod = klass.getMethod(methodNm.toString(), paramTypes);
			
			Object[] params = {setValue};
			setMethod.invoke(o, params);
		}
		catch(IllegalAccessException e) {
			e.printStackTrace();
		}
		catch(NoSuchMethodException e) {
			e.printStackTrace();
		}
		catch(InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
}
