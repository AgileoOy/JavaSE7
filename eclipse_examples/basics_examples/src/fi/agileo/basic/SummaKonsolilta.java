package fi.agileo.basic;


import java.util.Scanner;

public class SummaKonsolilta {
    // Funktio, joka laskee kahden luvun summan
    public static double laskeSumma(double a, double b) {
        return a + b;
    }

    // Pääohjelman kirjoittaminen
    public static void main(String args[]) {
        System.out.println("Lasketaan summaa ja luetaan luvut konsolilta");

        Scanner lukija = new Scanner(System.in);
        System.out.print("Anna 1. luku>");
        double a = lukija.nextDouble();
        System.out.print("Anna 2. luku>");
        double b = lukija.nextDouble();
        lukija.close();

        double vastaus = a + b;
        System.out.println(a + "+" + b + "=" + vastaus);

        // System.out.println(laskeSumma(a, b));

    }
}


