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

public class ClearanceServlet extends HttpServlet{
	protected void service (HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		double patientMobile = Double.parseDouble(request.getParameter("clearanceName"));
		
		int pId=0;
		int testSum=0;
		int  medicineSum=0;
		
		if (request.getParameter("clearanceBUTTON")!=null && request.getParameter("clearanceBUTTON").equals("clearanceBUTTON")) {
			
			try {
			request.setAttribute("MobileNo", patientMobile);
			RequestDispatcher rd= request.getRequestDispatcher("/jsp/BillReoprt.jsp");
			
			rd.forward(request, response);  
			
			} catch (Exception e) {
				 e.getStackTrace();
			 }
	}
  }
}
