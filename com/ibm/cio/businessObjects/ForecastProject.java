/**
 * File  ForecastProject.java
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

public class ForecastProject {

	private String PartId = null;

	private String CtryCd = null;

	private String CmpnyCd = null;

	private String WorkNum = null;

	private String YrNum = null;

	private String MthNum = null;

	private String RecTypCd = null;

	private String PoNum = null;

	private double MthlyAmt = -1;

	private double MthlyPAmt = -1;

	private int MhlHrs = -1;

	public ForecastProject() {
	}

	public ForecastProject(String PartId, String CtryCd, String CmpnyCd,
			String WorkNum, String YrNum, String MthNum, String RecTypCd,
			String PoNum, double MthlyAmt, double MthlyPAmt, int MhlHrs) {

		this.PartId = PartId;

		this.CtryCd = CtryCd;

		this.CmpnyCd = CmpnyCd;

		this.WorkNum = WorkNum;

		this.YrNum = YrNum;

		this.MthNum = MthNum;

		this.RecTypCd = RecTypCd;

		this.PoNum = PoNum;

		this.MthlyAmt = MthlyAmt;

		this.MthlyPAmt = MthlyPAmt;

		this.MhlHrs = MhlHrs;

	}

	/* Getter & Setter for PartId */
	public String getPartId() {
		return PartId;
	}

	public void setPartId(String PartId) {
		this.PartId = PartId;
	}

	/* Getter & Setter for CtryCd */
	public String getCtryCd() {
		return CtryCd;
	}

	public void setCtryCd(String CtryCd) {
		this.CtryCd = CtryCd;
	}

	/* Getter & Setter for CmpnyCd */
	public String getCmpnyCd() {
		return CmpnyCd;
	}

	public void setCmpnyCd(String CmpnyCd) {
		this.CmpnyCd = CmpnyCd;
	}

	/* Getter & Setter for WorkNum */
	public String getWorkNum() {
		return WorkNum;
	}

	public void setWorkNum(String WorkNum) {
		this.WorkNum = WorkNum;
	}

	/* Getter & Setter for YrNum */
	public String getYrNum() {
		return YrNum;
	}

	public void setYrNum(String YrNum) {
		this.YrNum = YrNum;
	}

	/* Getter & Setter for MthNum */
	public String getMthNum() {
		return MthNum;
	}

	public void setMthNum(String MthNum) {
		this.MthNum = MthNum;
	}

	/* Getter & Setter for RecTypCd */
	public String getRecTypCd() {
		return RecTypCd;
	}

	public void setRecTypCd(String RecTypCd) {
		this.RecTypCd = RecTypCd;
	}

	/* Getter & Setter for PoNum */
	public String getPoNum() {
		return PoNum;
	}

	public void setPoNum(String PoNum) {
		this.PoNum = PoNum;
	}

	/* Getter & Setter for MthlyAmt */
	public double getMthlyAmt() {
		return MthlyAmt;
	}

	public void setMthlyAmt(double MthlyAmt) {
		this.MthlyAmt = MthlyAmt;
	}

	/* Getter & Setter for MthlyPAmt */
	public double getMthlyPAmt() {
		return MthlyPAmt;
	}

	public void setMthlyPAmt(double MthlyPAmt) {
		this.MthlyPAmt = MthlyPAmt;
	}

	/* Getter & Setter for MhlHrs */
	public int getMhlHrs() {
		return MhlHrs;
	}

	public void setMhlHrs(int MhlHrs) {
		this.MhlHrs = MhlHrs;
	}

}