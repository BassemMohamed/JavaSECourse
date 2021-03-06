package cib.se.adv.lambda_practice.p04;

import java.util.List;
import java.util.OptionalDouble;

/**
 *
 * @author oracle
 */
public class CalcTest {
    
    public static void main(String[] args) {

        List<SalesTxn> tList = SalesTxn.createTxnList();
        
        // Print out Transaction Totals
        System.out.println("=== Transactions Totals ===");

        double t1 = tList.stream()
            .filter( t -> t.getBuyerName().equals("Radio Hut") )
            .mapToDouble( t -> t.getTransactionTotal() )
            .sum();
        System.out.printf("Radio Hut Total: $%,9.2f%n", t1);
        
        double t2 = tList.stream()
            .filter( t -> t.getBuyerName().equals("PriceCo") )
            .mapToDouble( t -> t.getTransactionTotal() )
            .sum();
        System.out.printf("PriceCo Total: $%,9.2f%n", t2);

        double t3 = tList.stream()
            .filter( t -> t.getBuyerName().equals("Best Deals") )
            .mapToDouble( t -> t.getTransactionTotal() )
            .sum();
        System.out.printf("Best Deals Total: $%,9.2f%n", t3);
        
        // Print out Average Unit Count
        System.out.println("=== Average Unit Count ===");

        OptionalDouble a1 = tList.stream()
            .filter(t -> t.getProduct().equals("Widget Pro"))
            .mapToDouble(t -> t.getUnitCount())
            .average();

        if (a1.isPresent()){
            System.out.printf("Widget Pro Avg: %,9.0f%n", a1.getAsDouble());
        }
        
        OptionalDouble a2 = tList.stream()
            .filter(t -> t.getProduct().equals("Widget"))
            .mapToDouble(t -> t.getUnitCount())
            .average();
        
        if (a2.isPresent()){
            System.out.printf("Widget Avg: %,9.0f%n", a2.getAsDouble());        
        }
                 
        
    }
}
