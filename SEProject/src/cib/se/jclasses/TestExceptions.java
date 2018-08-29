package cib.se.jclasses;

import cib.se.jclasses.customexception.EmpSalException;

import cib.se.oop.Emp;

import java.awt.HeadlessException;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.omg.CORBA.ExceptionList;

public class TestExceptions {
    
    public static void testScanner() {
        
        Scanner input = new Scanner(System.in);
        try {
            int firstNum = input.nextInt();
            int secondNum = input.nextInt();
            System.out.println("You have entered both Numbers " + firstNum + " " + secondNum);
        } catch (InputMismatchException e) {
            //e.getMessage(); ->  returns printStack as String
            System.out.println("Only Numbers are allowed!" );
        }

        System.out.println("End of Application!");
    }
    
    public static void testOptionPane() {
        
        try {
            String first =
                JOptionPane.showInputDialog(null, "First Num", "Input Dialog", JOptionPane.INFORMATION_MESSAGE);
            String second =
                JOptionPane.showInputDialog(null, "Second Num", "Input Dialog", JOptionPane.INFORMATION_MESSAGE);

            int result = Integer.parseInt(first) / Integer.parseInt(second);
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("Numbers only!");
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println("No one can divide by zero!");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Something went terribly wrong!");                
            e.printStackTrace();
        } finally {
            System.out.println("This is final statement");
        }
        
        System.out.println("End of Application!");
    }
    
    public static void main(String[] args) throws EmpSalException {
        //testOptionPane();
        Emp e1 = new Emp(801,"Bassem", -5);
        System.out.println(e1);
    }
}
