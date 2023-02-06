import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.connection.*;
public class UpdateEmployeeServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    
    	
  		String employeeName =request.getParameter("entityChange");
  		double employeeMobile =Double.parseDouble(request.getParameter("employeeKnown"));
  		
  		//String deleteName = request.getParameter("deleteEmployee");
  		
  		try {
			/*Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Demo@123");
  			*/Connection con = Conn.getCon();
			System.out.println("Connection is : " + con);
			PreparedStatement stmt = con.prepareStatement("update user_dtls set fullName =? where mobile =?");
			
			stmt.setString(1,employeeName);
			stmt.setDouble(2,employeeMobile);
			
			int i=stmt.executeUpdate();  
			System.out.println(i+" records updated");  
			response.getWriter().print("Employee Updated Successfully...");
			con.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
  		
    }
}