package fi.agileo.advanced;

import java.util.*;
import java.io.*;

public class TallennaAnkatTeksti  {
  public static void main(String args[])
  {
    String t = "ankat.txt";
    Henkilo[] ankat = new Henkilo[5];
    ankat[0] = new Henkilo("Aku", "Ankka");
    ankat[1] = new Henkilo("Tupu", "Ankka");
    ankat[2] = new Henkilo("Hupu", "Ankka");
    ankat[3] = new Henkilo("Lupu", "Ankka");
    ankat[4] = new Henkilo("Hessu", "Hopo");
    try {
      FileOutputStream tulosvirta = new FileOutputStream(t);
  
      // tekstitiedostoon kirjoittaminen    
      PrintWriter out = new PrintWriter(tulosvirta, true);
      for (int i=0; i < ankat.length; i++) out.println(ankat[i]);
      out.close();
      tulosvirta.close();

      // tiedoston lukeminen
      String rivi;
      FileInputStream syotevirta = new FileInputStream(t);
      BufferedReader syote = new BufferedReader(new InputStreamReader(syotevirta));
      while (( rivi = syote.readLine()) != null)
        System.out.println(rivi);
      syote.close();

      // muita tapoja mm. JDK 5:ssa 

  
    }
    catch (IOException e) {
      System.out.println(e);
    }
  
  }
}
