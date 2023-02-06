import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.connection.*;
public class AdminLogin {
	 private String fullName;
	 private String email;
     private 	String password;
	 private String role;
	 private double mobile;
	
	
	
	
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public double getMobile() {
		return mobile;
	}

	public void setMobile(double mobile) {
		this.mobile = mobile;
	}



	
	@Override
	public String toString() {
		return "AdminLogin [fullName=" + fullName + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", mobile=" + mobile + "]";
	}
	
	protected AdminLogin valid(double mobile) {
		AdminLogin  validObj = new AdminLogin ();
		try {
			/*Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Demo@123");
			*/Connection con = Conn.getCon();
			System.out.println("Connection is : " + con);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user_dtls Where mobile=\""+mobile+"\"");
			
			
			while (rs.next()) {
				validObj.setFullName(rs.getString(2));
				validObj.setEmail(rs.getString(3));
				validObj.setPassword(rs.getString(4));
				validObj.setRole(rs.getString(5));
				validObj.setMobile(rs.getDouble(6));
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	    return validObj;
}

	
	
}


