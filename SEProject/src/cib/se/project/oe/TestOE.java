package cib.se.project.oe;

import cib.se.project.oe.customer.Individual;
import cib.se.project.oe.order.Order;
import cib.se.project.oe.product.Hardware;
import cib.se.project.oe.product.Manual;
import cib.se.project.oe.product.Software;

import java.util.Date;

public class TestOE {

    public static void main(String[] args) {

        Individual i = new Individual("Sheraton", "Bassem", "01022", "2940628");

        Software s = new Software(301, "description", "Antivirues", 100, "0123456");
        Manual m = new Manual(201, "description", "Java Course", 250, "Hossam");
        Hardware h = new Hardware(101, "description", "VideoCard", 1000, 50);

        Order o1 = new Order(i, 501, new Date());
        o1.addOrderItem(s);
        o1.addOrderItem(s);
        o1.addOrderItem(s);
        o1.addOrderItem(s);
        o1.addOrderItem(m);
        o1.addOrderItem(m);
        o1.addOrderItem(h);
        o1.addOrderItem(h);

        System.out.println(o1);
    }
}
