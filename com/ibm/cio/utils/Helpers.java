package com.ibm.cio.utils;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.File;
import java.util.StringTokenizer;
import java.lang.Integer;

public class Helpers {

  public static String setWidth(String width) {
    if (width.endsWith("pt")) {
      int result = (Integer.parseInt(width.substring(0, width.length()-2)) / 5);
      width = String.valueOf(result) + "%";
    }

    return width;
  }

  public static String getDate() {
    String months[] = {"January", "February", "March", "April", "May", "June"
                     , "July"   , "August",   "September", "October", "November", "December"};
      /*Get today's date for last published date*/
      Calendar calendar = new GregorianCalendar();
      return String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)) + " "
           + months[calendar.get(Calendar.MONTH)] + " "
           + String.valueOf(calendar.get(Calendar.YEAR)) ;
  }

  public static String getPDFSize(String directory, String pdfFileName) {
      /*Get size of PDF file*/
      try {
        File pdfFile = new File(directory + "/" + pdfFileName+ "-a4.pdf");
        return String.valueOf((pdfFile.length()/1024)+1);
      }
      catch (NullPointerException npe) {
        return "?";
      }
      catch (SecurityException se) {
        return "?";
      }
  }

  public static String getFileName(String filename) {
    if (filename.startsWith("http://w3.ibm.com/images/"))
    //if (filename.substring(0,25).equalsIgnoreCase("http://w3.ibm.com/images/"))
      return "images/w3/" + filename.substring(25,filename.length());
    else
      return filename;
  }

  public static String getFileNameWOExtension(String filename) {
    StringTokenizer st = new StringTokenizer(filename, "/.");
    String token = "";
    String lastToken = "";

    while (st.hasMoreTokens()) {
      lastToken = token;
      token = st.nextToken();
   }
   return lastToken;
  }

  public static String getFileNameWExtension(String filename) {
    StringTokenizer st = new StringTokenizer(filename, "/.");
    String token = "";
    String lastToken = "";

    while (st.hasMoreTokens()) {
      lastToken = token;
      token = st.nextToken();
   }
   return lastToken+"."+token;
  }
  
  public static String setHeight(String h) {
  	return String.valueOf(Integer.parseInt(h) + 200);
  }
  
  public static String setWidth2(String w) {
  	return String.valueOf(Integer.parseInt(w) + 65);
  }  
  	
}
