import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FinalConsultationServlet extends HttpServlet{
	public void doPost (HttpServletRequest request, HttpServletResponse response) {
		
		int Patient = Integer.parseInt(request.getParameter("testReport"));
		
		String [] Medicine = request.getParameterValues("medicine");
		
		String Name=null;
		int Id=0;
		int Price =0;  
		
		
		if (request.getParameter("consultationBook")!=null && request.getParameter("consultationBook").equals("consultationBook")) {
			
			long currentTimeMS = System.currentTimeMillis();
		     Date date = new  Date(currentTimeMS);
		
		    Timestamp time = new Timestamp(currentTimeMS);
			
			for(int i=0;i<Medicine.length;i++) {
				int medicine = Integer.parseInt(Medicine[i]);
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Demo@123");
				
				Statement stmt2 = con.createStatement();
				ResultSet rs2 = stmt2.executeQuery("select * from  medicine where mId = "+medicine+"");
				
				while(rs2.next()) {
					  Id = rs2.getInt("mId");
					  Name = rs2.getString("mName");
					  Price = rs2.getInt("mPrice");
					
				
				PreparedStatement stmt1 = con.prepareStatement("insert into medicineUser (pId, mName, mId, mPrice, date, time) values(?,?,?,?,?,?)");
				
				stmt1.setInt(1, Patient);
				stmt1.setString(2, Name);
				stmt1.setInt(3, Id);
				stmt1.setInt(4, Price);
				stmt1.setDate(5, date);
				stmt1.setTimestamp(6,time);
				int j = stmt1.executeUpdate();  
				System.out.println(j + "records inserted");
				response.getWriter().print("Consultation Completed...");
				
				con.close();  
			} 
			}catch (Exception e) {
				          e.printStackTrace();

			      }
		 }
	}
  }
}