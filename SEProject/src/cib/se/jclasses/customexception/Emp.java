package cib.se.jclasses.customexception;

public class Emp {
    
    private int id;
    private String name;
    private double salary;

    public Emp(int id, String name, double salary) throws EmpSalException {
        super();
        this.id = id;
        this.name = name;
        this.setSalary(salary);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSalary(double salary) throws EmpSalException {
        if(salary < 0) {
            throw new EmpSalException();
        }
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

}
