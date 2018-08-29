package cib.se.adv.lambdapractice.p01;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author oracle
 */
public class PeekTest {
    
    public static void main(String[] args) {
    
    List<SalesTxn> tList = SalesTxn.createTxnList();
    
    Predicate<SalesTxn> caFilter = (t) -> t.getState().equals(State.CA);
    Predicate<SalesTxn> widgetFilter = (t) -> t.getProduct().equals("Widget Pro");
    Function<SalesTxn,Double> taxMap = (t) -> t.getTransactionTotal() * TaxRate.byState(t.getState());
    
    Consumer<Double> printConsumer = (t) -> System.out.printf("Txn tax: $%,9.2f%n",t);
    Consumer<SalesTxn> taxReport = t -> { 
        System.out.printf("Id: " + t.getTxnId() + " Buyer: " + t.getBuyerName() + " Txn amt: $%,9.2f ", t.getTransactionTotal());
      };
    
    // Write report using peek
    System.out.println("=== Widget Pro Sales Tax in CA ===");

    tList.stream()
        .filter(caFilter)
        .filter(widgetFilter)
        .peek(taxReport)
        .map(taxMap)
        .forEach(printConsumer);  
        
    }
}
