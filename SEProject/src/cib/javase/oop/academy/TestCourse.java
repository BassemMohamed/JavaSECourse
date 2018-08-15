package cib.javase.oop.academy;

import java.util.Date;

public class TestCourse {
    public static void main(String[] args) {
        
        Student s1 = new Student(101, "Bassem", 0102255);
        Student s2 = new Student(102, "Ahmed", 0102255);
        Student s3 = new Student(103, "Hossam", 0102255);
        Student s4 = new Student(104, "Khaled", 0102255);
       
        Trainer t1 = new Trainer(201, "Mostafa", new Date(), 6000);
        
        Course c = new Course(501, "CS", "Tech", 50, 1000, t1);
        c.addStudent(s1);
        c.addStudent(s2);
        c.addStudent(s3);
        c.addStudent(s4);
        c.addStudent(s2);
        c.removeStudent(s4);
        
        c.setAbsent(s1);
        c.setAbsent(s1);
        c.setAbsent(s2);
       
        c.setMark(s1, 50);
        c.setMark(s2, 20);
        c.setMark(s3, 100);
       
        System.out.println(c.getHighestMark().getName());
        c.printCourseDetails();
   }
}
