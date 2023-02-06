import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.connection.*;
public class UpdateMedicineServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    
    	
  		String medicineName =request.getParameter("testItem");
  		int  medicenePrice =Integer.parseInt(request.getParameter("oldPrice"));
  		
  		try {
			/*Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Demo@123");
  			*/Connection con = Conn.getCon();
			System.out.println("Connection is : " + con);
			PreparedStatement stmt = con.prepareStatement("update medicine set mPrice =? where mName =?");
			
			stmt.setInt(1,medicenePrice);
			stmt.setString(2,medicineName);
			
			int i=stmt.executeUpdate();  
			System.out.println(i+" records updated");  
			response.getWriter().print("Medicine Price Updated Successfully...");
			con.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
  		
    }
}