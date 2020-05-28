package pattern.proxy;

import pattern.adapter.Card;
import pattern.adapter.CardReader;
import pattern.adapter.TransactionInfo;

public class CardReaderProxy implements TransactionInfo {

    public static int attempt = 0;
    private CardReader cardReader = new CardReader();

    @Override
    public void startTransaction(Card card) {
        if (attempt < 3) {
            cardReader.startTransaction(card);
            attempt++;
        } else {
            System.out.println("Too many attempts");
        }
    }
}
