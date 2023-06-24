package TEMA4;

import java.util.ArrayList;
import java.util.List;

class Samsung extends Phone {
    private List<Contact> contacts;
    private List<String> callHistory;

    public Samsung(String color, String material, String imei, int batteryLife) {
        super(color, material, imei, batteryLife);
        contacts = new ArrayList<>();
        callHistory = new ArrayList<>();
    }

    @Override
    public void addContact(String phoneNumber, String firstName, String lastName) {
        Contact contact = new Contact(phoneNumber, firstName, lastName);
        contacts.add(contact);
    }

    @Override
    public void sendMessage(String phoneNumber, String messageContent) {
        if (messageContent.length() <= 500) {
            decreaseBatteryLife(1);
            System.out.println("Sending message to " + phoneNumber + ": " + messageContent);
        } else {
            System.out.println("Message exceeds maximum character limit.");
        }
    }

    @Override
    public void call(String phoneNumber) {
        decreaseBatteryLife(2);
        callHistory.add(phoneNumber);
        System.out.println("Calling " + phoneNumber);
    }

    @Override
    public void viewHistory() {
        System.out.println("Call History:");
        for (String phoneNumber : callHistory) {
            System.out.println(phoneNumber);
        }
    }
}
