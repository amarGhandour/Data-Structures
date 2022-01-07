package datastrucures.problems.stack.homework1;

//Problem #6: Two stacks
//● Change our class to be able to perform the stack operations but simulating 2
//stacks in same time. Consider the following constraints
//○ Use only the same single array
//○ All operations should have the same old time/memory complexity
//○ Each stack can use as much as possible of available array
//■ For example, assume we created stack of 100 elements
//● The first stack used 20 elements so far
//● Then the second stack can use up to 80 elements and so on
//● Change functions similar to following: void push(int id, int x)
//○ Id either 1 or 2 to refer to the stack itself

class Stack3<T> {

	private Object[] data;
	private static final int MAX = 100;
	private int top1, top2, size;

	Stack3() { // memory O(n) - time O(n)
		this.size = 0;
		this.top1 = -1;
		this.top2 = MAX - 1;
		this.data = new Object[MAX];
	}

	int size(int id) {
		return id == 1 ? top1 + 1 : MAX - top2 + 1;
	}

	boolean isEmpty(int id) {
		return id == 1 ? top1 < 0 : top2 == MAX - 1;
	}

	boolean isFull() {
		return (top1 == top2);
	}

	boolean push(int id, T value) { // memory O(1) - time O(1)
		if (isFull()) {
			return false;
		}
		if (id == 1)
			data[++top1] = value;
		else
			data[top2--] = value;
		return true;
	}

	Object peek(int id) throws Exception { // memory O(1) - time O(1)
		if (isEmpty(id)) {
			throw new Exception("Error: stack underflow");
		}

		return id == 1 ? this.data[top1] : this.data[top2];
	}

	Object pop(int id) throws Exception { // memory O(1) - time O(1)

		if (isEmpty(id)) {
			throw new Exception("Error: stack underflow");
		}

		return id == 1 ? this.data[top1--] : this.data[top2++];

	}

	void print(int id) { // memory O(1) - time O(n)

		if (id == 1) {
			System.out.print("Stack 1: ");
			for (int i = top1; i >= 0; i--) {
				System.out.print(this.data[i] + " ");
			}
		} else {
			System.out.print("Stack 2: ");
			for (int i = top2 + 1; i < MAX; i++) {
				System.out.print(this.data[i] + " ");
			}
		}

		System.out.println();
	}
}

public class Problem6 {

	public static void main(String[] args) throws Exception {

		Stack3<Integer> stack = new Stack3<>();

		stack.push(1, 1);
		stack.push(1, 2);
		stack.push(2, 3);
		stack.push(1, 3);
		stack.push(2, 4);

		stack.print(1);  // 3 2 1 
		stack.print(2);	// 4 3 
		
		stack.pop(1);  // 3
		
		stack.pop(2);  // 4
		
		System.out.println(stack.peek(1)); // 2

	}

}
