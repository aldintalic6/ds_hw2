package task1;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentSearchV1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Read the unsorted student data from the CSV file
            String unsortedFilePath = "/Users/aldintalic/Desktop/ds_hw2/Global_University_Students.csv";

            Student[] students;
            try {
                students = FileUtils.readFile(unsortedFilePath);
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Exiting the program.");
                return;
            }

            // Sort the student array using merge sort
            MergeSort.sort(students);

            // Save the sorted student data to a new CSV file
            String sortedFilePath = "sorted.csv";
            FileUtils.writeToFile(students, sortedFilePath);
            System.out.println("Sorted data saved to the file.");

            // Search for students
            boolean isSearching = true;
            while (isSearching) {
                System.out.print("\nEnter a student ID to search (or -1 to exit): ");
                int studentId = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                if (studentId == -1) {
                    isSearching = false;
                    System.out.println("Exiting the program.");
                    continue;
                }

                int numSteps = 0;
                int index = BinarySearch.search(students, studentId, numSteps);

                if (index != -1) {
                    Student student = students[index];
                    System.out.println("\nStudent Details:");
                        System.out.println("Student ID: " + student.getStudentId());
                        System.out.println("Full Name: " + student.getFullName());
                        System.out.println("Date of Birth: " + student.getDateOfBirth());
                        System.out.println("University Name: " + student.getUniversityName());
                        System.out.println("Department Code: " + student.getDepartmentCode());
                        System.out.println("Department Name: " + student.getDepartmentName());
                        System.out.println("Year of Enrollment: " + student.getYearOfEnrollment());
                        System.out.println("Number of steps taken: " + numSteps);
                } else {
                    System.out.println("Student Not Found!");
                    System.out.println("Number of Steps: " + numSteps);
                }
            }
        } finally {
            scanner.close();
        }
    }
}


