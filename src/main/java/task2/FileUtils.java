package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import task1.Student;

public class FileUtils {

    public static RedBlackTree<Integer, Student> readFile(String filePath) throws FileNotFoundException {
        RedBlackTree<Integer, Student> tree = new RedBlackTree<>();

        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        // Skip the header line if present
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

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
            tree.put(studentId, student);
        }

        scanner.close();

        return tree;
    }
}

