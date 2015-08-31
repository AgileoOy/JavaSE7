import java.sql.*;
import javax.sql.*;
import java.util.*;

/* Update esimerkki 4.
 *  Juha Peltomäki.
 *
 * Esimerkissä esitellään transaktion käytän lisäksi myäs
 * eräajopäivitysten (batch update) käyttä (addBatch(), executeBatch() metodit PreparedStatement luokasta)
 */

public class UpdateBatchStudents {
    // Database connection String
    static String user  = "jupepe";
    static String passwd = "jsp";
    static String url = "jdbc:mysql://localhost/jupepe";
    
    public static void main(String args[]) throws java.sql.SQLException {
        Connection conn=null;
        PreparedStatement pstmt = null;
        try { // 1. Create Connection to database
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, passwd);
            
            conn.setAutoCommit(false); // Aloitetaan transaktio
            // Tehdään esivalmisteltu kysely
            pstmt = conn.prepareStatement("INSERT INTO Student (Nimi,Demopisteet,Koepisteet, Syntymaaika) VALUES (?,?,?,?)");
            pstmt.setString(1, "Musta-Kaapu");
            pstmt.setInt(2, 2);
            pstmt.setInt(3, 3);
            
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.MONTH, 9);
            cal.set(Calendar.DAY_OF_MONTH, 30);
            cal.set(Calendar.YEAR, 1950);
            java.sql.Date nowDate = new java.sql.Date(cal.getTime().getTime());            
            pstmt.setDate(4, nowDate);
            pstmt.addBatch(); //laitetaan jonoon myähempää suorittamista varten
            
            // Päivämäärän muuttaminen merkkijonosta java.sql.Date tyyppiseksi
            String sdate = "1959-11-30";
            java.text.SimpleDateFormat inFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date sqldate = new java.sql.Date(inFormat.parse(sdate).getTime());
            System.out.println(sqldate.getDay() + "." + sqldate.getMonth() + "." + sqldate.getYear());
            
            pstmt.setString(1, "Musta-Kaapo");
            pstmt.setInt(2, 7);
            pstmt.setInt(3, 7);
            pstmt.setDate(4, sqldate);
            pstmt.addBatch(); //laitetaan jonoon myähempää suorittamista varten
            
            // Lähetetään päivityslauseet tietokantaan
            // Huom! PreparedStatement.executeBatch() kutsuminen tyhjää jonossa olleen listassa olleet lauseet
            int[] tulos = pstmt.executeBatch();
            System.out.println("Päivityksiä tehtiin " + tulos[0] + " kappaletta" );
            conn.commit(); // vasta tässä vaiheessa kanta päivittyy
        } catch(Exception e) {
            // Jos virheitä,niin peruutetaan kaikki päivitykset
            e.printStackTrace();
            conn.rollback();
        }
        
        
    }
    
    
    
}
