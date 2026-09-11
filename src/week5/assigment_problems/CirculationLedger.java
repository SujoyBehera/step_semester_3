package week5.assigment_problems;

public class CirculationLedger {
    private static String branchCode;

    static {
        branchCode = "PT-MAIN";
    }

    public static String processNightlyCirculation(Object[] receipts) {
        int processed = 0;
        int nullSkipped = 0;
        int referenceOnly = 0;
        int regular = 0;

        if (receipts != null) {
            for (Object receipt : receipts) {
                if (receipt == null) {
                    nullSkipped++;
                    continue;
                }

                processed++;
                if (receipt instanceof ReferenceOnlyLoanReceipt) {
                    referenceOnly++;
                } else if (receipt instanceof LoanReceipt) {
                    regular++;
                }
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | "
                + referenceOnly + " reference-only | " + regular + " regular";
    }

    public static String getBranchCode() {
        return branchCode;
    }
}
