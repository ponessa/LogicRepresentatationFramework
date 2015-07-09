package com.ibm.cio.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.log4j.Logger;
/**
 * A utility containing static methods to read the content of RESTful services.
 * <p>
 * The class is executable, containing a <b>main</b> method that allows parameters to be passed
 * into it.  These parameters are:
 * <ul>
 * <li><b>-url</b> - [mandatory/optional] The URL of the RESTful service.</li>
 * <li><b>-id</b> - [mandatory/optional] The id of the BMS DaaS RESTful service.  Either <b>url</b> or <b>id</b> is required.
 * <p>When id is specified the URL is built as follows:
 * <br/>
 * <code><b>http://bms3.sby.ibm.com/bms/iw/rest/?id=<i>id</i>&s=DaaS&f=xml</b></code>
 * </p></li>
 * <li><b>-f</b> - [optional, default=xml] The format of the data returned from the RESTful service.
 * <p>Valued values are <b>xml</b> (default), JSON, CSV,and fixed (DB2 LOAD format)</p></li>
 * <li><b>-o</b> - [optional] The output file name to store the results.</li>
 * </ul>
 * @since 1.0
 */
public class RestfulServiceReader {
	private static Logger logger = Logger.getLogger(RestfulServiceReader.class);

	private static final String newLine = System.getProperty("line.separator").toString(); //$NON-NLS-1$
	/**
	 * Default constructor
	 */
	public RestfulServiceReader() {		
	}

	/**
	 * The executable main.
	 * @param args Array of arguments passed into the executable class. 
	 * <ul>
	 * <li><b>-url</b> - [mandator/optional] The URL of the RESTful service.</li>
	 * <li><b>-id</b> - [mandator/optional] The id of the BMS DaaS RESTful service.  Either <b>url</b> or <b>id</b> is required.
	 * <p>When id is specified the URL is built as follows:
	 * <br/>
	 * <code><b>http://bms3.sby.ibm.com/bms/iw/rest/?id=<i>id</i>&s=DaaS&f=xml</b></code>
	 * </p></li>
	 * <li><b>-f</b> - [optional, default=xml] The format of the data returned from the RESTful service.
	 * <p>Valued values are <b>xml</b> (default), JSON, CSV,and fixed (DB2 LOAD format)</p></li>
	 * <li><b>-o</b> - [optional] The output file name to store the results.</li>
	 * </ul>
	 */
	public static void main(String[] args) {
		logger.info(Messages.getString("RestfulServiceReader.1") + String.valueOf(new java.util.Date())); //$NON-NLS-1$
		String outputFileName = null;
		String serviceUrl = null;
		String format = Messages.getString("RestfulServiceReader.0"); //$NON-NLS-1$
		String encodingSchema=Messages.getString("RestfulServiceReader.3"); //$NON-NLS-1$
		String id=null;
		boolean validParams = true;

		try {
			for (int optind = 0; optind < args.length; optind++) {
				if (args[optind].equalsIgnoreCase(Messages.getString("RestfulServiceReader.2"))) { //$NON-NLS-1$
					outputFileName = args[++optind];
				} else if (args[optind].equalsIgnoreCase(Messages.getString("RestfulServiceReader.4"))) { //$NON-NLS-1$
					serviceUrl = args[++optind];	
				} else if (args[optind].equalsIgnoreCase(Messages.getString("RestfulServiceReader.5"))) { //$NON-NLS-1$
					format = args[++optind];	
				} else if (args[optind].equalsIgnoreCase(Messages.getString("RestfulServiceReader.6"))) { //$NON-NLS-1$
					id = args[++optind];	
				} else if (args[optind].equalsIgnoreCase(Messages.getString("RestfulServiceReader.7"))) { //$NON-NLS-1$
					validParams = false;  
				} else {
					logger.error(Messages.getString("RestfulServiceReader.9") + args[optind]); //$NON-NLS-1$
					validParams = false;                  
				}
			} //end - for (int optind = 0; optind < args.length; optind++)
		} //end try
		catch (Exception e) {
			logger.warn(Messages.getString("RestfulServiceReader.10") + e.getMessage()); //$NON-NLS-1$
			e.printStackTrace();
			validParams = false;
		}
		if (id != null) serviceUrl = Messages.getString("RestfulServiceReader.11")+id+Messages.getString("RestfulServiceReader.12"); //$NON-NLS-1$ //$NON-NLS-2$
		if (serviceUrl==null) validParams = false;

		if (!validParams) {
			logger.info(Messages.getString("RestfulServiceReader.13")); //$NON-NLS-1$
			logger.info(Messages.getString("RestfulServiceReader.14")); //$NON-NLS-1$
			logger.info(Messages.getString("RestfulServiceReader.15"));		 //$NON-NLS-1$
			logger.info(Messages.getString("RestfulServiceReader.16")); //$NON-NLS-1$
			logger.info(Messages.getString("RestfulServiceReader.17")); //$NON-NLS-1$
			logger.info(Messages.getString("RestfulServiceReader.18")); //$NON-NLS-1$
			logger.info(Messages.getString("RestfulServiceReader.19")); //$NON-NLS-1$
			logger.info(Messages.getString("RestfulServiceReader.20")); //$NON-NLS-1$
			logger.info(Messages.getString("RestfulServiceReader.21")); //$NON-NLS-1$
			logger.info(Messages.getString("RestfulServiceReader.22")); //$NON-NLS-1$
			logger.info(Messages.getString("RestfulServiceReader.23")); //$NON-NLS-1$
			logger.info(Messages.getString("RestfulServiceReader.24")); //$NON-NLS-1$
			logger.info(Messages.getString("RestfulServiceReader.25"));	 //$NON-NLS-1$
			logger.info(Messages.getString("RestfulServiceReader.26")); //$NON-NLS-1$
			logger.info(Messages.getString("RestfulServiceReader.27"));	 //$NON-NLS-1$
			logger.info(Messages.getString("RestfulServiceReader.28")); //$NON-NLS-1$
			logger.info(Messages.getString("RestfulServiceReader.29")); //$NON-NLS-1$
			logger.info(Messages.getString("RestfulServiceReader.30"));       //$NON-NLS-1$
		} 	
		else {
			if (outputFileName != null)
				if (RestfulServiceReader.writeRestfulService(serviceUrl, outputFileName, encodingSchema, format))
					logger.info(Messages.getString("RestfulServiceReader.31")+new java.util.Date()); //$NON-NLS-1$
				else
					logger.info(Messages.getString("RestfulServiceReader.32")+new java.util.Date()); //$NON-NLS-1$
			else {
				System.out.println(RestfulServiceReader.readRestfulService(serviceUrl, encodingSchema, null));
			}
		}
	}
	
	/**
	 * Writes the results of a RESTful service into a dataset.
	 * <p>
	 * </p>
	 * @param serviceUrlString The URL for the RESTful service
	 * @param outputFileName The name of the file to store the results of the RESTful service
	 * @param encodingSchema The encoding schema to use to store the results
	 * @param format Append format to the back of the RESTful service URL.  Valid values are XML, JSON, CSV, and fixed
	 * @return whether the file was saved with the service results
	 */
	public static boolean writeRestfulService(String serviceUrlString, String outputFileName, String encodingSchema, String format) {
		try {	
			//Define the DaaS URL.  
			URL serviceUrl =  new URL(serviceUrlString+ (format==null?"":"&f="+format)); //$NON-NLS-1$ //$NON-NLS-2$
	
			//Set up the output dataset
			BufferedWriter out = null;
			if (outputFileName != null) out = new BufferedWriter(new FileWriter(outputFileName));
			
			//Call the DaaS RESTful Service via URL openStream() method.  The content will go into the BufferedReader.
			logger.info("I0010: Within process() - calling DaaS Service ("+serviceUrlString+") at "+new java.util.Date());
	
			BufferedReader in = new BufferedReader(new InputStreamReader(serviceUrl.openStream(), encodingSchema));		    
			logger.info(Messages.getString("RestfulServiceReader.37")+new java.util.Date()); //$NON-NLS-1$
			
			/*
			 * Process each line returned by reading form the BufferedReader.
			 */
			logger.info(Messages.getString("RestfulServiceReader.38")); //$NON-NLS-1$
		    String line;
		    int lineCnt=0;
		    while ((line = in.readLine()) != null) {
		    	if (out==null) 
		    		System.out.println(line);
		    	else {
		    		out.write(line);
		    		out.newLine();
		    	}	
		    }
		    in.close();
		    if (out != null) {
			    out.flush();
			    out.close();
		    }
		} catch (IOException e) {
			logger.fatal(e.getMessage());
			return false;
		}		
		return true;
	}
	
	/**
	 * Reads and returns the results of a RESTful service with the default encoding UTF-8
	 * <p>
	 * </p>
	 * @param serviceUrlString The URL for the RESTful service
	 * @return results of a RESTful service
	 */	
	public static String readRestfulService(String serviceUrlString) {
		return readRestfulService(serviceUrlString, Messages.getString("RestfulServiceReader.8"), null);  //$NON-NLS-1$
	}
	
	/**
	 * Reads and returns the results of a RESTful service.
	 * <p>
	 * </p>
	 * @param serviceUrlString The URL for the RESTful service
	 * @param encodingSchema The encoding schema to use to store the results
	 * @return results of a RESTful service
	 */
	public static String readRestfulService(String serviceUrlString, String encodingSchema) {
		return readRestfulService(serviceUrlString, encodingSchema, null); 
	}
	
	/**
	 * Reads and returns the results of a RESTful service.
	 * <p>
	 * </p>
	 * @param serviceUrlString The URL for the RESTful service
	 * @param encodingSchema The encoding schema to use to store the results
	 * @param format Append format to the back of the RESTful service URL.  Valid values are XML, JSON, CSV, and fixed
	 * @return results of a RESTful service
	 */
	public static String readRestfulService(String serviceUrlString, String encodingSchema, String format) {
		StringBuffer out = new StringBuffer();
		try {	
			//Define the DaaS URL.  
			URL serviceUrl =  new URL(serviceUrlString + (format==null?"":"&f="+format)); //$NON-NLS-1$ //$NON-NLS-2$
			
			//Call the DaaS RESTful Service via URL openStream() method.  The content will go into the BufferedReader.
			BufferedReader in = new BufferedReader(new InputStreamReader(serviceUrl.openStream(), encodingSchema));		    
			logger.info(Messages.getString("RestfulServiceReader.42")+new java.util.Date()); //$NON-NLS-1$
			
			/*
			 * Process each line returned by reading form the BufferedReader.
			 */
			logger.info(Messages.getString("RestfulServiceReader.43")); //$NON-NLS-1$
		    String line=null;
		    while ((line = in.readLine()) != null) {
	    		out.append(line).append(RestfulServiceReader.newLine);
		    }
		} catch (IOException e) {
			logger.fatal(e.getMessage());
			return null;
		}		
		return out.toString();
	}	
}
