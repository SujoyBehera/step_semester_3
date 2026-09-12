package week6.assigment_problems;

public class GymMember {
    private static int membersEnrolled = 2000;

    private final String membershipNumber;
    private String memberId;
    private final int monthlyFee;
    private int sessionsAttended;
    private int feesPaid;
    private String lastPaymentMode;
    private final int[] lateFeeHistory = new int[10];
    private int lateFeeCount;

    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("memberId must contain at least 4 non-whitespace characters");
        }
        if (monthlyFee <= 0) {
            throw new IllegalArgumentException("monthlyFee must be positive");
        }
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        membersEnrolled++;
        this.membershipNumber = "GYM-" + membersEnrolled;
    }

    public GymMember(int monthlyFee) {
        if (monthlyFee <= 0) {
            throw new IllegalArgumentException("monthlyFee must be positive");
        }
        this.monthlyFee = monthlyFee;
        membersEnrolled++;
        this.membershipNumber = "GYM-" + membersEnrolled;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public String displayInfo() {
        return "Standard Member | Sessions: " + sessionsAttended;
    }

    public static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUp = 0;
        int rejected = 0;
        if (memberIds != null) {
            for (String id : memberIds) {
                try {
                    new GymMember(id, monthlyFee);
                    signedUp++;
                } catch (IllegalArgumentException e) {
                    rejected++;
                }
            }
        }
        return "Signed Up: " + signedUp + " | Rejected: " + rejected;
    }

    protected void chargeLateFee(int amount) {
        if (lateFeeCount < lateFeeHistory.length) {
            lateFeeHistory[lateFeeCount++] = amount;
        }
    }

    public int[] getLateFeeHistory() {
        int[] copy = new int[lateFeeCount];
        System.arraycopy(lateFeeHistory, 0, copy, 0, lateFeeCount);
        return copy;
    }

    public int getTotalLateFees() {
        int total = 0;
        for (int i = 0; i < lateFeeCount; i++) total += lateFeeHistory[i];
        return total;
    }

    public void payFee(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("amount must be positive");
        feesPaid += amount;
    }

    public void payFee(int amount, String mode) {
        lastPaymentMode = mode;
        payFee(amount);
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) return false;
        return code.charAt(0) == 'G'
                && Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2))
                && Character.isUpperCase(code.charAt(3));
    }

    public static int getMembersEnrolled() {
        return membersEnrolled - 2000;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }

    public String getMemberId() {
        return memberId;
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }

    public String getLastPaymentMode() {
        return lastPaymentMode;
    }
}
