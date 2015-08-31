package fi.agileo.advanced;

import java.util.*;
import java.io.*;

public class ListaaHakemisto  {
    public static void main(String args[])
    {
        File hakemisto = new File(".");
        String tiedostot[] = hakemisto.list();
        System.out.println("Listaan hakemiston sisällön:");
        for (int i=0; i<tiedostot.length; i++)
        System.out.println(tiedostot[i]);
    }
}
