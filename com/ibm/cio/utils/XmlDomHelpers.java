package com.ibm.cio.utils;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class XmlDomHelpers {

  private static String HTMLString = "";

  public XmlDomHelpers() {}

  public static String getAttributeValue(Element start, String attrName) {
	if (start.getNodeType() == Element.ELEMENT_NODE) {
	  NamedNodeMap startAttr = start.getAttributes();
	  for (int i = 0; i<startAttr.getLength(); i++) {
		Node attr = startAttr.item(i);
		if (attrName.equals(attr.getNodeName().trim()))
		  return attr.getNodeValue().trim();
	  }
	  return null;
	}
	else return null;
  }

  public static String getElementValue(Element parentElement, String tag) {
	if (parentElement.getElementsByTagName(tag).item(0) == null) return null;
	else if (parentElement.getElementsByTagName(tag).item(0).getFirstChild()==null) return null;
	else return parentElement.getElementsByTagName(tag).item(0).getFirstChild().getNodeValue();	
	//return (parentElement.getElementsByTagName(tag).item(0) == null
	//	  ? "None"
	//	  : parentElement.getElementsByTagName(tag).item(0).getFirstChild().getNodeValue()
	//	   );
 }

   public static Element getParentXElement(Element startElement, String xmlTag) {
	boolean found = false;
	if (startElement == null) return null;
	Node parentNode = startElement.getParentNode();
	while (!found) {
	  if (parentNode == null) found = true;
	  else if (parentNode.getNodeName().equals(xmlTag)) found = true;
	  if (!found) parentNode = parentNode.getParentNode();
	}
	return (Element)parentNode;
  }

  public static String getXmlString(Node start) {
	getAllChildren(start,0);
	return HTMLString;
  }  

  public static String getHTMLString(Node start) {
	return getHTMLString(start, false);
  }

  public static String getHTMLString(Node start, boolean covertPredefEntities) {
	getAllChildrenString(start, 0);
	if (covertPredefEntities)
	  return HTMLString.replace('@', '&');
	else
	  return HTMLString;
  }

  public static int getAllChildrenString(Node start, int offset) {
	//String spacers  = "                                                         ";
	String tagOpen = "<";
	String tagClose = ">";
	String tagEndOpen = "</";
	String tagEndClose = ">";
	String tagName = start.getNodeName();
	String tagValue = (start.getNodeValue() == null ? "" : start.getNodeValue());

	if (start.getNodeName().trim().equals("#text")) {
	  tagOpen ="";
	  tagClose = "";
	  tagName = "";
	  tagEndOpen = "";
	  tagEndClose = "";
	}
	if (offset == 0) HTMLString = "";
	else {
	  HTMLString += //spacers.substring(0, offset) +
				   tagOpen + tagName;

	  if (start.getNodeType() == Element.ELEMENT_NODE) {
		NamedNodeMap startAttr = start.getAttributes();
		for (int i = 0; i<startAttr.getLength(); i++) {
		  Node attr = startAttr.item(i);
		  HTMLString += " "+ attr.getNodeName()
					  +"=\""+attr.getNodeValue()+ "\"";
		}
	  }
	  HTMLString += tagClose + tagValue;
	}

	for (Node child = start.getFirstChild();
		 child != null;
		 child = child.getNextSibling()) {
	  getAllChildrenString(child, offset + 1);
	}

	if (offset > 0
	 && tagName.length() > 0) {
	  HTMLString += //spacers.substring(0, offset) +
				  tagEndOpen + tagName  + tagEndClose;
	}

	return ++offset;
  }  

  public static int getAllChildren(Node start, int offset) {
	//String spacers  = "                                                         ";
	String tagOpen = "<";
	String tagClose = ">";
	String tagEndOpen = "</";
	String tagEndClose = ">";
	String tagName = start.getNodeName();
	String tagValue = (start.getNodeValue() == null ? "" : start.getNodeValue());

	if (start.getNodeName().trim().equals("#text")) {
	  tagOpen ="";
	  tagClose = "";
	  tagName = "";
	  tagEndOpen = "";
	  tagEndClose = "";
	}
	else if (start.getNodeName().trim().equals("#comment")) {
	  tagOpen ="<!--";
	  tagClose = "";
	  tagName = "";
	  tagEndOpen = "";
	  tagEndClose = "-->";
	}
	if (offset == 0) HTMLString = "";

	HTMLString += tagOpen + tagName;

	if (start.getNodeType() == Element.ELEMENT_NODE) {
		NamedNodeMap startAttr = start.getAttributes();
		for (int i = 0; i<startAttr.getLength(); i++) {
			Node attr = startAttr.item(i);
			HTMLString += " "+ attr.getNodeName()
					  +"=\""+attr.getNodeValue()+ "\"";
		}
	}
	HTMLString += tagClose + tagValue;

	for (Node child = start.getFirstChild();
		 child != null;
		 child = child.getNextSibling()) {
	  getAllChildren(child, offset + 1);
	}

	//if (offset > 0 && tagName.length() > 0) {
	if (tagName.length() > 0 || start.getNodeName().trim().equals("#comment")) {
	  HTMLString += tagEndOpen + tagName  + tagEndClose;
	}

	return ++offset;
  }  


  public static void stepThrough(Node start) {
	System.out.println(start.getNodeName()+" = "+start.getNodeValue());

	if (start.getNodeType() == Element.ELEMENT_NODE) {
	  NamedNodeMap startAttr = start.getAttributes();
	  for (int i = 0; i < startAttr.getLength(); i++) {
		Node attr = startAttr.item(i);
		System.out.println(" Attribute: "+ attr.getNodeName()
						  +" = "+attr.getNodeValue());
	  }
	}

	for (Node child = start.getFirstChild(); child != null; child = child.getNextSibling()) {
	  stepThrough(child);
	}
  }

  public static String convertXMLEntities(String s) {
	  if (s == null)
		  return "null";
	  String t = "";
	  for (int i = 0; i < s.length(); i++) {
		  if (s.substring(i, i + 1).equals("'"))
			  t += "&apos;";
		  else if (s.substring(i, i + 1).equals("\""))
			  t += "&quot;";
		  else if (s.substring(i, i + 1).equals("<"))
			  t += "&lt;";
		  else if (s.substring(i, i + 1).equals(">"))
			  t += "&gt;";
		  else if (s.substring(i, i + 1).equals("&"))
			  t += "&amp;";
		  else
			  t += s.substring(i, i + 1);
	  }
	  return t;
  }

	public static String checkXMLSting(String origStr) {
		byte[] origBytes = origStr.getBytes();
		StringBuffer sb = new StringBuffer(origBytes.length);  	
		for (int i=0; i<origBytes.length; i++) {
			System.out.println(i + "  ="+String.valueOf(origBytes[i]));
			if (origBytes[i]<0) sb.append(" ");
			else sb.append(origStr.substring(i,i+1));
		}
		return sb.toString();
  }
}
