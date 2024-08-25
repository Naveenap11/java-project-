import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordStrengthChecker {

    // Method to check password strength
    public static String checkPasswordStrength(String password) {
        final int MIN_LENGTH = 8;
        
        // Regular expressions to check for different character types
        Pattern upperCasePattern = Pattern.compile("[A-Z]");
        Pattern lowerCasePattern = Pattern.compile("[a-z]");
        Pattern digitPattern = Pattern.compile("[0-9]");
        Pattern specialCharPattern = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]");
        
        Matcher upperCaseMatcher = upperCasePattern.matcher(password);
        Matcher lowerCaseMatcher = lowerCasePattern.matcher(password);
        Matcher digitMatcher = digitPattern.matcher(password);
        Matcher specialCharMatcher = specialCharPattern.matcher(password);
        
        boolean hasUpperCase = upperCaseMatcher.find();
        boolean hasLowerCase = lowerCaseMatcher.find();
        boolean hasDigit = digitMatcher.find();
        boolean hasSpecialChar = specialCharMatcher.find();
        boolean isLongEnough = password.length() >= MIN_LENGTH;
        
        // Evaluate password strength
        if (!isLongEnough) {
            return "Password is too short. It must be at least " + MIN_LENGTH + " characters long.";
        }
        
        int strengthScore = 0;
        if (hasUpperCase) strengthScore++;
        if (hasLowerCase) strengthScore++;
        if (hasDigit) strengthScore++;
        if (hasSpecialChar) strengthScore++;
        
        switch (strengthScore) {
            case 4:
                return "Password is strong!";
            case 3:
                return "Password is medium.";
            case 2:
                return "Password is weak.";
            default:
                return "Password is very weak.";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for a password
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        
        // Check the password strength
        String result = checkPasswordStrength(password);
        System.out.println(result);
        
        scanner.close();
    }
}
