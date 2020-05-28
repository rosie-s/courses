package pattern.adapter;

public class CardReader implements TransactionInfo {
    @Override
    public void startTransaction(Card card) {
        card.connect();
    }
}
