/*
 * Created on Sep 20, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.ibm.cio.dataMarshaller;

import com.ibm.cio.exceptions.DuplicateRecordException;

import java.util.HashMap;

/**
 * @author ponessa
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
/**
 * @author ponessa
 *
 */
public class SqlMap {
	private String serviceUrl = null;
	private String businessObjectClassName = null;
	private HashMap map = null;
	
	protected SqlMap() {
	}
	
	protected SqlMap(String serviceUrl, String businessObjectClassName) {
		this(serviceUrl, businessObjectClassName, null);
	}	
	
	protected SqlMap(String serviceUrl, String businessObjectClassName, HashMap map) {
		this.serviceUrl = serviceUrl;
		this.businessObjectClassName = businessObjectClassName;
		this.map = map;
	}
	
	public boolean isEmpty() {
		return map.isEmpty();
	}
	
	public int size() {
		return map.size();
	}
	
	public DbColumn get(String dbColumnName) {
		return ((DbColumn)map.get(dbColumnName));
	}
	
	public void addDbColumn(DbColumn dbc) throws DuplicateRecordException {
		if (map==null) map = new HashMap();
		
		if (map.containsKey(dbc.getName())) 
			throw new DuplicateRecordException("Duplicate Record Exception, DB Column with name "+dbc.getName()+ " already defined in map.");
		
		map.put(dbc.getName(), dbc);		
	}

	/**
	 * @return
	 */
	public String getServiceUrl() {
		return serviceUrl;
	}

	/**
	 * @return
	 */
	public String getBusinessObjectClassName() {
		return businessObjectClassName;
	}

	/**
	 * @return
	 */
	public HashMap getMap() {
		return map;
	}

	/**
	 * @param string
	 */
	public void setServiceUrl(String serviceUrl) {
		serviceUrl = serviceUrl;
	}

	/**
	 * @param string
	 */
	public void setBusinessObjectClassName(String string) {
		businessObjectClassName = string;
	}

	/**
	 * @param map
	 */
	public void setMap(HashMap map) {
		this.map = map;
	}

}
