package task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

    public static Student[] readFile(String filePath) throws FileNotFoundException {
        // putting unsorted data from csv into an array

        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        // count the number of lines in the file to determine the size of the array
        int numLines = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            numLines++;
        }

        scanner.close();

        // creating array to store the student objects
        Student[] students = new Student[numLines];

        // read the file again to populate the array
        scanner = new Scanner(file);


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
        // putting sorted array data to the new file
       try (FileWriter writer = new FileWriter(filePath)) {

        for (Student student : students) {
            String line = student.getStudentId() + ";" + student.getFullName() + ";" + student.getDateOfBirth() + ";" + student.getUniversityName() + ";" + student.getDepartmentCode() + ";" + student.getDepartmentName() + ";" + student.getYearOfEnrollment() + "\n";
            writer.write(line);
        }
        System.out.println("Data written to the file successfully.");
    } catch (IOException e) {
        System.out.println("An error occurred while writing the file: " + e.getMessage());
    }
    }
}



