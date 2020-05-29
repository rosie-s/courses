package pattern.adapter;

public class BankCardAdapter implements Card {
    private BankCard bankCard;

    public BankCardAdapter(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    @Override
    public void connect() {
        System.out.println("Call start transaction method");
        bankCard.startTransactionWithBank();
    }

    @Override
    public String getCode() {
        return null;
    }
}
