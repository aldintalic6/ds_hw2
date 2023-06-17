package task1;

public class MergeSort {

    public static void sort(Student[] students) {
        mergeSort(students, 0, students.length - 1);
    }

    private static void mergeSort(Student[] students, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(students, low, mid);
            mergeSort(students, mid + 1, high);
            merge(students, low, mid, high);
        }
    }

    private static void merge(Student[] students, int low, int mid, int high) {
        int leftSize = mid - low + 1;
        int rightSize = high - mid;

        Student[] leftArray = new Student[leftSize];
        Student[] rightArray = new Student[rightSize];

        // Copy data to temporary arrays
        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = students[low + i];
        }

        for (int j = 0; j < rightSize; j++) {
            rightArray[j] = students[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = low;

        // Merge the temporary arrays
        while (i < leftSize && j < rightSize) {
            if (leftArray[i].getStudentId() <= rightArray[j].getStudentId()) {
                students[k] = leftArray[i];
                i++;
            } else {
                students[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of leftArray, if any
        while (i < leftSize) {
            students[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy the remaining elements of rightArray, if any
        while (j < rightSize) {
            students[k] = rightArray[j];
            j++;
            k++;
        }
    }
}

