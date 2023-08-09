package org.example;

import java.time.LocalDate;

public class Student {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String id;

    public Student(String firstName, String lastName, String dateOfBirth, String gender, String id)
            throws InvalidDataException {
        validateFirstName(firstName);
        validateLastName(lastName);
        validateDateOfBirth(dateOfBirth);
        validateGender(gender);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
        this.gender = gender.toUpperCase();
        this.id = id;
    }

    // Getters and setters for the fields

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Helper methods for validations
    private void validateFirstName(String firstName) throws InvalidDataException {
        if (firstName.isEmpty()) {
            throw new InvalidDataException("First Name cannot be empty.");
        }
    }

    private void validateLastName(String lastName) throws InvalidDataException {
        if (lastName.isEmpty()) {
            throw new InvalidDataException("Last Name cannot be empty.");
        }
    }

    private void validateDateOfBirth(String dateOfBirth) throws InvalidDataException {
        try {
            LocalDate dob = LocalDate.parse(dateOfBirth);
            int currentYear = LocalDate.now().getYear();
            int minAllowedYear = currentYear - 18;
            int yearOfBirth = dob.getYear();

            if (yearOfBirth < 1900 || yearOfBirth > minAllowedYear) {
                throw new InvalidDataException("Date of Birth should be between 1900 and current year - 18.");
            }
        } catch (Exception e) {
            throw new InvalidDataException("Invalid Date of Birth.");
        }
    }

    private void validateGender(String gender) throws InvalidDataException {
        if (!(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")
                || gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F"))) {
            throw new InvalidDataException("Gender should be Male (M) or Female (F).");
        }
    }

    // Additional method to calculate age
    public int calculateAge() {
        return LocalDate.now().getYear() - dateOfBirth.getYear();
    }
}
