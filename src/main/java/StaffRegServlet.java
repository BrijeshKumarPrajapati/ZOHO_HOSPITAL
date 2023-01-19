import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StaffRegServlet extends HttpServlet{
	public void doPost (HttpServletRequest request, HttpServletResponse response) {
		
		String Name = request.getParameter("Name");
		String Email = request.getParameter("Email");
		String Password = request.getParameter("Pass");
		String Role = request.getParameter("Role");
		double Mobile = Double.parseDouble(request.getParameter("Mobile"));
		String Specialization = request.getParameter("Specialization");
		int age = Integer.parseInt(request.getParameter("Age"));
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Demo@123");
			System.out.println("Connection is : " + con);
			PreparedStatement stmt = con.prepareStatement("insert into user_dtls (fullName, email, password, role, mobile, specialization,age) values(?,?,?,?,?,?,?)");
			
			
			stmt.setString(1, Name);
			stmt.setString(2, Email);
			stmt.setString(3, Password);
			stmt.setString(4, Role);
			stmt.setDouble(5, Mobile);
			stmt.setString(6, Specialization);
			stmt.setInt(7, age);
			int i = stmt.executeUpdate();  
			System.out.println(i + "records inserted"); 
			response.getWriter().print("Now! User Registered Successfully");
			
			con.close();  
		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}
}
