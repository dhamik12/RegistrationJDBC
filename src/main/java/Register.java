

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reg")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connect=null;
		String sql="insert into studentpersonalinfo (name,address,age) value (?,?,?)";
		int rowsAffected=0;
		PrintWriter pw=response.getWriter();
		
		
		String userName=request.getParameter("name");
		String userAddress=request.getParameter("address");
		String userAge=request.getParameter("age");
		
		System.out.println(userName+":"+ userAddress+ ":"+ userAge);
		
		try {
			connect=Utility.getDbConnection();
			
			if(connect!=null) {
				
				PreparedStatement pstmt=connect.prepareStatement(sql);
				pstmt.setString(1, userName);
				pstmt.setString(2, userAddress);
				pstmt.setInt(3, Integer.parseInt(userAge));
				
				rowsAffected=pstmt.executeUpdate();
				
				if(rowsAffected!=0) {
					
					pw.println("<html><head><title>Results....</title></head>");
					pw.println("<body><h2 bgcolor= 'green'> Data is updated successfully..</h2></body>");
					pw.println("</html>");
					
				}
				
				else {
					pw.println("<html><head><title>Results....</title></head>");
					pw.println("<body><h2 bgcolor= 'red'>Failed to update the data...</h2></body>");
					pw.println("</html>");
				}
				
			}
		} 
		
		
		catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	}

}
