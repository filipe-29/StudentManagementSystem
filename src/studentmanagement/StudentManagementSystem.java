// StudentManagementSystem.java
package studentmanagement;

import java.util.ArrayList;
import java.util.List;

public class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public void removeStudent(int id) {
        students.removeIf(student -> student.getId() == id);
        System.out.println("Student removed successfully!");
    }

    public Student findStudent(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void updateStudent(int id, String name, int age, String grade, double gpa) {
        Student student = findStudent(id);
        if (student != null) {
            student.setName(name);
            student.setAge(age);
            student.setGrade(grade);
            student.setGpa(gpa);
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }
        System.out.println("\nStudent List:");
        students.forEach(System.out::println);
    }

    public List<Student> getStudentsByGrade(String grade) {
        return students.stream()
                .filter(student -> student.getGrade().equals(grade))
                .toList();
    }

    public double getAverageGPA() {
        if (students.isEmpty()) return 0.0;
        return students.stream()
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0.0);
    }
}
