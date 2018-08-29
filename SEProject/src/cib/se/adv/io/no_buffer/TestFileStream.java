package cib.se.adv.io.no_buffer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileStream {
    
    public static void main(String[] args) {
        
        // File input stream without using buffer!
        String f1 = "C:\\files\\readdata.txt";
        read(f1);
        
        // File output stream without using buffer!
        String f2 = "C:\\files\\writedata.txt";
        String text = "Hello World!";
        write(f2,text);

    }
    
    public static void read(String file) {
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
            
            int x = 0;
            while( (x = fis.read()) != -1) {
                System.out.println( (char) x);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void write(String file, String text) {
        
        FileOutputStream fos;

        try {
            fos = new FileOutputStream(file);
            byte[] textBytes = text.getBytes();
            fos.write(textBytes);
            
        } catch (Exception e) {
            e.printStackTrace();            
        }
    }
    
}
