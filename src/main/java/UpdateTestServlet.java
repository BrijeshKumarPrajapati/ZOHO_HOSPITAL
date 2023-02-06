import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.connection.*;
public class UpdateTestServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    
    	
  		String testName =request.getParameter("testItem");
  		int  testPrice =Integer.parseInt(request.getParameter("oldPrice"));
  		
  		try {
			/*Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Demo@123");
  			*/Connection con = Conn.getCon();
			System.out.println("Connection is : " + con);
			PreparedStatement stmt = con.prepareStatement("update test set testPrice =? where testName =?");
			
			stmt.setInt(1,testPrice);
			stmt.setString(2,testName);
			
			int i=stmt.executeUpdate();  
			System.out.println(i+" records updated");  
			response.getWriter().print("Test Price Updated Successfully...");
			con.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
  		
    }
}