package cib.javase.oop.inherit;

public class Manager extends Person {
    
    private int profitPerc;

    public Manager(int ID, String name, double grossSalary, int profitPerc) {
        super(ID, name, grossSalary);
        this.profitPerc = profitPerc;
    }

    public double getMonthlyNetSalary() {
        double tax = 10;
        double salary = this.getGrossSalary();
        
        return (salary - (salary * tax / 100) );
    }
    
    public double getAnnualNetSalary() {
        return this.getMonthlyNetSalary() * 12;
    }
    
    public double getAnnualNetSalary(double profit) {
        return ((this.getMonthlyNetSalary() * 12) + ( profit * (this.profitPerc/100.0) ));
    }
    
    public void setProfitPerc(int profitPerc) {
        this.profitPerc = profitPerc;
    }

    public int getProfitPerc() {
        return profitPerc;
    }
}
