public class StrMethods {
    public static void main(String[] args) {
        String sampleText = " Java Programming is Fun and Challenging! ";
        System.out.println("Original length: " + sampleText.length());
        String trimmed = sampleText.trim();
        System.out.println("Trimmed length: " + trimmed.length());
        System.out.println("Character at index 5: " + sampleText.charAt(5));
        String sub = trimmed.substring(5, 16);
        System.out.println("Substring: " + sub);
        System.out.println("Index of 'Fun': " + trimmed.indexOf("Fun"));
        System.out.println("Contains 'Java': " + trimmed.contains("Java"));
        System.out.println("Starts with 'Java': " + trimmed.startsWith("Java"));
        System.out.println("Ends with '!': " + trimmed.endsWith("!"));
        System.out.println("Uppercase: " + trimmed.toUpperCase());
        System.out.println("Lowercase: " + trimmed.toLowerCase());
        System.out.println("Vowel count: " + countVowels(trimmed));
        findAllOccurrences(trimmed, 'a');
    }
    public static int countVowels(String text) {
        int count = 0;
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u') count++;
        }
        return count;
    }
    public static void findAllOccurrences(String text, char target) {
        System.out.print("Occurrences of '" + target + "': ");
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) System.out.print(i + " ");
        }
    }
}
