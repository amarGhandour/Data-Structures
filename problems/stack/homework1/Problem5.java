package datastrucures.problems.stack.homework1;

import java.util.Scanner;

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
//1047. Remove All Adjacent Duplicates In String
//You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
//
//We repeatedly make duplicate removals on s until we no longer can.
//
//Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

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

public class Problem5 {

	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		
		String str = input.next();
		

		System.out.println(removeDuplicates(str));
		
	}
	
	 public static String  removeDuplicates(String s) throws Exception {
	        
	        Stack<Character> stack = new Stack<>();
	        
	        for (int i = 0; i < s.length(); i++){
	            if (stack.isEmpty() || (Character) stack.peek() != s.charAt(i)){
	                stack.push(s.charAt(i));
	            }else{
	                    stack.pop();
	            }
	        }
	        StringBuilder str = new StringBuilder();
	        while(!stack.isEmpty()){
	            str.append(stack.pop());
	        }
	        return str.reverse().toString();
	    }
	
}
