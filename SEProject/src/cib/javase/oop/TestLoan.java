package cib.javase.oop;

public class TestLoan {
    public static void main(String[] args) {
        Loan x = new Loan(12.0,5,100000.00);
        
        System.out.println(Math.round(x.getMonthlyPayment() * 100) / 100);
        System.out.println(Math.round(x.getTotalPayment() * 100) / 100);      
    }
}
