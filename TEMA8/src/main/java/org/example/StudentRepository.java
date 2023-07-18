package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class StudentRepository {
    private List<Student> students = new ArrayList<>();
    private Logger logger = Logger.getLogger(StudentRepository.class.getName());

    public void addStudent(String firstName, String lastName, String dateOfBirth, String gender, String id)
            throws InvalidDataException {
        Student student = new Student(firstName, lastName, dateOfBirth, gender, id);
        students.add(student);
    }

    public void deleteStudent(String id) throws StudentNotFoundException {
        Student studentToRemove = null;
        for (Student student : students) {
            if (student.getId().equals(id)) {
                studentToRemove = student;
                break;
            }
        }

        if (studentToRemove == null) {
            throw new StudentNotFoundException("Student with ID " + id + " does not exist.");
        }

        students.remove(studentToRemove);
    }

    public List<Student> retrieveStudentsWithAge(int age) throws InvalidDataException {
        if (age < 0) {
            throw new InvalidDataException("Age cannot be negative.");
        }

        List<Student> studentsWithAgeX = new ArrayList<>();
        for (Student student : students) {
            if (student.calculateAge() == age) {
                studentsWithAgeX.add(student);
            }
        }

        return studentsWithAgeX;
    }

    public List<Student> listStudentsOrderByLastName() throws InvalidDataException {
        students.sort(Comparator.comparing(Student::getLastName));
        return students;
    }

    public List<Student> listStudentsOrderByBirthDate() throws InvalidDataException {
        students.sort(Comparator.comparing(Student::getDateOfBirth));
        return students;
    }
}
