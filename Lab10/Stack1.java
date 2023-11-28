package Lab10;

import java.util.Stack;

public class Stack1 {
	// This method reserves the given array
	public static <E> void reserve(E[] array) {
		Stack<E> st1 = new Stack<E>();
		for (E e : array) {
			st1.push(e);
		}

		for (int i = 0; i < array.length; i++) {
			System.out.print(st1.pop() + " ");
		}
	}

	// This method checks the correctness of the given input
	// i.e. ()(())[]{(())} ==> true, ){[]}() ==> false
	public static boolean isCorrect(String input) {
		if (input == null || input.isEmpty())
			return true;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else if (stack.isEmpty()) {
				return false;
			} else if ((stack.peek() == '(' && c == ')') || (stack.peek() == '[' && c == ']')
					|| (stack.peek() == '{' && c == '}')) {
				stack.pop();
			} else {
				return false;
			}
		}
		return stack.isEmpty();
	}

	// This method evaluates the value of an expression
	// i.e 51 + (54 * (3+2)) = 321
	public static int evaluateExpression(String expression) {
		//TODO
		return 0;
	}

	public static void main(String[] args) {
		Integer[] re = { 1, 2, 3, 4, 5 };
		reserve(re);
		String st = "{[()]}";
		String st1 = "(()]}(){}[]";
		System.out.println();
		System.out.println(isCorrect(st));
		System.out.println(isCorrect(st1));
		String st2 = "26 + 10 * 3";
		System.out.println(evaluateExpression(st2));
	}
}
