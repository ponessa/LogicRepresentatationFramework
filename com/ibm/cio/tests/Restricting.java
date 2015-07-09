package com.ibm.cio.tests;

import com.ibm.cio.expressionEvaluator.*;

/** An example of how to restrict operators, functions and constants of an existing evaluator.
 */
public class Restricting {
	public static void main(String[] args) {
		// Let's create a double evaluator that only support +,-,*,and / operators, with no constants,
		// and no functions. The default parenthesis will be allowed
		// First create empty evaluator parameters
		Parameters params = new Parameters();
		
		// Only add the operators we want to support (+,-,*,and /)
		params.add(DoubleEvaluator.PLUS);
		params.add(DoubleEvaluator.MINUS);
		params.add(DoubleEvaluator.MULTIPLY);
		params.add(DoubleEvaluator.DIVIDE);
		params.add(DoubleEvaluator.NEGATE);
		
		// Add the default expression brackets
		params.addExpressionBracket(BracketPair.PARENTHESES);
		
		// Create the restricted evaluator
		DoubleEvaluator evaluator = new DoubleEvaluator(params);
		
		Double result = evaluator.evaluate("(3*-4)+2");
		
		// Let's try some expressions
		doIt(evaluator, "(3*-4)+2");
		doIt(evaluator, "3^2");
		doIt(evaluator, "ln(5)");
	}

	private static void doIt(DoubleEvaluator evaluator, String expression) {
		try {
			System.out.println (expression+" = "+evaluator.evaluate(expression));
		} catch (IllegalArgumentException e) {
			System.out.println (expression+" is an invalid expression");
		}
	}
}
