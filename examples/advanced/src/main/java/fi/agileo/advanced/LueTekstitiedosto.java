package fi.agileo.advanced;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LueTekstitiedosto {

    public static final String TIEDOSTON_NIMI = "testiteksti.txt";
    
    public static void main(String[] args) {
    
       try {
         File file = new File(TIEDOSTON_NIMI);
         Scanner scanner = new Scanner(file);
         scanner.useDelimiter("\n");
         while (scanner.hasNext()) {
           System.out.println(scanner.next());
         }
         scanner.close();
       } catch (FileNotFoundException e) {
         System.out.println("Tiedostoa ei loydy!");
       }
       
    }
    
}
