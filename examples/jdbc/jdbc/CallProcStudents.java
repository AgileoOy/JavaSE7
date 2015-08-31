import java.sql.*;
import javax.sql.*;

/*
 * Tallennettujen proseduurien kutsuminen.
 * Käyttää CallableStatement luokkaa.
 * TOimii vasta MySQL:n 5-versiosta lähtien
 * 
 Alla tallennettu proseduuri ja sen kutsuminen MySQL 5-tietokannassa:
 
 delimiter //
 CREATE PROCEDURE laskeRivitMaxId (OUT rivit INT, OUT maxid INT)
  BEGIN
    SELECT COUNT(*) INTO rivit FROM Student;
    SELECT MAX(Id) INTO maxid FROM Student;
  END;
 //

 delimiter ;
 CALL laskeRivitMaxId(@a, @b);
 SELECT @a, @b;
 
 Lisätietoa:
 http://dev.mysql.com/doc/refman/5.0/en/create-procedure.html
 **/

public class CallProcStudents {
    //static String user  = "jupepe";
    //static String passwd = "jsp";
    static String url = "jdbc:mysql://localhost/jupepe?user=jupepe&password=jsp&noAccessToProcedureBodies=true";
    
    // Huom! root-käyttäjänä ei tarvita extra parametria noAccessToProcedureBodies=true
    //static String url = "jdbc:mysql://localhost/jupepe?user=root&password=root66";
    
    public static void main(String args[]) {
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url);
            
            CallableStatement cstmt = conn.prepareCall("CALL laskeRivitMaxId(?,?)");
            // rekisteräidään parametrit
            cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
            // suoritetaan kutsu 
            cstmt.execute();
            //int lkm = cstmt.getInt(1);
            //int maxId = cstmt.getInt(2);
            //System.out.println("Tietueessa on " + lkm + " kenttää ja Max ID on " + maxId);
            System.out.println("Tietueessa on " + cstmt.getString(1) +
                    " kenttää ja Max ID on " + cstmt.getString(2));
            cstmt.close();
            conn.close();
        } catch (Exception e) { e.printStackTrace(); }
    }
}








