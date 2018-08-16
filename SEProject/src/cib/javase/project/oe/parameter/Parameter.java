package cib.javase.project.oe.parameter;

public class Parameter {
    
    String name;
    double value;

    public Parameter(String name, double value) {
        this.name = name;
        this.value = value;
    }

    // Getters AND Setters
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public double getValue() {
        return value;
    }
}
