package fi.agileo.basic;

public class HelloUtfString {
    static String a="First";
    static String b="Some ä and Ö characters!";
    static String c="Some " + "\u00E4" + " and \u00D6 characters!";
    static String d= "over 16 bit char: " + "\u10400";
    //static char d= "";
    public static void main(String[] args) {
        System.out.println("UTF-8 characters");
        System.out.println("default:" +
          java.nio.charset.Charset.defaultCharset().name());
        System.out.println("a=" + HelloUtfString.a );
        System.out.println("b=" + HelloUtfString.b );
        System.out.println("c=" + HelloUtfString.c);
        System.out.println("d=" + HelloUtfString.d );
        System.out.println("length: " + "\u00E4".length());
        System.out.println("length: " + "\u10400".length());
    }
}