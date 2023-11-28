package Lab10;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Queue1 {
	// method stutter that accepts a queue of integers as a parameter and replaces
	// every element of the queue with two copies of that element
	// front [1, 2, 3] back
	// becomes
	// front [1, 1, 2, 2, 3, 3] back
	public static <E> void stutter(Queue<E> input) {
		int size = input.size();
		for (int i = 0; i < size; i++) {
			E re = input.poll();
			input.add(re);
			input.add(re);
		}
	}

	// Method mirror that accepts a queue of strings as a parameter and appends the
	// queue's contents to itself in reverse order front [a,b,c] back
	// becomes
	// front [a,b,c,c,b,a] back

	public static <E> void mirror(Queue<E> input) {
		int size = input.size();
		E[] lastElement = (E[]) new String[size * 2];

		for (int i = 0; i < size; i++) {
			E ele = input.poll();
			lastElement[i] = ele;
			lastElement[size * 2 - 1 - i] = ele;
			input.add(ele);
		}
		input.clear();

		for (E e : lastElement) {
			input.add(e);
		}
	}

	public static void main(String[] args) {
		Queue<Integer> re = new LinkedList<Integer>();
		re.add(1);
		re.add(2);
		re.add(3);
		stutter(re);
		System.out.println(re);

		Queue<String> mi = new LinkedList<>();
		mi.add("a");
		mi.add("b");
		mi.add("c");
		mirror(mi);
		System.out.println(mi);
	}
}
