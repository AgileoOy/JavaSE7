package fi.agileo.object;

class Koira {

  private String hauAani = "Hau Hau Hau Hau!";
  private String murAani = "Murrrrrrrrrrrrrrghgrr!";

  public void asetaAani(String uusi) {
    murAani = uusi;
  }

  public void hauku() {
    System.out.println(hauAani);
  }

  public void murise() {
    System.out.println(murAani);
  }

  public static void main(String args[]) {
    Koira hessu = new Koira();
    hessu.murise();
    hessu.hauku();

    Koira ressu = new Koira();
    ressu.asetaAani("RRRRRRRRR");
    ressu.murise();

  }

}