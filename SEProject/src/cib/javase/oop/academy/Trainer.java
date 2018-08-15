package cib.javase.oop.academy;

import java.util.Date;

public class Trainer {
    
    private int id;
    private String name;
    private Date hireDate;
    private int salary;

    public Trainer(int id, String name, Date hireDate, int salary) {
        super();
        this.id = id;
        this.name = name;
        this.hireDate = hireDate;
        this.salary = salary;
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

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
}
