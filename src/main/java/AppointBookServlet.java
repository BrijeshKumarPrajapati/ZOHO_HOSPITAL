import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppointBookServlet extends HttpServlet{
	public void service (HttpServletRequest request, HttpServletResponse response) {
		

		if (request.getParameter("appointmentBook")!=null && request.getParameter("appointmentBook").equals("appointmentBook")) {
	try {
		 
		response.sendRedirect("jsp/appointment.jsp");
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
}