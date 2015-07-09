package com.ibm.cio.expressionEvaluator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class StringEvaluator extends AbstractEvaluator<String> {
	
	private static Parameters DEFAULT_PARAMETERS = null;
	
	/** The equals operator.*/
	public static final Operator EQUALS = new Operator("=", 2, Operator.Associativity.LEFT, 2);
	
	public static final Function UPPER = new Function("upper", 1);
	public static final Function LOWER = new Function("lower", 1);
	public static final Function CONCAT = new Function("||", 2);
	public static final Function INDEX_OF = new Function("indexOf", 2);
	public static final Function IN_STR = new Function("inString", 2);
	
	/** The standard whole set of predefined operators */
	private static final Operator[] OPERATORS = new Operator[]{EQUALS}; //, GT, GT_EQUALS, LT, LT_EQUALS, LIKE};
	/** The whole set of predefined functions */
	private static final Function[] FUNCTIONS = new Function[]{UPPER, LOWER, CONCAT}; //, INDEX_OF, IN_STR};
	/** The whole set of predefined constants */
	//private static final Constant[] CONSTANTS = new Constant[]{PI, E};
	
	/** Constructor.
	 * <br>This default constructor builds an instance with all predefined operators, functions and constants. 
	 */
	public StringEvaluator() {
		this(getParameters());
	}

	/** Constructor.
	 * <br>This constructor can be used to reduce the set of supported operators, functions or constants,
	 * or to localize some function or constant's names.
	 * @param parameters The parameters of the evaluator.
	 */
	public StringEvaluator(Parameters parameters) {
		super(parameters);
	}
	
	/** Gets a copy of DoubleEvaluator default parameters.
	 * <br>The returned parameters contains all the predefined operators, functions and constants.
	 * <br>Each call to this method create a new instance of Parameters. 
	 * @return a Paramaters instance
	 */
	public static Parameters getDefaultParameters() {
		Parameters result = new Parameters();
		result.addOperators(Arrays.asList(OPERATORS));
		result.addFunctions(Arrays.asList(FUNCTIONS));
		//result.addConstants(Arrays.asList(CONSTANTS));
		result.addFunctionBracket(BracketPair.PARENTHESES);
		result.addExpressionBracket(BracketPair.PARENTHESES);
		return result;
	}

	private static Parameters getParameters() {
		if (DEFAULT_PARAMETERS == null) {
			DEFAULT_PARAMETERS = getDefaultParameters();
		}
		return DEFAULT_PARAMETERS;
	}	
	
	@Override
	protected String toValue(String literal, Object evaluationContext) {
		/*
		 * TO-DO: Need to understand the nature of this method.  It looks to only return the value of the literal to 
		 * the datatype required.  Just not sure as to why the evaluationConext is required.
		 */
		return literal;
	}
	
	/* (non-Javadoc)
	 * @see net.astesana.javaluator.AbstractEvaluator#evaluate(net.astesana.javaluator.Operator, java.util.Iterator)
	 */
	@Override
	protected String evaluate(Operator operator, Iterator<String> operands, Object evaluationContext) {
		if (EQUALS.equals(operator)) {
			return (operands.next().equals(operands.next())?"True":"False");
		} else {
			return super.evaluate(operator, operands, evaluationContext);
		}
	}
	
	/* (non-Javadoc)
	 * @see net.astesana.javaluator.AbstractEvaluator#evaluate(net.astesana.javaluator.Function, java.util.Iterator)
	 */
	@Override
	protected String evaluate(Function function, Iterator<String> arguments, Object evaluationContext) {
		String result=null;
		if (UPPER.equals(function)) {
			result = arguments.next().toUpperCase();
		} else if (LOWER.equals(function)) {
			result = arguments.next().toUpperCase();
		} else if (CONCAT.equals(function)) {
			result = arguments.next() + arguments.next();
		} else {
			result = super.evaluate(function, arguments, evaluationContext);
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StaticVariableSet<String> evaluationContext = new StaticVariableSet<String>();
		evaluationContext.set("owngLob", "GBS");
		evaluationContext.set("rptgrpCntlCd", "GBS-SI");
		
		System.out.println("owngLob     = "+evaluationContext.get("owngLob"));
		System.out.println("rptgrpCntlCd= "+evaluationContext.get("rptgrpCntlCd"));
		
		// Create a new evaluator
		StringEvaluator evaluator = new StringEvaluator();
		
		ArrayList<String> expressionList = new ArrayList<String>();
		expressionList.add("BB=BB");
		expressionList.add("BB=Bv");
		expressionList.add("BB=bb");
		expressionList.add("BB=upper(bb)");
		expressionList.add("owngLob=GBS");
		expressionList.add("owngLob=GBx");
		expressionList.add("GBS=owngLob");
		expressionList.add("GBx=owngLob");	
		expressionList.add("(owngLob=GBS && ");
		expressionList.add("BB=B||B");
		//expressionList.add("");
		
		for (int i=0; i<expressionList.size(); i++) {
			System.out.println (expressionList.get(i)+" -> "+evaluator.evaluate(expressionList.get(i),evaluationContext));
		}

	}

}
