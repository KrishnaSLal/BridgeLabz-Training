package mybank;

class CurrentAccount extends Account {

    private static final double INTEREST_RATE = 1.5;

    public CurrentAccount(String accountNumber) {
        super(accountNumber);
    }

    @Override
    public double calculateInterest() {
        return checkBalance() * INTEREST_RATE / 100;
    }
}
