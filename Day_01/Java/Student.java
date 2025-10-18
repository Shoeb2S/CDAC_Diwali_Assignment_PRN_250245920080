package Day_01.Java;

import java.io.Serializable;

public class Student implements Serializable, Comparable<Student> {
    private static final long serialVersionUID = 1L;
    
    private int rollno;
    private String sname;
    private String course;
    private double attendance_percentage;
    private double score;
    
    // Default constructor
    public Student() {
        this.rollno = 0;
        this.sname = "";
        this.course = "";
        this.attendance_percentage = 0.0;
        this.score = 0.0;
    }
    
    // Parameterized constructor
    public Student(int rollno, String sname, String course, 
                   double attendance_percentage, double score) throws LowAttendanceException {
        if (attendance_percentage < 60.0) {
            throw new LowAttendanceException(
                "Student " + sname + " has low attendance: " + attendance_percentage + "%");
        }
        
        this.rollno = rollno;
        this.sname = sname;
        this.course = course;
        this.attendance_percentage = attendance_percentage;
        this.score = score;
    }
    
    // Method to calculate grade
    public String calculateGrade() {
        if (score >= 85) return "A+";
        else if (score >= 70) return "A";
        else if (score >= 60) return "B";
        else if (score >= 50) return "C";
        else if (score >= 40) return "D";
        else return "F";
    }
    
    // For sorting in decreasing order of attendance_percentage
    @Override
    public int compareTo(Student other) {
        int attendanceCompare = Double.compare(other.attendance_percentage, this.attendance_percentage);
        if (attendanceCompare != 0) {
            return attendanceCompare;
        }
        return Integer.compare(this.rollno, other.rollno);
    }
    
    @Override
    public String toString() {
        return "Roll No: " + rollno + ", Name: " + sname + ", Course: " + course + 
               ", Attendance: " + attendance_percentage + "%, Score: " + score + 
               ", Grade: " + calculateGrade();
    }
}