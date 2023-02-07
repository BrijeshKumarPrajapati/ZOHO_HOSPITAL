import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.connection.*;
 public class AddNewMedicineServelet extends HttpServlet{
	protected void doPost (HttpServletRequest request, HttpServletResponse response) {
		
	
		 String medicineName = request.getParameter("medicineAddName");
		 int medicinePrice = Integer.parseInt(request.getParameter("medicineAddPrice"));
		
		try {
			addRecordToDb(medicineName, medicinePrice); 
			response.getWriter().print("New Medicine Added Successfully...");
		} catch (Exception e) {
			e.printStackTrace();

		}
		
}

	private void addRecordToDb(String name, int price) throws ClassNotFoundException, SQLException {
		
		Connection con = Conn.getCon();
		System.out.println("Connection is : " + con);
		PreparedStatement stmt = con.prepareStatement("INSERT into  medicine (mName, mPrice) VALUES(?,?)");
		stmt.setString(1, name);
		stmt.setInt(2, price);

		int i=stmt.executeUpdate();  
		System.out.println(i+" records inserted");
		con.close(); 

		return;
	}


}
