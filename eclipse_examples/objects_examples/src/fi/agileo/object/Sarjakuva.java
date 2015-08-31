package fi.agileo.object;

abstract class Taide {
  String nimi;
  Taide(String nimi) {
    System.out.println("Taide konstruktori");
    this.nimi=nimi;
  }
  public String toString() {
    return "taideteoksen nimi on " + nimi;
  }
}

class Piirros extends Taide {
  Piirros(String nimi) {
    super(nimi);
    System.out.println("Piirros konstruktori");
  }
}

public class Sarjakuva extends Piirros {
  public Sarjakuva(String nimi) {
    super(nimi);
    System.out.println("Sarjakuva konstruktori");
  }
  public static void main(String[] args) {
    Sarjakuva finger = new Sarjakuva("Fingerpori");
    System.out.println(finger);
    Sarjakuva virtanen = new Sarjakuva("B. Virtanen");
    System.out.println(virtanen);

  }
}