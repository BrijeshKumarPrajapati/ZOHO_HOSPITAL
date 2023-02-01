import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoctorServlet extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response) {
		double mobile = Double.parseDouble(request.getParameter("userDoc"));	
		String password = request.getParameter("docPass");
	try {
			AdminLogin obj1= new AdminLogin();
			
			
			
		if (request.getParameter("userDoc")!=null && request.getParameter("docPass") !=null && obj1.valid(mobile).getPassword().equals(password) && obj1.valid(mobile).getMobile()==mobile) {
		 
				response.sendRedirect("jsp/docService.jsp?userDoc="+request.getParameter("userDoc"));
		  
		       }
		
		else {
			
                response.getWriter().print("Dear Customer! You Are Entering Wrong Input Please Check Your Mobile No.");
				response.getWriter().close();
				response.getWriter().flush();
		     }
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
             
}