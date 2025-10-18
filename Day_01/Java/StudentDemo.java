package Day1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class StudentDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Aarav", "Java", 80, 85));
        students.add(new Student(2, "Priya", "Python", 55, 70));
        students.add(new Student(3, "Rohan", "Java", 90, 92));
        students.add(new Student(4, "Sneha", "C++", 65, 60));
        students.add(new Student(5, "Vikram", "Java", 75, 88));
        students.add(new Student(6, "Anjali", "Python", 45, 50));
        students.add(new Student(7, "Karan", "C++", 95, 95));
        students.add(new Student(8, "Neha", "Java", 82, 78));
        students.add(new Student(9, "Raj", "Python", 62, 66));
        students.add(new Student(10, "Pooja", "C++", 58, 55));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.ser"))) {
            oos.writeObject(students);
            System.out.println("Students serialized successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        students.sort((s1, s2) -> Double.compare(s2.attendance_percentage, s1.attendance_percentage));
        System.out.println("\nStudents sorted by attendance:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}

