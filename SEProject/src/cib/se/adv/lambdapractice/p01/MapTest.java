package cib.se.adv.lambdapractice.p01;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author oracle
 */
public class MapTest {
    
    public static void main(String[] args) {

        List<SalesTxn> tList = SalesTxn.createTxnList();
   
        // Calculate sales tax for CA Transactions
        System.out.println("=== Widget Pro Sales Tax in CA ===");
        
        Predicate<SalesTxn> caFilter = (t) -> t.getState().equals(State.CA);
        Predicate<SalesTxn> widgetFilter = (t) -> t.getProduct().equals("Widget Pro");
        Function<SalesTxn,Double> taxMap = (t) -> t.getTransactionTotal() * TaxRate.byState(t.getState());
        Consumer<Double> printConsumer = (t) -> System.out.printf("Txn tax: $%,9.2f%n",t);
        
        tList.stream()
            .filter(caFilter)
            .filter(widgetFilter)
            .map(taxMap)
            .forEach(printConsumer); 
    }
}
