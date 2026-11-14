package week12.class_problems;

public class SecretNoticeShifter {

    /**
     * Encrypts a club notice by shifting every letter forward by k places in the alphabet.
     * Letters wrap around from 'z' to 'a' and 'Z' to 'A' while preserving case;
     * digits, spaces, and symbols stay unchanged.
     *
     * Time Complexity: O(n) where n is the length of the input text.
     * Space Complexity: O(n) for the StringBuilder and resulting encrypted string.
     */
    public static String shiftNotice(String text, int k) {
        if (text == null) {
            return "";
        }

        int shift = ((k % 26) + 26) % 26;
        StringBuilder sb = new StringBuilder(text.length());

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append((char) ((c - 'a' + shift) % 26 + 'a'));
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char) ((c - 'A' + shift) % 26 + 'A'));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
