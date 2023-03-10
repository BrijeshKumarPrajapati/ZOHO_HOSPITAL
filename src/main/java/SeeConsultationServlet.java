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
	protected void service (HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		double patientMobile = Double.parseDouble(request.getParameter("seeConsult"));
		
		int patientId=0;
		if (request.getParameter("seeConsultName")!=null && request.getParameter("seeConsultName").equals("seeConsult")) {
			
			try {
				Connection con = Conn.getCon();
				Statement stmt1 = con.createStatement();
				ResultSet rs1 = stmt1.executeQuery("select * from  patient where pMobile = "+patientMobile+"");
				
				while(rs1.next()) {
					  patientId = rs1.getInt("pId");
			} 	
			request.setAttribute("PatientId", patientId);
			RequestDispatcher rd= request.getRequestDispatcher("/jsp/consultation.jsp");
			rd.forward(request, response);  
			con.close();  
			} catch (Exception e) {
				 e.getStackTrace();
			 }
	}
  }
}