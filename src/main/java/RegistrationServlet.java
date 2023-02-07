import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		StaffRegServlet obj = new StaffRegServlet();

		if (request.getParameter("Submit") != null && request.getParameter("Submit").equals("Submit")) {
			try {
				System.out.println(obj);
				obj.doPost(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
