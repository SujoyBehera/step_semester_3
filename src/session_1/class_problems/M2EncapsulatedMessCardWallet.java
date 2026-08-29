package session_1.class_problems;

public class M2EncapsulatedMessCardWallet {

    public static class MessWallet{
        private double balance;
        double amount;
        MessWallet(double balance){
            if(balance<0){
                System.out.println("balance starts from 0");
                this.balance=0;
            }
            else{
                this.balance=balance;
            }
        }
        void topUp(double amount){
            if(amount<=0){
                System.out.println("The amount entered is ZERO or smaller than zero");
                this.balance=0;
                System.out.println("Balance after top-up: "+balance);
            }
            else{
                this.balance+=amount;
                System.out.println("Balance after top-up: "+balance);
            }
        }
        void deduct(double amount){
            if(amount>balance){
                System.out.println("Deduct rejected: insufficient balance");
            }
            else{
                this.balance=balance-amount;
                System.out.println("Balance after deduction: "+balance);
            }
        }
        void getBalance(){
            System.out.println("Final Balance: "+balance);
        }

    }
    public static void main(String[] args){
        MessWallet wallet = new MessWallet(5);
        wallet.topUp(1200);
        wallet.deduct(40);
        wallet.getBalance();

    }

}
