package pattern.singleton;

public class CarSingleton {

    int id;
    String brand;

    private static CarSingleton instance = null;

    private CarSingleton() {
        id = 1;
        brand = "The only brand";
    }

    public static CarSingleton getInstance() {
        if (instance == null) {
            instance = new CarSingleton();
        }
        return instance;
    }
}
