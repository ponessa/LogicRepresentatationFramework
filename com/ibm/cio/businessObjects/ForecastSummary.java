/**
 * File  ForecastSummary.java
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

public class ForecastSummary {

	private String PARTITION_ID = null;

	private String COUNTRY_CODE = null;

	private String COMPANY_CODE = null;

	private String WORK_NUMBER = null;

	private String DIVISION_CODE = null;

	private String LOC_CURR_IND = null;

	private String FORECAST_TYPE = null;

	private double TOTAL_COST = -1;

	private double COST_REG_LABOR = -1;

	private double COST_SUB_LB_HR = -1;

	private double COST_SUB_LB_FIX = -1;

	private double COST_OEM_HW = -1;

	private double COST_OEM_SW = -1;

	private double COST_T_L = -1;

	private double COST_MISC = -1;

	private double TOTAL_REG_LABOR_HR = -1;

	private double REG_HRS_OUTSIDE_SC = -1;

	private double SUB_LABOR_HRS = -1;

	private double COST_TO_YR_END = -1;

	private double REG_LABOR_COST_YE = -1;

	private double SUB_LABOR_HR_YE = -1;

	private double COST_LABOR_FIX_YE = -1;

	private double OEM_HARDWARE_YE = -1;

	private double OEM_SOFTWARE_YE = -1;

	private double TRAVEL_LIVING_YE = -1;

	private double MISC_YE = -1;

	private double REG_LABOR_HRS_YE = -1;

	private double REG_HRS_OUT_SC_YE = -1;

	private double SUB_LABOR_HRS_YE = -1;

	private String CURRENT_MONTH = null;

	private String UPDATE_MONTH = null;

	private double COST_REMAINING = -1;

	private double REG_LABOR_REM = -1;

	private double SUB_LABOR_HR_REM = -1;

	private double SUB_LABOR_FX_REM = -1;

	private double OEM_HARDWARE_REM = -1;

	private double OEM_SOFTWARE_REM = -1;

	private double T_L_REM = -1;

	private double MISC_REM = -1;

	private double REG_HRS_REM = -1;

	private double REG_HRS_OUT_SC_REM = -1;

	private double SUB_LABOR_HRS_REM = -1;

	private double TOTAL_COSTP = -1;

	private double COST_REG_LABORP = -1;

	private double COST_SUB_LB_HRP = -1;

	private double COST_SUB_LB_FIXP = -1;

	private double COST_OEM_HWP = -1;

	private double COST_OEM_SWP = -1;

	private double COST_T_LP = -1;

	private double COST_MISCP = -1;

	private double COST_TO_YR_ENDP = -1;

	private double REG_LABOR_COST_YEP = -1;

	private double SUB_LABOR_HR_YEP = -1;

	private double COST_LABOR_FIX_YEP = -1;

	private double OEM_HARDWARE_YEP = -1;

	private double OEM_SOFTWARE_YEP = -1;

	private double TRAVEL_LIVING_YEP = -1;

	private double MISC_YEP = -1;

	private double COST_REMAININGP = -1;

	private double REG_LABOR_REMP = -1;

	private double SUB_LABOR_HR_REMP = -1;

	private double SUB_LABOR_FX_REMP = -1;

	private double OEM_HARDWARE_REMP = -1;

	private double OEM_SOFTWARE_REMP = -1;

	private double T_L_REMP = -1;

	private double MISC_REMP = -1;

	public ForecastSummary() {
	}

	public ForecastSummary(String PARTITION_ID, String COUNTRY_CODE,
			String COMPANY_CODE, String WORK_NUMBER, String DIVISION_CODE,
			String LOC_CURR_IND, String FORECAST_TYPE, double TOTAL_COST,
			double COST_REG_LABOR, double COST_SUB_LB_HR,
			double COST_SUB_LB_FIX, double COST_OEM_HW, double COST_OEM_SW,
			double COST_T_L, double COST_MISC, double TOTAL_REG_LABOR_HR,
			double REG_HRS_OUTSIDE_SC, double SUB_LABOR_HRS,
			double COST_TO_YR_END, double REG_LABOR_COST_YE,
			double SUB_LABOR_HR_YE, double COST_LABOR_FIX_YE,
			double OEM_HARDWARE_YE, double OEM_SOFTWARE_YE,
			double TRAVEL_LIVING_YE, double MISC_YE, double REG_LABOR_HRS_YE,
			double REG_HRS_OUT_SC_YE, double SUB_LABOR_HRS_YE,
			String CURRENT_MONTH, String UPDATE_MONTH, double COST_REMAINING,
			double REG_LABOR_REM, double SUB_LABOR_HR_REM,
			double SUB_LABOR_FX_REM, double OEM_HARDWARE_REM,
			double OEM_SOFTWARE_REM, double T_L_REM, double MISC_REM,
			double REG_HRS_REM, double REG_HRS_OUT_SC_REM,
			double SUB_LABOR_HRS_REM, double TOTAL_COSTP,
			double COST_REG_LABORP, double COST_SUB_LB_HRP,
			double COST_SUB_LB_FIXP, double COST_OEM_HWP, double COST_OEM_SWP,
			double COST_T_LP, double COST_MISCP, double COST_TO_YR_ENDP,
			double REG_LABOR_COST_YEP, double SUB_LABOR_HR_YEP,
			double COST_LABOR_FIX_YEP, double OEM_HARDWARE_YEP,
			double OEM_SOFTWARE_YEP, double TRAVEL_LIVING_YEP, double MISC_YEP,
			double COST_REMAININGP, double REG_LABOR_REMP,
			double SUB_LABOR_HR_REMP, double SUB_LABOR_FX_REMP,
			double OEM_HARDWARE_REMP, double OEM_SOFTWARE_REMP,
			double T_L_REMP, double MISC_REMP) {

		this.PARTITION_ID = PARTITION_ID;

		this.COUNTRY_CODE = COUNTRY_CODE;

		this.COMPANY_CODE = COMPANY_CODE;

		this.WORK_NUMBER = WORK_NUMBER;

		this.DIVISION_CODE = DIVISION_CODE;

		this.LOC_CURR_IND = LOC_CURR_IND;

		this.FORECAST_TYPE = FORECAST_TYPE;

		this.TOTAL_COST = TOTAL_COST;

		this.COST_REG_LABOR = COST_REG_LABOR;

		this.COST_SUB_LB_HR = COST_SUB_LB_HR;

		this.COST_SUB_LB_FIX = COST_SUB_LB_FIX;

		this.COST_OEM_HW = COST_OEM_HW;

		this.COST_OEM_SW = COST_OEM_SW;

		this.COST_T_L = COST_T_L;

		this.COST_MISC = COST_MISC;

		this.TOTAL_REG_LABOR_HR = TOTAL_REG_LABOR_HR;

		this.REG_HRS_OUTSIDE_SC = REG_HRS_OUTSIDE_SC;

		this.SUB_LABOR_HRS = SUB_LABOR_HRS;

		this.COST_TO_YR_END = COST_TO_YR_END;

		this.REG_LABOR_COST_YE = REG_LABOR_COST_YE;

		this.SUB_LABOR_HR_YE = SUB_LABOR_HR_YE;

		this.COST_LABOR_FIX_YE = COST_LABOR_FIX_YE;

		this.OEM_HARDWARE_YE = OEM_HARDWARE_YE;

		this.OEM_SOFTWARE_YE = OEM_SOFTWARE_YE;

		this.TRAVEL_LIVING_YE = TRAVEL_LIVING_YE;

		this.MISC_YE = MISC_YE;

		this.REG_LABOR_HRS_YE = REG_LABOR_HRS_YE;

		this.REG_HRS_OUT_SC_YE = REG_HRS_OUT_SC_YE;

		this.SUB_LABOR_HRS_YE = SUB_LABOR_HRS_YE;

		this.CURRENT_MONTH = CURRENT_MONTH;

		this.UPDATE_MONTH = UPDATE_MONTH;

		this.COST_REMAINING = COST_REMAINING;

		this.REG_LABOR_REM = REG_LABOR_REM;

		this.SUB_LABOR_HR_REM = SUB_LABOR_HR_REM;

		this.SUB_LABOR_FX_REM = SUB_LABOR_FX_REM;

		this.OEM_HARDWARE_REM = OEM_HARDWARE_REM;

		this.OEM_SOFTWARE_REM = OEM_SOFTWARE_REM;

		this.T_L_REM = T_L_REM;

		this.MISC_REM = MISC_REM;

		this.REG_HRS_REM = REG_HRS_REM;

		this.REG_HRS_OUT_SC_REM = REG_HRS_OUT_SC_REM;

		this.SUB_LABOR_HRS_REM = SUB_LABOR_HRS_REM;

		this.TOTAL_COSTP = TOTAL_COSTP;

		this.COST_REG_LABORP = COST_REG_LABORP;

		this.COST_SUB_LB_HRP = COST_SUB_LB_HRP;

		this.COST_SUB_LB_FIXP = COST_SUB_LB_FIXP;

		this.COST_OEM_HWP = COST_OEM_HWP;

		this.COST_OEM_SWP = COST_OEM_SWP;

		this.COST_T_LP = COST_T_LP;

		this.COST_MISCP = COST_MISCP;

		this.COST_TO_YR_ENDP = COST_TO_YR_ENDP;

		this.REG_LABOR_COST_YEP = REG_LABOR_COST_YEP;

		this.SUB_LABOR_HR_YEP = SUB_LABOR_HR_YEP;

		this.COST_LABOR_FIX_YEP = COST_LABOR_FIX_YEP;

		this.OEM_HARDWARE_YEP = OEM_HARDWARE_YEP;

		this.OEM_SOFTWARE_YEP = OEM_SOFTWARE_YEP;

		this.TRAVEL_LIVING_YEP = TRAVEL_LIVING_YEP;

		this.MISC_YEP = MISC_YEP;

		this.COST_REMAININGP = COST_REMAININGP;

		this.REG_LABOR_REMP = REG_LABOR_REMP;

		this.SUB_LABOR_HR_REMP = SUB_LABOR_HR_REMP;

		this.SUB_LABOR_FX_REMP = SUB_LABOR_FX_REMP;

		this.OEM_HARDWARE_REMP = OEM_HARDWARE_REMP;

		this.OEM_SOFTWARE_REMP = OEM_SOFTWARE_REMP;

		this.T_L_REMP = T_L_REMP;

		this.MISC_REMP = MISC_REMP;

	}

	/* Getter & Setter for PARTITION_ID */
	public String getPARTITION_ID() {
		return PARTITION_ID;
	}

	public void setPARTITION_ID(String PARTITION_ID) {
		this.PARTITION_ID = PARTITION_ID;
	}

	/* Getter & Setter for COUNTRY_CODE */
	public String getCOUNTRY_CODE() {
		return COUNTRY_CODE;
	}

	public void setCOUNTRY_CODE(String COUNTRY_CODE) {
		this.COUNTRY_CODE = COUNTRY_CODE;
	}

	/* Getter & Setter for COMPANY_CODE */
	public String getCOMPANY_CODE() {
		return COMPANY_CODE;
	}

	public void setCOMPANY_CODE(String COMPANY_CODE) {
		this.COMPANY_CODE = COMPANY_CODE;
	}

	/* Getter & Setter for WORK_NUMBER */
	public String getWORK_NUMBER() {
		return WORK_NUMBER;
	}

	public void setWORK_NUMBER(String WORK_NUMBER) {
		this.WORK_NUMBER = WORK_NUMBER;
	}

	/* Getter & Setter for DIVISION_CODE */
	public String getDIVISION_CODE() {
		return DIVISION_CODE;
	}

	public void setDIVISION_CODE(String DIVISION_CODE) {
		this.DIVISION_CODE = DIVISION_CODE;
	}

	/* Getter & Setter for LOC_CURR_IND */
	public String getLOC_CURR_IND() {
		return LOC_CURR_IND;
	}

	public void setLOC_CURR_IND(String LOC_CURR_IND) {
		this.LOC_CURR_IND = LOC_CURR_IND;
	}

	/* Getter & Setter for FORECAST_TYPE */
	public String getFORECAST_TYPE() {
		return FORECAST_TYPE;
	}

	public void setFORECAST_TYPE(String FORECAST_TYPE) {
		this.FORECAST_TYPE = FORECAST_TYPE;
	}

	/* Getter & Setter for TOTAL_COST */
	public double getTOTAL_COST() {
		return TOTAL_COST;
	}

	public void setTOTAL_COST(double TOTAL_COST) {
		this.TOTAL_COST = TOTAL_COST;
	}

	/* Getter & Setter for COST_REG_LABOR */
	public double getCOST_REG_LABOR() {
		return COST_REG_LABOR;
	}

	public void setCOST_REG_LABOR(double COST_REG_LABOR) {
		this.COST_REG_LABOR = COST_REG_LABOR;
	}

	/* Getter & Setter for COST_SUB_LB_HR */
	public double getCOST_SUB_LB_HR() {
		return COST_SUB_LB_HR;
	}

	public void setCOST_SUB_LB_HR(double COST_SUB_LB_HR) {
		this.COST_SUB_LB_HR = COST_SUB_LB_HR;
	}

	/* Getter & Setter for COST_SUB_LB_FIX */
	public double getCOST_SUB_LB_FIX() {
		return COST_SUB_LB_FIX;
	}

	public void setCOST_SUB_LB_FIX(double COST_SUB_LB_FIX) {
		this.COST_SUB_LB_FIX = COST_SUB_LB_FIX;
	}

	/* Getter & Setter for COST_OEM_HW */
	public double getCOST_OEM_HW() {
		return COST_OEM_HW;
	}

	public void setCOST_OEM_HW(double COST_OEM_HW) {
		this.COST_OEM_HW = COST_OEM_HW;
	}

	/* Getter & Setter for COST_OEM_SW */
	public double getCOST_OEM_SW() {
		return COST_OEM_SW;
	}

	public void setCOST_OEM_SW(double COST_OEM_SW) {
		this.COST_OEM_SW = COST_OEM_SW;
	}

	/* Getter & Setter for COST_T_L */
	public double getCOST_T_L() {
		return COST_T_L;
	}

	public void setCOST_T_L(double COST_T_L) {
		this.COST_T_L = COST_T_L;
	}

	/* Getter & Setter for COST_MISC */
	public double getCOST_MISC() {
		return COST_MISC;
	}

	public void setCOST_MISC(double COST_MISC) {
		this.COST_MISC = COST_MISC;
	}

	/* Getter & Setter for TOTAL_REG_LABOR_HR */
	public double getTOTAL_REG_LABOR_HR() {
		return TOTAL_REG_LABOR_HR;
	}

	public void setTOTAL_REG_LABOR_HR(double TOTAL_REG_LABOR_HR) {
		this.TOTAL_REG_LABOR_HR = TOTAL_REG_LABOR_HR;
	}

	/* Getter & Setter for REG_HRS_OUTSIDE_SC */
	public double getREG_HRS_OUTSIDE_SC() {
		return REG_HRS_OUTSIDE_SC;
	}

	public void setREG_HRS_OUTSIDE_SC(double REG_HRS_OUTSIDE_SC) {
		this.REG_HRS_OUTSIDE_SC = REG_HRS_OUTSIDE_SC;
	}

	/* Getter & Setter for SUB_LABOR_HRS */
	public double getSUB_LABOR_HRS() {
		return SUB_LABOR_HRS;
	}

	public void setSUB_LABOR_HRS(double SUB_LABOR_HRS) {
		this.SUB_LABOR_HRS = SUB_LABOR_HRS;
	}

	/* Getter & Setter for COST_TO_YR_END */
	public double getCOST_TO_YR_END() {
		return COST_TO_YR_END;
	}

	public void setCOST_TO_YR_END(double COST_TO_YR_END) {
		this.COST_TO_YR_END = COST_TO_YR_END;
	}

	/* Getter & Setter for REG_LABOR_COST_YE */
	public double getREG_LABOR_COST_YE() {
		return REG_LABOR_COST_YE;
	}

	public void setREG_LABOR_COST_YE(double REG_LABOR_COST_YE) {
		this.REG_LABOR_COST_YE = REG_LABOR_COST_YE;
	}

	/* Getter & Setter for SUB_LABOR_HR_YE */
	public double getSUB_LABOR_HR_YE() {
		return SUB_LABOR_HR_YE;
	}

	public void setSUB_LABOR_HR_YE(double SUB_LABOR_HR_YE) {
		this.SUB_LABOR_HR_YE = SUB_LABOR_HR_YE;
	}

	/* Getter & Setter for COST_LABOR_FIX_YE */
	public double getCOST_LABOR_FIX_YE() {
		return COST_LABOR_FIX_YE;
	}

	public void setCOST_LABOR_FIX_YE(double COST_LABOR_FIX_YE) {
		this.COST_LABOR_FIX_YE = COST_LABOR_FIX_YE;
	}

	/* Getter & Setter for OEM_HARDWARE_YE */
	public double getOEM_HARDWARE_YE() {
		return OEM_HARDWARE_YE;
	}

	public void setOEM_HARDWARE_YE(double OEM_HARDWARE_YE) {
		this.OEM_HARDWARE_YE = OEM_HARDWARE_YE;
	}

	/* Getter & Setter for OEM_SOFTWARE_YE */
	public double getOEM_SOFTWARE_YE() {
		return OEM_SOFTWARE_YE;
	}

	public void setOEM_SOFTWARE_YE(double OEM_SOFTWARE_YE) {
		this.OEM_SOFTWARE_YE = OEM_SOFTWARE_YE;
	}

	/* Getter & Setter for TRAVEL_LIVING_YE */
	public double getTRAVEL_LIVING_YE() {
		return TRAVEL_LIVING_YE;
	}

	public void setTRAVEL_LIVING_YE(double TRAVEL_LIVING_YE) {
		this.TRAVEL_LIVING_YE = TRAVEL_LIVING_YE;
	}

	/* Getter & Setter for MISC_YE */
	public double getMISC_YE() {
		return MISC_YE;
	}

	public void setMISC_YE(double MISC_YE) {
		this.MISC_YE = MISC_YE;
	}

	/* Getter & Setter for REG_LABOR_HRS_YE */
	public double getREG_LABOR_HRS_YE() {
		return REG_LABOR_HRS_YE;
	}

	public void setREG_LABOR_HRS_YE(double REG_LABOR_HRS_YE) {
		this.REG_LABOR_HRS_YE = REG_LABOR_HRS_YE;
	}

	/* Getter & Setter for REG_HRS_OUT_SC_YE */
	public double getREG_HRS_OUT_SC_YE() {
		return REG_HRS_OUT_SC_YE;
	}

	public void setREG_HRS_OUT_SC_YE(double REG_HRS_OUT_SC_YE) {
		this.REG_HRS_OUT_SC_YE = REG_HRS_OUT_SC_YE;
	}

	/* Getter & Setter for SUB_LABOR_HRS_YE */
	public double getSUB_LABOR_HRS_YE() {
		return SUB_LABOR_HRS_YE;
	}

	public void setSUB_LABOR_HRS_YE(double SUB_LABOR_HRS_YE) {
		this.SUB_LABOR_HRS_YE = SUB_LABOR_HRS_YE;
	}

	/* Getter & Setter for CURRENT_MONTH */
	public String getCURRENT_MONTH() {
		return CURRENT_MONTH;
	}

	public void setCURRENT_MONTH(String CURRENT_MONTH) {
		this.CURRENT_MONTH = CURRENT_MONTH;
	}

	/* Getter & Setter for UPDATE_MONTH */
	public String getUPDATE_MONTH() {
		return UPDATE_MONTH;
	}

	public void setUPDATE_MONTH(String UPDATE_MONTH) {
		this.UPDATE_MONTH = UPDATE_MONTH;
	}

	/* Getter & Setter for COST_REMAINING */
	public double getCOST_REMAINING() {
		return COST_REMAINING;
	}

	public void setCOST_REMAINING(double COST_REMAINING) {
		this.COST_REMAINING = COST_REMAINING;
	}

	/* Getter & Setter for REG_LABOR_REM */
	public double getREG_LABOR_REM() {
		return REG_LABOR_REM;
	}

	public void setREG_LABOR_REM(double REG_LABOR_REM) {
		this.REG_LABOR_REM = REG_LABOR_REM;
	}

	/* Getter & Setter for SUB_LABOR_HR_REM */
	public double getSUB_LABOR_HR_REM() {
		return SUB_LABOR_HR_REM;
	}

	public void setSUB_LABOR_HR_REM(double SUB_LABOR_HR_REM) {
		this.SUB_LABOR_HR_REM = SUB_LABOR_HR_REM;
	}

	/* Getter & Setter for SUB_LABOR_FX_REM */
	public double getSUB_LABOR_FX_REM() {
		return SUB_LABOR_FX_REM;
	}

	public void setSUB_LABOR_FX_REM(double SUB_LABOR_FX_REM) {
		this.SUB_LABOR_FX_REM = SUB_LABOR_FX_REM;
	}

	/* Getter & Setter for OEM_HARDWARE_REM */
	public double getOEM_HARDWARE_REM() {
		return OEM_HARDWARE_REM;
	}

	public void setOEM_HARDWARE_REM(double OEM_HARDWARE_REM) {
		this.OEM_HARDWARE_REM = OEM_HARDWARE_REM;
	}

	/* Getter & Setter for OEM_SOFTWARE_REM */
	public double getOEM_SOFTWARE_REM() {
		return OEM_SOFTWARE_REM;
	}

	public void setOEM_SOFTWARE_REM(double OEM_SOFTWARE_REM) {
		this.OEM_SOFTWARE_REM = OEM_SOFTWARE_REM;
	}

	/* Getter & Setter for T_L_REM */
	public double getT_L_REM() {
		return T_L_REM;
	}

	public void setT_L_REM(double T_L_REM) {
		this.T_L_REM = T_L_REM;
	}

	/* Getter & Setter for MISC_REM */
	public double getMISC_REM() {
		return MISC_REM;
	}

	public void setMISC_REM(double MISC_REM) {
		this.MISC_REM = MISC_REM;
	}

	/* Getter & Setter for REG_HRS_REM */
	public double getREG_HRS_REM() {
		return REG_HRS_REM;
	}

	public void setREG_HRS_REM(double REG_HRS_REM) {
		this.REG_HRS_REM = REG_HRS_REM;
	}

	/* Getter & Setter for REG_HRS_OUT_SC_REM */
	public double getREG_HRS_OUT_SC_REM() {
		return REG_HRS_OUT_SC_REM;
	}

	public void setREG_HRS_OUT_SC_REM(double REG_HRS_OUT_SC_REM) {
		this.REG_HRS_OUT_SC_REM = REG_HRS_OUT_SC_REM;
	}

	/* Getter & Setter for SUB_LABOR_HRS_REM */
	public double getSUB_LABOR_HRS_REM() {
		return SUB_LABOR_HRS_REM;
	}

	public void setSUB_LABOR_HRS_REM(double SUB_LABOR_HRS_REM) {
		this.SUB_LABOR_HRS_REM = SUB_LABOR_HRS_REM;
	}

	/* Getter & Setter for TOTAL_COSTP */
	public double getTOTAL_COSTP() {
		return TOTAL_COSTP;
	}

	public void setTOTAL_COSTP(double TOTAL_COSTP) {
		this.TOTAL_COSTP = TOTAL_COSTP;
	}

	/* Getter & Setter for COST_REG_LABORP */
	public double getCOST_REG_LABORP() {
		return COST_REG_LABORP;
	}

	public void setCOST_REG_LABORP(double COST_REG_LABORP) {
		this.COST_REG_LABORP = COST_REG_LABORP;
	}

	/* Getter & Setter for COST_SUB_LB_HRP */
	public double getCOST_SUB_LB_HRP() {
		return COST_SUB_LB_HRP;
	}

	public void setCOST_SUB_LB_HRP(double COST_SUB_LB_HRP) {
		this.COST_SUB_LB_HRP = COST_SUB_LB_HRP;
	}

	/* Getter & Setter for COST_SUB_LB_FIXP */
	public double getCOST_SUB_LB_FIXP() {
		return COST_SUB_LB_FIXP;
	}

	public void setCOST_SUB_LB_FIXP(double COST_SUB_LB_FIXP) {
		this.COST_SUB_LB_FIXP = COST_SUB_LB_FIXP;
	}

	/* Getter & Setter for COST_OEM_HWP */
	public double getCOST_OEM_HWP() {
		return COST_OEM_HWP;
	}

	public void setCOST_OEM_HWP(double COST_OEM_HWP) {
		this.COST_OEM_HWP = COST_OEM_HWP;
	}

	/* Getter & Setter for COST_OEM_SWP */
	public double getCOST_OEM_SWP() {
		return COST_OEM_SWP;
	}

	public void setCOST_OEM_SWP(double COST_OEM_SWP) {
		this.COST_OEM_SWP = COST_OEM_SWP;
	}

	/* Getter & Setter for COST_T_LP */
	public double getCOST_T_LP() {
		return COST_T_LP;
	}

	public void setCOST_T_LP(double COST_T_LP) {
		this.COST_T_LP = COST_T_LP;
	}

	/* Getter & Setter for COST_MISCP */
	public double getCOST_MISCP() {
		return COST_MISCP;
	}

	public void setCOST_MISCP(double COST_MISCP) {
		this.COST_MISCP = COST_MISCP;
	}

	/* Getter & Setter for COST_TO_YR_ENDP */
	public double getCOST_TO_YR_ENDP() {
		return COST_TO_YR_ENDP;
	}

	public void setCOST_TO_YR_ENDP(double COST_TO_YR_ENDP) {
		this.COST_TO_YR_ENDP = COST_TO_YR_ENDP;
	}

	/* Getter & Setter for REG_LABOR_COST_YEP */
	public double getREG_LABOR_COST_YEP() {
		return REG_LABOR_COST_YEP;
	}

	public void setREG_LABOR_COST_YEP(double REG_LABOR_COST_YEP) {
		this.REG_LABOR_COST_YEP = REG_LABOR_COST_YEP;
	}

	/* Getter & Setter for SUB_LABOR_HR_YEP */
	public double getSUB_LABOR_HR_YEP() {
		return SUB_LABOR_HR_YEP;
	}

	public void setSUB_LABOR_HR_YEP(double SUB_LABOR_HR_YEP) {
		this.SUB_LABOR_HR_YEP = SUB_LABOR_HR_YEP;
	}

	/* Getter & Setter for COST_LABOR_FIX_YEP */
	public double getCOST_LABOR_FIX_YEP() {
		return COST_LABOR_FIX_YEP;
	}

	public void setCOST_LABOR_FIX_YEP(double COST_LABOR_FIX_YEP) {
		this.COST_LABOR_FIX_YEP = COST_LABOR_FIX_YEP;
	}

	/* Getter & Setter for OEM_HARDWARE_YEP */
	public double getOEM_HARDWARE_YEP() {
		return OEM_HARDWARE_YEP;
	}

	public void setOEM_HARDWARE_YEP(double OEM_HARDWARE_YEP) {
		this.OEM_HARDWARE_YEP = OEM_HARDWARE_YEP;
	}

	/* Getter & Setter for OEM_SOFTWARE_YEP */
	public double getOEM_SOFTWARE_YEP() {
		return OEM_SOFTWARE_YEP;
	}

	public void setOEM_SOFTWARE_YEP(double OEM_SOFTWARE_YEP) {
		this.OEM_SOFTWARE_YEP = OEM_SOFTWARE_YEP;
	}

	/* Getter & Setter for TRAVEL_LIVING_YEP */
	public double getTRAVEL_LIVING_YEP() {
		return TRAVEL_LIVING_YEP;
	}

	public void setTRAVEL_LIVING_YEP(double TRAVEL_LIVING_YEP) {
		this.TRAVEL_LIVING_YEP = TRAVEL_LIVING_YEP;
	}

	/* Getter & Setter for MISC_YEP */
	public double getMISC_YEP() {
		return MISC_YEP;
	}

	public void setMISC_YEP(double MISC_YEP) {
		this.MISC_YEP = MISC_YEP;
	}

	/* Getter & Setter for COST_REMAININGP */
	public double getCOST_REMAININGP() {
		return COST_REMAININGP;
	}

	public void setCOST_REMAININGP(double COST_REMAININGP) {
		this.COST_REMAININGP = COST_REMAININGP;
	}

	/* Getter & Setter for REG_LABOR_REMP */
	public double getREG_LABOR_REMP() {
		return REG_LABOR_REMP;
	}

	public void setREG_LABOR_REMP(double REG_LABOR_REMP) {
		this.REG_LABOR_REMP = REG_LABOR_REMP;
	}

	/* Getter & Setter for SUB_LABOR_HR_REMP */
	public double getSUB_LABOR_HR_REMP() {
		return SUB_LABOR_HR_REMP;
	}

	public void setSUB_LABOR_HR_REMP(double SUB_LABOR_HR_REMP) {
		this.SUB_LABOR_HR_REMP = SUB_LABOR_HR_REMP;
	}

	/* Getter & Setter for SUB_LABOR_FX_REMP */
	public double getSUB_LABOR_FX_REMP() {
		return SUB_LABOR_FX_REMP;
	}

	public void setSUB_LABOR_FX_REMP(double SUB_LABOR_FX_REMP) {
		this.SUB_LABOR_FX_REMP = SUB_LABOR_FX_REMP;
	}

	/* Getter & Setter for OEM_HARDWARE_REMP */
	public double getOEM_HARDWARE_REMP() {
		return OEM_HARDWARE_REMP;
	}

	public void setOEM_HARDWARE_REMP(double OEM_HARDWARE_REMP) {
		this.OEM_HARDWARE_REMP = OEM_HARDWARE_REMP;
	}

	/* Getter & Setter for OEM_SOFTWARE_REMP */
	public double getOEM_SOFTWARE_REMP() {
		return OEM_SOFTWARE_REMP;
	}

	public void setOEM_SOFTWARE_REMP(double OEM_SOFTWARE_REMP) {
		this.OEM_SOFTWARE_REMP = OEM_SOFTWARE_REMP;
	}

	/* Getter & Setter for T_L_REMP */
	public double getT_L_REMP() {
		return T_L_REMP;
	}

	public void setT_L_REMP(double T_L_REMP) {
		this.T_L_REMP = T_L_REMP;
	}

	/* Getter & Setter for MISC_REMP */
	public double getMISC_REMP() {
		return MISC_REMP;
	}

	public void setMISC_REMP(double MISC_REMP) {
		this.MISC_REMP = MISC_REMP;
	}

}
