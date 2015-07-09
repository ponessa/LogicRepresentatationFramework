/**
 * File  DuplicateRecordException.java 
 *
 * Begin Copyright
 *
 * IBM Confidential
 *
 * OCO Source Materials
 *
 * The Source code for this program is not published or otherwise
 * divested of its trade secrets, irrespective of what has been
 * deposited with the U.S. Copyright Office.
 *
 * (C) Copyright IBM Corp. 2003
 *
 * End Copyright                                                                
 */
package com.ibm.cio.exceptions;

/**
 * Thrown when an unexpected condition arises while marshalling data from a service to a class or de-marshalling data from a class to an output stream.
 * <p>
 * The exceptions encompass:</p>
 * <ul>
 * 		<li>MalformedURLException</li>
 * 		<li>ParserConfigurationException</li>
 * 		<li>SAXException</li>
 * 		<li>ClassNotFoundException</li>
 * 		<li>InstantiationException</li>
 * 		<li>IllegalAccessException</li>
 * 		<li>InvocationTargetException</li>
 * 		<li>IOException</li>
 * </ul>
 */
public class DataMarshalException extends Exception {
	static final long serialVersionUID = 10L;
	private String message;

	/**
	 * Constructor for DuplicateRecordException.
	 * 
	 * @param the exception message.
	 */
	public DataMarshalException(String aMessage) {
		super(aMessage);
		this.message = aMessage;
	}

	/**
	 * Returns the exception message text
	 * 
	 * @return exception message text
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Returns the exception message text
	 * 
	 * @return exception message text
	 */
	public String toString() {
		return message;
	}
}

