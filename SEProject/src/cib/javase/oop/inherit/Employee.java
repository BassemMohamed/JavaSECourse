package cib.javase.oop.inherit;

public class Employee extends Person {
    
    private int overTimehours;
    private double overTimeRate;
    
    public Employee() {

    }
    
    Employee(int ID, String name, double grossSalary, int overTimehours, double overTimeRate) {
        super(ID,name,grossSalary);
        this.overTimehours = overTimehours;
        this.overTimeRate = overTimeRate;
    }

    public double getMonthlyNetSalary() {
        double tax = 10;
        double salary = this.getGrossSalary();
        return ( (salary - (salary * tax / 100) ) + (overTimeRate * overTimehours) );
    }
    public double getAnnualNetSalary() {
        return this.getMonthlyNetSalary() * 12;
    }
    
    public void printDetails() {
        super.printDetails();
        System.out.print(" : " + this.overTimehours); 
        System.out.println();
    }

    // GETTERS AND SETTERS!
    public void setOverTimehours(int overTimehours) {
        this.overTimehours = overTimehours;
    }
    public int getOverTimehours() {
        return overTimehours;
    }
    public void setOverTimeRate(double overTimeRate) {
        this.overTimeRate = overTimeRate;
    }
    public double getOverTimeRate() {
        return overTimeRate;
    }
}
