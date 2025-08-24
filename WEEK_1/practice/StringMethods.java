import java.util.Scanner;

public class StringMethods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter your favorite programming language: ");
        String language = scanner.nextLine();
        System.out.print("Enter a sentence about your programming experience: ");
        String sentence = scanner.nextLine();
        
        String[] parts = fullName.split(" ");
        String firstName = parts[0];
        String lastName = parts[parts.length - 1];
        int charCount = sentence.replace(" ", "").length();
        String upperLang = language.toUpperCase();
        
        System.out.println("\n=== Summary ===");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Programming Language (Uppercase): " + upperLang);
        System.out.println("Characters in Sentence (excluding spaces): " + charCount);
        
        scanner.close();
    }
}
