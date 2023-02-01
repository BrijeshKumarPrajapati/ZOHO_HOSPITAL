import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response) {
		double mobile = Double.parseDouble(request.getParameter("userLogin"));	
		String password = request.getParameter("userPass");
	try {
			AdminLogin obj1= new AdminLogin();
			
			
			
		if (request.getParameter("userLogin")!=null && request.getParameter("userPass") !=null && obj1.valid(mobile).getPassword().equals(password)&& obj1.valid(mobile).getMobile()==mobile) {
			
			
			
			
            if(obj1.valid(mobile).getRole().equals("path") ){
            	  // Cookie userCookie = new Cookie("name_server", obj1.valid(Mobile).getName());
            	  // response.addCookie(userCookie);
            	  // Cookie useridCookie = new Cookie("customerId_server", obj1.valid(Mobile).getCustomerID()+"");
            	  // response.addCookie(useridCookie);*/
            	 
				response.sendRedirect("jsp/Pathology.jsp");
		     } else if(obj1.valid(mobile).getRole().equals("pharma")){
		    	  // response.sendRedirect("html/Resturant.html");
		    	   
		    	 /*  response.getWriter().print("Dear User! You Are Not An Admin");*/
		    	 response.sendRedirect("jsp/Pharmasist.jsp");
		       } else if(obj1.valid(mobile).getRole().equals("receptionist")){
			    	  // response.sendRedirect("html/Resturant.html");
		    	   
			    	 /*  response.getWriter().print("Dear User! You Are Not An Admin");*/
			    	 response.sendRedirect("jsp/Receptionist.jsp");
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
