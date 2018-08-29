package cib.se.oop.inherit;

import cib.se.oop.interfaces.MaxRateAnalyzer;

public class TestInherit {
    public static void main(String[] args) {

       Employee e1 = new Employee(101,"Bassem",6000.0,20,60.0);
        
       //System.out.println(e1.getMonthlyNetSalary());
       //.out.println(e1.getAnnualNetSalary());
       //e1.printDetails();
       
       Manager m1 = new Manager(102, "Mostafa", 10000.0, 20);
       
       //System.out.println(m1.getMonthlyNetSalary());
       //System.out.println(m1.getAnnualNetSalary());
       //System.out.println(m1.getAnnualNetSalary(1000000.0));
       
    }
}