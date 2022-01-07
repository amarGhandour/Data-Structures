package datastrucures.problems.stack.homework1;


//Problem #2: Reverse subwords
//â—? Develop: string reverse_subwords(string line)
//â—? It takes a string of spaces, e.g. "abc d efg xy"
//â—? Then reverse each subword â‡’ â€œcba d gfe yxâ€œ
//â—? Find a stack-based idea


//class Stack<T> {
//
//	private Object[] data;
//	private static final int MAX = 1000;
//	private int top;
//
//	 Stack() { // memory O(n) - time O(n)
//		this.top = -1;
//		this.data = new Object[MAX];
//	}
//
//	public int size() {
//		return top + 1;
//	}
//
//	public boolean isEmpty() {
//		return (top < 0);
//	}
//
//	public boolean isFull() {
//		return (top == MAX);
//	}
//
//	public boolean push(T value) { // memory O(1) - time O(1)
//		if (isFull()) {
//			return false;
//		}
//		data[++top] = value;
//		return true;
//	}
//
//	public Object peek() throws Exception { // memory O(1) - time O(1)
//		if (isEmpty()) {
//			throw new Exception("Error: stack underflow");
//		}
//		return this.data[top];
//	}
//
//	public Object pop() throws Exception { // memory O(1) - time O(1)
//
//		if (isEmpty()) {
//			throw new Exception("Error: stack underflow");
//		}
//
//		return this.data[top--];
//
//	}
//
//	public void print() { // memory O(1) - time O(n)
//		for (int i = top; i >= 0; i--) {
//			System.out.print(this.data[i] + " ");
//		}
//
//		System.out.println();
//	}
//}

public class Problem2 {

	public static void main(String[] args) throws Exception {

		String str = "abc d cgf xyz";

		System.out.println(reverseSubwords(str));

	}

	public static String reverseSubwords(String str) throws Exception {

		str += ' ';
		StringBuilder sb = new StringBuilder();
		Stack<String> s = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				while (!s.isEmpty()) {
					sb.append(s.pop());
				}
				sb.append(' ');
			} else
				s.push(str.charAt(i) + "");
		}

		return sb.toString();
	}

}
