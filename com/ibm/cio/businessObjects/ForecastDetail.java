/**
 * File  ForecastDetail.java
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
 * Author: 
 * Date  : 7 July 2015
 *
 * End Copyright
 */
 
package com.ibm.cio.businessObjects;
 
public class ForecastDetail {
		  
	private String   PARTITION_ID = null;
        	  
	private String   RECORD_TYPE = null;
        	  
	private String   PO_NUMBER = null;
        	  
	private String   COUNTRY_CODE = null;
        	  
	private String   COMPANY_CODE = null;
        	  
	private String   DIVISION_CODE = null;
        	  
	private String   LOC_CURR_IND = null;
        	  
	private String   WORK_NUMBER = null;
        	  
	private java.sql.Date   START_DATE = null;
        	  
	private java.sql.Date   END_DATE = null;
        	  
	private short   LENGTH_IN_MONTHS = -1;
        	  
	private String   AUTOFLOW = null;
        	  
	private String   FIRM_NAME = null;
        	  
	private String   UPDATE_MONTH = null;
        	  
	private double   TOTAL_AMOUNT = -1;
        	  
	private double   TOTAL_AMOUNTP = -1;
        	  
	private double   TOTAL_HOURS = -1;
        	  
	private double   RATE = -1;
        	  
	private double   RATEP = -1;
        	  
	private short   PERCENT_OUTSIDE_SC = -1;
        	  
	private double   REMAINING_AMOUNT = -1;
        	  
	private double   REMAINING_AMOUNTP = -1;
        	  
	private int   REMAINING_HOURS = -1;
        	  
	private short   CURRENT_DURATION = -1;
        	  
	private String   CURRENT_MONTH = null;
        	  
	private short   MONTH_INDEX = -1;
        

	public ForecastDetail () {}

	public ForecastDetail (
	  String   PARTITION_ID
        	, String   RECORD_TYPE
        	, String   PO_NUMBER
        	, String   COUNTRY_CODE
        	, String   COMPANY_CODE
        	, String   DIVISION_CODE
        	, String   LOC_CURR_IND
        	, String   WORK_NUMBER
        	, java.sql.Date   START_DATE
        	, java.sql.Date   END_DATE
        	, short   LENGTH_IN_MONTHS
        	, String   AUTOFLOW
        	, String   FIRM_NAME
        	, String   UPDATE_MONTH
        	, double   TOTAL_AMOUNT
        	, double   TOTAL_AMOUNTP
        	, double   TOTAL_HOURS
        	, double   RATE
        	, double   RATEP
        	, short   PERCENT_OUTSIDE_SC
        	, double   REMAINING_AMOUNT
        	, double   REMAINING_AMOUNTP
        	, int   REMAINING_HOURS
        	, short   CURRENT_DURATION
        	, String   CURRENT_MONTH
        	, short   MONTH_INDEX	
	) {
	
			this.PARTITION_ID = PARTITION_ID;
	
			this.RECORD_TYPE = RECORD_TYPE;
	
			this.PO_NUMBER = PO_NUMBER;
	
			this.COUNTRY_CODE = COUNTRY_CODE;
	
			this.COMPANY_CODE = COMPANY_CODE;
	
			this.DIVISION_CODE = DIVISION_CODE;
	
			this.LOC_CURR_IND = LOC_CURR_IND;
	
			this.WORK_NUMBER = WORK_NUMBER;
	
			this.START_DATE = START_DATE;
	
			this.END_DATE = END_DATE;
	
			this.LENGTH_IN_MONTHS = LENGTH_IN_MONTHS;
	
			this.AUTOFLOW = AUTOFLOW;
	
			this.FIRM_NAME = FIRM_NAME;
	
			this.UPDATE_MONTH = UPDATE_MONTH;
	
			this.TOTAL_AMOUNT = TOTAL_AMOUNT;
	
			this.TOTAL_AMOUNTP = TOTAL_AMOUNTP;
	
			this.TOTAL_HOURS = TOTAL_HOURS;
	
			this.RATE = RATE;
	
			this.RATEP = RATEP;
	
			this.PERCENT_OUTSIDE_SC = PERCENT_OUTSIDE_SC;
	
			this.REMAINING_AMOUNT = REMAINING_AMOUNT;
	
			this.REMAINING_AMOUNTP = REMAINING_AMOUNTP;
	
			this.REMAINING_HOURS = REMAINING_HOURS;
	
			this.CURRENT_DURATION = CURRENT_DURATION;
	
			this.CURRENT_MONTH = CURRENT_MONTH;
	
			this.MONTH_INDEX = MONTH_INDEX;
	
	}
       
	
        /* Getter & Setter for PARTITION_ID */
	public String   getPARTITION_ID () {
		return PARTITION_ID;
	}	
	
	public void setPARTITION_ID (String   PARTITION_ID ) { 
		this.PARTITION_ID = PARTITION_ID ;
	}	  
        
        /* Getter & Setter for RECORD_TYPE */
	public String   getRECORD_TYPE () {
		return RECORD_TYPE;
	}	
	
	public void setRECORD_TYPE (String   RECORD_TYPE ) { 
		this.RECORD_TYPE = RECORD_TYPE ;
	}	  
        
        /* Getter & Setter for PO_NUMBER */
	public String   getPO_NUMBER () {
		return PO_NUMBER;
	}	
	
	public void setPO_NUMBER (String   PO_NUMBER ) { 
		this.PO_NUMBER = PO_NUMBER ;
	}	  
        
        /* Getter & Setter for COUNTRY_CODE */
	public String   getCOUNTRY_CODE () {
		return COUNTRY_CODE;
	}	
	
	public void setCOUNTRY_CODE (String   COUNTRY_CODE ) { 
		this.COUNTRY_CODE = COUNTRY_CODE ;
	}	  
        
        /* Getter & Setter for COMPANY_CODE */
	public String   getCOMPANY_CODE () {
		return COMPANY_CODE;
	}	
	
	public void setCOMPANY_CODE (String   COMPANY_CODE ) { 
		this.COMPANY_CODE = COMPANY_CODE ;
	}	  
        
        /* Getter & Setter for DIVISION_CODE */
	public String   getDIVISION_CODE () {
		return DIVISION_CODE;
	}	
	
	public void setDIVISION_CODE (String   DIVISION_CODE ) { 
		this.DIVISION_CODE = DIVISION_CODE ;
	}	  
        
        /* Getter & Setter for LOC_CURR_IND */
	public String   getLOC_CURR_IND () {
		return LOC_CURR_IND;
	}	
	
	public void setLOC_CURR_IND (String   LOC_CURR_IND ) { 
		this.LOC_CURR_IND = LOC_CURR_IND ;
	}	  
        
        /* Getter & Setter for WORK_NUMBER */
	public String   getWORK_NUMBER () {
		return WORK_NUMBER;
	}	
	
	public void setWORK_NUMBER (String   WORK_NUMBER ) { 
		this.WORK_NUMBER = WORK_NUMBER ;
	}	  
        
        /* Getter & Setter for START_DATE */
	public java.sql.Date   getSTART_DATE () {
		return START_DATE;
	}	
	
	public void setSTART_DATE (java.sql.Date   START_DATE ) { 
		this.START_DATE = START_DATE ;
	}	  
        
        /* Getter & Setter for END_DATE */
	public java.sql.Date   getEND_DATE () {
		return END_DATE;
	}	
	
	public void setEND_DATE (java.sql.Date   END_DATE ) { 
		this.END_DATE = END_DATE ;
	}	  
        
        /* Getter & Setter for LENGTH_IN_MONTHS */
	public short   getLENGTH_IN_MONTHS () {
		return LENGTH_IN_MONTHS;
	}	
	
	public void setLENGTH_IN_MONTHS (short   LENGTH_IN_MONTHS ) { 
		this.LENGTH_IN_MONTHS = LENGTH_IN_MONTHS ;
	}	  
        
        /* Getter & Setter for AUTOFLOW */
	public String   getAUTOFLOW () {
		return AUTOFLOW;
	}	
	
	public void setAUTOFLOW (String   AUTOFLOW ) { 
		this.AUTOFLOW = AUTOFLOW ;
	}	  
        
        /* Getter & Setter for FIRM_NAME */
	public String   getFIRM_NAME () {
		return FIRM_NAME;
	}	
	
	public void setFIRM_NAME (String   FIRM_NAME ) { 
		this.FIRM_NAME = FIRM_NAME ;
	}	  
        
        /* Getter & Setter for UPDATE_MONTH */
	public String   getUPDATE_MONTH () {
		return UPDATE_MONTH;
	}	
	
	public void setUPDATE_MONTH (String   UPDATE_MONTH ) { 
		this.UPDATE_MONTH = UPDATE_MONTH ;
	}	  
        
        /* Getter & Setter for TOTAL_AMOUNT */
	public double   getTOTAL_AMOUNT () {
		return TOTAL_AMOUNT;
	}	
	
	public void setTOTAL_AMOUNT (double   TOTAL_AMOUNT ) { 
		this.TOTAL_AMOUNT = TOTAL_AMOUNT ;
	}	  
        
        /* Getter & Setter for TOTAL_AMOUNTP */
	public double   getTOTAL_AMOUNTP () {
		return TOTAL_AMOUNTP;
	}	
	
	public void setTOTAL_AMOUNTP (double   TOTAL_AMOUNTP ) { 
		this.TOTAL_AMOUNTP = TOTAL_AMOUNTP ;
	}	  
        
        /* Getter & Setter for TOTAL_HOURS */
	public double   getTOTAL_HOURS () {
		return TOTAL_HOURS;
	}	
	
	public void setTOTAL_HOURS (double   TOTAL_HOURS ) { 
		this.TOTAL_HOURS = TOTAL_HOURS ;
	}	  
        
        /* Getter & Setter for RATE */
	public double   getRATE () {
		return RATE;
	}	
	
	public void setRATE (double   RATE ) { 
		this.RATE = RATE ;
	}	  
        
        /* Getter & Setter for RATEP */
	public double   getRATEP () {
		return RATEP;
	}	
	
	public void setRATEP (double   RATEP ) { 
		this.RATEP = RATEP ;
	}	  
        
        /* Getter & Setter for PERCENT_OUTSIDE_SC */
	public short   getPERCENT_OUTSIDE_SC () {
		return PERCENT_OUTSIDE_SC;
	}	
	
	public void setPERCENT_OUTSIDE_SC (short   PERCENT_OUTSIDE_SC ) { 
		this.PERCENT_OUTSIDE_SC = PERCENT_OUTSIDE_SC ;
	}	  
        
        /* Getter & Setter for REMAINING_AMOUNT */
	public double   getREMAINING_AMOUNT () {
		return REMAINING_AMOUNT;
	}	
	
	public void setREMAINING_AMOUNT (double   REMAINING_AMOUNT ) { 
		this.REMAINING_AMOUNT = REMAINING_AMOUNT ;
	}	  
        
        /* Getter & Setter for REMAINING_AMOUNTP */
	public double   getREMAINING_AMOUNTP () {
		return REMAINING_AMOUNTP;
	}	
	
	public void setREMAINING_AMOUNTP (double   REMAINING_AMOUNTP ) { 
		this.REMAINING_AMOUNTP = REMAINING_AMOUNTP ;
	}	  
        
        /* Getter & Setter for REMAINING_HOURS */
	public int   getREMAINING_HOURS () {
		return REMAINING_HOURS;
	}	
	
	public void setREMAINING_HOURS (int   REMAINING_HOURS ) { 
		this.REMAINING_HOURS = REMAINING_HOURS ;
	}	  
        
        /* Getter & Setter for CURRENT_DURATION */
	public short   getCURRENT_DURATION () {
		return CURRENT_DURATION;
	}	
	
	public void setCURRENT_DURATION (short   CURRENT_DURATION ) { 
		this.CURRENT_DURATION = CURRENT_DURATION ;
	}	  
        
        /* Getter & Setter for CURRENT_MONTH */
	public String   getCURRENT_MONTH () {
		return CURRENT_MONTH;
	}	
	
	public void setCURRENT_MONTH (String   CURRENT_MONTH ) { 
		this.CURRENT_MONTH = CURRENT_MONTH ;
	}	  
        
        /* Getter & Setter for MONTH_INDEX */
	public short   getMONTH_INDEX () {
		return MONTH_INDEX;
	}	
	
	public void setMONTH_INDEX (short   MONTH_INDEX ) { 
		this.MONTH_INDEX = MONTH_INDEX ;
	}	  
        
}
