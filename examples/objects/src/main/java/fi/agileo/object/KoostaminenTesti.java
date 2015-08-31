package fi.agileo.object;

class Rengas {
    private String koko;
    public String getKoko() {          return koko;      }
    public void setKoko(String koko) { this.koko = koko;     }
    public String toString() {         return koko + "";     }
}

class Moottori {
    private int teho;
    private int iskutilavuus;

    public int getTeho() {          return teho;     }
    public void setTeho(int teho) { this.teho = teho;     }
    public int getIskutilavuus() {  return iskutilavuus;     }
    public void setIskutilavuus(int iskutilavuus) { this.iskutilavuus = iskutilavuus;     }
    public String toString() { return teho + " hv, " + iskutilavuus + " cm^3"; }
}

/*
Esimerkissä koosteluokka Auto koostetaan olemassa olevien luokkien avulla. Osaoliot Moottori ja Rengas ovat käytössä Auto-luokassa. 
Sen lisäksi siinä on kaksi itsenäistä ominaisuutta: malli ja merkki.
*/
class Auto {
    private String merkki;
    private String malli;
    private Moottori moottori;
    private Rengas[] renkaat;

    public Auto() {
        renkaat = new Rengas[4];  // luodaan oliotaulu renkaat[]
        for (int i = 0; i < renkaat.length; i++) {
            renkaat[i] = new Rengas();
        }
        moottori = new Moottori(); // luodaan moottori-olio
    }

    public void asetaTiedot(String merkki, String malli, int teho, int til, String koko) {
        this.merkki = merkki;
        this.malli = malli;
        this.moottori.setIskutilavuus(til); // asetetaan moottori olion tiedot kohdalleen
        this.moottori.setTeho(teho);
       
        for (int i = 0; i < renkaat.length; i++) { // asetetaan rengas olioiden tiedot
            renkaat[i].setKoko(koko);
        }
    }

    public String toString() {
        return "[" + merkki + " " + malli + ", " + moottori + ", 4:" + renkaat[0] + "]";
    }

}

public class KoostaminenTesti {

    public static void main(String args[]) {
        Auto corolla = new Auto();
        corolla.asetaTiedot("Toyota", "Corolla", 99, 1329, "205/55 R16");
        Auto octavia = new Auto();
        octavia.asetaTiedot("Skoda", "Octavia", 160, 1798, "195/65 R15");
        System.out.println(corolla + "\n" + octavia);
    }
}

/*
tulostus:

[Toyota Corolla, 99 hv, 1329 cm^3, 4:205/55 R16]
[Skoda Octavia, 160 hv, 1798 cm^3, 4:195/65 R15]

*/