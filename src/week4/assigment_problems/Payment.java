package week4.assigment_problems;

public class Payment {
    public double pay(double amount) {
        System.out.println("Paid (cash): Rs " + amount);
        return amount;
    }

    public static void processTransaction(Payment payment, double amount) {
        double actualAmount;
        if (payment instanceof CardPayment) {
            CardPayment cardPayment = (CardPayment) payment;
            actualAmount = cardPayment.payWithProcessingFee(amount);
        } else {
            actualAmount = payment.pay(amount);
        }
        totalCollected += actualAmount;
    }

    static double totalCollected = 0;

    public static void main(String[] args) {
        Payment[] payments = {
            new CardPayment(), new Payment(), new CardPayment(), new Payment(), new CardPayment()
        };
        double[] amounts = {100, 50, 200, 75, 120};

        for (int i = 0; i < payments.length; i++) {
            processTransaction(payments[i], amounts[i]);
        }
        System.out.println("Total Collected: Rs " + totalCollected);
    }
}

class CardPayment extends Payment {
    public double payWithProcessingFee(double amount) {
        double total = amount * 1.02;
        System.out.println("Charged (card, incl. fee): Rs " + total);
        return total;
    }
}
