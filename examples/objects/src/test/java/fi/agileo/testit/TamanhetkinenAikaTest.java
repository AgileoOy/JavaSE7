package fi.agileo.testit;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TamanhetkinenAikaTest {

    @Test
    public void testAika() {
       long nykyinenAika = System.currentTimeMillis(); 
       java.util.Date aika = new java.util.Date(nykyinenAika);  
       java.util.Date aika2 = java.util.Calendar.getInstance().getTime();  

       assertNotNull(aika);       
       assertNotNull(aika2);
       assertEquals(aika.toString(), aika2.toString());
       
       assertThat(aika.toString(), equalTo(aika2.toString()));
       assertThat(aika.toString(), not(equalTo("24:01")));
       assertThat(aika, instanceOf(java.util.Date.class) );

       System.out.println(aika);  
       System.out.println(aika2);  

    }


    @Test
    public void testAika2() {
       long nykyinenAika = System.currentTimeMillis(); 
       java.util.Date aika = new java.util.Date(nykyinenAika);  
       java.util.Date aika3 = new java.util.Date();  
       assertNotNull(aika);
       assertNotNull(aika3);

       assertEquals(aika.toString(), aika3.toString());
       assertNotSame(aika, aika3);

       System.out.println(aika3);  

    }

}
