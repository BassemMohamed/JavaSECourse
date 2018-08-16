package cib.javase.project.oe.customer;

public class Individual extends Customer {
    
    private String licNumber;

    public Individual() {
        super();
    }
    public Individual(String address, String name, String phone,String licNumber) {
        super(address, name, phone);
        this.licNumber = licNumber;
    }
}
