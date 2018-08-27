package cib.javase.project.oe.product;

public class Manual extends Product {

    String publisher;

    public Manual(int id, String description, String name, double price, String publisher) {
        this.setId(id);
        this.setDescription(description);
        this.setName(name);
        this.setPrice(price);
        this.publisher = publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }
}
