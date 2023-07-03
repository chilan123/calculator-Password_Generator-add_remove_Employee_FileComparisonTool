import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_-+=<>?";

    private static final int DEFAULT_PASSWORD_LENGTH = 12;

    private static SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        int passwordLength = DEFAULT_PASSWORD_LENGTH;

        if (args.length > 0) {
            try {
                passwordLength = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid password length. Using default length of " + DEFAULT_PASSWORD_LENGTH + " characters.");
            }
        }

        String password = generatePassword(passwordLength);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length) {
        String validCharacters = LOWERCASE_CHARACTERS + UPPERCASE_CHARACTERS + NUMBERS + SPECIAL_CHARACTERS;

        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validCharacters.length());
            password.append(validCharacters.charAt(randomIndex));
        }

        return password.toString();
    }
}
