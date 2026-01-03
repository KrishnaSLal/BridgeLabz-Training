package mybank;

class SavingsAccount extends Account {

    private static final double INTEREST_RATE = 4.0;

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public double calculateInterest() {
        return checkBalance() * INTEREST_RATE / 100;
    }
}
