package week2.assigment_problems;

import java.util.Scanner;

public class LibraryIsbnNormalizerValidator {
    static String normalizeCode(String raw) {
        String code = raw.trim();
        if (code.length() < 3) return code;
        return code.substring(0, 3).toUpperCase() + code.substring(3);
    }

    static String validateAndFormat(String code) {
        if (code.length() != 13) return "Invalid: wrong length";
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) return "Invalid: publisher code must be 3 letters";
        }
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) return "Invalid: body must contain only digits";
        }

        StringBuilder result = new StringBuilder();
        result.append("[").append(code.substring(0, 3)).append("] YEAR: 20");
        result.append(code.substring(5, 7));
        result.append(" | CATALOG: ").append(code.substring(7));
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ISBN-style code: ");
        String normalized = normalizeCode(scanner.nextLine());
        System.out.println(validateAndFormat(normalized));
    }
}
