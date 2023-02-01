import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLoginServlet extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response) {
		double mobile = Double.parseDouble(request.getParameter("userAdmin"));	
		String password = request.getParameter("adminPass");
	try {
			AdminLogin obj1= new AdminLogin();
			
			
			
		if (request.getParameter("userAdmin")!=null && request.getParameter("adminPass") !=null && obj1.valid(mobile).getPassword().equals(password) && obj1.valid(mobile).getMobile()==mobile) {
			
			
			
			
             if(obj1.valid(mobile).getRole().equals("admin") ){
            	  // Cookie userCookie = new Cookie("name_server", obj1.valid(Mobile).getName());
            	  // response.addCookie(userCookie);
            	  // Cookie useridCookie = new Cookie("customerId_server", obj1.valid(Mobile).getCustomerID()+"");
            	  // response.addCookie(useridCookie);
            	 
				response.sendRedirect("jsp/admin_service.jsp");
		       } else {
		    	  // response.sendRedirect("html/Resturant.html");
		    	   
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
