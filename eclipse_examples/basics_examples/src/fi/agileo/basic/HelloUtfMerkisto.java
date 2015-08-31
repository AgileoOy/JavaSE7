package fi.agileo.basic;

public class HelloUtfMerkisto {
    static char a=0;
    static char b='b';
    static char c='Ä';
    static char d= 0x00E4;
    public static void main(String[] args) {
        System.out.println("UTF-8 characters");
        System.out.println("a=" + HelloUtfMerkisto.a );
        System.out.println("b=" + HelloUtfMerkisto.b );
        System.out.println("c=" + HelloUtfMerkisto.c);
        System.out.println("d=" + HelloUtfMerkisto.d );
    }
}
