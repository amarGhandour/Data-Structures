package datastrucures.problems.stack.homework2;

//Problem #2: Insert at the bottom
//● Add a new function to the stack: void insert_at_bottom(int x)
//● It simply makes x the bottom element (last one)
//● Assume stack is [4, 3, 2, 1] and x = 10 [1 is top, 4 is last]
//● Now is: [10, 4, 3, 2, 1]
//● What is the time & memory order?
//● Constraints
//○ Implement it recursively
//○ Don’t create new stack or new arrays

class Stack<T> {

	private Object[] data;
	private static final int MAX = 1000;
	private int top;

	@SuppressWarnings("unchecked")
	Stack() { // memory O(n) - time O(n)
		this.top = -1;
		this.data = (T[]) new Object[MAX];
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

	@SuppressWarnings("unchecked")
	public T pop() throws Exception { // memory O(1) - time O(1)

		if (isEmpty()) {
			throw new Exception("Error: stack underflow");
		}

		return (T) this.data[top--];

	}

	public void insertAtBottom(T x) throws Exception { // O(n) time - O(n) memory

		if (this.isEmpty()) {
			this.push(x);
		} else {

			T cur = (T) this.pop();

			insertAtBottom(x);

			push(cur);

		}
	}

	public void print() { // memory O(1) - time O(n)
		for (int i = top; i >= 0; i--) {
			System.out.print(this.data[i] + " ");
		}

		System.out.println();
	}
}

public class Problem2 {

	public static void main(String[] args) throws Exception {

		Stack<Integer> s = new Stack<>();

		s.push(4);
		s.push(3);
		s.push(2);
		s.push(1);

		s.print();

		s.insertAtBottom(10);

		s.print();

		s.reverse();

		s.print();

	}

}
