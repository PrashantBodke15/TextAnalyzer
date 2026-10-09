package TextAnalyzer;


	import java.util.Scanner;

	public class Main {

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        try {

	            System.out.println("========== TEXT ANALYZER ==========");

	            System.out.println("Enter a sentence or paragraph:");

	            String text = sc.nextLine();

	            TextAnalyzer analyzer =
	                    new TextAnalyzer(text);

	            int choice;

	            do {

	                System.out.println("\n========== MENU ==========");
	                System.out.println("1. Display Original Text");
	                System.out.println("2. Count Characters");
	                System.out.println("3. Count Words");
	                System.out.println("4. Count Unique Words");
	                System.out.println("5. Display Word Frequency");
	                System.out.println("6. Display Unique Words");
	                System.out.println("7. Display Duplicate Words");
	                System.out.println("8. Find Longest Word");
	                System.out.println("9. Find Shortest Word");
	                System.out.println("10. Search for a Word");
	                System.out.println("11. Display Alphabetically");
	                System.out.println("0. Exit");

	                System.out.print("Enter your choice: ");

	                try {

	                    choice = Integer.parseInt(sc.nextLine());

	                } catch (NumberFormatException e) {

	                    System.out.println(
	                            "Invalid input! Enter a number."
	                    );

	                    choice = -1;
	                    continue;
	                }

	                try {

	                    switch (choice) {

	                        case 1:
	                            analyzer.displayOriginalText();
	                            break;

	                        case 2:
	                            analyzer.countCharacters();
	                            break;

	                        case 3:
	                            analyzer.countWords();
	                            break;

	                        case 4:
	                            analyzer.countUniqueWords();
	                            break;

	                        case 5:
	                            analyzer.displayWordFrequency();
	                            break;

	                        case 6:
	                            analyzer.displayUniqueWords();
	                            break;

	                        case 7:
	                            analyzer.displayDuplicateWords();
	                            break;

	                        case 8:
	                            analyzer.findLongestWord();
	                            break;

	                        case 9:
	                            analyzer.findShortestWord();
	                            break;

	                        case 10:

	                            System.out.print(
	                                    "Enter word to search: "
	                            );

	                            String searchWord = sc.nextLine();

	                            analyzer.searchWord(searchWord);
	                            break;

	                        case 11:
	                            analyzer.displayAlphabetically();
	                            break;

	                        case 0:
	                            System.out.println(
	                                    "Thank you for using Text Analyzer!"
	                            );
	                            break;

	                        default:
	                            System.out.println(
	                                    "Invalid choice! Try again."
	                            );
	                    }

	                } catch (TextAnalyzerException e) {

	                    System.out.println(
	                            "Error: " + e.getMessage()
	                    );
	                }

	            } while (choice != 0);

	        } catch (TextAnalyzerException e) {

	            System.out.println(
	                    "Error: " + e.getMessage()
	            );

	        } finally {

	            sc.close();
	        }
	    }
	}


