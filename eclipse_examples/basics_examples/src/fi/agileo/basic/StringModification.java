package fi.agileo.basic;

public class StringModification {

    public static void main(String[] args) {
        String lang = "  This is JAVA str example with some  Java functions";

        System.out.println(lang.toLowerCase());
        System.out.println(lang.toUpperCase());
        String[] splittedString = lang.split("\\s");
 
       for (String str : splittedString) {
            System.out.println(str);
        }
    }
}