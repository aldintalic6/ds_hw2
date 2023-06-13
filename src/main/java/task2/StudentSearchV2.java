package task2;

import java.io.FileNotFoundException;
import java.util.Scanner;
import task1.Student;

public class StudentSearchV2 {

    public static void main(String[] args) {
        String filePath = "Global_University_Students.csv";

        try {
            // Load the unsorted file into a red-black tree
            RedBlackTree<Integer, Student> tree = FileUtils.readFile(filePath);

            // Print the number of red links in the tree
            int redLinksCount = tree.countRedLinks();
            System.out.println("Number of red links in the tree: " + redLinksCount);

            Scanner scanner = new Scanner(System.in);
            int studentId;

            do {
                // Ask the user to enter a student ID or -1 to close the program
                System.out.print("\nEnter a student ID to search (or -1 to exit): ");
                studentId = scanner.nextInt();

                if (studentId != -1) {
                    // Perform the search
                    Student student = tree.get(studentId);

                    if (student != null) {
                        // Student found, print details and number of steps
                        System.out.println("\nStudent Details:");
                        System.out.println("Student ID: " + student.getStudentId());
                        System.out.println("Full Name: " + student.getFullName());
                        System.out.println("Date of Birth: " + student.getDateOfBirth());
                        System.out.println("University Name: " + student.getUniversityName());
                        System.out.println("Department Code: " + student.getDepartmentCode());
                        System.out.println("Department Name: " + student.getDepartmentName());
                        System.out.println("Year of Enrollment: " + student.getYearOfEnrollment());
                        System.out.println("Number of steps taken: " + tree.getNumSteps());

                    } else {
                        // Student not found
                        System.out.println("\nStudent with ID " + studentId + " not found.");
                        System.out.println("Number of steps taken: " + tree.getNumSteps());
                    }
                }
            } while (studentId != -1);

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }
}

