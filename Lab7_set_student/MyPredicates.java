package set_student;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class MyPredicates {
	public static final String fileName = "data/fit.txt";

	static List<String> words = new ArrayList<>();

	public MyPredicates() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
}
	
	public interface Predicate<T> {
		public boolean test(T obj);
	}

	// Remove every object, obj, from coll for which p.test(obj)
	// is true. (This does the same thing as coll.removeIf(p).)
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		// TODO
		Iterator<T> iterator = coll.iterator();
		while (iterator.hasNext()) {
			T element = iterator.next();
			if (p.test(element)) {
				iterator.remove();
			}
		}
	}

	// Remove every object, obj, from coll for which
	// pr.test(obj) is false. (That is, retain the
	// objects for which the predicate is true.)
	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		// TODO
		Iterator<T> iterator = coll.iterator();
		while (iterator.hasNext()) {
			T element = iterator.next();
			if (!p.test(element)) {
				iterator.remove();
			}
		}
	}

	// Return a Set that contains all unique objects, obj,
	// from the collection, coll, such that p.test(obj)
	// is true.
	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		// TODO
		Set<T> result = new HashSet<>();

		for (T t : coll) {
			if (p.test(t)) {
				result.add(t);
			}
		}
		return result;
	}

	// Return the index of the first item in list
	// for which the predicate is true, if any.
	// If there is no such item, return -1.
	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		// TODO
		int index = 0;
		for (T t : coll) {
			if (p.test(t)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	public static void main(String[] args) {
	
	}
}
