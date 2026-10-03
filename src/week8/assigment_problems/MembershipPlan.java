package week8.assigment_problems;

import java.util.Locale;

public abstract class MembershipPlan {
    public static final double BASE_MONTHLY_RATE = 1000.0;

    private final String planName;
    private final int durationMonths;

    protected MembershipPlan(String planName, int durationMonths) {
        if (planName == null || planName.trim().isEmpty()) {
            throw new IllegalArgumentException("planName cannot be blank");
        }
        if (durationMonths <= 0) {
            throw new IllegalArgumentException("durationMonths must be positive");
        }
        this.planName = planName;
        this.durationMonths = durationMonths;
    }

    public String getPlanName() {
        return planName;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public abstract double calculateFee();

    public static class Member extends GymMember {
        public Member(String name) {
            super(name);
        }
    }
}

class MonthlyPlan extends MembershipPlan {
    public MonthlyPlan() {
        super("Monthly", 1);
    }

    @Override
    public double calculateFee() {
        return getDurationMonths() * BASE_MONTHLY_RATE;
    }
}

class QuarterlyPlan extends MembershipPlan {
    public QuarterlyPlan() {
        super("Quarterly", 3);
    }

    @Override
    public double calculateFee() {
        double gross = getDurationMonths() * BASE_MONTHLY_RATE;
        return gross * 0.90;
    }
}

class AnnualPlan extends MembershipPlan {
    public AnnualPlan() {
        super("Annual", 12);
    }

    @Override
    public double calculateFee() {
        double gross = getDurationMonths() * BASE_MONTHLY_RATE;
        return gross * 0.75;
    }
}

enum FitZoneStatus {
    Active, Frozen, Expired
}

class GymMember {
    private final String name;

    public GymMember(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name cannot be blank");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Membership {
    private final GymMember member;
    private final MembershipPlan plan;
    private FitZoneStatus status = FitZoneStatus.Active;
    private final double fee;

    public Membership(GymMember member, MembershipPlan plan) {
        if (member == null || plan == null) {
            throw new IllegalArgumentException("Member and plan cannot be null");
        }
        this.member = member;
        this.plan = plan;
        this.fee = plan.calculateFee();
    }

    public GymMember getMember() {
        return member;
    }

    public MembershipPlan getPlan() {
        return plan;
    }

    public FitZoneStatus getStatus() {
        return status;
    }

    public double getFee() {
        return fee;
    }

    public String checkIn() {
        if (status == FitZoneStatus.Active) {
            return member.getName() + " checked in successfully.";
        }
        return "Check-in denied: " + member.getName() + "'s membership is " + status + ".";
    }

    public String freeze() {
        if (status == FitZoneStatus.Expired) {
            return "Cannot freeze an Expired membership.";
        }
        if (status == FitZoneStatus.Frozen) {
            return member.getName() + "'s membership is already Frozen.";
        }
        status = FitZoneStatus.Frozen;
        return member.getName() + "'s membership frozen. Status: Frozen.";
    }

    public String unfreeze() {
        if (status == FitZoneStatus.Expired) {
            return "Cannot unfreeze an Expired membership.";
        }
        if (status == FitZoneStatus.Active) {
            return member.getName() + "'s membership is already Active.";
        }
        status = FitZoneStatus.Active;
        return member.getName() + "'s membership unfrozen. Status: Active.";
    }

    public String expire() {
        status = FitZoneStatus.Expired;
        return member.getName() + "'s membership expired. Status: Expired.";
    }
}

class MembershipDesk {
    public static String createMembership(GymMember member, MembershipPlan plan) {
        if (member == null || plan == null) {
            throw new IllegalArgumentException("member and plan cannot be null");
        }
        Membership m = new Membership(member, plan);
        return plan.getPlanName() + " membership created for " + member.getName() +
                ". Fee: ₹" + String.format(Locale.US, "%,.2f", m.getFee()) + ". Status: Active.";
    }
}
