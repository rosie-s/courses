package card;

import pattern.adapter.*;

public class CardApplication {

    public static void main(String[] args) {
        CardReader cardReader = new CardReader();

        BankCard bankCard = new BankCard("1234");
        RegisteredUserCard registeredUserCard = new RegisteredUserCard();

        cardReader.startTransaction(registeredUserCard);
        cardReader.startTransaction(new BankCardAdapter(bankCard));

    }
}
