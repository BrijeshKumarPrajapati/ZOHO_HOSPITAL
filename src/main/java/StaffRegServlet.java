import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONException;
import org.json.JSONObject;

import com.mysql.cj.log.Log;
  

public class StaffRegServlet extends HttpServlet{
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String jsonBody = new BufferedReader(new InputStreamReader(request.getInputStream())).lines().collect(
					    Collectors.joining("\n"));
					   System.out.println(jsonBody);
					   /*// System.out.println(".....");
					    // String empD[] = jsonBody.split("&");
					    // System.out.println(empD.length);
				
					     for(int i=0;i<empD.length-1;i++) {
					    	String empDetails[] = empD[i].split("="); 
					    		System.out.println("the length is"+i+"element is = "+empDetails.length);	
					    		for(int j=0;j<empDetails.length;j++) {
					    			System.out.println(empDetails[j]);
					    		}
					     }*/
			JSONObject jObj = new JSONObject(jsonBody);
					    System.out.println("this is  json obj"+jObj);
					   //Iterator<String> it = jObj.keys();
			
					    
					    JSONParser parser = new JSONParser(jsonBody);
					    JSONObject json = (JSONObject) parser.parse(parser);
					    
					    
					    
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Demo@123");
			System.out.println("Connection is : " + con);
			PreparedStatement stmt = con.prepareStatement("insert into user_dtls (fullName, email, password, role, mobile, age, specialization) values(?,?,?,?,?,?,?)");
			
			    stmt.setString(1, jObj.getString("Name"));
				stmt.setString(2, jObj.getString("Email")); 
				stmt.setInt(3, jObj.getInt("Pass"));
				stmt.setString(4,jObj.getString("Role"));
				stmt.setDouble(5,jObj.getDouble("Mobile"));
				stmt.setInt(6, jObj.getInt("Age"));
				stmt.setString(7, jObj.getString("Specialiozation"));
				int i = stmt.executeUpdate();  
				System.out.println(i + "records inserted");
			response.getWriter().print("New Employee Added Successfully...");
			
			con.close();  
		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}
}
