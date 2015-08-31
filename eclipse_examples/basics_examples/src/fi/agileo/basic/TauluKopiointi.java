package fi.agileo.basic;

import java.util.Arrays;

public class TauluKopiointi {

 public static void main(String args[]) {
   int[] t = {10,20,30,40,50};
   int[] t2 = {8,7,6,5,4,3,2,1};
   // Arrays.fill(t2, 0);

   try {
     // Kopiointi: t kopioidaan t2 indekseihin t2[2]-t2[7]
     System.arraycopy(t,0,t2,3,5);
     Arrays.sort(t2); // ja uuden taulun sisällön järjestäminen
     for (int i=0; i<t2.length; i++) 
       System.out.println(i + ":" + t2[i]);
   }
   catch (Exception e) { e.printStackTrace(); }
 }
}

/* Tulostaa:
0:6
1:7
2:8
3:10
4:20
5:30
6:40
7:50

*/