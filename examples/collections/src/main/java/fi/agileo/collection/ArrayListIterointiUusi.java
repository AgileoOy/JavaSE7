package fi.agileo.collection;

import java.util.*;
  
public class ArrayListIterointiUusi {
  public static void main(String args[]) {
    // Alustettaessa lista kerrotaan, että se sisältää vain Integer-olioita.
    // Generics-tuki - tuli mukaan JDK 1.5:ssa, sen takia sitä ei käytetä läheskään joka paikassa vieläkään
    ArrayList<Integer> luvut = new ArrayList<>();
    for (int i = 0; i <= 10; i++) {
      luvut.add(new Integer(i));
    }
    int summa = 0;
    // Iteraattorille voidaan kertoa JDK 1.5:Sta lähtien tietotyyppi
    Iterator<Integer> i = luvut.iterator();
    while (i.hasNext()){
      summa += i.next();
    }
    System.out.println("Summa on " + summa);
  }
}