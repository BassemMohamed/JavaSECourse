package cib.javase.project.oe.product;

public class Software extends Product {
    
    String license;
    
    public Software(int id, String description, String name, double price, String license) {
        this.setId(id);
        this.setDescription(description);
        this.setName(name);
        this.setPrice(price);
        this.license = license;
    }
    
    public String toString() {
        return this.getName() + "," + this.getDescription() + "," + this.getPrice() + "," + this.getLicense();
    }

    public void setLicense(String license) {
        this.license = license;
    }
    public String getLicense() {
        return license;
    }
}
