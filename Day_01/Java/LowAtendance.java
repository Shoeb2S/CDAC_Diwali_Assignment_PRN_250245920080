package Day1;

import java.io.Serializable;

class LowAttendanceException extends Exception {
    public LowAttendanceException(String message) {
        super(message);
    }
}

class Student implements Serializable {
    int rollno;
    String sname;
    String course;
    double attendance_percentage;
    double score;

    public Student() {}

    public Student(int rollno, String sname, String course, double attendance_percentage, double score) {
        this.rollno = rollno;
        this.sname = sname;
        this.course = course;
        this.attendance_percentage = attendance_percentage;
        this.score = score;
    }

    public String calculateGrade() throws LowAttendanceException {
        if (attendance_percentage < 60) {
            throw new LowAttendanceException("Attendance is below 60% for " + sname);
        }
        if (score >= 90) return "A+";
        else if (score >= 75) return "A";
        else if (score >= 60) return "B";
        else return "C";
    }

    @Override
    public String toString() {
        return rollno + " | " + sname + " | " + course + " | " + attendance_percentage + "% | " + score + " | " + tryGrade();
    }

    private String tryGrade() {
        try {
            return calculateGrade();
        } catch (LowAttendanceException e) {
            return "Low Attendance";
        }
    }
}

