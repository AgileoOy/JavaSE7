package fi.agileo.object;

public class StaticMethodsDemo {

    static int sum(int a, int b) {
        return a + b;
    }

    public static void main(String args[]) {
        System.out.println(sum(10, 20));
        System.out.println(StaticMethodsDemo.sum(11, 22));
        StaticMethodsDemo s1 = new StaticMethodsDemo();
        System.out.println(s1.sum(30, 40));
        StaticMethodsDemo s2 = new StaticMethodsDemo();
        System.out.println(s2.sum(30, 40));

    }
}