import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLoginServlet extends HttpServlet{
	
	    protected void service(HttpServletRequest request, HttpServletResponse response) {
	    double mobile = Double.parseDouble(request.getParameter("userAdmin"));	
		String password = request.getParameter("adminPass");
	try {
			AdminLogin obj1= new AdminLogin();
			
		if (request.getParameter("userAdmin")!=null && request.getParameter("adminPass") !=null && obj1.valid(mobile).getPassword().equals(password)) {
			
			
             if(obj1.valid(mobile).getRole().equals("admin") ){
            	  
            	 
				response.sendRedirect("jsp/admin_service.jsp");
		       } else {
		    	  
		    	   response.getWriter().print("Dear User! You Are Not An Admin");
		       }}
		
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
