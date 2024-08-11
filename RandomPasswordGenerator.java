import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Prompt user for password specifications
        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();

        System.out.print("Include numbers? (y/n): ");
        boolean includeNumbers = scanner.next().toLowerCase().equals("y");

        System.out.print("Include lowercase letters? (y/n): ");
        boolean includeLowercase = scanner.next().toLowerCase().equals("y");

        System.out.print("Include uppercase letters? (y/n): ");
        boolean includeUppercase = scanner.next().toLowerCase().equals("y");

        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecial = scanner.next().toLowerCase().equals("y");

        // Generate and display the password
        String password = generatePassword(length, includeNumbers, includeLowercase, includeUppercase, includeSpecial);
        System.out.println("Generated password: " + password);

        scanner.close();
    }

    public static String generatePassword(int length, boolean includeNumbers, boolean includeLowercase,
                                          boolean includeUppercase, boolean includeSpecial) {
        String numbers = "0123456789";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special = "!@#$%^&*()-_=+[]{}|;:,.<>?";

        StringBuilder chars = new StringBuilder();
        if (includeNumbers) chars.append(numbers);
        if (includeLowercase) chars.append(lowercase);
        if (includeUppercase) chars.append(uppercase);
        if (includeSpecial) chars.append(special);

        if (chars.length() == 0) {
            throw new IllegalArgumentException("At least one character type must be selected.");
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(chars.length());
            password.append(chars.charAt(randomIndex));
        }

        return password.toString();
    }
}