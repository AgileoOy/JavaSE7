import java.sql.*;
import javax.sql.*;

/* Update esimerkki 2
 *  Esitellään JDBC:n päivitettävä tulosjoukko
 * Päivitettävä tulosjoukko. Updatable resultset
 */

public class UpdateRsStudents {
    // Database connection String
    static String user  = "jupepe";
    static String passwd = "jsp";
    static String url = "jdbc:mysql://localhost/jupepe";
    
    public static void main(String args[]) {
        String sql= "SELECT Id, Nimi, Demopisteet, Koepisteet FROM oppilas";
        
// Alla olevaa voi käyttää komentoriviltä ajettaessa
     /*   try {
            sql=  "SELECT Id, Demopisteet, Koepisteet FROM oppilas" +
                    " WHERE Nimi LIKE '%" + args[0] + "%'";
        } catch (ArrayIndexOutOfBoundsException ae) {
               System.err.println("Anna komentorivillä haettavan henkilän nimi");
        }
      */
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, passwd);
            
            // Päivitetään tietokannan riviä
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(sql);
            // mennään tulosjoukon ensimmäiseen alkioon
            rs.first();
            // Nollataan demopisteet ja lisätään koepisteitä yhdellä
            rs.updateString(2, "Updated Field");
            rs.updateInt(3, rs.getInt(3)+1);
            rs.updateRow();
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) { e.printStackTrace(); }
        
    }
    
    
    
}
