import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PatientRegServlet extends HttpServlet{
	public void service (HttpServletRequest request, HttpServletResponse response) {
		

		if (request.getParameter("patienttReg")!=null && request.getParameter("patienttReg").equals("patienttReg")) {
	try {
		 
		response.sendRedirect("jsp/patientReg.jsp");
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
}