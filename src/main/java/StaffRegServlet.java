import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

public class StaffRegServlet extends HttpServlet{
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String jsonBody = new BufferedReader(new InputStreamReader(request.getInputStream())).lines().collect(
					    Collectors.joining("\n"));
					   // System.out.println(jsonBody);
			JSONObject jObj = new JSONObject(jsonBody);				   
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Demo@123");
			System.out.println("Connection is : " + con);
			PreparedStatement stmt = con.prepareStatement("insert into user_dtls (fullName, email, password, role, mobile, age, specialization) values(?,?,?,?,?,?,?)");
			
			    stmt.setString(1, jObj.getString("name"));
				stmt.setString(2, jObj.getString("email")); 
				stmt.setInt(3, jObj.getInt("password"));
				stmt.setString(4,jObj.getString("role"));
				stmt.setDouble(5,jObj.getDouble("mobile"));
				stmt.setInt(6, jObj.getInt("age"));
				stmt.setString(7, jObj.getString("specialization"));
				int i = stmt.executeUpdate();  
				System.out.println(i + "records inserted");
			//response.getWriter().print("New Employee Added Successfully...");
			//response.sendRedirect("admin_login.jsp");
			con.close();  
		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}
}
