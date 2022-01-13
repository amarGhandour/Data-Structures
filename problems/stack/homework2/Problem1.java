package datastrucures.problems.stack.homework2;

//We are given an array asteroids of integers representing asteroids in a row.
//
//For each asteroid,the absolute value represents its size, and the sign represents its direction (positive meaning right,
// negative meaning left). Each asteroid moves at the same speed.
//
//Find out the state of the asteroids after all collisions.
//If two asteroids meet, the smaller one will explode. 
//If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

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

public class Problem1 {

	public static void main(String[] args) throws Exception {

		int[] arr = { 10, 5, -2 };
		int[] arr2 = asteroidCollision(arr);

		for (int i : arr2) {
			System.out.print(i + " ");
		}

	}

	public static int[] asteroidCollision(int[] astroides) throws Exception {

		Stack<Integer> res = new Stack<Integer>();

		for (int i = 0; i < astroides.length; i++) {

			int astroid = astroides[i];

			boolean isExploded = false;
			while (!res.isEmpty() && (int) res.peek() > 0 && astroid < 0) {

				if ((int) res.peek() < -astroid) {
					res.pop();
					continue;
				} else if ((int) res.peek() == -astroid) {
					res.pop();
				}

				isExploded = true;
				break;
			}

			if (!isExploded) {
				res.push(astroid);
			}

		}

		int[] as = new int[res.size()];
		for (int i = res.size() - 1; i >= 0; i--) {
			as[i] = (int) res.pop();
		}

		return as;
	}

}
