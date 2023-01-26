import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.json.JSONArray;
  

public class StaffRegServlet extends HttpServlet{
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {
			
		try {
			
			 String jsonBody = new BufferedReader(new InputStreamReader(request.getInputStream())).lines().collect(
					    Collectors.joining("\n"));
					   /*// System.out.println(jsonBody);
					   // System.out.println(".....");
					    // String empD[] = jsonBody.split("&");
					    // System.out.println(empD.length);
				
					     for(int i=0;i<empD.length-1;i++) {
					    	String empDetails[] = empD[i].split("="); 
					    		System.out.println("the length is"+i+"element is = "+empDetails.length);	
					    		for(int j=0;j<empDetails.length;j++) {
					    			System.out.println(empDetails[j]);
					    		}
					     }*/
			 
			 
			 String s="{\"name\":\"sonoo\",\"salary\":600000.0,\"age\":27}";
			 
			 
			 
			 
			 
			 
					    JSONObject jObj = new JSONObject(s);
					    System.out.println("this is obj"+jObj);
					   Iterator<String> it = jObj.keys();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Demo@123");
			System.out.println("Connection is : " + con);
			PreparedStatement stmt = con.prepareStatement("insert into user_dtls (fullName, email, password, role, mobile, age, specialization) values(?,?,?,?,?,?,?)");
			
			
			while (it.hasNext()) {
		       // String key = it.next();  
		        
		       // JSONObject obj = jObj.getJSONObject(key);
		        
				stmt.setString(1, jObj.getString("Name"));
				stmt.setString(2, jObj.getString("Email")); 
				stmt.setInt(3, jObj.getInt("Pass"));
				stmt.setString(4,jObj.getString("Role"));
				stmt.setDouble(5,jObj.getDouble("Mobile"));
				
				stmt.setInt(6, jObj.getInt("Age"));
				stmt.setString(7, jObj.getString("Specialiozation"));
				
				//stmt.executeUpdate();
				
				int i = stmt.executeUpdate();  
				System.out.println(i + "records inserted");
		    }
		       
			response.getWriter().print("New Employee Added Successfully...");
			
			con.close();  
		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}
}
