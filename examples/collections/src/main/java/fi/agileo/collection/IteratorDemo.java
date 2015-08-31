package fi.agileo.collection;

import java.util.*;

public class IteratorDemo {

  public static void main(String[] args){
    Set<Henkilo> henkilot = new HashSet<Henkilo>();
    Henkilo a = new Henkilo("Ankka", "Aku");
    henkilot.add(a);
    henkilot.add(new Henkilo("Hopo", "Hessu"));
    henkilot.add(new Henkilo("Hiiri", "Mikki"));
    henkilot.add(new Henkilo("Koninkaulus", "Polle"));

    // tulostetaan vuorollaan jokainen henkilo
    for (Henkilo henkilo : henkilot){  
      System.out.println(henkilo.getSukunimi() + " " + henkilo.getSukunimi());
    }
    // Ja sama kääntäen
    SortedSet<Henkilo> henkilotJarjestyksessa = new TreeSet<Henkilo>(henkilot);
    Iterator<Henkilo> henkiloIteraattori = henkilotJarjestyksessa.iterator(); 

    while(henkiloIteraattori.hasNext()) {
      Henkilo henkilo = henkiloIteraattori.next(); 
      System.out.println(henkilo.getSukunimi() + " " + henkilo.getSukunimi());
    } 

    // lopusta alkuun 
/*    while(henkiloIteraattori.hasPrevious()) {
      Henkilo henkilo = henkiloIteraattori.previous(); 
      System.out.println(henkilo.getSukunimi() + " " + henkilo.getSukunimi());
    } 
*/
  }
}
