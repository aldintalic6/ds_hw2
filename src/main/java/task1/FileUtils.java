package task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUtils {

    public static Student[] readFile(String filePath) throws FileNotFoundException {
        Student[] students;

        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        // Skip the header line if present
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        // Count the number of lines in the file to determine the size of the array
        int numLines = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            numLines++;
        }

        scanner.close();

        // Create an array to store the student objects
        students = new Student[numLines];

        // Read the file again to populate the array
        scanner = new Scanner(file);

        // Skip the header line if present
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        int index = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(";");

            int studentId = Integer.parseInt(data[0]);
            String fullName = data[1];
            String dateOfBirth = data[2];
            String universityName = data[3];
            String departmentCode = data[4];
            String departmentName = data[5];
            int yearOfEnrollment = Integer.parseInt(data[6]);

            Student student = new Student(studentId, fullName, dateOfBirth, universityName, departmentCode, departmentName, yearOfEnrollment);
            students[index] = student;
            index++;
        }

        scanner.close();

        return students;
    }

    public static void writeToFile(Student[] students, String filePath) {
        // Implement the logic to write the student data to a new CSV file
    }
}



