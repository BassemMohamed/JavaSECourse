package cib.javase.adv.builder;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TestPersonBuilder {
    
    public static void main(String[] args) {
        
        // Creating Person using person builder.
        // Fancy way to create a person without need for constructor with lots of fields
        Person p1 = new Person.Builder()
            .setGivenName("bassem")
            .setAddress("home")
            .setAge(21)
            .setEMail("gmail")
            .setPhone("01141040")
            .setCity("Cairo")
            .setState("Cairo")
            .setCode("55121")
            .build();
        
        // Manipulating Lists using Stream & Collections
        List<Person> list = Person.createShortList();

        // Old dull foreach loop
        for(Person p : list) {
            p.print();
        }

        System.out.println("*********************************************************************");
        // Foreach using anonymous
        list.forEach(new Consumer<Person>(){
            public void accept(Person p) {
                p.print();
            }
        });
    
        System.out.println("*********************************************************************");
        // Foreach using Lambda
        list.forEach((p) -> p.print());

        System.out.println("*********************************************************************");
        // Doing a filter before printing using anonymous
        list.stream().filter(new Predicate<Person>(){
                public boolean test(Person p) {
                    return p.getGivenName().startsWith("J");
                }
            }).forEach(new Consumer<Person>(){
                public void accept(Person p) {
                    p.print();
                }
            });
        
        System.out.println("*********************************************************************");
       // Doing a filter before printing using lambda
       list.stream().filter((p) -> p.getGivenName().startsWith("J")).forEach((p) -> p.print());
   }
}
