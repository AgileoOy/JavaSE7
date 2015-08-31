package fi.agileo.concurrent;

class LaskuriSaie2 implements Runnable {   
    int laskuri;   
    int lopetusarvo;
    Thread saie;   
       
    LaskuriSaie2(String nimi, int arvo) {   
        saie = new Thread(this, nimi);   
        laskuri = 0;   
        lopetusarvo = arvo;
        saie.start();
    }   

    public int getLaskuri() {
        return laskuri;
    }
    public Thread getSaie() {
        return saie;
    }
       
    public void run(){   
        System.out.println(saie.getName() + " aloitetaan");   
        try {   
            do {   
                Thread.sleep(50);   
                System.out.println("Thread "+ saie.getName() +   ", laskuri "+laskuri);   
                laskuri++;   
            } while (laskuri <= lopetusarvo);   

        }catch(InterruptedException e){   
            System.out.println(saie.getName() +" keskeytettiin");   
        }   
        System.out.println(saie.getName()+ " lopetettiin");   
    }   
}   

public class SaieLopetus {   
    public static void main(String args[]){   
        System.out.println("Pääsäie alkaa");   
        
        LaskuriSaie2 lapsiSaie1 = new LaskuriSaie2("1# Ensimmainen lapsisäie", 5);   
        LaskuriSaie2 lapsiSaie2 = new LaskuriSaie2("2# Toinen lapsisäie", 3);   
        LaskuriSaie2 lapsiSaie3 = new LaskuriSaie2("3# Kolmas lapsisäie", 6);   
           
        do {   
            System.out.print(".");   
            try {   
                Thread.sleep(100);   
            } catch(InterruptedException e){   
               System.out.println("Pääsäie keskeytettiin.");   
            }   
        } while ( lapsiSaie1.getSaie().isAlive() || lapsiSaie2.getSaie().isAlive() || lapsiSaie3.getSaie().isAlive() );   
        
        System.out.println("Pääsäie loppuu");   
    }   
}  