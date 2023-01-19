import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateFacilityServlet extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    
  		String Item =request.getParameter("oldItem");
  		int Price = Integer.parseInt(request.getParameter("oldPrice"));
  		
  		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swiggy", "root", "Demo@123");
			System.out.println("Connection is : " + con);
			PreparedStatement stmt = con.prepareStatement("update Menu set Price=? where Item=?");
			
			stmt.setInt(1,Price);
			stmt.setString(2,Item);
			
			int i=stmt.executeUpdate();  
			System.out.println(i+" records updated");  
			response.getWriter().print("New Price Updated Successfully...");
			con.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
