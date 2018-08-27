package cib.javase.adv.lambda.exercise;

import cib.javase.adv.lambda.Person;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExJ7 {
    
    public static void main(String[] args) {
        
        List<Person> persons = Arrays.asList(
            new Person(1, "Bassem", "Mohamed", 24),
            new Person(2, "Ahmed", "Ziad", 31),
            new Person(3, "Anwar", "Mohamed", 18),
            new Person(4, "Kamal", "Hossam", 27) );  
        
        // Sort list asc according to first name
        sort(persons);
        // Create a method to print all persons
        //printAllPersons(persons);
        // Create a method to print only persons with first name start with A
        printFiltered(persons, (p) -> p.getFirstname().startsWith("A"));
        printFiltered(persons, (p) -> p.getLastname().startsWith("M"));

    }
    
    public static void sort(List<Person> persons) {
        Collections.sort(persons, new Comparator<Person>(){
            public int compare(Person p1, Person p2) {
                return p1.getFirstname().compareTo(p2.getFirstname());
            }
        });
    }
    
    public static void printAllPersons(List<Person> persons) {
        for(Person p : persons) {
            System.out.println(p);
        }
    }
    
    public static void printFiltered(List<Person> persons, Condition cnd) {
        for(Person p : persons) {
            if(cnd.validate(p))
                System.out.println(p);
        }
    }
    
    public interface Condition {
        public abstract boolean validate(Person p);
    }
}
