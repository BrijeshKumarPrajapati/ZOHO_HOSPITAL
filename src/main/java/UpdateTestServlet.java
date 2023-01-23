import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateTestServlet extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    
    	
  		String name =request.getParameter("testItem");
  		int  price =Integer.parseInt(request.getParameter("oldPrice"));
  		
  		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Demo@123");
			System.out.println("Connection is : " + con);
			PreparedStatement stmt = con.prepareStatement("update test set testPrice =? where testName =?");
			
			stmt.setInt(1,price);
			stmt.setString(2,name);
			
			int i=stmt.executeUpdate();  
			System.out.println(i+" records updated");  
			response.getWriter().print("Test Price Updated Successfully...");
			con.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
  		
    }
}