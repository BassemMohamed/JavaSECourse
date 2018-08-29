package cib.se.project.oe.product;

public class Hardware extends Product implements Taxable {

    private int warrantyPeriod;

    public Hardware(int id, String description, String name, double price, int warrantyPeriod) {
        this.setId(id);
        this.setDescription(description);
        this.setName(name);
        this.setPrice(price);
        this.warrantyPeriod = warrantyPeriod;
    }

    public String toString() {
        return this.getName() + "," + this.getDescription() + "," + this.getPrice() + "," + this.getWarrantyPeriod();
    }

    public double getTax(double amount) {
        return ((amount * Taxable.tax) / 100);
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }
}
