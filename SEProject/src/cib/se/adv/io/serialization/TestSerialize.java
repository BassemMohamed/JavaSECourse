package cib.se.adv.io.serialization;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;

public class TestSerialize {
    
    public static void main(String[] args) {
    
        String file = "C:\\files\\emp.txt";
        Employee e1 = new Employee(1, "Bassem", 5000);
        Employee e2 = new Employee(2, "Mohamed", 2000);
        Employee e3 = new Employee(3, "Hussien", 1000);

        try {

            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(e1);
            oos.writeObject(e2);
            oos.writeObject(e3);
            e1 = null; e2 = null; e3 = null;
            
            Employee e = null;
            ArrayList<Employee> list = new ArrayList<Employee>();
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            while( (e = (Employee) ois.readObject()) != null ) {
                System.out.println(e);
            }
            
            ois.close();
            fis.close();
            oos.close();
            fos.close();

        } catch (EOFException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
