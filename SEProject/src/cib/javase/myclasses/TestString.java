package cib.javase.myclasses;

import java.util.Date;

public class TestString {
    
    // 2 87 05 09 2100838
    public static int birth(String id) {

        String[] splitted = id.split(" ");
        int c = Integer.parseInt(splitted[0]);
        int y = Integer.parseInt(splitted[1]);
        int m = Integer.parseInt(splitted[2]);
        int d = Integer.parseInt(splitted[3]);

        if (c == 2) {
            y = y + 1900;
        } else if(c == 3) {
            y = y + 2000;
        }
        System.out.println( "Your birth date = " + new Date(y-1900, m-1, d) );
        
        return new Date().getYear() - (y-1900);
    }
    
    public static void main(String[] args)
    {
        System.out.println(new TestString().birth("2 87 05 09 123412345"));	
    }
}
