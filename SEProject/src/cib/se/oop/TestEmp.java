package cib.se.oop;

public class TestEmp {
    
    public static double SumSalary(Emp[] emps) {
        
        double sum = 0;
        for (int i = 0; i < emps.length; i++) {
            sum += emps[i].getMonthlyNetSalary();
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        
        Emp e1 = new Emp(101,"Bassem",7000.0);
        Emp e2 = new Emp(102,"Ahmed",3000.0);
        Emp e3 = new Emp(103,"Mohamed",10000.0);
        Emp e4 = new Emp(104,"Hossam",5000.0);
        
        Emp[] emps = {e1,e2,e3,e4};
        System.out.println( SumSalary(emps) );
        System.out.println(Emp.getEmpCnt());
   }
}
