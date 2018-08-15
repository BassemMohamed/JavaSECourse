package cib.javase.project.oe.product;

public interface Taxable {
    
    final double tax = 10;
    
    // Returns the taxes given price!
    public abstract double getTax(double amount);
    
}
