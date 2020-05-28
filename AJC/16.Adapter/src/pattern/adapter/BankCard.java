package pattern.adapter;

public class BankCard {

    private String accountNumber;

    public BankCard(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void startTransactionWithBank() {
        System.out.println("Start transaction with Bank Card");
    }

}
