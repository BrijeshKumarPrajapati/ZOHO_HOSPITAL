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
import com.connection.*;

public class FinalConsultationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		int patient = Integer.parseInt(request.getParameter("testReport"));
		String[] medicineArray = request.getParameterValues("medicine");
		String name = null;
		int id = 0;
		int price = 0;
		if (request.getParameter("consultationBook") != null
				&& request.getParameter("consultationBook").equals("consultationBook")) {

			long currentTimeMS = System.currentTimeMillis();
			Date date = new Date(currentTimeMS);
			Timestamp time = new Timestamp(currentTimeMS);
			for (int i = 0; i < medicineArray.length; i++) {
				int medicine = Integer.parseInt(medicineArray[i]);

				try {
					Connection con = Conn.getCon();
					Statement stmt2 = con.createStatement();
					ResultSet rs2 = stmt2.executeQuery("select * from  medicine where mId = " + medicine + "");

					while (rs2.next()) {
						id = rs2.getInt("mId");
						name = rs2.getString("mName");
						price = rs2.getInt("mPrice");

						PreparedStatement stmt1 = con.prepareStatement(
								"insert into medicineUser (pId, mName, mId, mPrice, date, time) values(?,?,?,?,?,?)");

						stmt1.setInt(1, patient);
						stmt1.setString(2, name);
						stmt1.setInt(3, id);
						stmt1.setInt(4, price);
						stmt1.setDate(5, date);
						stmt1.setTimestamp(6, time);
						int j = stmt1.executeUpdate();
						System.out.println(j + "records inserted");
						response.getWriter().print("Consultation Completed...");

						con.close();
					}
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		}
	}
}