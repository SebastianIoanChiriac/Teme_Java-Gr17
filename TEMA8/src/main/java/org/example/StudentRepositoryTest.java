package org.example;

import java.util.List;

public class StudentRepositoryTest {
    public static void main(String[] args) {
        try {
            StudentRepository repository = new StudentRepository();

            // Test add student
            repository.addStudent("John", "Doe", "1990-01-01", "M", "1234567890");
            repository.addStudent("Jane", "Smith", "1995-03-15", "F", "0987654321");

            // Test delete student
            repository.deleteStudent("1234567890");

            // Test retrieve students with age
            List<Student> studentsWithAge25 = repository.retrieveStudentsWithAge(25);

            // Test list students by last name
            List<Student> studentsByLastName = repository.listStudentsOrderByLastName();

            // Test list students by birth date
            List<Student> studentsByBirthDate = repository.listStudentsOrderByBirthDate();

            // Print results
            for (Student student : studentsWithAge25) {
                System.out.println(student.getFirstName() + " " + student.getLastName() + " - Age: " + student.calculateAge());
            }

            for (Student student : studentsByLastName) {
                System.out.println(student.getFirstName() + " " + student.getLastName());
            }

            for (Student student : studentsByBirthDate) {
                System.out.println(student.getFirstName() + " " + student.getLastName() + " - Date of Birth: " + student.getDateOfBirth());
            }

        } catch (InvalidDataException | StudentNotFoundException e) {
            e.printStackTrace();
        }
    }
}
