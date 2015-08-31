package fi.agileo.concurrent;

class SummaaTaulukko {
    private int summa;

    // Kokeile myös ilman synchronized-avainsanaa
    //int summaa(int[] luvut) {
    synchronized int summaa(int[] luvut) {
        summa = 0;

        for (int i=0; i<luvut.length; i++) {
            summa += luvut[i];
            System.out.println(Thread.currentThread().getName() + " summaa-metodissa");   
        }

        // vähennetään kaikista taulukon alkioista arvo yksi
        for (int i=0; i<luvut.length; i++) 
            luvut[i]--;

        try {   
            Thread.sleep(30);   
        } catch(InterruptedException e) {   
            System.out.println("Saie keskeytettiin");   
        }   

        return summa;
    }
}

class LaskuriSaie3 implements Runnable {   
    static SummaaTaulukko summaaTaulu = new SummaaTaulukko();
    int[] luvut;
    Thread saie;   
       
    LaskuriSaie3(String nimi, int luvut[]) {   
        saie = new Thread(this, nimi);   
        this.luvut = luvut;
        saie.start();
    }   

    public Thread getSaie() {
        return saie;
    }
       
    public void run() {   
        System.out.println(saie.getName() + " aloitetaan");   
        int summa = summaaTaulu.summaa(luvut);
        System.out.println("... Summa saikeella " + saie.getName() +" on " + summa);   

        System.out.println(saie.getName()+ " lopetettiin");   
    }   
}   

public class SaieSynkronointi {   
    public static void main(String args[]) {   
        System.out.println("Pääsäie alkaa");   

        int arvot[] = {10, 30, 50, 70, 90, 110};
        
        LaskuriSaie3 lapsiSaie1 = new LaskuriSaie3("Säie 1#", arvot);   
        LaskuriSaie3 lapsiSaie2 = new LaskuriSaie3("Säie 2#", arvot);   
        LaskuriSaie3 lapsiSaie3 = new LaskuriSaie3("Säie 3#", arvot);   
           
        try {   
            lapsiSaie1.getSaie().join();
            lapsiSaie2.getSaie().join();
            lapsiSaie3.getSaie().join();
        } catch(InterruptedException e){   
               System.out.println("Pääsäie keskeytettiin.");   
           }   
        
        System.out.println("Pääsäie loppuu");   
    }   
}  