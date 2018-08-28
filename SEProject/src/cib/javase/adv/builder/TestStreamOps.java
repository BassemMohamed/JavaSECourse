package cib.javase.adv.builder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class TestStreamOps {
    
    public static void main(String[] args) {
        
        // MAP!
        List<Integer> numList = Arrays.asList(3, 6, 9, 12, 15);
        numList.stream().map(x -> x * 10).forEach(System.out::println);
        
        List<String> citiesList = Arrays.asList("Cairo", "Alex", "Mansoura");
        citiesList.stream().map(s -> s.length()).forEach(System.out::println);
        
        System.out.println("**************************************************");
        // PEEK! is mainly to support debugging, where you want to see the elements as they flow past a certain point in a pipeline.
        // Using peek without any terminal operation does nothing. like count
        Stream.of("bus", "car", "bycle", "flight", "train")
              .filter(e -> e.length() > 3)
              .peek(e -> System.out.println("Filtered value: " + e))
              .map(String::toUpperCase)
              .peek(e -> System.out.println("Mapped value: " + e))
              .count();
        
        System.out.println("**************************************************");
        // FIND FIRST!
        //There are cases where the business specification requires the first element of a filtered stream to be fetched.
        citiesList = Arrays.asList("Sohag","Cairo", "Alex", "Mansoura");
                Optional<String> city =  citiesList.stream()
                        .filter(t-> t.contains("a") )
                        .findFirst();
                System.out.println("The First city : "+city.get());
        
    }
}
