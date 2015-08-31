package fi.agileo.concurrent;


class LaskuriSaie implements Runnable {   
    int laskuri;   
    Thread saie;   
       
    LaskuriSaie(String nimi){   
        saie = new Thread(this, nimi );   
        laskuri = 0;   
        saie.start();
    }   

    public int getLaskuri() {
        return laskuri;
    }
       
    public void run(){   
        System.out.println(saie.getName());   
        try {   
            do {   
                Thread.sleep(500);   
                System.out.println("Thread "+ saie.getName() +   ", laskuri "+laskuri);   
                laskuri++;   
            } while (laskuri <= 5);   

        }catch(InterruptedException e){   
            System.out.println(saie.getName() +" keskeytettiin");   
        }   
    }   
}   

public class SaieLaskuri {   
    public static void main(String args[]){   
        System.out.println("Pääsäie alkaa");   
        
        LaskuriSaie lapsiSaie1 = new LaskuriSaie("1# Ensimmainen lapsisäie");   
        LaskuriSaie lapsiSaie2 = new LaskuriSaie("2# Toinen lapsisäie");   
        LaskuriSaie lapsiSaie3 = new LaskuriSaie("3# Kolmas lapsisäie");   
           
        do {   
            System.out.print(".");   
            try {   
                Thread.sleep(100);   
            } catch(InterruptedException e){   
               System.out.println("Pääsäie keskeytettiin.");   
            }   
        } while ( lapsiSaie1.getLaskuri() < 5 && lapsiSaie2.getLaskuri() < 5 && lapsiSaie3.getLaskuri() < 5 );   
        
        System.out.println("Pääsäie loppuu");   
    }   
}  