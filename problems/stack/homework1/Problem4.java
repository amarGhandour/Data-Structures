package datastrucures.problems.stack.homework1;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//https://leetcode.com/problems/valid-parentheses/
//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//1-Open brackets must be closed by the same type of brackets.
//2-Open brackets must be closed in the correct order.


class Stack<T> {

	private Object[] data;
	private static final int MAX = 1000;
	private int top;

	 Stack() { // memory O(n) - time O(n)
		this.top = -1;
		this.data = new Object[MAX];
	}

	public int size() {
		return top + 1;
	}

	public boolean isEmpty() {
		return (top < 0);
	}

	public boolean isFull() {
		return (top == MAX);
	}

	public boolean push(T value) { // memory O(1) - time O(1)
		if (isFull()) {
			return false;
		}
		data[++top] = value;
		return true;
	}

	public Object peek() throws Exception { // memory O(1) - time O(1)
		if (isEmpty()) {
			throw new Exception("Error: stack underflow");
		}
		return this.data[top];
	}

	public Object pop() throws Exception { // memory O(1) - time O(1)

		if (isEmpty()) {
			throw new Exception("Error: stack underflow");
		}

		return this.data[top--];

	}

	public void print() { // memory O(1) - time O(n)
		for (int i = top; i >= 0; i--) {
			System.out.print(this.data[i] + " ");
		}

		System.out.println();
	}
}

public class Problem4 {

	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		
		String str = input.next();
		
		System.out.println(isValid(str));
		
	}
	
	public static boolean isValid(String s) throws Exception {
		Map<Character, Character> symbols = new TreeMap<>();
		symbols.put(')', '(');
		symbols.put(']', '[');
		symbols.put('}', '{');
	
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			//char t = symbols.get(c);
			if (symbols.containsKey(c)) {
				if (stack.isEmpty() || stack.peek() != symbols.get(c))
					return false;
				stack.pop();
			}else {
				stack.push(c);
			}
		}
		
		return stack.isEmpty();
	
    }
	
}
