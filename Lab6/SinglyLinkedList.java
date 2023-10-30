package Lab6;

public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	public SinglyLinkedList() {
		super();
	}

	// Returns the number of elements in the list.
	public int size() {
		return size;
	}
	// Returns true if the list is empty, and false
	// otherwise.

	public boolean isEmpty() {
		return size == 0;
	}

	// Returns (but does not remove) the first element in
	// the list.

	public E first() {
		if (isEmpty()) {
			return null;
		} else {
			return head.getData();
		}
	}

	// Returns (but does not remove) the last element in
	// the list.
	public E last() {
		if (isEmpty()) {
			return null;
		} else {
			return tail.getData();
		}
	}

	// Adds a new element to the front of the list.
	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e);

		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.setNext(head);
			head = newNode;
		}
		size++;
	}

	// Adds a new element to the end of the list.
	public void addLast(E e) {
		Node<E> newNode = new Node<>(e);

		if (isEmpty()) {
			head = newNode;
		} else {
			tail.setNext(newNode);
		}
		tail = newNode;
		size++;
	}

	// Removes and returns the first element of the list.
	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}

		E removedData = head.getData();

		if (head == tail) {
			head = null;
			tail = null;
		} else {
			head = head.getNext();
		}
		size--;
		return removedData;
	}

	// Removes and returns the last element of the list.
	public E removeLast() {
		if (isEmpty()) {
			return null;
		}

		E removedData = tail.getData();

		if (tail == head) {
			head = null;
			tail = null;
		} else {
			Node<E> current = head;
			while (current.getNext() != tail) {
				current = current.getNext();
			}
			current.setNext(null);
			tail = current;
		}
		size--;
		return removedData;
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> myLinkedList = new SinglyLinkedList<>();
		myLinkedList.addFirst(5);
		myLinkedList.addFirst(0);
		myLinkedList.addFirst(1);
		myLinkedList.addLast(8);
		System.out.println(myLinkedList.size());
		System.out.println(myLinkedList.isEmpty());
		System.out.println(myLinkedList.first());
		System.out.println(myLinkedList.last());
		System.out.println(myLinkedList.removeFirst());
		System.out.println(myLinkedList.removeLast());
	}
}
