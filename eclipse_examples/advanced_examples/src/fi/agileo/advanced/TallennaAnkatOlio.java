package fi.agileo.advanced;

import java.util.*;
import java.io.*;

public class TallennaAnkatOlio  {
  public static void main(String args[])
  {
    String t = "ankat.dat";
    Henkilo[] ankat = new Henkilo[5];
    Henkilo[] luetutAnkat = new Henkilo[5];
    ankat[0] = new Henkilo("Aku", "Ankka");
    ankat[1] = new Henkilo("Tupu", "Ankka");
    ankat[2] = new Henkilo("Hupu", "Ankka");
    ankat[3] = new Henkilo("Lupu", "Ankka");
    ankat[4] = new Henkilo("Hessu", "Hopo");
    // olion tietojen kirjoittaminen
    try {
      FileOutputStream kirj = new FileOutputStream(t);
      ObjectOutputStream okirj = new ObjectOutputStream(kirj);
      okirj.writeObject(ankat);
      okirj.flush();
      okirj.close();

  // Olion tietojen lukeminen
      FileInputStream luku = new FileInputStream(t);
      ObjectInputStream oluku = new ObjectInputStream(luku);
      luetutAnkat = (Henkilo[])oluku.readObject();
      oluku.close();
    }
    catch (IOException | ClassNotFoundException e) {
       System.out.println(e);
    }
    // Tulostetaan taulukko, joka tallennettiin
    for (int i=0; i<luetutAnkat.length; i++) {
      System.out.print(luetutAnkat[i].getEtunimi() + ": " + luetutAnkat[i].getSukunimi() );
    }
  }
}
