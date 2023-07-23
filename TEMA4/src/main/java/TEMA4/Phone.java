package TEMA4;

abstract class Phone {
    private String color;
    private String material;
    private String imei;
    protected int batteryLife;

    public Phone(String color, String material, String imei, int batteryLife) {
        this.color = color;
        this.material = material;
        this.imei = imei;
        this.batteryLife = batteryLife;
    }

    public abstract void addContact(String phoneNumber, String firstName, String lastName);

    public abstract void sendMessage(String phoneNumber, String messageContent);

    public abstract void call(String phoneNumber);

    public abstract void viewHistory();

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    public String getImei() {
        return imei;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    protected void decreaseBatteryLife(int hours) {
        batteryLife -= hours;
    }
}
