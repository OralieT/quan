package Lab8_map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
	public static final String fileName = "data/short.txt";

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	public void load(String fileName) throws IOException {
		// TODO
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		int index = 1;
		while (true) {
			line = reader.readLine();

			if (line == null)
				break;
			StringTokenizer tokens = new StringTokenizer(line, " ");

			while (tokens.hasMoreTokens()) {
				String w = tokens.nextToken();
				if (!tokens.hasMoreTokens())
					add(w, -index);
				else
					add(w, index);

				index++;
			}
		}
		reader.close();
		System.out.println(map);
	}
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) {
		// TODO
		if (map.containsKey(word)) {
			ArrayList<Integer> values = map.get(word);
			values.add(position);
		} else {
			ArrayList<Integer> values = new ArrayList<>();
			values.add(position);
			map.put(word, values);
		}
	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
		// TODO
		for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			String key = entry.getKey();
			ArrayList<Integer> val = entry.getValue();
			System.out.println(key + " " + val);
		}
	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		// TODO
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		// TODO
		String mostFrequent = null;
		int maxFrequency = 0;

		for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			int frequency = entry.getValue().size();
			if (frequency > maxFrequency) {
				maxFrequency = frequency;
				mostFrequent = entry.getKey();
			}
		}

		return mostFrequent;
	}

	public static void main(String[] args) throws IOException {
		TextAnalyzer re = new TextAnalyzer();
		re.load(fileName);
		System.out.println();
		re.displayWords();
		System.out.println();
		re.displayText();
		System.out.println();
		System.out.println(re.mostFrequentWord());
	}
}
