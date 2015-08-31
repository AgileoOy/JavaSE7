package fi.agileo.basic;

public class WhileDemo {

    public static void main(String args[]) {

        int res = 1;
        int i = 1;

        while (i < 10) {
            res *= i;
            i++;
        }
        
        int sum = 0;
        while (i > 0) {
            sum += i;
            i--;
        }

        System.out.println("Multiply 1-9 = " + res);
        System.out.println("Sum 1-10 = " + sum + ",and i="
                   + i);
    }
}
