package datastructure;

import java.util.NoSuchElementException;

public class LinkedQueue<T> {

	Node<T> front;
	Node<T> rear;

	public class Node<T> {
		T data;
		Node<T> next;

		public Node(T data) {
			this.data = data;
		}
	}

	// add poll peek isEmpty
	public void add(T data) {
		Node<T> node = new Node(data);
		if (rear != null) rear.next = node;
		rear = node;

		if (front == null) front = rear;
	}

	public T poll() {
		if (front == null) throw new NoSuchElementException();

		T d = front.data;
		front = front.next;
		return d;
	}

	public T peek() {
		if (front == null)
			throw new NoSuchElementException();
		return front.data;
	}

	public boolean isEmpty() {
		return front == null;
	}

	public static void main(String[] args) {
		LinkedQueue<Integer> q = new LinkedQueue<Integer>();
		q.add(123);
		System.out.println(q.poll());
		q.add(2);
		q.add(3);
		System.out.println(q.poll());
		System.out.println(q.isEmpty());
		System.out.println(q.poll());
		System.out.println(q.isEmpty());
		q.add(1123123123);
		System.out.println(q.peek());
	}

}
