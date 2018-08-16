package cib.javase.project.oe.db;

import cib.javase.project.oe.customer.Company;
import cib.javase.project.oe.customer.CompanyHandler;
import cib.javase.project.oe.customer.Customer;
import cib.javase.project.oe.customer.CustomerHandler;
import cib.javase.project.oe.product.Hardware;
import cib.javase.project.oe.product.HardwareHandler;
import cib.javase.project.oe.product.Software;
import cib.javase.project.oe.product.SoftwareHandler;

public class TestJDBC {
    
    public static void main(String[] args) {
        
        System.exit(0);
        
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
        Company c = new Company("Nasr City", "CIB", "01022", "Hossam", 500);
        CompanyHandler.insertCompany(c);
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
