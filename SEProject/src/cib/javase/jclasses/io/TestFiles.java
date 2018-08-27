package cib.javase.jclasses.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

public class TestFiles {
    
    static ArrayList<String> text = new ArrayList<String>();
    
    public static void read() {
        
        FileReader fr;
        BufferedReader br;
        try {
            fr = new FileReader("C:\\java_files\\read_file.txt");
            br = new BufferedReader(fr);

            String line= br.readLine();
            while (line != null) {
                text.add(line);
                line = br.readLine();
            }
            
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void write() {
        
        FileWriter fw;
        BufferedWriter bw;
        try {
            fw = new FileWriter("C:\\java_files\\write_file.txt");
            bw = new BufferedWriter(fw);
            
            for (int i = 0; i<text.size(); i++) {
                bw.write(text.get(i));
                bw.newLine();
            }            
            
            bw.close();
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void copyFile() {
        
        FileReader fr;
        BufferedReader br;
        FileWriter fw;
        BufferedWriter bw;
        
        try {
            fr = new FileReader("C:\\java_files\\read_file.txt");
            br = new BufferedReader(fr);
            fw = new FileWriter("C:\\java_files\\write_file.txt");
            bw = new BufferedWriter(fw);

            String line= br.readLine();
            while (line != null) {
                bw.write(line);
                bw.newLine();
                line = br.readLine();
            }
            
            br.close();
            fr.close();
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        //read();
        //write();

        copyFile();        
    }
}
