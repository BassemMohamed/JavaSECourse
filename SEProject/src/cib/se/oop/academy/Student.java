package cib.se.oop.academy;

public class Student {
    
    private int id;
    private String name;
    private int mobile;
    private int mark;
    private int absence;
    
    public Student() {
        
    }
    
    public Student(int id, String name, int mobile) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
    }


    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setMobile(int mobile) {
        this.mobile = mobile;
    }
    public int getMobile() {
        return mobile;
    }
    public void setMark(int mark) {
        this.mark = mark;
    }
    public int getMark() {
        return mark;
    }
    public void setAbsence(int absence) {
        this.absence = absence;
    }
    public int getAbsence() {
        return absence;
    }
}
