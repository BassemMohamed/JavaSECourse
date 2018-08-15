package cib.javase.project.oe.customer;

public class Individual extends Customer {
    
    private String licNumber;

    public Individual() {
        super();
    }
    public Individual(int id, String address, String name, String phone,String licNumber) {
        super(id, address, name, phone);
        this.licNumber = licNumber;
    }
}
