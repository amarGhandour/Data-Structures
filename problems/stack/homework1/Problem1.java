package datastrucures.problems.stack.homework1;

class IntegerWrap {

	private int value;

	IntegerWrap(int value) {
		this.value = value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}

class Stack2 {

	private int[] data;
	private static final int MAX = 1000;
	private int addedElements;

	public Stack2() { // memory O(n) - time O(n)
		this.addedElements = 0;
		this.data = new int[MAX];
	}

	public int size() {
		return addedElements;
	}

	public boolean isEmpty() {
		return (addedElements <= 0);
	}

	public boolean isFull() {
		return (addedElements >= MAX);
	}

	public boolean push(int value) { // memory O(1) - time O(n)

		if (isFull()) {
			return false;
		}

		shiftAllElementsRight();

		this.data[0] = value;
		this.addedElements++;

		return true;
	}

	private void shiftAllElementsRight() {

		for (int i = addedElements; i > 0; i--) {
			this.data[i] = this.data[i - 1];
		}
	}

	public boolean peek(Integer result) { // memory O(1) - time O(1)
		if (isEmpty()) {
			return false;
		}

		result = this.data[0];
		return true;
	}

	public boolean pop(IntegerWrap result) { // memory O(1) - time O(n)

		if (isEmpty()) {
			return false;
		}

		result.setValue(this.data[0]);
		shiftAllElementsLeft();
		this.addedElements--;

		return true;

	}

	private void shiftAllElementsLeft() {

		for (int i = 0; i < addedElements - 1; i++) {
			this.data[i] = this.data[i + 1];
		}

	}

	public void print() { // memory O(1) - time O(n)

		for (int i = 0; i < this.addedElements; i++) {
			System.out.print(this.data[i] + " ");
		}

		System.out.println();
	}

}

public class Problem1 {

	public static void main(String[] args) throws Exception {

		Stack2 stack = new Stack2();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(3);
		stack.push(4);
		
		stack.print();   // 4 3 3 2 1 
		
		
		IntegerWrap result = new IntegerWrap(0);
		while(stack.pop(result)) {
			System.out.print(result.getValue() + " "); // 4 3 3 2 1 
		}

	}



}
