package fi.agileo.advanced;

import java.util.*;
import java.io.*;

class TiedostoOperaatiot 
{
  public static void tulostaTiedosto(String tiedoston_nimi) {
    try {
      String rivi;
      String tulos = "";
      FileInputStream virta = new FileInputStream(tiedoston_nimi);
      BufferedReader syote = new BufferedReader(new InputStreamReader(virta));
      while (( rivi = syote.readLine()) != null)
        tulos += rivi + "\n";
      syote.close();

      // Lopuksi tulostetaan koko tiedosto yhdellä lauseella
      System.out.println(tulos);
    } 
    catch (IOException e) {
      System.out.println(e);
    }
  }



  /* Tallentaa parametrinä tuodut merkkijonot tiedostoon */
  public static void tallennaTiedostoon(String tiedostonNimi, ArrayList<String> merkkijonot)
  {
    try {
      FileOutputStream tulos;
      File tiedosto =  new File(tiedostonNimi);

      // Jos tiedosto on olemassa, liitetään sen perään. 
     // Muuten luodaan uusi.
      if (tiedosto.exists() && tiedosto.canRead())
        tulos = new FileOutputStream(tiedostonNimi, true);
      else
        tulos = new FileOutputStream(tiedostonNimi);

      PrintWriter tulostus = new PrintWriter(tulos, true);

      for (int i=0; i < merkkijonot.size(); i++) tulostus.println((merkkijonot.get(i)));
      tulos.close();
     }
     catch (IOException e) {
       System.out.println(e);
     }
  }
}

public class TekstiTiedostoOperaatiot  {
  public static void main(String args[])
  {
     String tiedostonNimi = "testiteksti.txt";
     ArrayList<String> lauseet = new ArrayList<String>();
     lauseet.add("Pekka");
     lauseet.add("Ja");
     lauseet.add("Pätkä. \nLoppu.\n");     

     TiedostoOperaatiot.tallennaTiedostoon(tiedostonNimi, lauseet);
     TiedostoOperaatiot.tulostaTiedosto(tiedostonNimi);
  }
}
