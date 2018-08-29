package cib.se.gettingstarted;

public class sumOfDigits {
    public static void main(String[] args) {
        
        int sum = 0;
        int num = 57289;
        while( num % 10 != 0) {
            
            sum += num % 10;
            num /= 10;
        }
        
        System.out.println(sum);
    }
}
