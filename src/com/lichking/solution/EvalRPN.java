package com.lichking.solution;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are+,-,*,/. Each operand may be an integer or another
 * expression. Some examples: 
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * @author LichKing
 *
 */
public class EvalRPN {

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			if (isNumic(tokens[i]))
				stack.push(Integer.valueOf(tokens[i]));
			else {
				stack.push(calculate(tokens[i], stack));
			}
		}
		return stack.pop();
	}

	public boolean isNumic(String str) {
		return str.matches("^[-]?[0-9]+");
	}

	public int calculate(String operator, Stack<Integer> stack) {
		int a = stack.pop();
		int b = stack.pop();
		if (operator.equals("+"))
			return a + b;
		if (operator.equals("-"))
			return b - a;
		if (operator.equals("/"))
			return b / a;
		else
			return a * b;
	}
	
}
