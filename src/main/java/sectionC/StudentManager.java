package sectionC;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void menu() {
        int choice;
        do {
            System.out.println("\n=== Section C: Student Grade Manager ===");
            System.out.println("1. Add Student");
            System.out.println("2. Display Report");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> displayReport();
                case 3 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 3);
    }

    private void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("How many marks to enter? ");
        int count = scanner.nextInt();
        int[] marks = new int[count];

        for (int i = 0; i < count; i++) {
            System.out.print("Enter mark " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
        students.add(new Student(name, marks));
        System.out.println("Student added successfully!");
    }

    private void displayReport() {
        System.out.println("\n--- STUDENT REPORT ---");
        for (Student s : students) {
            System.out.println("Name: " + s.getName() +
                    ", Average: " + s.getAverage());
        }
    }


    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.menu();
    }
}
