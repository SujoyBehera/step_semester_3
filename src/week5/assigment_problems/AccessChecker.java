package week5.assigment_problems;

public class AccessChecker {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier == null || accessorContext == null) {
            return "DENIED";
        }

        switch (fieldModifier) {
            case "private":
                return "SAME_CLASS".equals(accessorContext) ? "ALLOWED" : "DENIED";
            case "default":
                return ("SAME_CLASS".equals(accessorContext)
                        || "SAME_PACKAGE".equals(accessorContext)) ? "ALLOWED" : "DENIED";
            case "protected":
                return ("SAME_CLASS".equals(accessorContext)
                        || "SAME_PACKAGE".equals(accessorContext)) ? "ALLOWED" : "DENIED";
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
                    if (modifiers[i].equals(attempt[0])) {
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

        return "private: " + allowed[0] + " allowed / " + denied[0] + " denied | "
                + "default: " + allowed[1] + " allowed / " + denied[1] + " denied | "
                + "protected: " + allowed[2] + " allowed / " + denied[2] + " denied | "
                + "public: " + allowed[3] + " allowed / " + denied[3] + " denied";
    }
}
