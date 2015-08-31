import java.sql.*;
import javax.sql.*;

/* Update esimerkki 3.
 * Juha Peltomäki.
 *  Esimerkissä esitellään transaktion käyttä 
 * Huomaa, että tietokannan on tuettava transaktiota. Tämän takia MySQL:ssä on käytettävä
 * muuta kuin ISAM taulutyyppiä, yleisimmin .
 * ks. http://dev.mysql.com/doc/refman/5.0/en/transactional-commands.html
 * Taulun luonti (Huom. tietokantamoottorin valinta)
   CREATE TABLE Student (
      Id INT auto_increment,
       Nimi VARCHAR(30) NOT NULL,
       Demopisteet INT NOT NULL,
       Koepisteet INT NOT NULL,
       Syntymaaika DATE NOT NULL,
       PRIMARY KEY (Id)
    ) ENGINE=InnoDB;
 
 */


public class UpdateTransStudents {
    // Database connection String
    static String user  = "jupepe";
    static String passwd = "jsp";
    static String url = "jdbc:mysql://localhost/jupepe";  

    public static void main(String args[]) {
	Connection conn=null; 
	try { // 1. Create Connection to database
	   Class.forName("com.mysql.jdbc.Driver");
	   conn = DriverManager.getConnection(url, user, passwd);

           conn.setAutoCommit(false); // Aloitetaan transaktio
           java.sql.Statement stmt = conn.createStatement();
           stmt.executeUpdate("INSERT INTO Student (Nimi,Demopisteet,Koepisteet, Syntymaaika) VALUES ('Musti-Kaapu',12,0,{d '1950-10-30'})" );
           stmt.executeUpdate("INSERT INTO Student (Nimi,Demopisteet,Koepisteet, Syntymaaika) VALUES ('Musti-Kaapo',5,6,{d '1959-11-30'})" );
           conn.rollback(); // Aikaisempia päivityksia ei ajeta lainkaan kantaan.

           int tulos = stmt.executeUpdate("DELETE FROM Student WHERE Nimi LIKE '%Musta%'");
           tulos += stmt.executeUpdate("INSERT INTO Student (Nimi,Demopisteet,Koepisteet, Syntymaaika) VALUES ('Musta-Pekka',5,6,{d '1935-01-01'})" );
           conn.commit(); // lopetetaan transaktio
           System.out.println("Päivityksiä " + tulos + " kappaletta" );

	    stmt.close();
	    conn.close();	    
	} 
	catch (Exception e) { e.printStackTrace(); }

    }


    
}
