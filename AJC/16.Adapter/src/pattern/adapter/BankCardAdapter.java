package pattern.adapter;

public class BankCardAdapter implements Card {
    BankCard bankCard;

    public BankCardAdapter(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    @Override
    public void connect() {
        System.out.println("Call start transaction method");
        bankCard.startTransactionWithBank();
    }
}
