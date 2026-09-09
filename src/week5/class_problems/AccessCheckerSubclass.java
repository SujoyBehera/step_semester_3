package week5.class_problems;

public class AccessCheckerSubclass extends AccessChecker {
    public static String classifySubclassAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier == null || accessorContext == null) return "DENIED";

        if ("protected".equalsIgnoreCase(fieldModifier)) {
            if ("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(accessorContext)) return "ALLOWED";
            if ("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE".equals(accessorContext)) return "DENIED";
        }
        return classifyAccess(fieldModifier, accessorContext);
    }
}
