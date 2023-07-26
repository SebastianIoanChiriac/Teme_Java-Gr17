package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BirthdayMatcher {
    public static void main(String[] args) {
        String inputFileName = "src/main/resources/input.txt";
        int targetMonth = 7;
        String outputFileName = "src/main/resources/output.txt";

        List<Person> persons = readPersonsFromFile(inputFileName);

        List<Person> matchingPersons = persons.stream()
                .filter(person -> person.getDateOfBirth().getMonthValue() == targetMonth)
                .sorted(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName))
                .collect(Collectors.toList());

        writeMatchingPersonsToFile(outputFileName, matchingPersons);
    }

    private static List<Person> readPersonsFromFile(String fileName) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines()
                    .map(line -> line.split(","))
                    .map(fields -> new Person(fields[0].trim(), fields[1].trim(), LocalDate.parse(fields[2].trim(), formatter)))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    private static void writeMatchingPersonsToFile(String fileName, List<Person> matchingPersons) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Person person : matchingPersons) {
                writer.write(person.getFirstName() + ", " + person.getLastName()); // Add comma separator here
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}