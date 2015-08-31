package fi.agileo.object;

class Suorakulmio {
  private double korkeus;
  private double leveys;

  public Suorakulmio(double korkeus, double leveys) {
    this.korkeus = korkeus;
    this.leveys = leveys;
  }
  public String toString() {
    return " korkeus, leveys : ( " + korkeus + ", " + leveys + " )";    
  }
}

public class SuorakulmioDemo {
  public static void main(String args[]) {

  Suorakulmio sk1 = new Suorakulmio(10, 20);
  Suorakulmio sk2 = sk1;

  System.out.println("sk1:" + sk1);
  System.out.println("sk2:" + sk2);

  }
}

