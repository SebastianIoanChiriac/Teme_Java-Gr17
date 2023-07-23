package TEMA4;

public class Main {
    public static void main(String[] args) {
        Phone phone = new SamsungGalaxyS6("Black", "Plastic", "1234567890", 10);

        phone.addContact("1", "John", "Doe");
        phone.addContact("2", "Jane", "Smith");

        phone.sendMessage("1", "Hello, John!");
        phone.call("2");

        phone.viewHistory();
    }
}
