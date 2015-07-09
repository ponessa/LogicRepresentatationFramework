package com.ibm.cio.decisionTree;


public class SimpleBinaryTreeNode {

	private int nodeId;
	private String id = null;
	private String type = null;
	private String questOrAns = null;
	private SimpleBinaryTreeNode yesBranch = null;
	private SimpleBinaryTreeNode noBranch = null;

	/* CONSTRUCTOR */

	public SimpleBinaryTreeNode(int nodeId, String id, String type, String questOrAns) {
		this.id = id;
		this.nodeId= nodeId;
		this.type = type;
		this.questOrAns = questOrAns;
	}
	public SimpleBinaryTreeNode(int nodeId, String type, String questOrAns) {
		this(nodeId, String.valueOf(nodeId), type, questOrAns);
	}

	public int getNodeId() {
		return nodeId;
	}

	public void setNodeID(int nodeId) {
		this.nodeId = nodeId;
	}

	public String getQuestOrAns() {
		return questOrAns;
	}

	public void setQuestOrAns(String questOrAns) {
		this.questOrAns = questOrAns;
	}

	public SimpleBinaryTreeNode getYesBranch() {
		return yesBranch;
	}

	public void setYesBranch(SimpleBinaryTreeNode yesBranch) {
		this.yesBranch = yesBranch;
	}

	public SimpleBinaryTreeNode getNoBranch() {
		return noBranch;
	}

	public void setNoBranch(SimpleBinaryTreeNode noBranch) {
		this.noBranch = noBranch;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}

}
