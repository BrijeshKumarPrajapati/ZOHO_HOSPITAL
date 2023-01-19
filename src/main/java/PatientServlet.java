import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PatientServlet extends HttpServlet{
	public void doPost (HttpServletRequest request, HttpServletResponse response) {
		
		String pName = request.getParameter("patiRegName");
		int pAge = Integer.parseInt(request.getParameter("patiRegAge"));
		double pMobile =Double.parseDouble(request.getParameter("patiRegMobile"));
		String pBloodG = request.getParameter("patiRegBG");
		//String pIllness = request.getParameter("patiRegIll");
		
		if (request.getParameter("patiReg")!=null && request.getParameter("patiReg").equals("patiReg")) {
		try {
			
			 long currentTimeMS = System.currentTimeMillis();
		     Date date = new  Date(currentTimeMS);
		
		    Timestamp time = new Timestamp(currentTimeMS);
		   
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Demo@123");
			System.out.println("Connection is : " + con);
			PreparedStatement stmt = con.prepareStatement("insert into patient(pName, pAge, pMobile, pBloodG, Date, Time) values(?,?,?,?,?,?)");
			
			stmt.setString(1, pName);
			stmt.setInt(2, pAge);
			stmt.setDouble(3, pMobile);
			stmt.setString(4,pBloodG );
			//stmt.setString(5, pIllness);
			stmt.setDate(5, date);
			stmt.setTimestamp(6, time);
		
			int i = stmt.executeUpdate();  
			System.out.println(i + "records inserted"); 
			response.sendRedirect("jsp/appointment.jsp");
			con.close();  
		} catch (Exception e) {
			e.printStackTrace();

		}
		}
		
	}
}
