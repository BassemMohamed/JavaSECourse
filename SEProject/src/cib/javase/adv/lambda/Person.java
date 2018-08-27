package cib.javase.adv.lambda;

public class Person {
    
    private int Id;
    private String firstname;
    private String lastname;
    private int age;


    public Person(int Id, String firstname, String lastname, int age) {
        super();
        this.Id = Id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public String toString() {
        return Id + " " + firstname + " " + lastname + " " + age;    
    }
    
    public void setId(int Id) {
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

}
