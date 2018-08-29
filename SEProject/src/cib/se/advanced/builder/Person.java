package cib.se.advanced.builder;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String givenName;
    private String surName;
    private int age;
    private Gender gender;
    private String eMail;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String code;

    private Person(Builder b) {
        this.givenName = b.givenName;
        this.surName = b.surName;
        this.age = b.age;
        this.gender = b.gender;
        this.eMail = b.eMail;
        this.phone = b.phone;
        this.address = b.address;
        this.city = b.city;
        this.state = b.state;
        this.code = b.code;
    }

    public void print() {
        System.out.println("Name: " + givenName + " " + surName + "Age: " + age + "Gender: " + gender +
                            "eMail: " + eMail + "Phone: " + phone + "Address: " + address + 
                           "City: " + city + "State: " + state + "Code: " + code);
    }

    public static List<Person> createShortList() {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person.Builder().setGivenName("Bob").setSurName("Baker").setAge(23).setGender(Gender.MALE).setEMail("bob.baker@example.com").setPhone("201-121-4678").setAddress("44 4th St").setCity("Smallville").setState("KS").setCode("12333").build());
        personList.add(new Person.Builder().setGivenName("Jane").setSurName("Doe").setAge(25).setGender(Gender.FEMALE).setEMail("jane.doe@example.com").setPhone("202-123-4678").setAddress("33 3rd St").setCity("Smallville").setState("KS").setCode("12333").build());
        personList.add(new Person.Builder().setGivenName("John").setSurName("Doe").setAge(28).setGender(Gender.MALE).setEMail("john.doe@example.com").setPhone("202-123-4678").setAddress("33 3rd St").setCity("Smallville").setState("KS").setCode("12333").build());
        return personList;
    }

    // GETTERS !!
    public String getGivenName() {
        return givenName;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getEMail() {
        return eMail;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCode() {
        return code;
    }

    // Builder Class !!

    public static class Builder {

        private String givenName;
        private String surName;
        private int age;
        private Gender gender;
        private String eMail;
        private String phone;
        private String address;
        private String city;
        private String state;
        private String code;

        // GETTERS !!
        public Builder setGivenName(String givenName) {
            this.givenName = givenName;
            return this;
        }

        public Builder setSurName(String surName) {
            this.surName = surName;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder setEMail(String eMail) {
            this.eMail = eMail;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setState(String state) {
            this.state = state;
            return this;
        }

        public Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
