package derby;

import java.sql.*;

/*
 Esimerkissä pitää olla mukana toimiva Jdbc-ajuri,
 * joka ladataan käyttöön org.apache.derby.jdbc.ClientDriver
 * nimisenä luokkana ohjelmassa.
 * derbyclient.jar -paketti pitää ladata projektille 
 * ja se löytyy ainakin GlassFish:ssa suoraan javadb-hakemiston
 * alta javadb/lib -hakemistosta.

 * Muista myös käydä käynnistämässä Derby ennen kuin yrität ajaa -esimerkkiä: 
 * Services -välilehti: Databases \ Java DB \ sample -> connect
 
 * Harjoitus: Toteuta JDBC:llä ohjelma, joka hakee kaikki kentät taulusta MANUFACTURER:
 * 
 */
public class DerbyProduct {
    // Database connection String

    static String user = "app";
    static String passwd = "app";
    static String url = "jdbc:derby://localhost:1527/sample";

    public static void main(String args[]) {
        // Create connection to database (conn -vcariable)
        Connection conn = null;
        try {
            String driver = "org.apache.derby.jdbc.ClientDriver";
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, user, passwd);
            // 2. Query database   
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from PRODUCT");
            while (rs.next()) {
                // retrieve and print the values for the current database row
                int id = rs.getInt("PRODUCT_ID");
                String maara = rs.getString("QUANTITY_ON_HAND");
                String kustannus = rs.getString("PURCHASE_COST");
                String kuvaus = rs.getString("DESCRIPTION");
                System.out.println(id + "\t" + maara + "\t" + kustannus + "\t" + kuvaus);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException sqle) {
            while (sqle != null) {
                System.out.println(sqle.toString());
                sqle = sqle.getNextException();
            }
        } /*catch (ClassNotFoundException e) {
         e.printStackTrace();
         }*/ catch (Exception e) {
            e.printStackTrace();
        }
    }
}
