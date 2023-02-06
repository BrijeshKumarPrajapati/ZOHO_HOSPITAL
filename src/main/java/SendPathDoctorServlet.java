import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.connection.*;
public class SendPathDoctorServlet extends HttpServlet{
	protected void doPost (HttpServletRequest request, HttpServletResponse response) {
		
		String [] testtArray = request.getParameterValues("testReport");
		
		if (request.getParameter("PathReport")!=null && request.getParameter("PathReport").equals("PathReport")) {
			
			for(int i=0;i<testtArray.length;i++) {
				int testtId = Integer.parseInt(testtArray[i]);
				
				String discription = request.getParameter("descPATH"+testtId);
			
			try {
				/*Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Demo@123");
				*/Connection con = Conn.getCon();
				
				PreparedStatement stmt1 = con.prepareStatement("UPDATE testUser SET discription = ? WHERE testUser_id = ?");
				
				stmt1.setString(1, discription);
				stmt1.setInt(2, testtId);
				
				int j = stmt1.executeUpdate();  
				System.out.println(j + "records inserted");
				
				response.getWriter().print("Report Submitted Successfully!...");
				
				con.close();  
			} 
			       catch (Exception e) {
				          e.printStackTrace();

			      }
		 }
	}
  }
}

