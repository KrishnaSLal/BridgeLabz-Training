package ewalletapllication;

public class MainEWalletApp {
	public static void main(String[] args) {

        User u1 = new User(1, "Krishna",
                new PersonalWallet(1000, 100));

        User u2 = new User(2, "Amit",
                new BusinessWallet(5000));

        u1.getWallet().transferTo(u2, 300);
        u2.getWallet().transferTo(u1, 500);

        System.out.println("Krishna Balance: ₹" + u1.getWallet().getBalance());
        System.out.println("Amit Balance: ₹" + u2.getWallet().getBalance());
    }
}
