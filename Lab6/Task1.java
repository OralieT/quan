package Lab6;

import java.util.Arrays;
import java.util.Comparator;

public class Task1<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public Task1() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public Task1(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	// creates an array of doublr - size if the array of elements is full
	public void growSize() {
		int newCapacity = size * 2;
		E[] newElements = (E[]) new Object[newCapacity];

		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}

		elements = newElements;
		System.out.println(Arrays.toString(newElements));
	}

	// Returns the number of elements in this list
	public int size() {
		return size;
	}

	// Returns whether the list is empty
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns (but does not remove) the element at index i
	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Vuot qua pham vi ");
		}
		return elements[i];
	}

	// Replaces the element at index i with e, and returns the replaced element
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		} else {
			E replaceElement = elements[i];
			elements[i] = e;
			return replaceElement;
		}
	}

	// It is used to append the specified element at the end of a list.
	public boolean add(E e) {
		if (size == elements.length) {
			growSize();
		}
		elements[size] = e;
		size++;
		return true;
	}

	// Inserts element e to be at index i, shifting all
	// subsequent elements later.
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException();
		}

		if (size == elements.length) {
			growSize();
		}

		for (int j = size; j > i; j--) {
			elements[j] = elements[j - 1];
		}

		elements[i] = e;
		size++;
		System.out.println("ADD: " + Arrays.toString(elements));
	}

	// Removes and returns the element at index i,
	// shifting subsequent elements earlier.
	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		size--;
		E removeElement = elements[i];

		for (int j = i; j < size - 1; j++) {
			elements[j] = elements[j + 1];
		}

		elements[size - 1] = null;
		size--;
		return removeElement;
	}

	// It is used to clear all elements in the list.
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	// It is used to return the index in this list of the
	// last occurrence of the specified element, or -1 if the
	// list does not contain this element.
	public int lastIndexOf(Object o) {
		if (o == null) {
			for (int i = size - 1; i >= 0; i--) {
				if (elements[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = size - 1; i >= 0; i--) {
				if (o.equals(elements[i])) {
					return i;
				}
			}
		}
		return -1; // Return -1 if the element is not found in the list
	}

	// It is used to return an array containing all of the
	// elements in this list in the correct order.
	public E[] toArray() {
		E[] result = (E[]) new Object[size];

		for (int i = 0; i < size; i++) {
			result[i] = elements[i];
		}

		return result;
	}

	// It is used to return a shallow copy of an ArrayList.
	public Task1<E> clone() {
		Task1<E> cloneList = new Task1<>(size);

		for (int i = 0; i < size; i++) {
			cloneList.add(elements[i]);
		}

		return cloneList;
	}

	// It returns true if the list contains the specified element
	public boolean contains(E o) {
		for (int i = 0; i < size; i++) {
			if (o.equals(elements[i])) {
				return true;
			}
		}
		return false;
	}

	// It is used to return the index in this list of the
	// first occurrence of the specified element, or -1 if the
	// List does not contain this element.
	public int indexOf(E o) {
		for (int i = 0; i < size; i++) {
			if (o.equals(elements[i])) {
				return i; // Return the index if the element is found
			}
		}
		return -1; // Return -1 if the element is not found
	}

	// It is used to remove the first occurrence of the specified element.
	public boolean remove(E e) {
		for (int i = 0; i < size; i++) {
			if (e.equals(elements[i])) {
				removeAtIndex(i);
				return true;
			}
		}
		return false;
	}

	private void removeAtIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}

		for (int i = index; i < size - 1; i++) {
			elements[i] = elements[i + 1];
		}

		elements[size - 1] = null;
		size--;
	}

	// It is used to sort the elements of the list on the basis of specified
	// comparator.
	public void sort(Comparator<E> c) {
        E[] newArray = (E[]) new Object[size];
        System.arraycopy(elements, 0, newArray, 0, size);

        // Sorting using a basic bubble sort algorithm
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (c.compare(newArray[j], newArray[j + 1]) > 0) {
                    // Swapping elements
                    E temp = newArray[j];
                    newArray[j] = newArray[j + 1];
                    newArray[j + 1] = temp;
                }
            }
        }

        System.arraycopy(newArray, 0, elements, 0, size);
    }

	public static void main(String[] args) {
		Task1<Integer> myList = new Task1<>();
		myList.add(2);
		myList.add(1);
		myList.add(3);
		myList.add(4);
		myList.add(2);
		myList.growSize();
		System.out.println(myList.size());
		System.out.println(myList.isEmpty());
		System.out.println(myList.get(0));
		System.out.println(myList.set(3, 9));
		myList.add(3, 3);
		myList.remove(3);
		// myList.clear();
		// System.out.println(myList.size());
		System.out.println(myList.lastIndexOf(9));
		System.out.println(Arrays.toString(myList.toArray()));
		// Task1<Integer> cloneA = myList.clone();
		System.out.println(myList.contains(8));
		System.out.println(myList.indexOf(7));
		System.out.println(myList.remove(2));
		System.out.println("Original List:");
	}
}
