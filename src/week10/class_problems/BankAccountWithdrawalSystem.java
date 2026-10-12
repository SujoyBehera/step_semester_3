package week10.class_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankAccountWithdrawalSystem {

    public static abstract class BankAccount {
        protected final String id;
        protected int balance;

        public BankAccount(String id, int initialBalance) {
            if (id == null || id.trim().isEmpty()) {
                throw new IllegalArgumentException("Account ID cannot be blank");
            }
            this.id = id;
            this.balance = initialBalance;
        }

        public String getId() {
            return id;
        }

        public int getBalance() {
            return balance;
        }

        public abstract String withdraw(int amount);
    }

    public static class SavingsAccount extends BankAccount {
        private static final int MINIMUM_BALANCE = 1000;

        public SavingsAccount(String id, int initialBalance) {
            super(id, initialBalance);
        }

        @Override
        public String withdraw(int amount) {
            if (balance - amount < MINIMUM_BALANCE) {
                return id + " rejected: minimum balance " + MINIMUM_BALANCE;
            }
            balance -= amount;
            return id + " balance " + balance;
        }
    }

    public static class CurrentAccount extends BankAccount {
        private static final int OVERDRAFT_LIMIT = 5000;

        public CurrentAccount(String id, int initialBalance) {
            super(id, initialBalance);
        }

        @Override
        public String withdraw(int amount) {
            if (balance - amount < -OVERDRAFT_LIMIT) {
                return id + " rejected: overdraft limit " + OVERDRAFT_LIMIT;
            }
            balance -= amount;
            return id + " balance " + balance;
        }
    }

    private final Map<String, BankAccount> accounts = new HashMap<>();

    public void createSavings(String id, int initialBalance) {
        accounts.put(id, new SavingsAccount(id, initialBalance));
    }

    public void createCurrent(String id, int initialBalance) {
        accounts.put(id, new CurrentAccount(id, initialBalance));
    }

    public String processWithdraw(String id, int amount) {
        BankAccount account = accounts.get(id);
        if (account == null) {
            return "Account not found";
        }
        return account.withdraw(amount);
    }

    public List<String> processOperations(List<String> operations) {
        List<String> results = new ArrayList<>();
        if (operations == null) return results;

        for (String op : operations) {
            if (op == null || op.trim().isEmpty()) continue;
            String[] parts = op.trim().split("\\s+");
            String type = parts[0];

            if ("Savings".equalsIgnoreCase(type)) {
                String id = parts[1];
                int initial = Integer.parseInt(parts[2]);
                createSavings(id, initial);
            } else if ("Current".equalsIgnoreCase(type)) {
                String id = parts[1];
                int initial = Integer.parseInt(parts[2]);
                createCurrent(id, initial);
            } else if ("WITHDRAW".equalsIgnoreCase(type)) {
                String id = parts[1];
                int amount = Integer.parseInt(parts[2]);
                results.add(processWithdraw(id, amount));
            }
        }
        return results;
    }
}
