package cib.javase.essentials;

public class TestAverage {
    
    public static void test1() {
        
        int first = 6;
        int second = 9;
        int third = 4;
        double avg = ( first + second + third ) / 3.0;
        
        System.out.println(avg);
        System.out.println("Hello World");
    }
    
    public static int test2(int[] xArr) {
        
        int sum = 0;
        for (int i = 0; i < xArr.length; i++)
        {
            sum += xArr[i];
        }
        return sum;
        
    }
        
    public static void main(String[] args) {
        
        int[] xArr = new int[5];
        xArr[0] = 15;
        xArr[1] = 10;
        xArr[2] = 5;
        xArr[3] = 7;
        xArr[4] = 2;
        System.out.println( test2(xArr) );
    }
}
