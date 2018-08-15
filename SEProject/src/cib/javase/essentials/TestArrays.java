package cib.javase.essentials;

public class TestArrays {
    public TestArrays() {
        super();
    }
    
    public static void main(String[] args) {
       
       int[] xArr = new int[5];
       xArr[0] = 15;
       xArr[1] = 10;
       xArr[2] = 5;
       xArr[3] = 7;
       xArr[4] = 2;
       
       int sum = 0;
       for (int i = 0; i < xArr.length; i++)
       {
           sum += xArr[i];
       }
       System.out.println("For!");
       System.out.println(sum);

       int i = 0;
       sum = 0;
       while(i != xArr.length) {
           sum += xArr[i];
           i++;
       }
       System.out.println("While!");
       System.out.println(sum);
       
       int j = 0;
       sum = 0;
       do {
          sum += xArr[j];
          j++;
       } while (j != xArr.length);
       System.out.println("DO While!");
       System.out.println(sum);
       
       sum = 0;
       for(int k: xArr) {
           sum += xArr[k];
       }
       System.out.println("For Each!");
       System.out.println(sum);
   }
        
}
