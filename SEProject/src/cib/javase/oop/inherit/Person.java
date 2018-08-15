package cib.javase.oop.inherit;

public abstract class Person {
    
    private int ID;
    private String name;
    private double grossSalary;
    private String personJob;
    
    public Person() {

     }

    public Person(int ID, String name, double grossSalary) {
        this();
        this.ID = ID;
        this.name = name;
        this.grossSalary = grossSalary;
        this.personJob = personJob;
    }
    
    public void printDetails() {
        System.out.print(this.ID + " : " + this.name);       
    }
 
    // GETTERS AND SETTERS!
    public void setID(int ID) {
        this.ID = ID;
    }
    public int getID() {
        return ID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }
    public double getGrossSalary() {
        return grossSalary;
    }
    public void setPersonJob(String personJob) {
        this.personJob = personJob;
    }
    public String getPersonJob() {
        return personJob;
    }
}
