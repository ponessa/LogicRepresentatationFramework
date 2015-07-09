/*
 * Created on Sep 20, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.ibm.cio.dataMarshaller;

/**
 * @author ponessa
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DbColumn {
	private String schema = null;
	private String tableName = null;
	private String name = null;
	private String columnName = null;
	private String dataType = null;
	private int size = -1;
	private boolean nullable = false;
	private int precission = -1;
	private int scale = -1; 
	private int dataTypeEnum = DbColumn.TYPE_UNDEFINED;
	
	public static final int TYPE_UNDEFINED = -1;
	public static final int TYPE_CHAR = 1;
	public static final int TYPE_VARCHAR = 2;
	public static final int TYPE_SMALLINT = 3;
	public static final int TYPE_INTEGER = 4;
	public static final int TYPE_DECIMAL = 5;
	public static final int TYPE_NUMBER = 6;
	public static final int TYPE_REAL = 7;
	public static final int TYPE_DOUBLE = 8;
	public static final int TYPE_TIME = 9;
	public static final int TYPE_TIMESTAMP = 10;
	public static final int TYPE_DATE = 11;
	
	protected DbColumn() {
	}
	
	protected DbColumn(String schema, String tableName, String columnName, String name, String dataType, int size, int precission, boolean nullable, int scale) {
		this.schema = schema;
		this.tableName = tableName;
		this.name = name;
		this.columnName = columnName;
		this.dataType = dataType;
		this.size = size;
		this.precission = precission;
		this.nullable = nullable;
		this.scale = scale;	
		this.setDataTypeEnum(this.dataType);	
	}
	
	public void setDataTypeEnum(String dataType) {
		int i = DbColumn.TYPE_UNDEFINED;
		if (dataType.equalsIgnoreCase("CHAR")
		 || dataType.equalsIgnoreCase("CHARACTER"))
		 	i = DbColumn.TYPE_CHAR;
		else if (dataType.equalsIgnoreCase("VARCHAR"))
			i = DbColumn.TYPE_VARCHAR;
		else if (dataType.equalsIgnoreCase("SMALLINT") || dataType.equalsIgnoreCase("SHORT"))
			i = DbColumn.TYPE_SMALLINT;
		else if (dataType.equalsIgnoreCase("INTEGER") || dataType.equalsIgnoreCase("INT"))
			i = DbColumn.TYPE_INTEGER;
		else if (dataType.equalsIgnoreCase("DECIMAL") || dataType.equalsIgnoreCase("DEC")
		|| dataType.equalsIgnoreCase("FIXED DEC") || dataType.equalsIgnoreCase("FIXED DECIMAL"))
			i = DbColumn.TYPE_DECIMAL;
		else if (dataType.equalsIgnoreCase("NUMBER"))
			i = DbColumn.TYPE_NUMBER;			
		else if (dataType.equalsIgnoreCase("REAL"))
			i = DbColumn.TYPE_REAL;				
		else if (dataType.equalsIgnoreCase("DOUBLE"))
			i = DbColumn.TYPE_DOUBLE;			
		else if (dataType.equalsIgnoreCase("TIME"))
			i = DbColumn.TYPE_TIME;				
		else if (dataType.equalsIgnoreCase("TIMESTAMP"))
			i = DbColumn.TYPE_TIMESTAMP;
		else if (dataType.equalsIgnoreCase("DATE"))
			i = DbColumn.TYPE_DATE;							
		dataTypeEnum = i;
	}

	/**
	 * @return
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * @return
	 */
	public String getDataType() {
		return dataType;
	}

	/**
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 */
	public boolean isNullable() {
		return nullable;
	}

	/**
	 * @return
	 */
	public int getScale() {
		return scale;
	}

	/**
	 * @param string
	 */
	public void setColumnName(String string) {
		columnName = string;
	}

	/**
	 * @param string
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
		this.setDataTypeEnum(dataType);
	}

	/**
	 * @param i
	 */
	public void setSize(int i) {
		size = i;
	}

	/**
	 * @param string
	 */
	public void setName(String string) {
		name = string;
	}

	/**
	 * @param b
	 */
	public void setNullable(boolean b) {
		nullable = b;
	}

	/**
	 * @param i
	 */
	public void setScale(int i) {
		scale = i;
	}

	/**
	 * @return
	 */
	public int getDataTypeEnum() {
		return dataTypeEnum;
	}

	/**
	 * @param i
	 */
	public void setDataTypeEnum(int i) {
		dataTypeEnum = i;
	}

	/**
	 * @return
	 */
	public String getGetterName() {
		return "get"+name.substring(0,1).toUpperCase()+name.substring(1,name.length());
	}

	/**
	 * @param string
	 */
	public String getSetterName() {
		return "set"+name.substring(0,1).toUpperCase()+name.substring(1,name.length());
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getPrecission() {
		return precission;
	}

	public void setPrecission(int precission) {
		this.precission = precission;
	}

}
