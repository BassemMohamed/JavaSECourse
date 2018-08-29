package cib.se.advanced.lambda.greetings;

public class GreetingsClass implements GreetingsInterface {

    @Override
    public void performGreeting() {
        System.out.println("Hello normal class!");
    }
    
}
