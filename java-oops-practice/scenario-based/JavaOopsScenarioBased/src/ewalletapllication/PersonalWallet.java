package ewalletapllication;

class PersonalWallet extends Wallet {

    public PersonalWallet(double balance) {
        super(balance);
    }

    public PersonalWallet(double balance, double referralBonus) {
        super(balance, referralBonus);
    }

    @Override
    public void transferTo(User receiver, double amount) {
        double tax = amount * 0.02; // 2% tax
        double total = amount + tax;

        if (deduct(total)) {
            receiver.getWallet().add(amount);
            Transaction.record("Personal Transfer", amount);
        } else {
            System.out.println("Insufficient balance in personal wallet");
        }
    }
}
