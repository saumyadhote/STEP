import java.util.*;

public class TextProcessor {
    public static String cleanInput(String input) {
        input = input.trim().replaceAll("\\s+", " ");
        String[] words = input.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1)).append(" ");
        }
        return sb.toString().trim();
    }
    
    public static void analyzeText(String text) {
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        int charCount = text.replaceAll("\\s+", "").length();
        int sentenceCount = text.split("[.!?]").length;
        String longestWord = "";
        for (String w : words) {
            if (w.length() > longestWord.length()) longestWord = w;
        }
        Map<Character,Integer> freq = new HashMap<>();
        for (char c : text.replaceAll("\\s+", "").toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        char mostCommon = ' ';
        int max = 0;
        for (Map.Entry<Character,Integer> e : freq.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                mostCommon = e.getKey();
            }
        }
        System.out.println("Words: " + wordCount);
        System.out.println("Sentences: " + sentenceCount);
        System.out.println("Characters: " + charCount);
        System.out.println("Longest Word: " + longestWord);
        System.out.println("Most Common Character: " + mostCommon);
    }
    
    public static String[] getWordsSorted(String text) {
        text = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        String[] words = text.split("\\s+");
        Arrays.sort(words);
        return words;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== TEXT PROCESSOR ===");
        System.out.print("Enter a paragraph: ");
        String paragraph = scanner.nextLine();
        String cleaned = cleanInput(paragraph);
        System.out.println("\nCleaned Text: " + cleaned);
        System.out.println("\n=== Analysis ===");
        analyzeText(cleaned);
        System.out.println("\n=== Sorted Words ===");
        String[] sortedWords = getWordsSorted(cleaned);
        System.out.println(Arrays.toString(sortedWords));
        System.out.print("\nEnter a word to search: ");
        String search = scanner.nextLine().toLowerCase();
        boolean found = Arrays.asList(sortedWords).contains(search);
        System.out.println(found ? "Word found" : "Word not found");
        scanner.close();
    }
}
