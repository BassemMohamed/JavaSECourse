package cib.javase.oop;
import java.util.Date;
import java.lang.Math;
public class Loan {
    
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;

    public Loan() {     
    }
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.setAnnualInterestRate(annualInterestRate / 100);
        this.setNumberOfYears(numberOfYears);
        this.setLoanAmount(loanAmount);
    }
    
    public double getMonthlyPayment() {
        double monthlyInterestRate = (this.getAnnualInterestRate() / 12);
        double totalMonths = this.getNumberOfYears() * 12;
        
        double t1 = this.getLoanAmount() * monthlyInterestRate;
        double t2 = 1 - ( 1 / Math.pow( 1 + monthlyInterestRate, totalMonths ) );
        
        return t1 / t2;
    }
    
    public double getTotalPayment() {
        return this.getMonthlyPayment() * this.getNumberOfYears() * 12;
    }


    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getLoanDate() {
        return loanDate;
    }
}
