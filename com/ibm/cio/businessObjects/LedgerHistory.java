/**
 * File  LedgerHistory.java
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
 
public class LedgerHistory {
		  
	private String   ACCTYR = null;
        	  
	private String   ACCTMO = null;
        	  
	private String   USE_IND = null;
        	  
	private String   CM_IND = null;
        	  
	private String   CGP_IND = null;
        	  
	private String   BUCKET_IND = null;
        	  
	private String   CATEGORY = null;
        	  
	private String   CURRENCY_CD = null;
        	  
	private String   MAJOR = null;
        	  
	private String   MINOR = null;
        	  
	private double   LOC_AMT = -1;
        	  
	private double   USD_AMT = -1;
        	  
	private double   PLANNING_AMT = -1;
        

	public LedgerHistory () {}

	public LedgerHistory (
	  String   ACCTYR
        	, String   ACCTMO
        	, String   USE_IND
        	, String   CM_IND
        	, String   CGP_IND
        	, String   BUCKET_IND
        	, String   CATEGORY
        	, String   CURRENCY_CD
        	, String   MAJOR
        	, String   MINOR
        	, double   LOC_AMT
        	, double   USD_AMT
        	, double   PLANNING_AMT	
	) {
	
			this.ACCTYR = ACCTYR;
	
			this.ACCTMO = ACCTMO;
	
			this.USE_IND = USE_IND;
	
			this.CM_IND = CM_IND;
	
			this.CGP_IND = CGP_IND;
	
			this.BUCKET_IND = BUCKET_IND;
	
			this.CATEGORY = CATEGORY;
	
			this.CURRENCY_CD = CURRENCY_CD;
	
			this.MAJOR = MAJOR;
	
			this.MINOR = MINOR;
	
			this.LOC_AMT = LOC_AMT;
	
			this.USD_AMT = USD_AMT;
	
			this.PLANNING_AMT = PLANNING_AMT;
	
	}
       
	
        /* Getter & Setter for ACCTYR */
	public String   getACCTYR () {
		return ACCTYR;
	}	
	
	public void setACCTYR (String   ACCTYR ) { 
		this.ACCTYR = ACCTYR ;
	}	  
        
        /* Getter & Setter for ACCTMO */
	public String   getACCTMO () {
		return ACCTMO;
	}	
	
	public void setACCTMO (String   ACCTMO ) { 
		this.ACCTMO = ACCTMO ;
	}	  
        
        /* Getter & Setter for USE_IND */
	public String   getUSE_IND () {
		return USE_IND;
	}	
	
	public void setUSE_IND (String   USE_IND ) { 
		this.USE_IND = USE_IND ;
	}	  
        
        /* Getter & Setter for CM_IND */
	public String   getCM_IND () {
		return CM_IND;
	}	
	
	public void setCM_IND (String   CM_IND ) { 
		this.CM_IND = CM_IND ;
	}	  
        
        /* Getter & Setter for CGP_IND */
	public String   getCGP_IND () {
		return CGP_IND;
	}	
	
	public void setCGP_IND (String   CGP_IND ) { 
		this.CGP_IND = CGP_IND ;
	}	  
        
        /* Getter & Setter for BUCKET_IND */
	public String   getBUCKET_IND () {
		return BUCKET_IND;
	}	
	
	public void setBUCKET_IND (String   BUCKET_IND ) { 
		this.BUCKET_IND = BUCKET_IND ;
	}	  
        
        /* Getter & Setter for CATEGORY */
	public String   getCATEGORY () {
		return CATEGORY;
	}	
	
	public void setCATEGORY (String   CATEGORY ) { 
		this.CATEGORY = CATEGORY ;
	}	  
        
        /* Getter & Setter for CURRENCY_CD */
	public String   getCURRENCY_CD () {
		return CURRENCY_CD;
	}	
	
	public void setCURRENCY_CD (String   CURRENCY_CD ) { 
		this.CURRENCY_CD = CURRENCY_CD ;
	}	  
        
        /* Getter & Setter for MAJOR */
	public String   getMAJOR () {
		return MAJOR;
	}	
	
	public void setMAJOR (String   MAJOR ) { 
		this.MAJOR = MAJOR ;
	}	  
        
        /* Getter & Setter for MINOR */
	public String   getMINOR () {
		return MINOR;
	}	
	
	public void setMINOR (String   MINOR ) { 
		this.MINOR = MINOR ;
	}	  
        
        /* Getter & Setter for LOC_AMT */
	public double   getLOC_AMT () {
		return LOC_AMT;
	}	
	
	public void setLOC_AMT (double   LOC_AMT ) { 
		this.LOC_AMT = LOC_AMT ;
	}	  
        
        /* Getter & Setter for USD_AMT */
	public double   getUSD_AMT () {
		return USD_AMT;
	}	
	
	public void setUSD_AMT (double   USD_AMT ) { 
		this.USD_AMT = USD_AMT ;
	}	  
        
        /* Getter & Setter for PLANNING_AMT */
	public double   getPLANNING_AMT () {
		return PLANNING_AMT;
	}	
	
	public void setPLANNING_AMT (double   PLANNING_AMT ) { 
		this.PLANNING_AMT = PLANNING_AMT ;
	}	  
        
}