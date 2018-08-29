package cib.se.oop.academy;

import java.util.ArrayList;

public class Course {
    
    private int id;
    private String name;
    private String category;
    private int hours;
    private int price;

    private Trainer courseTrainer;
    private ArrayList<Student> students;

    public Course(int id, String name, String category, int hours, int price, Trainer courseTrainer) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.hours = hours;
        this.price = price;
        
        students = new ArrayList<Student>();
        this.courseTrainer = courseTrainer;
    }
    
    public boolean addStudent(Student st) {
        for(Student item : students) {
            if(item.getId() == st.getId()) {
                return false;
            }
        }
        this.students.add(st);
        return true;
    }
    
    public boolean removeStudent(Student st) {
        for(Student item : students) {
            if(item.getId() == st.getId()) {
                this.students.remove(st);
                return true;
            }
        }
        return false;
    }
    
    public boolean setAbsent(Student st) {
        for(Student item : students) {
            if(item.getId() == st.getId()) {
                item.setAbsence(item.getAbsence() + 1);
                return true;
            }
        }
        return false;
    }
    
    public int getAbsentDays(Student st) {
        for(Student item : students) {
            if(item.getId() == st.getId()) {
                return item.getAbsence();
            }
        }
        return 0;
    }
    
    public boolean setMark(Student st, int Mark) {
        for(Student item : students) {
            if(item.getId() == st.getId()) {
                item.setMark(Mark);
                return true;
            }
        }
        return false;
    }
    
    public Student getHighestMark() {
        int max = 0;
        Student topStudent = new Student();
        
        for(Student item : students) {
            if(item.getMark() > max) {
                max = item.getMark();
                topStudent = item;
            }
        }
        return topStudent;
    }
    
    public void printCourseDetails() {
        
        String res = "COURSE: " + this.id + ", " + this.name + ", " + this.category + ", " + this.price;
        res += "\n";
        res += "TRAINER: " + this.courseTrainer.getId() + ", " + this.courseTrainer.getName();
        res += "\nSTUDENTS: \n";
        for(Student item : students) {
            res+= "\t" + item.getId() + ", " + item.getName() + ", " + item.getMark() + ", " + item.getAbsence();
            res+= "\n";
        }
        System.out.println(res);
    }

}
