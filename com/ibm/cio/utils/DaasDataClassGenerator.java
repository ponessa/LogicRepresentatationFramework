package com.ibm.cio.utils;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DaasDataClassGenerator {
	static Logger logger = Logger.getLogger(DaasDataClassGenerator.class);

	private static final String newLine = System.getProperty("line.separator").toString();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		logger.info("I0001: ServiceMapper started at " + String.valueOf(new java.util.Date()));
		String outputFileName = null;
		String serviceUrl = null;
		String id=null;
		String fullClassName = null;
		boolean validParams = true;

		try {
			for (int optind = 0; optind < args.length; optind++) {
				if (args[optind].equalsIgnoreCase("-o")) {
					outputFileName = args[++optind];
				} else if (args[optind].equalsIgnoreCase("-url")) {
					serviceUrl = args[++optind];	
				} else if (args[optind].equalsIgnoreCase("-c")) {
					fullClassName = args[++optind];	
				} else if (args[optind].equalsIgnoreCase("-id")) {
					id = args[++optind];
				} else if (args[optind].equalsIgnoreCase("-o")) {
					outputFileName = args[++optind];					
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
		if (serviceUrl==null) validParams = false;

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
			String packageName = fullClassName.substring(0, fullClassName.lastIndexOf('.'));
			String className = fullClassName.substring(fullClassName.lastIndexOf('.')+1, fullClassName.length());
			if (outputFileName==null) {
				String s = DaasDataClassGenerator.generate(serviceUrl, packageName, className);
				System.out.println(s);
			}
			else {
				
			}
		}
	}
	
	public static String generate(String url, String packageName , String className) {
		/* The process first needs to parse the document to insert a <packageName> and <className> XML element ito the
		 * returned meta-data.
		 */
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance(); 
		domFactory.setIgnoringComments(true);
		Document doc = null;
		try {
			DocumentBuilder builder = domFactory.newDocumentBuilder(); 
			//Document doc = builder.parse(RestfulServiceReader.readRestfulService(url)); 
			InputSource is = new InputSource();
		    is.setCharacterStream(new StringReader(RestfulServiceReader.readRestfulService(url)));
		    doc = builder.parse(is);
			Element rootElement = doc.getDocumentElement();	
			Text packageText = doc.createTextNode(packageName); 
			Element packageElement = doc.createElement("packageName"); 
			packageElement.appendChild(packageText); 
			Text classText = doc.createTextNode(className); 
			Element classElement = doc.createElement("className"); 
			classElement.appendChild(classText); 
			rootElement.appendChild(packageElement);
			rootElement.appendChild(classElement);
			
			System.out.println(DaasDataClassGenerator.getStringFromDocument(doc));

			return(XslRenderer.render(doc, "businessDataClassGenerator.xsl"));		
		}
		catch(SAXException e) {
			logger.fatal(e.getMessage());
			e.printStackTrace();
			return null;
		}
		catch(ParserConfigurationException e) {
			logger.fatal(e.getMessage());
			e.printStackTrace();
			return null;
		}
		catch(IOException e) {
			logger.fatal(e.getMessage());
			e.printStackTrace();
			return null;
		}
		//return XslRenderer.render(DaasDataClassGenerator.getStringFromDocument(doc), "businessDataClassGenerator.xsl");		
	}
	
	public static boolean generate(String url, String packageName , String className, String outputFileName) {
		/* The process first needs to parse the document to insert a <packageName> and <className> XML element ito the
		 * returned meta-data.
		 */
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance(); 
		domFactory.setIgnoringComments(true);
		Document doc = null;
		try {
			DocumentBuilder builder = domFactory.newDocumentBuilder(); 
			//Document doc = builder.parse(RestfulServiceReader.readRestfulService(url)); 
			InputSource is = new InputSource();
		    is.setCharacterStream(new StringReader(RestfulServiceReader.readRestfulService(url)));
		    doc = builder.parse(is);
			Element rootElement = doc.getDocumentElement();	
			Text packageText = doc.createTextNode(packageName); 
			Element packageElement = doc.createElement("packageName"); 
			packageElement.appendChild(packageText); 
			Text classText = doc.createTextNode(className); 
			Element classElement = doc.createElement("className"); 
			classElement.appendChild(classText); 
			rootElement.appendChild(packageElement);
			rootElement.appendChild(classElement);
			
			System.out.println(DaasDataClassGenerator.getStringFromDocument(doc));

			return(XslRenderer.renderToFile(doc, "businessDataClassGenerator.xsl", outputFileName));				
		}
		catch(SAXException e) {
			logger.fatal(e.getMessage());
			e.printStackTrace();
			return false;
		}
		catch(ParserConfigurationException e) {
			logger.fatal(e.getMessage());
			e.printStackTrace();
			return false;
		}
		catch(IOException e) {
			logger.fatal(e.getMessage());
			e.printStackTrace();
			return false;
		}
		//return XslRenderer.render(DaasDataClassGenerator.getStringFromDocument(doc), "businessDataClassGenerator.xsl");		
	}	
	
	// method to convert Document to String
	public static String getStringFromDocument(Document doc) {
		try {
			DOMSource domSource = new DOMSource(doc);
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.transform(domSource, result);
			return writer.toString();
		} catch (TransformerException ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
