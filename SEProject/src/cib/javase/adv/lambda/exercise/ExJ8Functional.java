package cib.javase.adv.lambda.exercise;

import cib.javase.adv.lambda.Person;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ExJ8Functional {
    
    public static void main(String[] args) {
        
        List<Person> persons = Arrays.asList(
            new Person(1, "Bassem", "Mohamed", 24),
            new Person(2, "Ahmed", "Ziad", 31),
            new Person(3, "Anwar", "Mohamed", 18),
            new Person(4, "Kamal", "Hossam", 27) );  
        
        // Sort list asc according to first name
        sort(persons);
        // Create a method to print persons with a condition
        printFiltered(persons, (p) -> p != null, (p) -> System.out.println(p));
        System.out.println("*********");
        printFiltered(persons,
                      (p) -> p.getFirstname().startsWith("A"),
                      (p) -> System.out.println(p.getFirstname()));
        System.out.println("*********");
        printFiltered(persons,
                      (p) -> p.getLastname().startsWith("M"),
                      (p) -> System.out.println(p.getLastname()));
    }
    
    public static void sort(List<Person> persons) {
        Collections.sort( persons, (p1, p2) -> p1.getFirstname().compareTo(p2.getFirstname()) );
    }
    
    public static void printFiltered(List<Person> persons, Predicate<Person> cnd, Consumer<Person> prnt) {
        for(Person p : persons) {
            if(cnd.test(p))
                prnt.accept(p);
        }
    }
}
