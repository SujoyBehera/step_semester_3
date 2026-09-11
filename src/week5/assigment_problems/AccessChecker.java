package week5.assigment_problems;

public class AccessChecker {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier == null || accessorContext == null) return "DENIED";

        switch (fieldModifier.toLowerCase()) {
            case "private":
                return "SAME_CLASS".equals(accessorContext) ? "ALLOWED" : "DENIED";
            case "default":
                return ("SAME_CLASS".equals(accessorContext) || "SAME_PACKAGE".equals(accessorContext))
                        ? "ALLOWED" : "DENIED";
            case "protected":
                return ("SAME_CLASS".equals(accessorContext) || "SAME_PACKAGE".equals(accessorContext))
                        ? "ALLOWED" : "DENIED";
            case "public":
                return "ALLOWED";
            default:
                return "DENIED";
        }
    }

    public static String summarizeByModifier(String[][] attempts) {
        String[] modifiers = {"private", "default", "protected", "public"};
        int[] allowed = new int[4];
        int[] denied = new int[4];

        if (attempts != null) {
            for (String[] attempt : attempts) {
                if (attempt == null || attempt.length < 2) continue;
                for (int i = 0; i < modifiers.length; i++) {
                    if (modifiers[i].equalsIgnoreCase(attempt[0])) {
                        if ("ALLOWED".equals(classifyAccess(attempt[0], attempt[1]))) {
                            allowed[i]++;
                        } else {
                            denied[i]++;
                        }
                        break;
                    }
                }
            }
        }

        return String.format(
                "private: %d allowed / %d denied | default: %d allowed / %d denied | protected: %d allowed / %d denied | public: %d allowed / %d denied",
                allowed[0], denied[0], allowed[1], denied[1], allowed[2], denied[2], allowed[3], denied[3]);
    }

    static class LibraryMember {
        private String membershipPin;
        String branchCode;
        protected double finesOwed;
        public String displayName;
    }
}
