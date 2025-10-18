package Day_01.Java;

import java.io.*;
import java.util.*;

public class StudentManagementSystem {
    
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        
        // 10 student objects
        try {
        	studentList.add(new Student(101, "Shoeb", "Java", 95.5, 88.0));
        	studentList.add(new Student(102, "Rohan", "Python", 78.0, 76.5));
        	studentList.add(new Student(103, "Anjali", "C++", 65.0, 91.0));
        	studentList.add(new Student(104, "Raj", "C++", 85.5, 82.0));
        	studentList.add(new Student(105, "Pooja", "Python", 70.0, 79.5));
        	studentList.add(new Student(106, "Sneha", "Java", 88.5, 65.0));
        	studentList.add(new Student(107, "Priya", "C++", 68.0, 75.0));
        	studentList.add(new Student(108, "Rohit", "Java", 81.0, 55.0));
        	studentList.add(new Student(109, "Vikram", "Python", 71.0, 38.0));
        	studentList.add(new Student(110, "Atharva", "Java", 55.5, 56.0));
            
        } catch (LowAttendanceException e) {
            System.out.println(e.getMessage());
        }
        
        // Serialize students to file
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("students.ser"))) {
            oos.writeObject(studentList);
            System.out.println("Students serialized to file");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // TreeSet for storing students in decreasing order of attendance_percentage
        TreeSet<Student> studentSet = new TreeSet<>(studentList);
        
        // Display students
        System.out.println("\nStudents in decreasing order of attendance:");
        for (Student student : studentSet) {
            System.out.println(student);
        }
    }
}