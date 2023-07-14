import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Password Generator");
        System.out.println("Please enter the desired password length:");
        int length = scanner.nextInt();

        if (length <= 1) {
            System.out.println("Invalid length. Length must be at least 2.");
            return;
        }
        else if(length==2 || length==3)
        {
            System.out.println("TIP:Password will be more secured, if length of the password >=4");
        }

        System.out.println("Include Uppercase letters? (Y/N):");
        boolean uppercase = scanner.next().equalsIgnoreCase("Y");

        System.out.println("Include Lowercase letters? (Y/N):");
        boolean lowercase = scanner.next().equalsIgnoreCase("Y");

        System.out.println("Include Digits? (Y/N):");
        boolean digits = scanner.next().equalsIgnoreCase("Y");

        System.out.println("Include Special Characters? (Y/N):");
        boolean specialChars = scanner.next().equalsIgnoreCase("Y");

        if (!uppercase && !lowercase && !digits && !specialChars) {
            System.out.println("No character type selected. Please select at least one character type.");
            return;
        }

        String password = generateRandomPassword(length, uppercase, lowercase, digits, specialChars);
        System.out.println("Generated Password:");
        System.out.println(password);

        scanner.close();
    }

    private static String generateRandomPassword(int length, boolean uppercase, boolean lowercase, boolean digits, boolean specialChars) {
        StringBuilder characters = new StringBuilder();

        if (uppercase) {
            characters.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }
        if (lowercase) {
            characters.append("abcdefghijklmnopqrstuvwxyz");
        }
        if (digits) {
            characters.append("0123456789");
        }
        if (specialChars) {
            characters.append("!@#$%^&*()_+");
        }

        StringBuilder password = new StringBuilder();

        if (characters.length() == 0) {
            return "No character type selected";
        }

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }
}