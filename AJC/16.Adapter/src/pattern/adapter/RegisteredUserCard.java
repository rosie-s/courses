package pattern.adapter;

public class RegisteredUserCard implements Card {
    @Override
    public void connect() {
        System.out.println("Connection with registered user card");
    }
}
