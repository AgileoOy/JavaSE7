package fi.agileo.collection;

import java.util.*;
import java.text.*;
 
public class KansainvalinenEsimerkki {

    private static void printLocaleMessages(ResourceBundle nippu) {
        System.out.println(nippu.getString("name"));
        System.out.println(nippu.getString("CountryName"));
        System.out.println(nippu.getString("CountryCode"));
    }

    private static void printCurrency(ResourceBundle nippu){  
       double hinta=123.567;  
       Locale lokaali = nippu.getLocale();
       NumberFormat formatoija = NumberFormat.getCurrencyInstance(lokaali);  
       String valuutta=formatoija.format(hinta);  
       System.out.println(valuutta + " lokaalille " + lokaali);  
       NumberFormat lukuformaatti = NumberFormat.getInstance(lokaali);
       String luku = lukuformaatti.format(55.99);
       System.out.println(luku + " lokaalille " + lokaali);  

       Date tanaan = new Date();
       
       DateFormat pvmformaatti = DateFormat.getDateInstance(DateFormat.FULL, lokaali);
       System.out.println(nippu.getString("Datestring") + pvmformaatti.format(tanaan));  

       DateFormat aikaformaatti = DateFormat.getTimeInstance(DateFormat.MEDIUM, lokaali);
       System.out.println("Aika: " + aikaformaatti.format(tanaan));  

       DateFormat aikapvmformaatti = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, lokaali);       
       System.out.println("Ajanhetki: " + aikapvmformaatti.format(tanaan));  
       System.out.println();
    }  


 
    public static void main(String[] args) {
        //oletus lokaali
        // .properties tiedostotarkenne oletuksena
        ResourceBundle nippu = ResourceBundle.getBundle("ApplicationMessages");
        // yleisillä vakiot Locale luokassa
        ResourceBundle nippuGB = ResourceBundle.getBundle("ApplicationMessages", new Locale("en","GB") );
        // luodaan suomalainen lokaaliasetus
        //ResourceBundle nippuFI = ResourceBundle.getBundle("ApplicationMessages", new Locale("fi", "FI"));
        ResourceBundle nippuFI = ResourceBundle.getBundle("ApplicationMessages", new Locale("sv", "SE"));
        // Locale.US
         
        //tulostetaan viesteja
        printLocaleMessages(nippu);
        printCurrency(nippu);
        
        printLocaleMessages(nippuGB);
        printCurrency(nippuGB);

        printLocaleMessages(nippuFI);
        printCurrency(nippuFI);
         
    }
 
 
}