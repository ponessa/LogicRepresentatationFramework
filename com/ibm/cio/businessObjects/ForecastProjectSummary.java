/**
 * 
 */
package com.ibm.cio.businessObjects;

/**
 * @author ponessa
 *
 */
public class ForecastProjectSummary {
	private int REC_CNT = -1;
	private String RECORD_TYPE = null;
	private double SUM_MTHLY_AMT = 0.0;
	private double SUM_MTHLYP_AMT = 0.0;
	
	public ForecastProjectSummary() {}

	public int getREC_CNT() {
		return REC_CNT;
	}

	public void setREC_CNT(int rEC_CNT) {
		REC_CNT = rEC_CNT;
	}

	public String getRECORD_TYPE() {
		return RECORD_TYPE;
	}

	public void setRECORD_TYPE(String rECORD_TYPE) {
		RECORD_TYPE = rECORD_TYPE;
	}

	public double getSUM_MTHLY_AMT() {
		return SUM_MTHLY_AMT;
	}

	public void setSUM_MTHLY_AMT(double sUM_MTHLY_AMT) {
		SUM_MTHLY_AMT = sUM_MTHLY_AMT;
	}

	public double getSUM_MTHLYP_AMT() {
		return SUM_MTHLYP_AMT;
	}

	public void setSUM_MTHLYP_AMT(double sUM_MTHLYP_AMT) {
		SUM_MTHLYP_AMT = sUM_MTHLYP_AMT;
	}

}
