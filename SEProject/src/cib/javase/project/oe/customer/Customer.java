package cib.javase.project.oe.customer;

public class Customer {

    private int id;
    private String address;
    private String name;
    private String phone;

    public Customer() {
        
    }
    public Customer(int id, String address, String name, String phone) {
        super();
        this.address = address;
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
    
    public String toString() {
        return ("Cus: " + this.id + ", Name: " + this.name + ", Phone: " + this.phone);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
}
