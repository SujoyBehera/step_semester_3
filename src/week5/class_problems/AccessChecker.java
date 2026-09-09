package week5.class_problems;

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

    public static String summarizeBatch(String[][] attempts) {
        int allowed = 0;
        int denied = 0;

        if (attempts != null) {
            for (String[] attempt : attempts) {
                if (attempt == null || attempt.length < 2) continue;
                if ("ALLOWED".equals(classifyAccess(attempt[0], attempt[1]))) {
                    allowed++;
                } else {
                    denied++;
                }
            }
        }
        return "ALLOWED=" + allowed + ", DENIED=" + denied;
    }

    public static class MovieTicket {
        private String seatNumber;
        String screenId;
        protected double ticketPrice;
        public String movieTitle;

        public MovieTicket(String seatNumber, String screenId, double ticketPrice, String movieTitle) {
            this.seatNumber = seatNumber;
            this.screenId = screenId;
            this.ticketPrice = ticketPrice;
            this.movieTitle = movieTitle;
        }
    }
}
