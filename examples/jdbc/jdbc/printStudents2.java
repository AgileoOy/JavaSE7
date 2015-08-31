
import java.sql.*;
import javax.sql.*;

/*
 * Kyselyesimerkki
 * Käytetään PreparedStatament tyyppisiä lausekkeita.
 * 
 **/
public class printStudents2 {

    static String user = "jupepe";
    static String passwd = "jsp";
    static String url = "jdbc:mysql://localhost/jupepe";

    public static void main(String args[]) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, passwd);
            PreparedStatement pstmt = conn.prepareStatement(
                    "select *, Demopisteet+Koepisteet as Yht from oppilas where Nimi LIKE ?");
            String hakutaulu[] = {"Mik%", "%nni", "%Musta%", "U%", "Up%"};

            for (int i = 0; i < hakutaulu.length; i++) {
                pstmt.setString(1, hakutaulu[i]);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    String nimi = rs.getString("Nimi");
                    int demo = rs.getInt("Demopisteet");
                    int koe = rs.getInt("Koepisteet");
                    System.out.println(nimi + ";" + demo + ";" + koe + ";" + rs.getInt("Yht"));
                }
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
