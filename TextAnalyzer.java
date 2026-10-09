package TextAnalyzer;


	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.HashSet;
	import java.util.Map;
	import java.util.TreeSet;

	public class TextAnalyzer {

	    private String text;

	    private ArrayList<String> words;
	    private HashSet<String> uniqueWords;
	    private HashMap<String, Integer> wordFrequency;

	    public TextAnalyzer(String text) throws TextAnalyzerException {

	        if (text == null || text.trim().isEmpty()) {
	            throw new TextAnalyzerException(
	                    "Text cannot be empty!"
	            );
	        }

	        this.text = text;

	        words = new ArrayList<>();
	        uniqueWords = new HashSet<>();
	        wordFrequency = new HashMap<>();

	        analyzeText();
	    }

	    // Convert the text into words and analyze them
	    private void analyzeText() {

	        String cleanedText = text.toLowerCase()
	                .replaceAll("[^a-z0-9\\s]", " ")
	                .trim();

	        if (cleanedText.isEmpty()) {
	            return;
	        }

	        String[] wordArray = cleanedText.split("\\s+");

	        for (String word : wordArray) {

	            words.add(word);

	            uniqueWords.add(word);

	            wordFrequency.put(
	                    word,
	                    wordFrequency.getOrDefault(word, 0) + 1
	            );
	        }
	    }

	    // Display original text
	    public void displayOriginalText() {

	        System.out.println("\nOriginal Text: " + text);
	    }

	    // Count characters
	    public void countCharacters() {

	        System.out.println(
	                "Total Characters: " + text.length()
	        );
	    }

	    // Count words
	    public void countWords() {

	        System.out.println(
	                "Total Words: " + words.size()
	        );
	    }

	    // Count unique words
	    public void countUniqueWords() {

	        System.out.println(
	                "Unique Words: " + uniqueWords.size()
	        );
	    }

	    // Display frequency of every word
	    public void displayWordFrequency() {

	        System.out.println("\nWord Frequency:");

	        for (Map.Entry<String, Integer> entry
	                : wordFrequency.entrySet()) {

	            System.out.println(
	                    entry.getKey() + " : " + entry.getValue()
	            );
	        }
	    }

	    // Display unique words
	    public void displayUniqueWords() {

	        System.out.println("\nUnique Words:");

	        for (String word : uniqueWords) {

	            System.out.println(word);
	        }
	    }

	    // Display duplicate words
	    public void displayDuplicateWords() {

	        System.out.println("\nDuplicate Words:");

	        boolean found = false;

	        for (Map.Entry<String, Integer> entry
	                : wordFrequency.entrySet()) {

	            if (entry.getValue() > 1) {

	                System.out.println(
	                        entry.getKey() + " : "
	                                + entry.getValue() + " times"
	                );

	                found = true;
	            }
	        }

	        if (!found) {
	            System.out.println("No duplicate words found.");
	        }
	    }

	    // Find the longest word
	    public void findLongestWord() {

	        if (words.isEmpty()) {
	            System.out.println("No words available.");
	            return;
	        }

	        String longest = words.get(0);

	        for (String word : words) {

	            if (word.length() > longest.length()) {
	                longest = word;
	            }
	        }

	        System.out.println("Longest Word: " + longest);
	    }

	    // Find the shortest word
	    public void findShortestWord() {

	        if (words.isEmpty()) {
	            System.out.println("No words available.");
	            return;
	        }

	        String shortest = words.get(0);

	        for (String word : words) {

	            if (word.length() < shortest.length()) {
	                shortest = word;
	            }
	        }

	        System.out.println("Shortest Word: " + shortest);
	    }

	    // Search for a word
	    public void searchWord(String searchWord)
	            throws TextAnalyzerException {

	        if (searchWord == null || searchWord.trim().isEmpty()) {

	            throw new TextAnalyzerException(
	                    "Search word cannot be empty!"
	            );
	        }

	        String word = searchWord.toLowerCase()
	                .replaceAll("^[^a-z0-9]+|[^a-z0-9]+$", "");

	        if (word.isEmpty()) {

	            throw new TextAnalyzerException(
	                    "Please enter a valid word!"
	            );
	        }

	        if (wordFrequency.containsKey(word)) {

	            System.out.println(
	                    word + " occurs "
	                            + wordFrequency.get(word)
	                            + " time(s)."
	            );

	        } else {

	            System.out.println("Word not found.");
	        }
	    }

	    // Display words alphabetically
	    public void displayAlphabetically() {

	        TreeSet<String> sortedWords =
	                new TreeSet<>(uniqueWords);

	        System.out.println("\nWords in Alphabetical Order:");

	        for (String word : sortedWords) {

	            System.out.println(word);
	        }
	    }
	}


