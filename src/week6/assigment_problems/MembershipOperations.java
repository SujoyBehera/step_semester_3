package week6.assigment_problems;

public class MembershipOperations {
    public static String classifyGeneration(GymMember member) {
        if (member instanceof EliteMember) return "Multilevel descendant (3 generations deep)";
        if (member instanceof GroupClassMember) return "Hierarchical sibling (independent branch)";
        if (member instanceof PremiumMember) return "Multilevel descendant (2 generations deep)";
        if (member instanceof GymMember) return "Base member";
        return "Unknown";
    }

    public static int getTotalSessionsAttended(GymMember[] members) {
        int total = 0;
        if (members != null) {
            for (GymMember member : members) {
                if (member != null) total += member.getSessionsAttended();
            }
        }
        return total;
    }

    public static String batchPrint(GymMember[] members) {
        StringBuilder result = new StringBuilder();
        for (GymMember member : members) {
            result.append(member.displayInfo());
            if (member instanceof PremiumMember) {
                PremiumMember premium = (PremiumMember) member;
                result.append(" [Trainer via downcast: ").append(premium.getTrainerName()).append("]");
            }
            result.append(" | ");
        }
        return result.toString();
    }
}
