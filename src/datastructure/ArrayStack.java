package datastructure;

import java.util.EmptyStackException;

public class ArrayStack {

	int top;
	int size;
	int[] stack;

	public ArrayStack(int size) {
		this.size = size;
		stack = new int[size];
		top = -1;
	}

	public void push(int item) {
		stack[++top] = item;
	}

	public int pop() {
		int pop = stack[top];
		stack[top--] = 0;
		return pop;
	}

	public int peek() {
		if (top < 0) throw new EmptyStackException();
		return stack[top];
	}

	public static void main(String[] args) {
		ArrayStack st = new ArrayStack(3);
		st.push(2);
		st.push(3);
		st.push(4);

		System.out.println(st.pop());
		st.push(5);
		System.out.println(st.pop());
		System.out.println(st.peek());
	}
}

// push pop peek
