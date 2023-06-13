package task1;

public class BinarySearch {
    public static int search(Student[] students, int key, int numSteps) {
        int low = 0;
        int high = students.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            numSteps++;

            if (students[mid].getStudentId() == key) {
                return mid;
            } else if (students[mid].getStudentId() < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}





