package datastructure;

public class LinkedListTest<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data) {
			this.data = data;
		}
	}

	// add next

	public void addFirst(T data) {
		Node<T> node = new Node(data);
		node.next = head;
		head = node;
		size++;
		if (head.next == null) {
			tail = head;
		}
	}

	public void addLast(T data) {
		Node<T> node = new Node(data);
		if (size == 0) {
			addFirst(data);
		} else {
			tail.next = node;
			tail = node;
			size++;
		}
	}

	public void add(int index, T data) {
		Node<T> x = head;
		for (int i = 0; i < index - 1; i++) {
			x = x.next;
		}

		Node<T> node = new Node(data);
		node.next = x.next;
		x.next = node;
		size++;

		if (node.next == null) {
			tail = node;
		}
	}

	public static void main(String[] args) {
		LinkedListTest<Integer> arr = new LinkedListTest<>();

		arr.addFirst(1);
		arr.addFirst(2);
		arr.add(1, 100);

		System.out.println("hi");
	}

}
