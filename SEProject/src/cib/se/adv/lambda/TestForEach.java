package cib.se.adv.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class TestForEach {
    
    public static void main(String[] args) {
        
        List<Person> persons = Arrays.asList(
            new Person(1, "Bassem", "moh", 24),
            new Person(2, "Ahmed", "moh", 31),
            new Person(3, "Anwar", "moh", 18),
            new Person(4, "Kamal", "moh", 27) );    
        Consumer<Person> printId = (p) -> System.out.println(" " + p.getId() + " ");
        
        // For each OLD implementation
        for(Person p : persons) {
            System.out.println(" " + p.getId() + " ");
        }
        System.out.println("-----------");
        
        // For each NEW implementation (Anonymous)
        persons.forEach(new Consumer<Person>(){
            public void accept(Person p) {
                System.out.println(" " + p.getId() + " ");                
            }
        });
        System.out.println("-----------");       
        
        // For each NEW implementation (Lambda)
        persons.forEach((p) -> System.out.println(" " + p.getId() + " ") );
        
        // NEW STREAM WAY OF DOING STUFF (COOOL !)
        persons.stream().filter( (p) -> p.getFirstname().startsWith("A") ).forEach(printId);
    }
}

