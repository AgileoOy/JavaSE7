package fi.agileo.collection;

import java.util.*;

public class CollectionPerusmetodit {

   public static void main(String[] args) {
      List<String> taulukkoLista = new ArrayList<String>();
      taulukkoLista.add("Aku");
      taulukkoLista.add("Roope");
      taulukkoLista.add("Mikki");
      System.out.println("ArrayList alkiot");
      System.out.println("\t" + taulukkoLista);

      List<String> linkitettyLista = new LinkedList<String>();
      linkitettyLista.add("Aku");
      linkitettyLista.add("Roope");
      linkitettyLista.add("Mikki");
      System.out.println(" LinkedList alkiot");
      System.out.println("\t" + linkitettyLista);

      Set<String> hajautettuJoukko = new HashSet<String>(); 
      hajautettuJoukko.add("Aku");
      hajautettuJoukko.add("Roope");
      hajautettuJoukko.add("Mikki");
      System.out.println();
      System.out.println("HashSet alkiot");
      System.out.println("\t" + hajautettuJoukko);


      Set<String> puuJoukko = new TreeSet<String>(); 
      puuJoukko.add("Aku");
      puuJoukko.add("Roope");
      puuJoukko.add("Mikki");
      System.out.println();
      System.out.println("TreeSet alkiot");
      System.out.println("\t" + puuJoukko);


      Map<String, Integer> hajautusTaulu = new HashMap<String, Integer>(); 
      hajautusTaulu.put("Aku",   55);
      hajautusTaulu.put("Roope", 62);
      hajautusTaulu.put("Mikki", 45);
      hajautusTaulu.put("MustaPekka", 82);
      System.out.println();
      System.out.println("HashMap alkiot");
      System.out.println("\t" + hajautusTaulu);

      Map<String, Integer> puuTaulu = new TreeMap<String, Integer>(); 
      puuTaulu.put("Aku",   55);
      puuTaulu.put("Roope", 62);
      puuTaulu.put("Mikki", 45);
      puuTaulu.put("MustaPekka", 82);
      System.out.println();
      System.out.println("TreeMap alkiot");
      System.out.println("\t" + puuTaulu);

      Map<Integer,String> puuTaulu2 = new TreeMap<Integer, String>(); 
      puuTaulu2.put(55, "Aku");
      puuTaulu2.put(62, "Roope");
      puuTaulu2.put(45, "Mikki");
      puuTaulu2.put(82, "MustaPekka");
      System.out.println();
      System.out.println("TreeMap2 alkiot");
      System.out.println("\t" + puuTaulu2);

   }
}