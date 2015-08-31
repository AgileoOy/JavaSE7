package fi.agileo.basic;

class Ihminen {
  private String nimi; int ika;

  public void aseta_ika(int uusi_ika) {
    ika = uusi_ika;
  }
  public void aseta_nimi(String uusi_nimi) {
   nimi = uusi_nimi;
  }
  public void tulosta( ) {
   System.out.print("Nimi:" + nimi+ "\n" + "ikä:" + ika);
  }

  public String toString( ) {
   return "Nimi:" + nimi+ "\n" + "ikä:" + ika;
  }
}


public class IhminenTesti {

    public static void main(String[] args) {
      Ihminen pelle = new Ihminen();
      pelle.aseta_ika(44); 
      pelle.aseta_nimi("P. Peloton");
      System.out.println(pelle);
    }
}