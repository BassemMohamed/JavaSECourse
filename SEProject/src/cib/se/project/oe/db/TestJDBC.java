package cib.se.project.oe.db;

import cib.se.project.oe.customer.Company;
import cib.se.project.oe.customer.CompanyHandler;
import cib.se.project.oe.customer.Customer;
import cib.se.project.oe.customer.CustomerHandler;
import cib.se.project.oe.order.Order;
import cib.se.project.oe.order.OrderHandler;
import cib.se.project.oe.order.OrderItem;
import cib.se.project.oe.product.Hardware;
import cib.se.project.oe.product.HardwareHandler;
import cib.se.project.oe.product.Software;
import cib.se.project.oe.product.SoftwareHandler;

import java.util.Date;

public class TestJDBC {

    public static void main(String[] args) {

        // Testing Order Handler
        System.out.println(OrderHandler.getOrder(120));

        System.exit(0);

        // Testing Order Handler
        Customer c = CustomerHandler.getCustomer(100);
        Order o = new Order(c, 901, new Date());
        o.addOrderItem(SoftwareHandler.getSoftware(109));
        o.addOrderItem(SoftwareHandler.getSoftware(107));
        OrderHandler.insertOrder(o);

        // Testing Customer Handler
        Customer c1 = new Customer("Sheraton", "Bassem", "01022755420");
        Customer c2 = new Customer("Nasr City", "Mohamed", "01022755420");

        CustomerHandler.insertCustomer(c1);
        CustomerHandler.insertCustomer(c2);
        System.out.println(CustomerHandler.getAllCustomers());

        c2 = new Customer(101, "Nasr City", "Mohamed", "01022");
        CustomerHandler.updateCustomer(c2);
        CustomerHandler.removeCustomer(101);
        System.out.println(CustomerHandler.getAllCustomers());

        // Testing Company Handler
        Company co = new Company("Nasr City", "CIB", "01022", "Hossam", 500);
        CompanyHandler.insertCompany(co);
        System.out.println(CompanyHandler.getCompany(102));

        // Testing Software Handler
        Software s = new Software(101, "Java", "Eclipse", 50, "license");
        SoftwareHandler.insertSoftware(s);
        System.out.println(SoftwareHandler.getSoftware(100));

        // Testing Hardware Handler
        Hardware h = new Hardware(101, "Arduino", "Arduino", 500, 5);
        HardwareHandler.insertHardware(h);
        System.out.println(HardwareHandler.getHardware(100));
    }
}
