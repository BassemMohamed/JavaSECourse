package cib.se.oop;

public class Emp {
    
    private int empId;
    private String empName;
    private double empGross;
    private String empJob;
    private static int empCnt;
    
    // Constructors
    public Emp() {
        empCnt++;   
    }
    public Emp(int empId, String empName, double empGross) {
        this();
        this.setEmpId(empId);
        this.setEmpName(empName);
        this.setEmpGross(empGross);
    }
    
    /**
     * This method is to calculate monthly net salary
     */
    public double getMonthlyNetSalary() {
        return empGross - ( (empGross * 10) / 100 );   
    }
    
    public double getAnnualNetSalary() {
        return getMonthlyNetSalary() * 12;           
    }
    
    // Getters & Setters
    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpGross(double empGross) {
        if(empGross < 0) {
            System.out.println("Emp salary cannot be negative!");
            System.exit(0);            
        }
            this.empGross = empGross;
    }

    public double getEmpGross() {
        return empGross;
    }

    public void setEmpJob(String empJob) {
        this.empJob = empJob;
    }

    public String getEmpJob() {
        return empJob;
    }
    
    public static int getEmpCnt() {
        return empCnt;
    }
}
