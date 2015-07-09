package com.ibm.cio.tests;

import com.ibm.cio.expressionEvaluator.DoubleEvaluator;
import com.ibm.cio.expressionEvaluator.StaticVariableSet;

/** The most simple class to use the built-in real expression evaluator.*/
public class Simplest {
	public static void main(String[] args) {
		String expression = "(2^3-1)*sin(pi/4)/ln(pi^2)";
		//String expression = "(2+3)*5^2*sin(pi/4)";

		
		// Create a new evaluator
		DoubleEvaluator evaluator = new DoubleEvaluator();
		// Evaluate an expression
		Double result = evaluator.evaluate("(2^3-1)*sin(pi/4)/ln(pi^2)");	
		
		// Ouput the result
		System.out.println(expression + " = " + result);
		
		expression = "2+3*5";
		// Evaluate an expression
		result = evaluator.evaluate(expression);	
		
		// Ouput the result
		System.out.println(expression + " = " + result);
		
		expression = "(2+3)*5";
		// Evaluate an expression
		result = evaluator.evaluate(expression);	
		
		// Ouput the result
		System.out.println(expression + " = " + result);
		
		final StaticVariableSet<Double> variables = new StaticVariableSet<Double>();
		variables.set("x", 4.0);
		variables.set("y", 7.0);
		
		expression = "(x^3-1)*sin(pi/4)/ln(pi^y)";
		result = evaluator.evaluate(expression, variables);	
		
		// Ouput the result
		System.out.println(expression + " = " + result);
	}
}