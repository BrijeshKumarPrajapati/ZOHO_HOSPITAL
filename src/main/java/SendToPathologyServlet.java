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

public class SendToPathologyServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		int patient = Integer.parseInt(request.getParameter("obeservation"));
		String[] testArray = request.getParameterValues("testBook");

		int test_Id = 0;
		int cost = 0;
		String test_name = null;
		int sum = 0;

		if (request.getParameter("pathologyBook") != null
				&& request.getParameter("pathologyBook").equals("pathologyBook")) {

			long currentTimeMS = System.currentTimeMillis();
			Date date = new Date(currentTimeMS);
			Timestamp time = new Timestamp(currentTimeMS);
			for (int i = 0; i < testArray.length; i++) {
				int testId = Integer.parseInt(testArray[i]);

				try {
					Connection con = Conn.getCon();
					Statement stmt2 = con.createStatement();
					ResultSet rs2 = stmt2.executeQuery("select * from test where testId = " + testId + "");

					while (rs2.next()) {
						test_Id = rs2.getInt("testId");
						test_name = rs2.getString("testName");
						cost = rs2.getInt("testPrice");

						PreparedStatement stmt1 = con.prepareStatement(
								"insert into testUser (testId, pId, cost, name, date, time) values(?,?,?,?,?,?)");

						stmt1.setInt(1, test_Id);
						stmt1.setInt(2, patient);
						stmt1.setInt(3, cost);
						stmt1.setString(4, test_name);
						stmt1.setDate(5, date);
						stmt1.setTimestamp(6, time);

						int j = stmt1.executeUpdate();
						System.out.println(j + "records inserted");
						PreparedStatement stmt3 = con.prepareStatement("UPDATE patient SET pStatus = ? WHERE pId = ?");
						stmt3.setInt(1, 1);
						stmt3.setInt(2, patient);
						int k = stmt3.executeUpdate();
						System.out.println(k + "records inserted");

						response.sendRedirect("jsp/docService.jsp");
						con.close();
					}
				} catch (Exception e) {
					e.printStackTrace();

				}
			}

		}
	}
}
