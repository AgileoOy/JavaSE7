package fi.agileo.concurrent;

import java.util.*;
import java.util.concurrent.*;

  class CallableSumCalc implements Callable<Long> {
    @Override
    public Long call() throws Exception {
       Thread.sleep(2000); 
       long sum = 0;
       for (long i = 0; i <= 10e6; i++) {
          sum += i;
       }
       
       return sum;
    }
  }



public class SimpleExecutorServiceDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
      ExecutorService executor = Executors.newSingleThreadExecutor();
      @SuppressWarnings("unchecked")
      CallableSumCalc sumcall = new CallableSumCalc();


      Future<Long> futureValue = executor.submit( sumcall ); 

      long s=0 ;
      for (long i=0; i<10e6; i++) s += i;

      System.out.println("Line before and we are waiting future variable! sum was = " + s );

      System.out.println("Future value is ready now = " + futureValue.get());
      System.out.println("Last line!");
      executor.shutdown();
  }
}