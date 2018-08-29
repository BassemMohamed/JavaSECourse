package cib.se.adv.io.serialization;

import java.io.Serializable;

public class Employee implements Serializable {
    
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    public String toString() {
        return id + ": " + name + " (" + salary + ")";
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

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}
