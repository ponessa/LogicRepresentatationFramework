package com.ibm.cio.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import com.ibm.cio.expressionEvaluator.AbstractEvaluator;
import com.ibm.cio.expressionEvaluator.BracketPair;
import com.ibm.cio.expressionEvaluator.Operator;
import com.ibm.cio.expressionEvaluator.Parameters;
import com.ibm.cio.expressionEvaluator.StaticVariableSet;

public class TextualOperatorsEvaluator extends AbstractEvaluator<Boolean> {
	/** The negate unary operator. */
	public final static Operator NEGATE = new Operator("NOT", 1, Operator.Associativity.RIGHT, 3);
	/** The logical AND operator. */
	private static final Operator AND = new Operator("AND", 2, Operator.Associativity.LEFT, 2);
	/** The logical OR operator. */      
	public final static Operator OR = new Operator("OR", 2, Operator.Associativity.LEFT, 1);
	
	/** The logical OR operator. */      
	public final static Operator EQUAL = new Operator("=", 2, Operator.Associativity.LEFT, 1);
	
	private static final Parameters PARAMETERS;

	static {
		// Create the evaluator's parameters
		PARAMETERS = new Parameters();
		// Add the supported operators
		PARAMETERS.add(AND);
		PARAMETERS.add(OR);
		PARAMETERS.add(NEGATE);
		
		PARAMETERS.addFunctionBracket(BracketPair.PARENTHESES);
		PARAMETERS.addExpressionBracket(BracketPair.PARENTHESES);
	}

	public TextualOperatorsEvaluator() {
		super(PARAMETERS);
	}

	@Override
	protected Boolean toValue(String literal, Object evaluationContext) {
		int index = literal.indexOf('=');
		if (index>=0) {
			String variable = literal.substring(0, index);
			String value = literal.substring(index+1);
			//return value.equals(((Map<String, String>)evaluationContext).get(variable));
			return value.equals(((StaticVariableSet<String>)evaluationContext).get(variable));
		} else {
			return Boolean.valueOf(literal);
		}
	}

	@Override
	protected Boolean evaluate(Operator operator,
			Iterator<Boolean> operands, Object evaluationContext) {
		if (operator == NEGATE) {
			return !operands.next();
		} else if (operator == OR) {
			Boolean o1 = operands.next();
			Boolean o2 = operands.next();
			return o1 || o2;
		} else if (operator == AND) {
			Boolean o1 = operands.next();
			Boolean o2 = operands.next();
			return o1 && o2;
		} else {
			return super.evaluate(operator, operands, evaluationContext);
		}
	}

	@Override
	protected Iterator<String> tokenize(String expression) {
		return Arrays.asList(expression.split("\\s")).iterator();
	}
	
	public static void main(String[] args) {
		//Map<String,String> variableToValue = new HashMap<String, String>();
		StaticVariableSet<String> variableToValue = new StaticVariableSet<String>();
		variableToValue.set("owngLob", "GBS");
		variableToValue.set("rptgrpCntlCd", "GBS-SI");
		
		System.out.println("owngLob     = "+variableToValue.get("owngLob"));
		System.out.println("rptgrpCntlCd= "+variableToValue.get("rptgrpCntlCd"));
		
		AbstractEvaluator<Boolean> evaluator = new TextualOperatorsEvaluator();
		
		System.out.println ("");
		ArrayList<String> expressionList = new ArrayList<String>();
		expressionList.add("owngLob=GBS");
		expressionList.add("GBS=owngLob"); //TO-DO: Very weak, assumes the first value is a variable and second is a constant 
		expressionList.add("(owngLob=BIS OR owngLob=BIG)");
		expressionList.add("( owngLob=BIG OR owngLob=BIS )"); //TO-DO : fix so that space is not needed before and after parenthesis
		expressionList.add("owngLob=BIS OR owngLob=BIG");
		expressionList.add("owngLob=BIG OR owngLob=BIS");
		expressionList.add("rptgrpCntlCd=GBS-SI AND owngLob=BIS OR owngLob=BIG");
		expressionList.add("rptgrpCntlCd=GBS-SI AND ( owngLob=BIS OR owngLob=BIG )");
		expressionList.add("rptgrpCntlCd=GBS-SI AND owngLob=BIS OR rptgrpCntlCd=owngLob||-SI");
		expressionList.add("rptgrpCntlCd=GBS-SI AND ( owngLob=BIS OR rptgrpCntlCd=owngLob||-SI )");
		expressionList.add("rptgrpCntlCd=owngLob||-SI");
		expressionList.add("rptgrpCntlCd=GBS-SI AND ( owngLob=BIS OR rptgrpCntlCd=owngLob||-SI )");
		expressionList.add("rptgrpCntlCd=GBS-SI AND (owngLob=BIG OR rptgrpCntlCd=owngLob||-SI)");
		expressionList.add("rptgrpCntlCd=GBS-SI AND ( owngLob=BIG OR rptgrpCntlCd=owngLob||-SI )");
		//expressionList.add("");
		
		for (int i=0; i<expressionList.size(); i++) {
			System.out.println (expressionList.get(i)+" -> "+evaluator.evaluate(expressionList.get(i), variableToValue));
		}
		
	}
}
