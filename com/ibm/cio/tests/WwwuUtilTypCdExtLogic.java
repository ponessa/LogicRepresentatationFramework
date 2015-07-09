package com.ibm.cio.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class WwwuUtilTypCdExtLogic {
	private ArrayList<Rule> rules = null;
	
	public WwwuUtilTypCdExtLogic() {}
	
	public class WwwuRecord {
		protected String PRFRMNG_LOB_CD = null; //PRFRMNG_LOB_CD
		protected String OWNG_LOB_CD = null; 	//OWNG_LOB_CD
		protected String UTIL_TYP_CD = null; 	//Original UTIL_TYP_CD
		protected String RPTGRP_CNTL_CD = null;	//RPTGRP_CNTL_CD 
		protected String ACTVTY_CD = null; 		//ACTVTY_CD
		protected String ACCT_ID = null;		//ACCT_ID
		protected String CNTL_GRP_CD = null;	//CNTL_GRP_CD
		
		protected int ruleNumber = -1;
		
		public WwwuRecord(String PRFRMNG_LOB_CD, String OWNG_LOB_CD, String UTIL_TYP_CD, String ACTVTY_CD, String RPTGRP_CNTL_CD, String ACCT_ID, String CNTL_GRP_CD) {
			this.PRFRMNG_LOB_CD = PRFRMNG_LOB_CD;
			this.OWNG_LOB_CD = OWNG_LOB_CD;
			this.UTIL_TYP_CD = UTIL_TYP_CD;
			this.ACTVTY_CD = ACTVTY_CD;
			this.RPTGRP_CNTL_CD = RPTGRP_CNTL_CD;
			this.ACCT_ID = ACCT_ID;
			this.CNTL_GRP_CD = CNTL_GRP_CD;
		}
	}
	
	private class Rule {
		public static final int OPERATION_UNDEFINED = -1;
		public static final int OPERATION_EQUALS = 1;
		public static final int OPERATION_LIKE = 2;
		public static final int OPERATION_CONCATINATION = 4;
		
		protected String PRFRMNG_LOB_CD = null; 				//PRFRMNG_LOB_CD
		protected String OWNG_LOB_CD = null; 					//OWNG_LOB_CD
		protected String ORIG_UTIL_TYP_CD = null; 				//Original UTIL_TYP_CD
		protected String ACTVTY_CD = null; 						//ACTVTY_CD
		protected int ACTVTY_OPERATOR_CD = OPERATION_UNDEFINED; //ACTVTY_CD
		protected String RPTGRP_CNTL_CD = null;					//RPTGRP_CNTL_CD
		protected int RPTGRP_CNTL_OPERATOR_CD = OPERATION_UNDEFINED;	//		
		protected String OVRD_UTIL_TYP_CD = null;
		
		public Rule(String PRFRMNG_LOB_CD, String OWNG_LOB_CD, String ORIG_UTIL_TYP_CD, String OVRD_UTIL_TYP_CD ) {
			this(PRFRMNG_LOB_CD, OWNG_LOB_CD, ORIG_UTIL_TYP_CD, null, -1, null, -1, OVRD_UTIL_TYP_CD);
		}
		
		public Rule(String PRFRMNG_LOB_CD, String OWNG_LOB_CD, String ORIG_UTIL_TYP_CD
				  , String ACTVTY_CD, int ACTVTY_OPERATOR_CD, String RPTGRP_CNTL_CD, int RPTGRP_CNTL_OPERATOR_CD, String OVRD_UTIL_TYP_CD ) {
			this.PRFRMNG_LOB_CD = PRFRMNG_LOB_CD;
			this.OWNG_LOB_CD = OWNG_LOB_CD;
			this.ORIG_UTIL_TYP_CD = ORIG_UTIL_TYP_CD;
			this.ACTVTY_CD = ACTVTY_CD;
			this.ACTVTY_OPERATOR_CD = ACTVTY_OPERATOR_CD;
			this.RPTGRP_CNTL_CD = RPTGRP_CNTL_CD;
			this.RPTGRP_CNTL_OPERATOR_CD = RPTGRP_CNTL_OPERATOR_CD;
			this.OVRD_UTIL_TYP_CD = OVRD_UTIL_TYP_CD;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("WWWU Utilization Type Code Override began at: "+new java.util.Date());
		
		WwwuUtilTypCdExtLogic wwwuUtilTypCdExtLogic = new WwwuUtilTypCdExtLogic();
		if (!wwwuUtilTypCdExtLogic.getRules()) {
			System.out.println("ERROR - WWWU Utilization Type Code Override failed at: "+new java.util.Date());
			return;
		}
		if (!wwwuUtilTypCdExtLogic.process()) {
			System.out.println("ERROR - WWWU Utilization Type Code Override failed at: "+new java.util.Date());
			return;
		}
		System.out.println("SUCCESS - WWWU Utilization Type Code Override completed at: "+new java.util.Date());
	}
	
	public boolean process() {
		System.out.println("PLC\tOLC\tUTC\tActvtyCd\tRPTGRP\tO-UTC\tRule#");
		System.out.println("---\t---\t---\t--------\t------\t-----\t-----");
		
		try {
			File f = new File("C:/$user/ISLS/1H15/wwwuUtilTypCdOverride/testData.csv");
			FileInputStream fis = new FileInputStream(f);
			 
			//Construct BufferedReader from InputStreamReader
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		 
			String line = null;

			while ((line = br.readLine()) != null) {
				String[] tokens = line.split(",");
				
				WwwuRecord wwwuRecord = new WwwuRecord(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
				System.out.println(wwwuRecord.PRFRMNG_LOB_CD+"\t"+wwwuRecord.OWNG_LOB_CD+"\t"+wwwuRecord.UTIL_TYP_CD+"\t"+wwwuRecord.ACTVTY_CD+"\t"+wwwuRecord.RPTGRP_CNTL_CD+"\t"+overrideUtilTypCd(wwwuRecord)+"\t"+wwwuRecord.ruleNumber);				
			}
			br.close();	
		} //end - try
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;			
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;				
		}				
		
		return true;
	}
	
	public boolean getRules() {
		rules = new ArrayList<Rule>();
		try {
			File f = new File("C:/$user/ISLS/1H15/wwwuUtilTypCdOverride/rules.csv");
			FileInputStream fis = new FileInputStream(f);
			 
			//Construct BufferedReader from InputStreamReader
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		 
			String line = null;

			int ruleCnt=0;
			while ((line = br.readLine()) != null) {
				if (++ruleCnt==1) continue;
				String[] tokens = line.split(",");
				
				String PRFRMNG_LOB_CD  = tokens[0].trim();
				String OWNG_LOB_CD  = tokens[1].trim();
				String ORIG_UTIL_TYP_CD  = tokens[2].trim();
				
				String actvtyOperatorStr = tokens[3].trim();	
				String ACTVTY_CD  = tokens[4].trim();				
				int ACTVTY_OPERATOR_CD = Rule.OPERATION_UNDEFINED;
				if ((ACTVTY_CD.length()==0 && actvtyOperatorStr.length()>0)
				  || ACTVTY_CD.length()>0  && actvtyOperatorStr.length()==0) {
					System.out.println("Rules error - Activity Code.");
					return false;
				}
				if (actvtyOperatorStr.length()==0) ACTVTY_OPERATOR_CD = Rule.OPERATION_UNDEFINED;
				else if (actvtyOperatorStr.equalsIgnoreCase("LIKE")) ACTVTY_OPERATOR_CD = Rule.OPERATION_LIKE;
				else if (actvtyOperatorStr.equalsIgnoreCase("EQ")) ACTVTY_OPERATOR_CD = Rule.OPERATION_EQUALS;
				else {
					System.out.println("Rules error - Undefined Activity Code Operator.");
					return false;
				}
				
				String rptgrpOperatorStr = tokens[5].trim();
				String RPTGRP_CNTL_CD  = tokens[6].trim();
				int RPTGRP_CNTL_OPERATOR_CD= Rule.OPERATION_UNDEFINED;
				if ((RPTGRP_CNTL_CD.length()==0 && rptgrpOperatorStr.length()>0)
				  || RPTGRP_CNTL_CD.length()>0  && rptgrpOperatorStr.length()==0) {
					System.out.println("Rules error - Report Group Control Code.");
					return false;
				}
				if (rptgrpOperatorStr.length()==0) RPTGRP_CNTL_OPERATOR_CD = Rule.OPERATION_UNDEFINED;
				else if (rptgrpOperatorStr.equalsIgnoreCase("CONCAT")) RPTGRP_CNTL_OPERATOR_CD = Rule.OPERATION_CONCATINATION;
				else if (rptgrpOperatorStr.equalsIgnoreCase("EQ")) RPTGRP_CNTL_OPERATOR_CD = Rule.OPERATION_EQUALS;
				else {
					System.out.println("Rules error - Undefined Report Group Code Operator.");
					return false;
				}				
				
				String OVRD_UTIL_TYP_CD  = tokens[7].trim();
				
				rules.add(new Rule(PRFRMNG_LOB_CD, OWNG_LOB_CD, ORIG_UTIL_TYP_CD, ACTVTY_CD, ACTVTY_OPERATOR_CD, RPTGRP_CNTL_CD, RPTGRP_CNTL_OPERATOR_CD, OVRD_UTIL_TYP_CD ));				
			}		 
			br.close();	
		} //end - try
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;			
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;				
		}
		
		return true;
	}
	
	public String overrideUtilTypCd(WwwuRecord wwwu) {
		//Assign current utilization type code to variable for the new utilization type code
		String NEW_UTIL_TYP_CD = wwwu.UTIL_TYP_CD;
		Rule rule = null;
		boolean ruleApplied = false;
	
		//Loop through rules array
		for (int i=0; i<rules.size(); i++) { 
			rule = rules.get(i);
			
			//Check if the rule’s Performing LoB Cd, Owning LoB Cd, and Original Utilization Type Code matches record.
			if (wwwu.PRFRMNG_LOB_CD.equals(rule.PRFRMNG_LOB_CD) 
					&& wwwu.OWNG_LOB_CD.equals(rule.OWNG_LOB_CD) 
					&& wwwu.UTIL_TYP_CD.equals(rule.ORIG_UTIL_TYP_CD)) {
				wwwu.ruleNumber=i;
				if (rule.ACTVTY_OPERATOR_CD!=Rule.OPERATION_UNDEFINED) {
					switch (rule.ACTVTY_OPERATOR_CD) {
						case (Rule.OPERATION_LIKE):
							if (wwwu.ACTVTY_CD.startsWith(rule.ACTVTY_CD)) {
								NEW_UTIL_TYP_CD = rule.OVRD_UTIL_TYP_CD;
								ruleApplied = true;
							}
							break;
						case (Rule.OPERATION_EQUALS):
							if (wwwu.ACTVTY_CD.equals(rule.ACTVTY_CD)) {
								NEW_UTIL_TYP_CD = rule.OVRD_UTIL_TYP_CD;
								ruleApplied = true;
							}
							break;							
					} //end - switch						
				} //end - if (rule.ACTVTY_OPERATOR_CD!=Rule.OPERATION_UNDEFINED)
				else if (rule.RPTGRP_CNTL_OPERATOR_CD!=Rule.OPERATION_UNDEFINED) {
					switch (rule.RPTGRP_CNTL_OPERATOR_CD) {
						case (Rule.OPERATION_CONCATINATION):
							if (wwwu.RPTGRP_CNTL_CD.equals(wwwu.OWNG_LOB_CD+rule.RPTGRP_CNTL_CD)) {
								NEW_UTIL_TYP_CD = rule.OVRD_UTIL_TYP_CD;
								ruleApplied = true;
							}
							break;		
						case (Rule.OPERATION_EQUALS):
							if (wwwu.RPTGRP_CNTL_CD.equals(rule.RPTGRP_CNTL_CD)) {
								NEW_UTIL_TYP_CD = rule.OVRD_UTIL_TYP_CD;
								ruleApplied = true;
							}
							break;
					} //end - switch		
				} //end - if (rule.RPTGRP_CNTL_OPERATOR_CD!=Rule.OPERATION_UNDEFINED) 
				else {
					NEW_UTIL_TYP_CD = rule.OVRD_UTIL_TYP_CD;
					ruleApplied = true;
				}				
				if (ruleApplied) break; //break out of the rules loop
			} // end - if (wwwu.PRFRMNG_LOB_CD.equals(rule.PRFRMNG_LOB_CD) 
			  //             && wwwu.OWNG_LOB_CD.equals(rule.OWNG_LOB_CD) 
			  //			 && wwwu.OWNG_LOB_CD.equals(rule.ORIG_UTIL_TYP_CD))		
		} //end - for (int i=0; i<rules.size(); i++)
		return NEW_UTIL_TYP_CD;
	}

}
