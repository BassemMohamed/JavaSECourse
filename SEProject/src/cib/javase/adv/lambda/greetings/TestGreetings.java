package cib.javase.adv.lambda.greetings;

public class TestGreetings {
    
    public static void main(String[] args) {
        
        // Old normal way using normal class
        printMsg(new GreetingsClass() );
    
        // Anonymous Class (Java 7)
        printMsg(new GreetingsInterface(){
            public void performGreeting() {
                System.out.println("Hello Anonymous Class!");
            }
        });        
        
        // Anonymous Class using lambda expressions (Java 8)
        printMsg( () -> System.out.println("Hello Lambda!") ); 

    }
    
    public static void printMsg(GreetingsInterface gi) {
        gi.performGreeting();
    }
    
}
