package me.dalek70.craftsuiteminigames;

import java.util.Stack;

public class InfixToPostfix {

	// Get operator precedence
	private static int precedence(char op) {
		switch (op) {
			case '+':
			case '-': return 1;
			case '*':
			case '/': return 2;
			case '^': return 3;
			default: return 0;
		}
	}

	// Check if operator is right-associative
	private static boolean isRightAssociative(char op) {
		return op == '^';
	}

	// Convert infix to postfix
	public static String infixToPostfix(String infix) {
		Stack<Character> ops = new Stack<>();
		StringBuilder postfix = new StringBuilder();

		for (int i = 0; i < infix.length(); i++) {
			char ch = infix.charAt(i);

			if (Character.isWhitespace(ch)) {
				continue;
			}

			// Handle numbers (multi-digit + decimals)
			if (Character.isDigit(ch)) {
				while (i < infix.length() &&
						(Character.isDigit(infix.charAt(i)) || infix.charAt(i) == '.')) {
					postfix.append(infix.charAt(i));
					i++;
				}
				postfix.append(' '); // delimiter
				i--; // step back since for-loop will increment
			}
			// Handle variables (A, B, C...)
			else if (Character.isLetter(ch)) {
				postfix.append(ch).append(' ');
			}
			// Left parenthesis
			else if (ch == '(') {
				ops.push(ch);
			}
			// Right parenthesis
			else if (ch == ')') {
				while (!ops.isEmpty() && ops.peek() != '(') {
					postfix.append(ops.pop()).append(' ');
				}
				if (!ops.isEmpty()) {
					ops.pop();
				}
			}
			// Operators
			else {
				while (!ops.isEmpty() &&
						((isRightAssociative(ch) && precedence(ch) < precedence(ops.peek())) ||
								(!isRightAssociative(ch) && precedence(ch) <= precedence(ops.peek()))) &&
						ops.peek() != '(') {
					postfix.append(ops.pop()).append(' ');
				}
				ops.push(ch);
			}
		}

		// Pop remaining operators
		while (!ops.isEmpty()) {
			postfix.append(ops.pop()).append(' ');
		}

		return postfix.toString().trim();
	}
}
