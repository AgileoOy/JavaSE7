package fi.agileo.concurrent;

import java.util.*;
import java.util.concurrent.*;
/**
*
* java.util.concurrent.Callable rajapinta concurrency paketissa vastaa Runnable rajapintaa, mutta voi palauttaa minkä tyyppisen olion tahansa sekä aiheuttaa poikkeuksen. 
* Executors luokan avulla voidan suorittaa Callable-olioita säiealtaassa (thread pool). 
* Callable palauttaa java.util.concurrent.Future olion. Future-oliosta saadaan selville tehtävän tila sekä palautettu olio.
* Future-luokan get()-metodilla voidaan odottaa tehtävän loppuun suorittamista ja palauttaa tulos.
* 
* Tavoitteena on kääriä pitkään kestävä laskenta Callable<String> olioihin 
* ja lähettää ne submit() metodilla määritellyille säikealtaille (thread pool).
*/
class SimpleCallable implements Callable<String> {
    
    private int waitTime;

    public SimpleCallable(int time) {
        waitTime = time;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(waitTime);
        return Thread.currentThread().getName()  + " waitTime was " + waitTime;
    }
}
     
public class UsingCallables {
    public static void main(String args[]){
        ExecutorService executor = Executors.newFixedThreadPool(15);
        List<Future<String>> list = new ArrayList<Future<String>>();
        

        for (int i=0; i< 10; i++) {
            int time = 1000;
            if (i % 2 == 1) time *= 2; // kaksinkertaistetaan odotusaika joka toiselle
            Callable<String> simpleCallable = new SimpleCallable(time);
            Future<String> future = executor.submit(simpleCallable);
            list.add(future);  
        }

        for (Future<String> returnedFuture : list) {
            try {
                // print if future has been completed
                System.out.println(new Date() + "::" + returnedFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown(); 
    }
 
}
