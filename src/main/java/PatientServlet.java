import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.connection.*;

public class PatientServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		try {
			String jsonBody = new BufferedReader(new InputStreamReader(request.getInputStream())).lines()
					.collect(Collectors.joining("\n"));
			System.out.println(jsonBody);
			JSONObject jObj = new JSONObject(jsonBody);
			long currentTimeMS = System.currentTimeMillis();
			Date date = new Date(currentTimeMS);

			Timestamp time = new Timestamp(currentTimeMS);
			Connection con = Conn.getCon();
			System.out.println("Connection is : " + con);
			PreparedStatement stmt = con.prepareStatement(
					"insert into patient(pName, pAge, pMobile, pBloodG, Date, Time) values(?,?,?,?,?,?)");

			stmt.setString(1, jObj.getString("Name"));
			stmt.setInt(2, jObj.getInt("Age"));
			stmt.setDouble(3, jObj.getDouble("Mobile"));
			stmt.setString(4, jObj.getString("BloodGroup"));
			// stmt.setString(5, pIllness);
			stmt.setDate(5, date);
			stmt.setTimestamp(6, time);

			int i = stmt.executeUpdate();
			System.out.println(i + "records inserted");
			response.sendRedirect("jsp/appointment.jsp");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
//}
