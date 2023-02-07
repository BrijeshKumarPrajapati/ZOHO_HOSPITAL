import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.connection.*;

public class DeleteEmployeeServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String employeeName = request.getParameter("deleteEmployee");
		try {
			Connection con = Conn.getCon();
			System.out.println("Connection is : " + con);
			PreparedStatement stmt = con.prepareStatement("delete from user_dtls where fullName =?");

			stmt.setString(1, employeeName);

			int i = stmt.executeUpdate();
			System.out.println(i + " records updated");
			response.getWriter().print("Employee Deleted Successfully...");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
