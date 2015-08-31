package fi.agileo.collection;

import java.util.*;

class GeneerinenPerusluokka<Type> { 

    private Type arvo = null; 

    public Type getArvo() { 
        return this.arvo; 
    } 

    public void setArvo(Type arvo) { 
        this.arvo = arvo; 
    } 

    public String toString() { 
        return arvo.toString(); 
    } 
} 

public class SingleGeneric { 

    public static void main(String args[]) { 
        GeneerinenPerusluokka<String> g1 = 
                new GeneerinenPerusluokka<>(); 
        g1.setArvo("uuno"); 
        //g1.setArvo(new Integer(5));   // poikkeus!
        System.out.println(g1); 


        // Voidaan lisätä myös kokoelma listaan. 
        ArrayList<String> list = new ArrayList<>(); 
        list.add("yksi"); 
        list.add("kaksi"); 
        list.add("kolme"); list.add("neljä"); 
        GeneerinenPerusluokka<ArrayList<String>> g3 = 
        new GeneerinenPerusluokka<>(); 
        g3.setArvo(list); 
        System.out.println(g3); 

    } 
}