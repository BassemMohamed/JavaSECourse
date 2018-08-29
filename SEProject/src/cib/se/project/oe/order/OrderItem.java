package cib.se.project.oe.order;

import cib.se.project.oe.product.Hardware;
import cib.se.project.oe.product.Product;

public class OrderItem {

    private int lineNbr;
    private Product product;
    private int quantity;

    public OrderItem() {

    }

    public OrderItem(int lineNbr, Product product, int quantity) {
        this.lineNbr = lineNbr;
        this.product = product;
        this.quantity = quantity;
    }

    public String toString() {
        return ("Item: " + this.lineNbr + ", Product: " + this.product.getName() + "(" + this.quantity + ")" +
                ", Uprice: " + this.getUnitPrice() + ", Total: " + this.getItemTotal());
    }

    public double getUnitPrice() {
        return this.product.getPrice();
    }

    public double getTax() {
        if (this.product instanceof Hardware) {
            Hardware temp = (Hardware) this.product;
            return temp.getTax(this.getUnitPrice() * this.quantity);
        }
        return 0.0;
    }

    public double getItemTotal() {
        if (this.product instanceof Hardware) {
            return (this.product.getPrice() * this.quantity) + this.getTax();
        }

        return (this.product.getPrice() * this.quantity);
    }


    // Getters AND Setters
    public void setLineNbr(int lineNbr) {
        this.lineNbr = lineNbr;
    }

    public int getLineNbr() {
        return lineNbr;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

}
