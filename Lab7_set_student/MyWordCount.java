package set_student;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;

public class MyWordCount {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public List<WordCount> getWordCounts() {
		ArrayList<WordCount> result = new ArrayList<WordCount>();
		for (String w : words) {
			WordCount wc = new WordCount(w, countWord(w));
			if (!result.contains(wc)) {
				result.add(wc);
			}
		}
		return result;
	}

	public int countWord(String word) {
		int count = 0;
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).equals(word)) {
				count++;
			}
		}
		return count;
	}

	// Returns the words that their appearance are 1, do not consider duplidated
	// words
	public Set<String> getUniqueWords() {
		Set<String> setWords = new HashSet<>();
		for (String word : words) {
			if (!setWords.contains(word)) {
			setWords.add(word);
			}
			if(countWord(word) == 2) {
				setWords.remove(word);
			}
		}
		return setWords;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		// TODO
		Set<String> result = new HashSet<String>();
		result.addAll(words);
		return result;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> printWordCounts() {
		// TODO
		Set<WordCount> re = new TreeSet<>(new Comparator<WordCount>() {

			@Override
			public int compare(WordCount o1, WordCount o2) {
				// TODO Auto-generated method stub
				return o1.getWord().compareTo(o2.getWord());
			}
		});
		
		for (WordCount wordCount : re) {
			WordCount wc = new WordCount(fileName, 0);
			if(wordCount.getWord().equals(wc)) {
				re.add(wc);
			}
		}
		return re;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsByOccurence() {
		// TODO
		return null;
	}

	// delete words begining with the given pattern (i.e., delete words begin with
	// 'A' letter
	public Set<String> filterWords(String pattern) {
		// TODO
		return null;
	}

	public static void main(String[] args) {
		MyWordCount mwc = new MyWordCount();
		List<WordCount> w = mwc.getWordCounts();
		Set<String> set = mwc.getUniqueWords();
		Set<String> re = mwc.getDistinctWords();
		Set<WordCount> result = mwc.printWordCounts();
			
		System.out.println(w);
		System.out.println(set);
		System.out.println(re);
		System.out.println(result);
	}
}
