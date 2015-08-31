package fi.agileo.object;

class Prosessori {
  private String nimi;
  Prosessori(String nimi) {
    this.nimi=nimi;
  }
  public String toString() {
    return nimi;
  }
}

class Naytto {
  private String nimi;
  Naytto(String nimi) {
    this.nimi=nimi;
  }
  public String toString() {
    return nimi;
  }
}

class Tietokone {
  Prosessori prossu;  
  Naytto monitori;  
  String malli;

  public Tietokone(String prossuNimi, String monitoriNimi, String malli) {
    this.malli = malli;  
    this.prossu = new Prosessori(prossuNimi);
    this.monitori = new Naytto(monitoriNimi);
  }
  public String toString() {
    return "Tietokone " + malli + " jossa näyttö " + monitori + " ja prosessori " + prossu;
  }
}

public class Koosteluokka {
  public static void main(String[] args) {
    Tietokone lappari = new Tietokone("Intel i5", "14.1\" HD", "Elitebook 8440p");
    System.out.println(lappari);
    
  }
}
/*
Tulostus: 
Tietokone Elitebook 8440p jossa näyttö 14.1" HD ja prosessori Intel i5

*/