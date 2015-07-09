package com.ibm.cio.utils;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Node;

/**
 * @author ponessa
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class XslRenderer {

	public static void main(String[] args) {
		System.out.println("I0001: Test started at " + String.valueOf(new java.util.Date()));
		String xmlFileName = null;
		String xslFileName = null;
		String outputFileName = null;
		boolean validParams = true;

		try {
		for (int optind = 0; optind < args.length; optind++) {
			if (args[optind].equalsIgnoreCase("-XML")) {
				xmlFileName = args[++optind];
			} else if (args[optind].equalsIgnoreCase("-XSL")) {
				xslFileName = args[++optind];
			} else if (args[optind].equalsIgnoreCase("-OUT")) {
				outputFileName = args[++optind];	
			} else if (args[optind].equalsIgnoreCase("-help")) {
				validParams = false;  
			} else if (args[optind].equalsIgnoreCase("-h")) {
				validParams = false;  
			} else {
				System.out.println("E0001: Unknown parameter specified: " + args[optind]);
				validParams = false;                  
			}
		} //end - for (int optind = 0; optind < args.length; optind++)
		} //end try
		catch (Exception e) {
			System.out.println("E0001: Error processing input parameters.  " + e.getMessage());
			e.printStackTrace();
			validParams = false;
		}
		if (xmlFileName == null || xslFileName == null || outputFileName == null) validParams = false;

		if (!validParams) {
			System.out.println("USAGE - To Renderer");
			System.out.println("java com.ibm.isls.utils.Renderer -xml xml_file_name ");
			System.out.println("     -xsl xsl_file_name -out output_file_name");
			System.out.println("     [-help|-h]");
			System.out.println("Where:");
			System.out.println("------");
			System.out.println("-xml xml_file_name");
			System.out.println("\tXML file to be parsed");
			System.out.println("-xsl xsl_file_name");
			System.out.println("\tXSL stylesheet used to drive the rendering");
			System.out.println("-out [output file name] output_file_name");
			System.out.println("\tName of output data set");
			System.out.println("-help|-h [optional] Help flag");
			System.out.println("\tDisplays this help/usage text.");      
		} 	
		else {
			if (outputFileName==null) {
				String result=XslRenderer.render(xmlFileName, xslFileName);
				if (result!=null) {
					System.out.println("I0099: Test completed successfully at " + String.valueOf(new java.util.Date()));
					System.out.println(result);
				}
				else
					System.out.println("E0099: Test failed at " + String.valueOf(new java.util.Date()));
			}
			else {
				if (XslRenderer.renderToFile(xmlFileName, xslFileName, outputFileName))
					System.out.println("I0099: Test completed successfully at " + String.valueOf(new java.util.Date()));
				else
					System.out.println("E0099: Test failed at " + String.valueOf(new java.util.Date()));
			}
		}
	}
	
	public static boolean renderToFile(String xmlFileName, String xslFileName, String outputFileName) {		
		try {
			File xmlFile = new File(xmlFileName);
			File xslFile = new File(xslFileName);
			File outputFile = new File(outputFileName);
			
			System.out.println("I0006 Preparing to render "+outputFileName + " from XML file " + xmlFile + " using XSL stylesheet " + xslFile);			
		
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer(new StreamSource(xslFile));
			
			StreamSource xmlStreamSource = new StreamSource(xmlFile);			
			transformer.transform(xmlStreamSource, new StreamResult(outputFile));
			System.out.println("I0014 HTML output rendered successfully.");
		}
		catch (TransformerConfigurationException e) {
			System.out.println("E9001 XSLT Error encountered (TransformerConfigurationException).  Message: " + e.getMessage());
			e.printStackTrace();
			return false;	
		}	
		catch (TransformerException e) {
			System.out.println("E9001 XSLT Error encountered (TransformerException).  Message: " + e.getMessage());
			e.printStackTrace();
			return false;				
		}		
		return true;
	}
	
	public static String render(String xmlStr, String xslFileName) {	
		String renderedOutput = null;
		try {
			File xslFile = new File(xslFileName);
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer(new StreamSource(xslFile));
			
			StreamSource xmlStreamSource = new StreamSource(new StringReader(xmlStr));	//
			
			Writer outWriter = new StringWriter();			
			transformer.transform(xmlStreamSource, new StreamResult(outWriter));
			
			renderedOutput = outWriter.toString();
			
			//System.out.println("I0014 HTML output rendered successfully.");
		}
		catch (TransformerConfigurationException e) {
			System.out.println("E9001 XSLT Error encountered (TransformerConfigurationException).  Message: " + e.getMessage());
			e.printStackTrace();
			return null;	
		}	
		catch (TransformerException e) {
			System.out.println("E9001 XSLT Error encountered (TransformerException).  Message: " + e.getMessage());
			e.printStackTrace();
			return null;				
		}
		return renderedOutput;
	}
	
	public static String render(Node n, String xslFileName) {	
		String renderedOutput = null;
		try {
			File xslFile = new File(xslFileName);
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer(new StreamSource(xslFile));
			
			DOMSource xmlDOMSource = new DOMSource(n);	//
			
			Writer outWriter = new StringWriter();			
			transformer.transform(xmlDOMSource, new StreamResult(outWriter));
			
			renderedOutput = outWriter.toString();
		}
		catch (TransformerConfigurationException e) {
			System.out.println("E9001 XSLT Error encountered (TransformerConfigurationException).  Message: " + e.getMessage());
			e.printStackTrace();
			return null;	
		}	
		catch (TransformerException e) {
			System.out.println("E9001 XSLT Error encountered (TransformerException).  Message: " + e.getMessage());
			e.printStackTrace();
			return null;				
		}
		return renderedOutput;
	}
	
	public static Boolean renderToFile(Node n, String xslFileName, String outputFileName) {	
		File outputFile = new File(outputFileName);
		try {
			File xslFile = new File(xslFileName);
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer(new StreamSource(xslFile));
			
			DOMSource xmlDOMSource = new DOMSource(n);	//
			
			transformer.transform(xmlDOMSource, new StreamResult(outputFile));
		}
		catch (TransformerConfigurationException e) {
			System.out.println("E9001 XSLT Error encountered (TransformerConfigurationException).  Message: " + e.getMessage());
			e.printStackTrace();
			return false;	
		}	
		catch (TransformerException e) {
			System.out.println("E9001 XSLT Error encountered (TransformerException).  Message: " + e.getMessage());
			e.printStackTrace();
			return false;				
		}
		return true;
	}
	
	
}
