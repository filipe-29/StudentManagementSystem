package studentmanagement;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static StudentManagementSystem sms = new StudentManagementSystem();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> removeStudent();
                case 3 -> findStudent();
                case 4 -> updateStudent();
                case 5 -> sms.displayAllStudents();
                case 6 -> displayStudentsByGrade();
                case 7 -> displayAverageGPA();
                case 8 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nStudent Management System");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Find Student");
        System.out.println("4. Update Student");
        System.out.println("5. Display All Students");
        System.out.println("6. Display Students by Grade");
        System.out.println("7. Display Average GPA");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();
        System.out.print("Enter student GPA: ");
        double gpa = scanner.nextDouble();

        sms.addStudent(new Student(id, name, age, grade, gpa));
    }

    private static void removeStudent() {
        System.out.print("Enter student ID to remove: ");
        int id = scanner.nextInt();
        sms.removeStudent(id);
    }

    private static void findStudent() {
        System.out.print("Enter student ID to find: ");
        int id = scanner.nextInt();
        Student student = sms.findStudent(id);
        if (student != null) {
            System.out.println("Student found: " + student);
        } else {
            System.out.println("Student not found!");
        }
    }

    private static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new grade: ");
        String grade = scanner.nextLine();
        System.out.print("Enter new GPA: ");
        double gpa = scanner.nextDouble();

        sms.updateStudent(id, name, age, grade, gpa);
    }

    private static void displayStudentsByGrade() {
        System.out.print("Enter grade to filter by: ");
        String grade = scanner.nextLine();
        List<Student> studentsInGrade = sms.getStudentsByGrade(grade);
        if (studentsInGrade.isEmpty()) {
            System.out.println("No students found in grade " + grade);
        } else {
            System.out.println("\nStudents in grade " + grade + ":");
            studentsInGrade.forEach(System.out::println);
        }
    }

    private static void displayAverageGPA() {
        double averageGPA = sms.getAverageGPA();
        System.out.printf("Average GPA: %.2f%n", averageGPA);
    }
}