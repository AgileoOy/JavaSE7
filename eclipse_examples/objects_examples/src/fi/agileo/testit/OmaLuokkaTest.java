package fi.agileo.testit;

import org.junit.Test;
import static org.junit.Assert.*;

class OmaLuokka {
    String[] taulu;
    String[] taulu2;
    public OmaLuokka() {
        taulu = new String[3];
        taulu[0] = "yyy";
        taulu[1] = "kaa";
        taulu[2] = "koo";
    }

    public String[] getTaulu() {
        return taulu;
    }
    public String[] getTaulu2() {
        return taulu2;
    }

    public String yhdistaJonot(String a, String b) {
        return a + b;
    }
}


public class OmaLuokkaTest {

    @Test
    public void testTaulu() {
        OmaLuokka omaLuokka = new OmaLuokka();
        String[] oletettuTaulu = {"yyy", "kaa", "koo"};
        String[] tulosTaulu =  omaLuokka.getTaulu();
        assertArrayEquals(oletettuTaulu, tulosTaulu);
    }

    @Test
    public void testYhdista() {
        OmaLuokka omaLuokka = new OmaLuokka();
        String result = omaLuokka.yhdistaJonot("eka", "toka");
        assertEquals("ekatoka", result);
    }


    @Test
    public void testTauluOlio() {
        OmaLuokka omaLuokka = new OmaLuokka();
        assertNotNull(omaLuokka.getTaulu());
    }


    @Test
    public void testSamat() {
        OmaLuokka omaLuokka = new OmaLuokka();
        String[] oletettuTaulu = {"yyy", "kaa", "koo"};
        String[] tulosTaulu =  omaLuokka.getTaulu();
        assertNotSame(oletettuTaulu, tulosTaulu);
    }

    @Test
    public void testTaulu2Null() {
        OmaLuokka omaLuokka = new OmaLuokka();
        assertNull(omaLuokka.getTaulu2());
    }
}