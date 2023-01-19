import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PharmasistClearanceServlet extends HttpServlet{
	public void service (HttpServletRequest request, HttpServletResponse response) {
		

		if (request.getParameter("MediReport")!=null && request.getParameter("MediReport").equals("MediReport")) {
	try {
		 response.getWriter().print("Patient Has Taken His Medicine");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
}

