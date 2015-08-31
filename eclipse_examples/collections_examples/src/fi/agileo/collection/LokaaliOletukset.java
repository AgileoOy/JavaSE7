package fi.agileo.collection;


/** 
* Lokaali oletukset 
* Harjoitustehtävän ratkaisu
* Aihe: Locale - kansainvälisyys
*/


import java.util.Locale;
 
public class LokaaliOletukset {

    public static void tulostaKaikkiLokaalit() {
        Locale[] lokaalit = Locale.getAvailableLocales();

        for (Locale lokaali: lokaalit) {
            System.out.printf("koodi %s, nimi %s ja maa %s %n", lokaali, lokaali.getDisplayName(), lokaali.getDisplayCountry());  
            if (!lokaali.getScript().equals("")){
                System.out.printf("Skriptikoodi %s %n ", lokaali.getDisplayScript());
            }
        }
         System.out.printf("Lokaaleja löydettiin yhteensä %s kappaletta. %n ", lokaalit.length);
    }
 
    public static void main(String[] args) {
        //oletus lokaali
        //Locale.setDefault( new Locale("en","GB") );
        Locale.setDefault( new Locale("fi", "FI") );
        Locale.setDefault( new Locale("fr", "CA") );
        Locale oletusLokaali = Locale.getDefault();

        System.out.printf("oletuslokaali %s %n", oletusLokaali);  
        System.out.printf("oletuskieli %s ja nimi %s %n", oletusLokaali.getLanguage(), oletusLokaali.getDisplayName());  
        System.out.printf("oletusmaakoodi %s ja nimi %s %n", oletusLokaali.getCountry(), oletusLokaali.getDisplayCountry());  
         
        // tulostaa järjestelmässä olevat lokaalivaihtoehdot
        tulostaKaikkiLokaalit();
    }
 
 
}