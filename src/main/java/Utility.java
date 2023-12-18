import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Utility {
	
	static {
	
	
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	} 
	
	catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
	
	}
	

	
	public static Connection getDbConnection() throws SQLException {
		
		String url="jdbc:mysql://localhost:3306/soumikdb";
		String userName="root";
		String password="Soumik@1993";
		
		return DriverManager.getConnection(url,userName,password);
		
	}
	
	public static void closeResourse(ResultSet rs,Statement st,Connection c) throws SQLException {
		
		if(rs!=null) 
			rs.close();
		
		if(st!=null)
			st.close();
		
		if(c!=null)
			c.close();
	
		
	}
}
