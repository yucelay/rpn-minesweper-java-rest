package com.yucel.phisoftware.webservice;

import java.util.Stack;

public class RpnCalculate {

	public int rpnCalculater(String s) {

		String[] expressions = s.split(" ");
		Stack<Integer> numStack = new Stack<Integer>();
		int num1, num2;
		int value = 0;

		for (int i = 0; i < expressions.length; i++) {

			switch (expressions[i]) {
			case "+":
				num1 = numStack.pop();
				num2 = numStack.pop();
				value = num1 + num2;
				numStack.push(value);
				break;

			case "-":
				num1 = numStack.pop();
				num2 = numStack.pop();
				value = num2 - num1;
				numStack.push(value);
				break;

			case "*":
				num1 = numStack.pop();
				num2 = numStack.pop();
				value = num1 * num2;
				numStack.push(value);
				break;

			case "/":
				num1 = numStack.pop();
				num2 = numStack.pop();
				value = num2 / num1;
				numStack.push(value);
				break;

			default:
				numStack.push(Integer.parseInt(expressions[i]));
			}

		}
		return numStack.pop();

	}

}
