package com.ibm.cio.decisionTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

//import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ibm.cio.utils.XmlDomHelpers;

public class SimpleDecisionTree {

	static BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
	
	private SimpleBinaryTreeNode rootNode = null;

	/* Default Constructor */
	public SimpleDecisionTree() {
	}
	
	public static void main(String[] args) {
		//static Logger logger = Logger.getLogger(DecisionTree.class);		
	}
	
	public boolean buildTree(String xmlFileName) {	
		try {
		    DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
		    DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
		    Document doc = docBuilder.parse(xmlFileName);//this.getClass().getResourceAsStream(xmlFileName));
		    List<String> list = new ArrayList<String>();
		    Element root = doc.getDocumentElement();
	    	String type = XmlDomHelpers.getAttributeValue(root,"type");
	    	String value = XmlDomHelpers.getAttributeValue(root,"value");
	    	String id = XmlDomHelpers.getAttributeValue(root,"id");
	    	int key = 1;
	    	int level = 0;
	    	int parentKey = 0;
	    	System.out.println(key + ". level="+level+", parentKey="+parentKey+", node type="+type+", value="+value);
	    	this.createRoot(key, type, value);
	    	parentKey=key;
		    key = parse(key, level, parentKey, true, doc, list, root);
		}
		catch (SAXException e) {
			e.printStackTrace();
			return false;
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		catch (ParserConfigurationException e) {
			e.printStackTrace();
			return false;
		}
	    return true;
	}
	
    private int parse(int key, final int level, int parentKey, boolean branchType, final Document doc, final List<String> list, Element e) {
        final NodeList children = e.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            final Node n = children.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) n;
                if (n.getNodeName().equals("node")) {
                	String type = XmlDomHelpers.getAttributeValue(element,"type");
                	String value = XmlDomHelpers.getAttributeValue(element,"value");
                	key++;
                	System.out.println(key + ". level="+level+", parentKey="+parentKey+", node type="+type+", value="+value);
                	if (branchType)
                		this.addYesNode(parentKey, key, type, value);
                	else
                		this.addNoNode(parentKey, key, type, value);
                	if (type.equalsIgnoreCase("question")) parentKey=key;
                }
                else {
                	System.out.println(n.getNodeName()+", "+n.getNodeValue());
                	if (n.getNodeName().equalsIgnoreCase("truePath")) branchType=true;
                	else branchType=false;
                }
            	list.add(n.getNodeName());
                key = parse(key, level+1, parentKey, branchType, doc, list, (Element) n);
            }
            else {
            	//System.out.println("None element: "+n.getNodeName()+", "+n.getNodeValue());
            }
        }
        return key;
    }

	/* ----------------------------------------------- */
	/*                                                 */
	/* TREE BUILDING METHODS */
	/*                                                 */
	/* ----------------------------------------------- */

	/* CREATE ROOT NODE */
	public void createRoot(int newNodeID, String newType, String newQuestAns) {
		rootNode = new SimpleBinaryTreeNode(newNodeID, newType, newQuestAns);
		System.out.println("Created root node " + newNodeID);
	}

	/* ADD YES NODE */

	public void addYesNode(int existingNodeID, int newNodeID, String newType, String newQuestAns) {
		// If no root node do nothing
		if (rootNode == null) {
			System.out.println("ERROR: No root node!");
			return;
		}

		// Search tree
		if (searchTreeAndAddYesNode(rootNode, existingNodeID, newNodeID,newType, newQuestAns)) {
			System.out.println("Added node " + newNodeID + " onto \"yes\" branch of node " + existingNodeID);
		} else
			System.out.println("Node " + existingNodeID + " not found");
	}

	/* SEARCH TREE AND ADD YES NODE */
	private boolean searchTreeAndAddYesNode(SimpleBinaryTreeNode currentNode,	int existingNodeID, int newNodeID, String newType, String newQuestAns) {
		if (currentNode.getNodeId() == existingNodeID) {
			// Found node
			if (currentNode.getYesBranch() == null)
				currentNode.setYesBranch(new SimpleBinaryTreeNode(newNodeID, newType, newQuestAns));
			else {
				System.out.println("WARNING: Overwriting previous node "
						+ "(id = " + currentNode.getYesBranch().getNodeId()
						+ ") linked to yes branch of node " + existingNodeID);
				currentNode.setYesBranch(new SimpleBinaryTreeNode(newNodeID, newType, newQuestAns));
			}
			return (true);
		} else {
			// Try yes branch if it exists
			if (currentNode.getYesBranch() != null) {
				if (searchTreeAndAddYesNode(currentNode.getYesBranch(),	existingNodeID, newNodeID, newType, newQuestAns)) {
					return (true);
				} else {
					// Try no branch if it exists
					if (currentNode.getNoBranch() != null) {
						return (searchTreeAndAddYesNode(currentNode.getNoBranch(), existingNodeID, newNodeID, newType, newQuestAns));
					} else
						return (false); // Not found here
				}
			}
			return (false); // Not found here
		}
	}

	/* ADD NO NODE */
	public void addNoNode(int existingNodeID, int newNodeID, String newType, String newQuestAns) {
		// If no root node do nothing
		if (rootNode == null) {
			System.out.println("ERROR: No root node!");
			return;
		}

		// Search tree
		if (searchTreeAndAddNoNode(rootNode, existingNodeID, newNodeID,	newType, newQuestAns)) {
			System.out.println("Added node " + newNodeID + " onto \"no\" branch of node " + existingNodeID);
		} else
			System.out.println("Node " + existingNodeID + " not found");
	}

	/* SEARCH TREE AND ADD NO NODE */
	private boolean searchTreeAndAddNoNode(SimpleBinaryTreeNode currentNode, int existingNodeID, int newNodeID, String newType, String newQuestAns) {
		if (currentNode.getNodeId() == existingNodeID) {
			// Found node
			if (currentNode.getNoBranch() == null)
				currentNode.setNoBranch(new SimpleBinaryTreeNode(newNodeID, newType, newQuestAns));
			else {
				System.out.println("WARNING: Overwriting previous node "
						+ "(id = " + currentNode.getNoBranch().getNodeId()
						+ ") linked to yes branch of node " + existingNodeID);
				currentNode.setNoBranch(new SimpleBinaryTreeNode(newNodeID, newType, newQuestAns));
			}
			return (true);
		} else {
			// Try yes branch if it exists
			if (currentNode.getYesBranch() != null) {
				if (searchTreeAndAddNoNode(currentNode.getYesBranch(), existingNodeID, newNodeID, newType, newQuestAns)) {
					return (true);
				} else {
					// Try no branch if it exists
					if (currentNode.getNoBranch() != null) {
						return (searchTreeAndAddNoNode(currentNode.getNoBranch(), existingNodeID, newNodeID, newType, newQuestAns));
					} else
						return (false); // Not found here
				}
			} else
				return (false); // Not found here
		}
	}

	/* --------------------------------------------- */
	/*                                               */
	/* TREE QUERY METHODS */
	/*                                               */
	/* --------------------------------------------- */

	public void queryBinTree() throws IOException {
		queryBinTree(rootNode);
	}

	private void queryBinTree(SimpleBinaryTreeNode currentNode) throws IOException {		
		// Test for leaf node (answer) and missing branches
		if (currentNode.getYesBranch() == null) {
			if (currentNode.getNoBranch() == null)
				System.out.println("(ANSWER) " + currentNode.getQuestOrAns());
			else
				System.out.println("Error: Missing \"Yes\" branch at \""+ currentNode.getQuestOrAns() + "\" question");
			return;
		}
		if (currentNode.getNoBranch() == null) {
			System.out.println("Error: Missing \"No\" branch at \""	+ currentNode.getQuestOrAns() + "\" question");
			return;
		}

		// Question
		askQuestion(currentNode);
	}

	private void askQuestion(SimpleBinaryTreeNode currentNode) throws IOException {
		System.out.println(currentNode.getQuestOrAns() + " (enter \"Yes\" or \"No\")");
		String answer = keyboardInput.readLine();
		if (answer.equalsIgnoreCase("Y")||answer.equalsIgnoreCase("Yes"))
			queryBinTree(currentNode.getYesBranch());
		else {
			if (answer.equalsIgnoreCase("N")||answer.equalsIgnoreCase("No"))
				queryBinTree(currentNode.getNoBranch());
			else {
				System.out.println("ERROR: Must answer \"Yes\" or \"No\"");
				askQuestion(currentNode);
			}
		}
	}

	/* ----------------------------------------------- */
	/*                                                 */
	/* TREE OUTPUT METHODS */
	/*                                                 */
	/* ----------------------------------------------- */

	/* OUTPUT BIN TREE */
	public void outputBinTree() {
		outputBinTree("1", rootNode);
	}

	private void outputBinTree(String tag, SimpleBinaryTreeNode currentNode) {
		// Check for empty node
		if (currentNode == null)
			return;

		// Output
		System.out.println("[" + tag + "] nodeID = " + currentNode.getNodeId()
				+ ", "+currentNode.getType()+" = " + currentNode.getQuestOrAns());

		// Go down yes branch
		outputBinTree(tag + ".1", currentNode.getYesBranch());

		// Go down no branch
		outputBinTree(tag + ".2", currentNode.getNoBranch());
	}
}