package fi.agileo.basic;

public class BasicVariablesDemo {

    public static void main(String[] args) {
        {
            int i = 0;
            i = 5 * 10;
            System.out.println(i);
            {
                int a = 10;

                i += a;
                System.out.println(i + " " + a);
            }
        }
    }
}