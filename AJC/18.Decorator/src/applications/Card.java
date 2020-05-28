package applications;

import pattern.adapter.*;
import pattern.proxy.CardReaderProxy;

public class Card {

    public static void main(String[] args) {

        TransactionInfo transactionInfo = new CardReaderProxy();
        //TransactionInfo transactionInfo = new CardReader();
        BankCardAdapter bankCardAdapter = new BankCardAdapter(new BankCard("123456"));
        CardReader cardReader = new CardReader();

        //Proxy
        System.out.println("***Test Proxy***");
        transactionInfo.startTransaction(bankCardAdapter);
        transactionInfo.startTransaction(bankCardAdapter);
        transactionInfo.startTransaction(bankCardAdapter);
        transactionInfo.startTransaction(bankCardAdapter);
        transactionInfo.startTransaction(bankCardAdapter);
        transactionInfo.startTransaction(bankCardAdapter);

    }
}
