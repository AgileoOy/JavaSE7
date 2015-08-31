package fi.agileo.collection;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

public class GeneerinenTyyppi {
    List<String> mjonoLista = new ArrayList<String>();
    List<Integer> lukuLista = new ArrayList<Integer>();

    public static List<String> yhdistaEnsimmaiset(List<Character> merkit1, List<Character> merkit2) {
        List<String> uusiLista = new ArrayList<String>();
        uusiLista.add( Character.toString(merkit1.get(0)) );
        uusiLista.add( Character.toString(merkit2.get(0)) );
        return uusiLista;
    }

    public static List<Double> yhdistaListat(List<Double> luvut1, List<Double> luvut2) {
        List<Double> uusiLista = new ArrayList<Double>(luvut1);
        uusiLista.addAll(luvut2);
        return uusiLista;
    }

    public static void main(String args[]) throws Exception {
        Field mjonoListaField = GeneerinenTyyppi.class.getDeclaredField("mjonoLista");
        ParameterizedType mjonoListaType = (ParameterizedType) mjonoListaField.getGenericType();
        Class<?> mjonoListaClass = (Class<?>) mjonoListaType.getActualTypeArguments()[0];
        System.out.print("Ensimmäisen listan tyyppi ");
        System.out.println(mjonoListaClass);

        Field lukuListaField = GeneerinenTyyppi.class.getDeclaredField("lukuLista");
        ParameterizedType lukuListaType = (ParameterizedType) lukuListaField.getGenericType();
        Class<?> lukuListaClass = (Class<?>) lukuListaType.getActualTypeArguments()[0];
        System.out.print("Toisen listan tyyppi ");
        System.out.println(lukuListaClass); 

        // Käydään reflektoimalla kaikki luokan metodi läpi
        for (Method metodi : GeneerinenTyyppi.class.getMethods()) {
            Class returntyyppi = metodi.getReturnType();
            System.out.println("Metodi: " + metodi.getName() ); 
            // Tarkastetaan, että metodin palautustyyppi on Collection dynaamisesti ajon aikana
            if (Collection.class.isAssignableFrom(returntyyppi)) {
                Type geneerinenReturnTyyppi = metodi.getGenericReturnType();
                // Luetaan metodien parametrien tyypit
                Type[] tyypit = metodi.getGenericParameterTypes();
                ParameterizedType palautustyyppi = (ParameterizedType) geneerinenReturnTyyppi;
                ParameterizedType parametrityyppi1 = (ParameterizedType) tyypit[0];
                ParameterizedType parametrityyppi2 = (ParameterizedType) tyypit[1];

                Class<?> pluokka1 = (Class<?>) parametrityyppi1.getActualTypeArguments()[0];
                Class<?> pluokka2 = (Class<?>) parametrityyppi2.getActualTypeArguments()[0];
                System.out.print("Metodin ensimmäisen ja toisen parametrin tyypit ovat ");
                System.out.print(pluokka1); 
                System.out.print(" ja "); 
                System.out.print(pluokka2); 
                System.out.print(" ja return => "); 
                System.out.println((Class<?>) palautustyyppi.getActualTypeArguments()[0]);                 
            }
            System.out.println("return tyyppi: " + returntyyppi); 
        }
    }
}

/*
Ensimmäisen listan tyyppi class java.lang.String
Toisen listan tyyppi class java.lang.Integer
Metodi: yhdistaEnsimmaiset
Metodin ensimmäisen ja toisen parametrin tyypit ovat class java.lang.Character ja class java.lang.Character ja return => class java.lang.String
return tyyppi: interface java.util.List
Metodi: yhdistaListat
Metodin ensimmäisen ja toisen parametrin tyypit ovat class java.lang.Double ja class java.lang.Double ja return => class java.lang.Double
return tyyppi: interface java.util.List
Metodi: main
return tyyppi: void
Metodi: wait
return tyyppi: void
Metodi: wait
return tyyppi: void
Metodi: wait
return tyyppi: void
Metodi: equals
return tyyppi: boolean
Metodi: toString
return tyyppi: class java.lang.String
Metodi: hashCode
return tyyppi: int
Metodi: getClass
return tyyppi: class java.lang.Class
Metodi: notify
return tyyppi: void
Metodi: notifyAll
return tyyppi: void
*/