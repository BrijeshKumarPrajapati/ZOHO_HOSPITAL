import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HistoryServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		double patientMobile = Double.parseDouble(request.getParameter("historyName"));
		if (request.getParameter("historyBUTTON") != null
				&& request.getParameter("historyBUTTON").equals("historyBUTTON")) {

			try {
				request.setAttribute("Mobile", patientMobile);
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/history.jsp");

				rd.forward(request, response);

			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}
}