package datastructure;

import java.util.EmptyStackException;

public class LinkedStack<T> {
	Node<T> top = null;
	int size = 0;

	class Node<T> {
		T data;
		Node<T> next;

		public Node(T item) {
			this.data = item;
		}

	}

	// push pop peek isEmpty empty size
	public void push(T item) {
		Node<T> node = new Node<T>(item);
		node.next = top;
		top = node;

		size++;
	}

	public T peek() {
		if (size == 0 || top == null)
			throw new EmptyStackException();
		return top.data;
	}

	public T pop() {
		if (size == 0 || top == null)
			throw new EmptyStackException();
		T data = top.data;
		size--;
		top = top.next;
		return data;
	}

	public boolean isEmpty() {
		return size == 0 && top == null;
	}

	public int size() {
		return size;
	}

	public void empty() {
		size = 0;
		top = null;
	}

	public static void main(String[] args) {
		LinkedStack<Integer> st = new LinkedStack<>();
		st.push(1);
		st.push(2);
		st.push(3);

		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());

		st.push(123);
		System.out.println(st.peek());

	}

}