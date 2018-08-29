package cib.se.adv.files_io;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import java.util.List;
import java.util.stream.Stream;

public class TestNIO {
    
    public static void main(String[] args) {
        
        //testPath();
        //testFile();
    }
    
    public static void testPath() {
        Path p = Paths.get("D:\\files\\work\\servletData.txt");
        Path fileName = p.getFileName();

        System.out.println("File name : "+fileName);
        System.out.println("getParent: "+ p.getParent());
        System.out.println("getNameCount: "+ p.getNameCount());
        System.out.println("getRoot: "+ p.getRoot());
        System.out.println("isAbsolute: "+ p.isAbsolute());
        System.out.println("toAbsolutePath: "+ p.toAbsolutePath());
        
        // sub paths
        Path subPath1 = p.subpath(0,1);
        System.out.println("sub Path : "+subPath1);
        Path subPath2 = p.subpath(0,2);
        System.out.println("sub Path : "+subPath2);
           
        // normalize paths
        Path p3 = Paths.get("D:\\home\\myWork\\..\\articles");
        Path cleanPath = p3.normalize();
        System.out.println("Clean path : "+cleanPath);
        
        // joining paths
        Path pFirst = Paths.get("D:\\home\\myWork\\articles");
        Path pSecond = pFirst.resolve("java");
        System.out.println("Before join : "+pFirst);
        System.out.println("After join : "+pSecond);
    }

    private static void testFile() {
        // ex1. Check files
        // The Files.exists() method checks 
        // if a given Path exists in the file system, for example
        Path path = Paths.get("C:\\files\\readdata.txt");
        boolean exists = Files.exists(path, new LinkOption[]{ LinkOption.NOFOLLOW_LINKS});
        System.out.println("File Exists : ? "+exists);
       
        // ex. Read files
        System.out.println("Reading file");
        try {
            List<String> strList = Files.readAllLines(path);
            strList.forEach(s->System.out.println(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        // ex. Deleting Files
        System.out.println("Deleting File ....");
        try {
            path = Paths.get("C:\\files\\imgdata.txt");
            Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        // ex. Copying File
        System.out.println("Copying Files...");
        Path pSrc = Paths.get("C:\\files\\readdata.txt");
        Path pDest = Paths.get("C:\\files\\readdata2.txt");
    
        try {
            Files.copy(pSrc, pDest, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        // ex. Move Files
        System.out.println("Moving Files...");
        pSrc = Paths.get("C:\\files\\readdata2.txt");
        pDest = Paths.get("C:\\files\\readdata3.txt");
    
        try {
            Files.move(pSrc, pDest, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        /// ex.  Manage metadata
        /// The following methods can be used to extract information about the file or directory:
    
        // Tests whether a file is a directory.
        // public static boolean isDirectory(Path path, LinkOption... options)
        // Files.isDirectory(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
    
        // Tests whether a file is executable.
        // public static boolean isExecutable(Path path)
        
        // Tells whether or not a file is considered hidden.
        // public static boolean isHidden(Path path)
        
        // Tests whether a file is readable.
        // public static boolean isReadable(Path path)
        
        // Tests whether a file is writable.
        // public static boolean isWritable(Path path)
        
        // Returns the size of a file (in bytes).
        // public static long size(Path path)
    
        /// Streams with Files
        System.out.println("___________ List files ________");
        try (Stream<Path> stream = Files.list(Paths.get("c:\\files"))) {
            stream
                .map(String::valueOf)
                .filter(pTextFiles -> pTextFiles.endsWith(".txt"))
                .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
