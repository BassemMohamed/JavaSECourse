package cib.se.adv.lambda;

public class InterfacesClass {
    
    @FunctionalInterface
    public interface TwiceInterface {
        public abstract double twice(double num);
    }
    @FunctionalInterface
    public interface AddInterface {
        public abstract double add(double num1, double num2);
    }
    @FunctionalInterface
    public interface DivInterface {
        public abstract double divide(double num1, double num2);
    }
    @FunctionalInterface
    public interface TextInterface {
        public abstract int count(String text);
    }
    
    public static void main(String[] args) {
        
        TwiceInterface t1 = x -> x * 2;
        AddInterface a = (x,y) -> x + y;
        TextInterface t2 = s -> s.length();
        DivInterface d = (x,y) -> (y == 0) ? 0 : x / y;
        
        System.out.println(t1.twice(5));
        System.out.println(a.add(4,6));
        System.out.println(d.divide(10, 2));
        System.out.println(t2.count("Bassem"));
    }
    
}
