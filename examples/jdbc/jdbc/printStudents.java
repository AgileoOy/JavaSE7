import java.sql.*;

public class printStudents
{
    // Database connection String
    //static String user  = "root";
    //static String passwd = "root66";
    static String user  = "jupepe";
    static String passwd = "jsp";

        static String url = "jdbc:mysql://localhost:3306/jupepe";

        public static void main(String args[]) {


            // Create connection to database (conn -vcariable)
            Connection conn=null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
	    conn = DriverManager.getConnection(url, user, passwd);

	    // 2. Query database   
	    
	    Statement stmt = conn.createStatement();
	    ResultSet rs = stmt.executeQuery("select *, Demopisteet+Koepisteet as Total from oppilas");
    
	    while (rs.next()) {
		// retrieve and print the values for the current database row
		int id = rs.getInt("Id");
		String nimi = rs.getString("Nimi");
		int demo = rs.getInt("Demopisteet");
		int koe = rs.getInt("Koepisteet");
		System.out.println(id + "\t" + nimi  + "\t"  + demo + "\t" + koe 
                       + "\t" + rs.getInt("Total") + "\t" );
	    }

            rs.absolute(5); // Kursorin absoluuttinen paikka
	    while (rs.previous()) {
		// retrieve and print the values for the current database row
		int id = rs.getInt("Id");
		String nimi = rs.getString("Nimi");
		int demo = rs.getInt("Demopisteet");
		int koe = rs.getInt("Koepisteet");
		System.out.println(id + "\t" + nimi  + "\t"  + demo + "\t" + koe + "\t" );
	    }



	    rs.close();
	    stmt.close();
	    conn.close();
	} catch (SQLException sqle) {
	    while (sqle != null) { 
		System.out.println(sqle.toString());
		sqle = sqle.getNextException();
	    }
	}
	catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
}
