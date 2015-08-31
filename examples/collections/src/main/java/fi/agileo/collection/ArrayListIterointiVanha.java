package fi.agileo.collection;

import java.util.*;

public class ArrayListIterointiVanha {

  // Varoitukset:  unchecked call to add(E) as a member of the raw type java.util.Collection voi poistaa
  @SuppressWarnings("unchecked")
  public static void main(String args[]){
    // Vanha versio ennen JDK 1.5:sta. Nykyään kannattaa käyttää Generics-menetelmää, jotta voi kertoa tietotyypin.
    ArrayList luvut = new ArrayList();
    for (int i = 0; i<10; i++) {
      luvut.add(new Integer(i));
    }
    int summa = 0;
    Iterator i = luvut.iterator();
    while(i.hasNext()) {
      summa += ((Integer)i.next()).intValue();
    }
    System.out.println("Summa on " + summa);
  }
}