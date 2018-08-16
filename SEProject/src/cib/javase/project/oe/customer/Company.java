package cib.javase.project.oe.customer;

public class Company extends Customer {
    
    private String contact;
    private int discount;
    
    public Company() {
        super();
    }
    
    public Company(int id, String address, String name, String phone,String contact, int discount) {
        super(id, address, name, phone);
        this.contact = contact;
        this.discount = discount;
    }
    public Company(String address, String name, String phone,String contact, int discount) {
        super(address, name, phone);
        this.contact = contact;
        this.discount = discount;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getContact() {
        return contact;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    public int getDiscount() {
        return discount;
    }
}
