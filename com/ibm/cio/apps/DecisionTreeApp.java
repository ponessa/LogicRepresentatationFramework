package com.ibm.cio.apps;

import com.ibm.cio.decisionTree.SimpleDecisionTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

class DecisionTreeApp {

	static BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
	
	static SimpleDecisionTree dt;

	/* --------------------------------- */
	/* METHODS */
	/* --------------------------------- */

	/* MAIN */
	public static void main(String[] args) throws IOException {
		String rulesFileName = null;
		boolean validParams = true;

		try {
			for (int optind = 0; optind < args.length; optind++) {
				if (args[optind].equalsIgnoreCase("-r")) {
					rulesFileName = args[++optind];
				} else if (args[optind].equalsIgnoreCase("-help")) {
					validParams = false;  					
				} else {
					//logger.error("E0001: Unknown parameter specified: " + args[optind]);
					System.out.println("E0001: Unknown parameter specified: " + args[optind]);
					validParams = false;                  
				}
			} //end - for (int optind = 0; optind < args.length; optind++)
		} //end try
		catch (Exception e) {
			//logger.error("E0003: Error processing input parameters.  " + e.getMessage());
			System.out.println("E0003: Error processing input parameters.  " + e.getMessage());
			e.printStackTrace();
			validParams = false;
		}
		if (rulesFileName==null) validParams = false;		
		if (!validParams) {
			System.out.println("USAGE - To DecisionTreeApp");
			System.out.println("java com.ibm.cio.utils.DecisionTreeApp ");
			System.out.println("      -r Rules File Name");
			//TO-DO - complete info message
			System.out.println("     [-help|-h]");
			System.out.println("Where:");
			System.out.println("------");
			System.out.println("-r Rules File Name is the name of the XML file containing the binary decision tree (nodes and arcs).");
			System.out.println("-help|-h [optional] Help flag");
			System.out.println("\tDisplays this help/usage text."); 
			System.exit(-99);     
		} 			
		
		// Create instance of class DecisionTree
		dt = new SimpleDecisionTree();
	
		// Generate tree
		//generateTree();
		if (!dt.buildTree(rulesFileName)) { //"C:/$user/$toLearn/DecissionTreePlus/simpleDecisionTree.xml")) {
				System.out.println("Error building tree");
				return;
			}
	
			// Output tree	
			System.out.println("\nOUTPUT DECISION TREE");
			System.out.println("====================");
			dt.outputBinTree();
	
			// Query tree
			queryTree();
	}

	/* GENERATE TREE
	static void generateTree() {
		System.out.println("\nGENERATE DECISION TREE");
		System.out.println("======================");
		dt.createRoot(1, "Does animal eat meat?");
		dt.addYesNode(1, 2, "Does animal have stripes?");
		dt.addNoNode(1, 3, "Does animal have stripes?");
		dt.addYesNode(2, 4, "Animal is a Tiger");
		dt.addNoNode(2, 5, "Does animal have spots?");
		dt.addYesNode(5, 6, "Animal is a Leopard");
		dt.addNoNode(5, 7, "Animal is a Lion");
		
		dt.addYesNode(3, 8, "Animal is a Zebra");
		dt.addNoNode(3, 9, "Animal is a Horse");
	}
	 */

	/* QUERY TREE */

	static void queryTree() throws IOException {
		System.out.println("\nQUERY DECISION TREE");
		System.out.println("===================");
		dt.queryBinTree();

		// Option to exit
		optionToExit();
	}

	/* OPTION TO EXIT PROGRAM */

	static void optionToExit() throws IOException {
		System.out.println("Exit? (enter \"Yes\" or \"No\")");
		String answer = keyboardInput.readLine();
		if (answer.equalsIgnoreCase("Y")||answer.equalsIgnoreCase("Yes"))
			return;
		else {
			if (answer.equalsIgnoreCase("N")||answer.equalsIgnoreCase("No"))
				queryTree();
			else {
				System.out.println("ERROR: Must answer \"Yes\" or \"No\"");
				optionToExit();
			}
		}
	}
}
