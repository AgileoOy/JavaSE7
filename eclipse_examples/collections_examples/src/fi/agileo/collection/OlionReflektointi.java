package fi.agileo.collection;

import java.lang.reflect.Method;

class Tyontekija {
   String nimi;
   int ika;
   double palkka;
   public Tyontekija(String nimi){
      this.nimi = nimi;
   }
   public void setIka(int ika){
      this.ika =  ika;
   }
   public void setPalkka(double palkka){
      this.palkka = palkka;
   }
   public double getPalkka(){
      return palkka;
   }
   public String tulostaTyontekija(){
      return nimi + " ansaitsee " + palkka + " euroa.";
   }
}

public class OlionReflektointi {

    public static void main(String args[]) throws Exception {

        // Käydään reflektoimalla kaikki luokan metodi läpi
        
        for (Method metodi : Tyontekija.class.getMethods()) {

        // VOi olla mikä tahansa muukin käännetty luokka

        //for (Method metodi : GeneerinenPerusluokka.class.getMethods()) {
        	@SuppressWarnings("rawtypes")
            Class returntyyppi = metodi.getReturnType();
            @SuppressWarnings("rawtypes")
			Class[] parametrityypit = metodi.getParameterTypes();
            System.out.print("Metodi: " + metodi.getName() + "\t"); 
            // tarkastetaan, että metodilla oli parametreja ja tulostetaan vain ensimmäinen parametri
            if (parametrityypit.length > 0)
                System.out.print(", parametri: " + parametrityypit[0]  + "\t"); 
            System.out.println(", return: " + returntyyppi); 
        }
    }
}

/*  
Metodi: setIka   , parametri: int   , return: void
Metodi: setPalkka   , parametri: double    , return: void
Metodi: getPalkka   , return: double
Metodi: tulostaTyontekija   , return: class java.lang.String
Metodi: wait    , parametri: long  , return: void
Metodi: wait    , parametri: long  , return: void
Metodi: wait    , return: void
Metodi: equals  , parametri: class java.lang.Object    , return: boolean
Metodi: toString    , return: class java.lang.String
Metodi: hashCode    , return: int
Metodi: getClass    , return: class java.lang.Class
Metodi: notify  , return: void
Metodi: notifyAll   , return: void
*/