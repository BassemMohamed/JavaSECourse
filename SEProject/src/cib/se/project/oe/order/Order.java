package cib.se.project.oe.order;

import cib.se.project.oe.customer.Customer;

import cib.se.project.oe.product.Product;

import java.util.ArrayList;
import java.util.Date;

public class Order {

    static int counter = 1;

    private Customer customer;
    private int id;
    private ArrayList<OrderItem> items;
    private Date orderDate;
    private double orderTotal;

    public Order() {

    }

    public Order(Customer customer, int id, Date orderDate) {
        this.customer = customer;
        this.id = id;
        this.orderDate = orderDate;
        this.items = new ArrayList<OrderItem>();
    }

    public void addOrderItem(Product pr) {

        for (OrderItem item : items) {
            if (item.getProduct().getId() == pr.getId()) {
                item.setQuantity(item.getQuantity() + 1);
                return;
            }
        }

        OrderItem oi = new OrderItem(counter, pr, 1);
        items.add(oi);
        counter++;
    }

    public int getTotalPrice() {
        int TotalPrice = 0;
        for (OrderItem item : items) {
            TotalPrice += item.getItemTotal();
        }

        orderTotal = TotalPrice;
        return TotalPrice;
    }

    public String toString() {
        String res = ("Order: " + this.id + ", Date: " + this.orderDate + ", Total: " + this.getTotalPrice());
        res += "\n";
        res += this.getCustomer().toString();
        res += "\n";
        for (OrderItem item : items) {
            res += item.toString();
            res += "\n";
        }
        return res;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<OrderItem> items) {
        this.items = items;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public double getOrderTotal() {
        return orderTotal;
    }
}
