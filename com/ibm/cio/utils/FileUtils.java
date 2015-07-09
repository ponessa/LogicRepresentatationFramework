package com.ibm.cio.utils;
/** 
 * Copyright (C) 2002, International Business Machines Corporation
 * All Rights Reserved.
 **/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.NodeIterator;

public class FileUtils
{
  public static String getFileSeparator(String currentDirectory)
    throws java.io.IOException
  {
    if (currentDirectory.length() > 0 && !currentDirectory.endsWith(File.separator))
      currentDirectory += File.separator;

    System.out.println("\nFiles will be written to the directory " + currentDirectory + ".");

    File path = new File(currentDirectory);
    if (path.mkdirs())
    {
      System.out.println("\tThe directory was just created.");
      path = new File(currentDirectory + "images");
      path.mkdirs();
      path = new File(currentDirectory + "popup");
      path.mkdirs();
    }

    System.out.println();

    return File.separator;
  }

  public static void copyGraphicFiles(String baseFilename
                                    , String currentDirectory
                                    , String fileSeparator
                                    , NodeIterator graphicsElements)  {

    Node currentNode = graphicsElements.nextNode();
    byte[] buffer = new byte[4096];
    int bytes_read;    
    
    while (currentNode != null) {
      FileInputStream fis = null;
      FileOutputStream fos = null;
      File fileToCopy = null;
      File copiedFile = null;

        // We should make sure the node is a DOM Element. Our stylesheet
        // only passes Elements in, but that might change....
        if (currentNode instanceof Element) {
          String nextGraphicsFile = ((Element)currentNode).getAttribute("img");

          if (nextGraphicsFile == null || nextGraphicsFile.length() == 0)
            nextGraphicsFile = ((Element)currentNode).getAttribute("src");

          if (nextGraphicsFile!=null && !nextGraphicsFile.substring(0,4).equalsIgnoreCase("HTTP")) {
            try {
              fileToCopy = new File(nextGraphicsFile);
              copiedFile = new File(currentDirectory + fileSeparator +
                                    nextGraphicsFile);
              fis = new FileInputStream(fileToCopy);
              fos = new FileOutputStream(copiedFile);
              while ((bytes_read = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytes_read);
              } //end while
              fos.flush();
              fos.close();
            } //end try
            catch (java.io.IOException ioe) {
              System.err.println("An error has occurred while copying graphic file:\n" + ioe);
              return;
            }
          } //end if not HTTP
        } //end if an element
        currentNode = graphicsElements.nextNode();
    }
  }

  public static void copyFile(String source
                            , String targetDirectory
                            , String filesep) throws IOException {

      byte[] buffer = new byte[4096];
      int bytes_read;    

      FileInputStream fis = null;
      FileOutputStream fos = null;
      File fileToCopy = null;
      File copiedFile = null;

      try {
        fileToCopy = new File(System.getProperty("user.dir") + filesep + source);
        copiedFile = new File(System.getProperty("user.dir") + filesep + targetDirectory + filesep + source);

        fis = new FileInputStream(fileToCopy);
        fos = new FileOutputStream(copiedFile);
        while ((bytes_read = fis.read(buffer)) != -1) {
          fos.write(buffer, 0, bytes_read);
        } //end while
        fos.flush();
        fos.close();
      } //end try
      catch (java.io.IOException ioe) {
        System.err.println("An error has occurred while copying file:\n" + ioe);
        ioe.printStackTrace();
        return;
      }
  }

 /** Conveinience method to throw an exception */
 protected static void failIO (String msg) throws IOException {
  throw new IOException(msg);
 }

}
