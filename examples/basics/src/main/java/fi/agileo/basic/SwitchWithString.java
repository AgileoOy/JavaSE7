package fi.agileo.basic;
import static java.lang.System.out;

public class SwitchWithString {
    public static void main(String args[]) {
        out.println(info("Java"));
        out.println(info("Groovy"));
        out.println(info("Scala"));
        out.println(info("Clojure"));
    }

    public static String info(String lang) {
        switch (lang.toUpperCase()) {
            case "JAVA":
                return "Java was Designed by James Gosling "
                        + "and Sun Microsystems in 1995";
            case "GROOVY":
                return "Scala was Designed by German Professor"
                        + " Martin Odersky in 2003";

            case "SCALA":
                return "Groovy was Designed by James Strachen "
                        + "with Apache Foundation in 2003";
            default:

                break;
        }
        return "NO ANY information yet!";
    }
}
