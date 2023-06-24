package org.TEMA5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // TreeSet with name comparator
        Set<Person> personSetByName = new TreeSet<>(new PersonNameComparator());
        personSetByName.add(new Person("John", 25));
        personSetByName.add(new Person("Alice", 30));
        personSetByName.add(new Person("Bob", 20));

        System.out.println("Sorted by name:");
        for (Person person : personSetByName) {
            System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
        }

        // TreeSet with age comparator
        Set<Person> personSetByAge = new TreeSet<>(new PersonAgeComparator());
        personSetByAge.add(new Person("John", 25));
        personSetByAge.add(new Person("Alice", 30));
        personSetByAge.add(new Person("Bob", 20));

        System.out.println("\nSorted by age:");
        for (Person person : personSetByAge) {
            System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
        }

        // HashMap with Person as key and List of Hobby as value
        Map<Person, List<Hobby>> hobbiesMap = new HashMap<>();

        List<Address> cyclingAddresses = new ArrayList<>();
        cyclingAddresses.add(new Address("City1", "Country1"));
        cyclingAddresses.add(new Address("City2", "Country2"));

        List<Address> swimmingAddresses = new ArrayList<>();
        swimmingAddresses.add(new Address("City3", "Country1"));
        swimmingAddresses.add(new Address("City4", "Country2"));

        List<Hobby> johnHobbies = new ArrayList<>();
        johnHobbies.add(new Hobby("Cycling", 3, cyclingAddresses));
        johnHobbies.add(new Hobby("Swimming", 2, swimmingAddresses));

        hobbiesMap.put(new Person("John", 25), johnHobbies);

        // Print hobbies and countries for a certain person
        Person person = new Person("John", 25);
        if (hobbiesMap.containsKey(person)) {
            List<Hobby> hobbies = hobbiesMap.get(person);
            System.out.println("\nHobbies for " + person.getName() + ":");
            for (Hobby hobby : hobbies) {
                System.out.println("Hobby: " + hobby.getName());
                System.out.println("Countries where it can be practiced:");
                for (Address address : hobby.getAddresses()) {
                    System.out.println(address.getCountry());
                }
                System.out.println();
            }
        }
    }
}