package com.ibm.cio.expressionEvaluator;

/** An abstract variable set.
 * <br>Javaluator supports expression that contains variables (for example <i>sin(x)</i>).
 * <br>An AbstractVariableSet converts, during the expression evaluation, each variable to its value.
 * @param <T> The type of the values of the variable (the one handled by the evaluator).
 */
public interface AbstractVariableSet<T> {
	/** Gets the value of a variable.
	 * @param variableName The name of a variable
	 * @return the variable's value or null if the variable is unknown
	 */
	public T get(String variableName);
}
