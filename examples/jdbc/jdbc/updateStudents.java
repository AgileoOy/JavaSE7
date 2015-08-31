import java.sql.*;
import javax.sql.*;

public class updateStudents {
    // Database connection String
    static String user  = "jupepe";
    static String passwd = "jsp";
    static String url = "jdbc:mysql://localhost/jupepe";  

    public static void main(String args[]) {
	Connection conn=null; 
	try { // 1. Create Connection to database
	    Class.forName("com.mysql.jdbc.Driver");
	    conn = DriverManager.getConnection(url, user, passwd);

	    // 2. Insert row to database   
	    Statement stmt = conn.createStatement();
            String sql=  "INSERT INTO oppilas (Id,Nimi,Demopisteet,Koepisteet)" +
           " VALUES (15,'UUsi OLIO',10,2)" ;
	    int tulos = stmt.executeUpdate(sql);
        System.out.println("Päivityksiä " + tulos + " kappaletta" );

	    stmt.close();
	    conn.close();	    
	} 
	catch (Exception e) { e.printStackTrace(); }

    }


    
}
