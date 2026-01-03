package ewalletapllication;

class Transaction {
    public static void record(String type, double amount) {
        System.out.println("Transaction: " + type + " | Amount: ₹" + amount);
    }
}
