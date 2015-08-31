package fi.agileo.collection;

import java.util.*;

public class Henkilo implements Comparable<Henkilo> {
  private String sukunimi;
  private String etunimi;

  public Henkilo (String s, String e){
    sukunimi = s;
    etunimi = e;
  }

  public String getEtunimi(){
    return etunimi;
  }

  public String getSukunimi(){
    return sukunimi;
  }
  public String toString() {
   return etunimi + " " + sukunimi; 
  }
  public int compareTo(Henkilo seuraava) {
    if ((this.sukunimi).equals(seuraava.getSukunimi())) {
      return (this.sukunimi).compareTo(seuraava.getSukunimi());
    }
    else {
      return (this.sukunimi).compareTo(seuraava.getSukunimi());
    }
  }
}