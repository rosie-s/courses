package pattern.proxy;

import pattern.adapter.Card;
import pattern.adapter.CardReader;
import pattern.adapter.TransactionInfo;

public class CardReaderProxy implements TransactionInfo {

    public static int attempt = 0;
    CardReader cardReader = new CardReader();
    private String accountNumber;

    @Override
    public boolean startTransaction(Card card) {
        String accountNumber = card.getCode();
        attempt = this.accountNumber == accountNumber ? attempt + 1 : 1;
        this.accountNumber = accountNumber;
        if (attempt > 3) {
            System.out.println("Too many attempts");
            return false;
        }
        card.connect();
        return true;

    }

}
