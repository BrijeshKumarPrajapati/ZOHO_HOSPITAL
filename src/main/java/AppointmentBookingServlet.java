import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppointmentBookingServlet extends HttpServlet{
	public void doPost (HttpServletRequest request, HttpServletResponse response) {
		
		int Patient_Id = Integer.parseInt(request.getParameter("patiBook"));
		int User_Id =Integer.parseInt(request.getParameter("docBook"));
		
		
		
		
		int pId=0;
        String pName=null;
        int pAge=0;
        Double pMobile=0.0;
        String pBloodG=null;
        Date Date;
        Time Time; 
		
		if (request.getParameter("appointment")!=null && request.getParameter("appointment").equals("Sappointment")) {
		try {
			
			 long currentTimeMS = System.currentTimeMillis();
		     Date date = new  Date(currentTimeMS);
		
		    Timestamp time = new Timestamp(currentTimeMS);
		   
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Demo@123");
			System.out.println("Connection is : " + con);
			PreparedStatement stmt1 = con.prepareStatement("insert into booking(pId, u_id, Date, Time) values(?,?,?,?)");
			
			stmt1.setInt(1, Patient_Id);
			stmt1.setInt(2, User_Id);
			stmt1.setDate(3, date);
			stmt1.setTimestamp(4, time);
		
			int i = stmt1.executeUpdate();  
			System.out.println(i + "records inserted");
			
			Statement stmt2 = con.createStatement();
			ResultSet rs2 = stmt2.executeQuery("select * from patient where pId = "+Patient_Id+"");
		
			response.sendRedirect("jsp/appointment.jsp");
			con.close();  
		} catch (Exception e) {
			e.printStackTrace();

		}
		}
		
}
}