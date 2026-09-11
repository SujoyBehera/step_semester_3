package week5.assigment_problems;

public class ReferenceDeskSubclassReach extends AccessChecker {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if ("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(accessorContext)) {
            if ("protected".equalsIgnoreCase(fieldModifier)) return "ALLOWED";
            if ("public".equalsIgnoreCase(fieldModifier)) return "ALLOWED";
            return "DENIED";
        }

        if ("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE".equals(accessorContext)) {
            return "public".equalsIgnoreCase(fieldModifier) ? "ALLOWED" : "DENIED";
        }

        return AccessChecker.classifyAccess(fieldModifier, accessorContext);
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
