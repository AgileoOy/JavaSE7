package fi.agileo.concurrent;

import java.util.concurrent.*;

  final class StrLength implements Callable {
        private String str;
        public StrLength(String str) {
           this.str = str;
        }
        public Integer call() {      
           System.out.println("Current thread name: " + Thread.currentThread().getName());    
          return str.length();
       }
    }

public class StrLengthCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        run1();        
    }

    private static void run1() throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        @SuppressWarnings("unchecked")
        Callable<Integer> c1 =  new StrLength("Something to test");
        @SuppressWarnings("unchecked")
        Callable<Integer> c2 =  new StrLength("Something little longer string to test");
        @SuppressWarnings("unchecked")
        Callable<Integer> c3 =  new StrLength("Something more and much, much, much longer string to test");

        Future<Integer> future1 = executor.submit(c1);
        Future<Integer> future2 = executor.submit(c2);
        Future<Integer> future3 = executor.submit(c3);

        System.out.println("1st future is done: " + future1.isDone());
        System.out.println("  and result: " + future1.get());
        
        System.out.println("2nd future is done: " + future2.isDone());
        System.out.println(" and result2: " + future2.get());
        
        System.out.println("3th future is done: " + future3.isDone());
        System.out.println(" and result3: " + future3.get());

        executor.shutdownNow();
    }

}
