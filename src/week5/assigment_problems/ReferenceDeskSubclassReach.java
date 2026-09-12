package week5.assigment_problems;

public class ReferenceDeskSubclassReach extends AccessChecker {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier == null || accessorContext == null) return "DENIED";

        switch (accessorContext) {
            case "SAME_CLASS":
            case "SAME_PACKAGE":
                return AccessChecker.classifyAccess(fieldModifier, accessorContext);
            case "DIFFERENT_PACKAGE":
            case "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE":
                return "public".equals(fieldModifier) ? "ALLOWED" : "DENIED";
            case "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE":
                if ("public".equals(fieldModifier) || "protected".equals(fieldModifier)) return "ALLOWED";
                return "DENIED";
            default:
                return "DENIED";
        }
    }

    public static String firstDeniedAttempt(String[][] attempts) {
        if (attempts == null) return "None Denied";

        for (int i = 0; i < attempts.length; i++) {
            String[] attempt = attempts[i];
            if (attempt == null || attempt.length < 2) continue;

            if ("DENIED".equals(classifyAccess(attempt[0], attempt[1]))) {
                return attempt[0] + " via " + attempt[1] + " (attempt #" + (i + 1) + ")";
            }
        }
        return "None Denied";
    }
}
