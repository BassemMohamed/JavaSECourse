package cib.javase.oop.interfaces;

import cib.javase.oop.inherit.Manager;
import cib.javase.oop.inherit.Person;

public class TestLambda {
    public static void main(String[] args) {
       
       Manager m = new Manager(102, "Mostafa", 10000.0, 20);
       // ----------------------------------------------------------------
       // Lambda expressions & Functional interfaces
       
       // MaxRateAnalyzer Interface is a functional interface bec it only contains one method!
       MaxRateAnalyzer personRate = new MaxRateAnalyzer(){
            public boolean checkrate(Double amount) {
                return (amount < MAX_RATE);
            }
        };

       // Functional interfaces can be written used lambda experssions for less writing!
       MaxRateAnalyzer personRateLambda = (amount) -> (amount < MaxRateAnalyzer.MAX_RATE);
       
        //System.out.println("Manager reached max rate : " + personRate.checkrate(m1.getGrossSalary()) );
        //System.out.println("Manager reached max rate : " + personRateLambda.checkrate(m1.getGrossSalary()) );
        
        validatePerson(m, new MaxRateAnalyzer(){
            public boolean checkrate(Double amount) {
                return (amount < MaxRateAnalyzer.MAX_RATE);
            }
        });
        
        validatePerson(m, (amount) -> amount < MaxRateAnalyzer.MAX_RATE);
   }
    
    public static boolean validatePerson(Person p, MaxRateAnalyzer validator) {
        return validator.checkrate(p.getGrossSalary());
    }
}
