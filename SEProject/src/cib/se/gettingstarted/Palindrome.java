package cib.se.gettingstarted;

import java.util.Arrays;

public class Palindrome {
    
    public static boolean isPal(int[] xArr) {
        
       int i = 0;
       int j = xArr.length - 1;
       
       while(i != (xArr.length - 1/2) ) {
           if(xArr[i] == xArr[j]) {
                i++;
                j--;    
           } else {
                return false;   
           }
       }
       
       return true;
    }
    
    public static int[] reverse(int[] arr) {
        
        int j = 0;
        int l = arr.length;
        int[] temp = new int[l];
        for (int i = arr.length - 1; i > -1; i--) {
            
            temp[j] = arr[i];
            j++;
        }
        
        return temp;
    }
    
    public static int countDupp(int[] arr) {
        
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                
                if(arr[i] == arr[j]) {
                    cnt ++;
                }
           }
        }
        return cnt;
    }
    
    public static int[] removeDupp(int[] arr) {
       
        int k = 0; 
        boolean dup = false;
        int l = arr.length - countDupp(arr) + 1;
        int[] temp = new int[l];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                
                //System.out.println("A: " + arr[i] + " : " + "B: " + arr[j]);
                if(arr[i] == arr[j]) {
                    dup = true;
                    break;
                }
           }
            
           //System.out.println(dup);
            if(dup == false) {
                temp[k] = arr[i];
                k++;
            }
            dup = false;
       }
        
        return temp;
    }
    
    public static int rec(int x) {
        if ( x == 1 ) {
            return 1;
        }
        
        return rec( x * rec(x-1) );
    }
    
    public static void main(String[] args) {
        System.out.println( rec(5) );
   }
    
}
