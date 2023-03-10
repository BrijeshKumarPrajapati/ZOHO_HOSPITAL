import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import com.connection.*;

public class ReferPatientServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		try {
			String jsonBody = new BufferedReader(new InputStreamReader(request.getInputStream())).lines()
					.collect(Collectors.joining("\n"));
			JSONObject jObj = new JSONObject(jsonBody);

			long currentTimeMS = System.currentTimeMillis();
			Date date = new Date(currentTimeMS);

			Timestamp time = new Timestamp(currentTimeMS);

			Connection con = Conn.getCon();
			System.out.println("Connection is : " + con);
			PreparedStatement stmt1 = con.prepareStatement("insert into booking(pId, u_id, Date, Time) values(?,?,?,?)");

			stmt1.setInt(1, jObj.getInt("pId"));
			stmt1.setInt(2, jObj.getInt("user_Id"));
			stmt1.setDate(3, date);
			stmt1.setTimestamp(4, time);

			int i = stmt1.executeUpdate();
			System.out.println(i + "records inserted");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
