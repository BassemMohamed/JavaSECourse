package cib.se.gettingstarted;

import java.util.Date;

import javax.xml.crypto.Data;

public class TestEmpTax {
    
    public static int calcTax(double empGrossSalary) {
        if( empGrossSalary < 5000 ) {
            return 0;
        } else if ( empGrossSalary < 10000 ) {
            return 10;
        } else if ( empGrossSalary < 15000 ) {
            return 15;
        } else {
            return 20;
        }
    }
    
    public static void main(String[] args) {
        
        int empId = 101;
        String empName = "ahmed";
        double empGrossSalary = 7000.0;
        String empJob = "Java Developer";
        Date empHireDate = new Date();
        int tax = calcTax(empGrossSalary);
        
        double empNetSalary = empGrossSalary - ( (empGrossSalary * tax) / 100.0);
        double empAnnualNetSalary = empNetSalary * 12;
        
        String res = "Emp whose ID = " + empId + ", named : " + empName + ", works as " + empJob + ", Hired on " + empHireDate + 
                     " Takes Monthly net = " + empNetSalary + " and Annual Net = " + empAnnualNetSalary;
        System.out.println(res);
   }
}
