package pattern.adapter;

public class CardReader implements TransactionInfo {
    @Override
    public boolean startTransaction(Card card) {
        card.connect();
        return true;
    }
}
