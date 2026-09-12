package week6.assigment_problems;

public class GymMembershipOperations {
    public static String processWeeklyCheckIn(GymMember[] members) {
        return GroupClassMember.processWeeklyCheckIn(members);
    }

    public static String classifyGeneration(GymMember member) {
        return MembershipOperations.classifyGeneration(member);
    }

    public static int getTotalSessionsAttended(GymMember[] members) {
        return MembershipOperations.getTotalSessionsAttended(members);
    }

    public static String batchPrint(GymMember[] members) {
        return MembershipOperations.batchPrint(members);
    }
}
