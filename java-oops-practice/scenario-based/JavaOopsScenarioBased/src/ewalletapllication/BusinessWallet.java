package ewalletapllication;

class BusinessWallet extends Wallet {

    public BusinessWallet(double balance) {
        super(balance);
    }

    @Override
    public void transferTo(User receiver, double amount) {
        double serviceCharge = 50;

        if (deduct(amount + serviceCharge)) {
            receiver.getWallet().add(amount);
            Transaction.record("Business Transfer", amount);
        } else {
            System.out.println("Insufficient balance in business wallet");
        }
    }
}
