import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.connection.*;
public class SeeConsultationServlet extends HttpServlet{
	public void service (HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		double PatientMobile = Double.parseDouble(request.getParameter("seeConsult"));
		
		int pId=0;
		
		
		if (request.getParameter("seeConsultName")!=null && request.getParameter("seeConsultName").equals("seeConsult")) {
			
			try {
				/*Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Demo@123");
				*/Connection con = Conn.getCon();
				Statement stmt1 = con.createStatement();
				ResultSet rs1 = stmt1.executeQuery("select * from  patient where pMobile = "+PatientMobile+"");
				
				while(rs1.next()) {
					  pId = rs1.getInt("pId");
				
			} 	
			request.setAttribute("PatientId", pId);
			RequestDispatcher rd= request.getRequestDispatcher("/jsp/consultation.jsp");
			rd.forward(request, response);  
			
			con.close();  
			//response.sendRedirect("jsp/consultation.jsp");
			} catch (Exception e) {
				 e.getStackTrace();
			 }
	}
  }
}