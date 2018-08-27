package cib.javase.adv.nestedclasses;

public class Outer {
    
    private static String msg = "Hello World";
    
    private class Inner {
        // can access static & non static members
        public void display() {
            System.out.println(msg + " Message from non static nested Inner class");
        }
    }
    
    private static class StaticInner {
        // can only access static members
        public void display() {
            System.out.println(msg + " Message from static nested StaticInner class");
        }
    }
    
    
    public static void main(String[] args) {
        Outer.StaticInner siObj = new Outer.StaticInner();
        siObj.display();
        
        Outer.Inner oiObj = new Outer().new Inner();
        oiObj.display();
   }
}
