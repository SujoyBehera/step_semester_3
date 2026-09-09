package week2.class_problems;

import java.util.Scanner;

public class BankTransactionReferenceGenerator {
    static String normalizeReference(String raw) {
        String reference = raw.trim();
        if (reference.length() < 3) return reference;
        return reference.substring(0, 3).toUpperCase() + reference.substring(3);
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) return "Invalid: wrong length";
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) return "Invalid: bank code must be 3 letters";
        }
        for (int i = 3; i < reference.length(); i++) {
            if (!Character.isDigit(reference.charAt(i))) return "Invalid: body must contain only digits";
        }

        StringBuilder result = new StringBuilder();
        result.append("[").append(reference.substring(0, 3)).append("] DATE: ");
        result.append(reference.substring(3, 5)).append("/");
        result.append(reference.substring(5, 7)).append("/");
        result.append(reference.substring(7, 9));
        result.append(" | SEQ: ").append(reference.substring(9));
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter transaction reference: ");
        String normalized = normalizeReference(scanner.nextLine());
        System.out.println(validateAndFormat(normalized));
    }
}
