package cib.se.adv.io.buffer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class TestIOStreams {
    
    public static void main(String[] args) {
        
        // File input stream without using buffer!
        String f1 = "C:\\files\\img.jpg";
        String f2 = "C:\\files\\imgdata.jpg";

        copyContent(f1,f2);
    }
    
    public static void copyContent(String readFile, String writeFile) {
        
        FileInputStream fis;
        BufferedInputStream bis;
        FileOutputStream fos;
        BufferedOutputStream bos;

        try {
            fis = new FileInputStream(readFile);
            bis = new BufferedInputStream(fis);
            
            fos = new FileOutputStream(writeFile);
            bos = new BufferedOutputStream(fos);
            
            int i = 0;
            byte[] buffer = new byte[1024];
            
            while( (i = bis.read(buffer) ) != -1 ) {
                bos.write(buffer,0,i);
            }

            bos.close();
            bis.close();
            fos.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        } 
        
    }

}
