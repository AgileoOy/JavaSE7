package fi.agileo.collection;

import java.util.*;

class PrintCollection {
  
  /** 1.versio tulostaa käyttäen vanhaa Javan syntaksia. Ennen JDK 1.5:sta. */
  public static void printColl(Collection c) { 
    Iterator i = c.iterator();
    while (i.hasNext()) { 
      Object e = i.next();
      System.out.print(e); 
      System.out.println(" (" + e.getClass().getName() + ")");
    }
  }
   
  /** 2. versio tulostaa kokoelman sisällön käyttäen JDK 1.5:n syntaksia (geneeriset tietotyypit) 
      @param kokoelma tuntamettomia olioita - engl. "collection of unknown"**/
  public static void printCollGenerics(Collection<?> coll) { 
    for (Object e : coll) { // turvallista, koska kokoelma sisältää aina Object-luokan perillisiä 
      System.out.print(e);
      System.out.println(" (" + e.getClass().getName() + ")");
    }
  }
  

  // Varoitukset:  unchecked call to add(E) as a member of the raw type java.util.Collection voi poistaa
  @SuppressWarnings("unchecked")
  public static void main(String args[]) {
    
    // Luodaan Collection -olio ja lisätään sinne sekä String että henkilö olioita!
  

    Collection c1 = new ArrayList();
    c1.add("Aku"); 
    c1.add("Mikki"); 
    c1.add(new Integer(5));    // lisätään eri tietotyyppejä kokoelmaan!
    c1.add(new Henkilo("Aku", "Ankka"));
    /** 
    * PrintCollection.java:24: warning: [unchecked] unchecked call to add(E) as a member of the raw type java.util.Collection         
    * c1.add("Aku"); c1.add("Mikki"); c1.add(new Integer(5));
    */
    System.out.print("Tulostetaan c1 ArrayList-kokoelma, jossa on erityyppisiä olioita");
    printColl(c1);
    //printCollGenerics(c2);

    Collection<String> c2 = new ArrayList<String>();
    c2.add("Aku"); c2.add("Mikki"); 
    /** Ao. lause ei enää onnistu, koska kääntäjältä tulee virheilmoitus:
    PrintCollection.java:29: add(java.lang.String) in java.util.Collection<java.lang.String> cannot be applied to (java.lang.Integer) 
    c2.add("Aku"); c2.add("Mikki"); c2.add(new Integer(5));
    */
    //c2.add(new Integer(5));
    //c2.add(new Henkilo("Aku", 50));
    System.out.print("Tulostetaan c2 ArrayList<String>-tyyppinen kokoelma");
    printColl(c2);
    printCollGenerics(c2);

  }
  
}  
