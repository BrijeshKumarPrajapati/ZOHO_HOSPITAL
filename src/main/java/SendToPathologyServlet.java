import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.connection.*;
public class SendToPathologyServlet extends HttpServlet{
	public void doPost (HttpServletRequest request, HttpServletResponse response) {
		int Patient = Integer.parseInt(request.getParameter("obeservation"));
		String [] Test = request.getParameterValues("testBook");
		
		int Test_Id =0;
		int Cost=0;
		String Test_name=null;
		int sum = 0;
		

		
		if (request.getParameter("pathologyBook")!=null && request.getParameter("pathologyBook").equals("pathologyBook")) {
			
			long currentTimeMS = System.currentTimeMillis();
		     Date date = new  Date(currentTimeMS);
		
		    Timestamp time = new Timestamp(currentTimeMS);
			
			
		    for(int i=0;i<Test.length;i++) {
				
				
				int testId = Integer.parseInt(Test[i]);
			
			try {
				/*Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Demo@123");
				*/Connection con = Conn.getCon();
				Statement stmt2 = con.createStatement();
				ResultSet rs2 = stmt2.executeQuery("select * from test where testId = "+testId+"");
				
				while(rs2.next()) {
					 Test_Id= rs2.getInt("testId");
					 Test_name = rs2.getString("testName");
					 Cost = rs2.getInt("testPrice");
					
				
				PreparedStatement stmt1 = con.prepareStatement("insert into testUser (testId, pId, cost, name, date, time) values(?,?,?,?,?,?)");
				
				stmt1.setInt(1, Test_Id);
				stmt1.setInt(2, Patient);
				stmt1.setInt(3, Cost);
				stmt1.setString(4, Test_name);
				stmt1.setDate(5,date);
				stmt1.setTimestamp(6,time);
			
				int j = stmt1.executeUpdate();  
				System.out.println(j + "records inserted");
                PreparedStatement stmt3 = con.prepareStatement("UPDATE patient SET pStatus = ? WHERE pId = ?");
				stmt3.setInt(1, 1);
				stmt3.setInt(2, Patient);
				int k = stmt3.executeUpdate();  
				System.out.println(k + "records inserted");
				
				
				response.sendRedirect("jsp/docService.jsp");
				con.close();  
			} 
			       }catch (Exception e) {
				          e.printStackTrace();

			      }
		 }
			
		}
	}
}
