import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.connection.*;
public class FinalServlet extends HttpServlet{
	public void service (HttpServletRequest request, HttpServletResponse response) throws IOException {
	int  patientId = Integer.parseInt(request.getParameter("hiddenPid"));
		
		System.out.println("Wrking patient Id is: "+patientId);
		
		if (request.getParameter("clear")!=null && request.getParameter("clear").equals("clear")) {
			
			try {
				
				/*Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Demo@123");
				*/Connection con = Conn.getCon();
				
				PreparedStatement stmt1 = con.prepareStatement("UPDATE testUser SET tStatus = ? WHERE pId = ?");
				
				stmt1.setInt(1, 1);
				stmt1.setInt(2, patientId);
				int j = stmt1.executeUpdate();  
				System.out.println(j + "records inserted");
				
				PreparedStatement stmt2 = con.prepareStatement("UPDATE medicineUser SET mStatus = ? WHERE pId = ?");
				
				stmt2.setInt(1, 1);
				stmt2.setInt(2, patientId);
				int i = stmt2.executeUpdate();  
				System.out.println(i + "records inserted");
				  
			
			    response.getWriter().print("Paitient is dischared now..."); 
			    con.close();
			
			} catch (Exception e) {
				 e.getStackTrace();
			 }
	}
  }
}