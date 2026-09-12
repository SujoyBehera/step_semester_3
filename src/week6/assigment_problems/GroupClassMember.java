package week6.assigment_problems;

public class GroupClassMember extends GymMember {
    private final String className;

    public GroupClassMember(String memberId, int monthlyFee, String className) {
        super(memberId, monthlyFee);
        this.className = className;
    }

    public GroupClassMember(int monthlyFee, String className) {
        super(monthlyFee);
        this.className = className;
    }

    @Override
    public String displayInfo() {
        return "Group Class Member | Class: " + className + " | Sessions: " + getSessionsAttended();
    }

    public String getClassName() {
        return className;
    }

    public static String processWeeklyCheckIn(GymMember[] members) {
        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        if (members != null) {
            for (GymMember member : members) {
                if (member == null) {
                    nullSkipped++;
                } else {
                    processed++;
                    if (member instanceof GroupClassMember) group++;
                    else individual++;
                }
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | "
                + group + " group | " + individual + " individual";
    }
}
