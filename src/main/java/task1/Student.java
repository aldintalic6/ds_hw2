package task1;

public class Student implements Comparable<Student> {
    private int studentId;
    private String fullName;
    private String dateOfBirth;
    private String universityName;
    private String departmentCode;
    private String departmentName;
    private int yearOfEnrollment;

    public Student(int studentId, String fullName, String dateOfBirth, String universityName, String departmentCode, String departmentName, int yearOfEnrollment) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.universityName = universityName;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.yearOfEnrollment = yearOfEnrollment;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getUniversityName() {
        return universityName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getYearOfEnrollment() {
        return yearOfEnrollment;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.studentId, o.studentId);
    }

     @Override
    public String toString() {
        return "Student ID: " + studentId +
                "\nFull Name: " + fullName +
                "\nDate of Birth: " + dateOfBirth +
                "\nUniversity Name: " + universityName +
                "\nDepartment Code: " + departmentCode +
                "\nDepartment Name: " + departmentName +
                "\nYear of Enrollment: " + yearOfEnrollment;
    }
}
