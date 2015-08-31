package fi.agileo.object;

abstract class TaideTeos {
  String nimi;
  TaideTeos(String nimi) {
    System.out.println("TaideTeos konstruktori");
    this.nimi=nimi;
  }
  public String toString() {
    return "TaideTeosteoksen nimi on " + nimi;
  }
}

class PiirrosTeos extends TaideTeos {
  PiirrosTeos(String nimi) {
    super(nimi);
    System.out.println("PiirrosTeos konstruktori");
  }
}

class SarjakuvaAlbumi extends PiirrosTeos {
  String albumi;  
  public SarjakuvaAlbumi(String nimi, String albumi) {
    super(nimi);
    this.albumi = albumi;
    System.out.println("Sarjakuva konstruktori");
  }
  public String toString() {
    return "sarjakuvan " + nimi + " albumi " + albumi;
  }
}

public class Sarjakuva2 {
  public static void main(String[] args) {
    SarjakuvaAlbumi finger = new SarjakuvaAlbumi("Fingerpori", "Fingerpori 8");
    System.out.println(finger);
    SarjakuvaAlbumi virtanenB1 = new SarjakuvaAlbumi("B. Virtanen", "Negatiivisen ajattelun kurssi");
    System.out.println(virtanenB1);
    SarjakuvaAlbumi virtanenB2 = new SarjakuvaAlbumi("B. Virtanen", "Uusien ohjeiden muutoksien korjaukset");
    System.out.println(virtanenB2);

  }
}
/*
TaideTeos konstruktori
PiirrosTeos konstruktori
Sarjakuva konstruktori
sarjakuvan Fingerpori albumi Fingerpori 8
TaideTeos konstruktori
PiirrosTeos konstruktori
Sarjakuva konstruktori
sarjakuvan B. Virtanen albumi Negatiivisen ajattelun kurssi
TaideTeos konstruktori
PiirrosTeos konstruktori
Sarjakuva konstruktori
sarjakuvan B. Virtanen albumi Uusien ohjeiden muutoksien korjaukset
*/