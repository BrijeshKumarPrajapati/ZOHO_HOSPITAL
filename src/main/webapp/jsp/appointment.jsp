<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
   <%@page import="com.connection.Conn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Appointment Booking</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
	integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-success">
		<div class="container-fluid">
			<a class="navbar-brand" href="http://localhost:8080/ZOHO_HOSPITAL/"><i class="fa-solid fa-house-medical"></i> Medi-Home</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="admin_login.jsp"><i class="fa-solid fa-right-to-bracket"></i> Admin</a></li>
						
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="doctor_login.jsp">Doctor</a></li>
						
						
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="user_login.jsp">User</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<h5>Appintment Booking Page</h5></br>
	<h6>Patients Details</h6>
	 <form action="/ZOHO_HOSPITAL/appoint" method="post"> <%
        		
        		//String mobile =request.getParameter("userDoc");
        
         try{
        	 
        	/*Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
 			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Demo@123");
 			*/
 			Connection con = Conn.getCon();
 			System.out.println("Connection is : " + con);
 			Statement stmt1 = con.createStatement();
 			
 			String qry1 = "SELECT * FROM  patient where pId not in (select pId from booking)";
			
 			String qry2 = "SELECT * FROM user_dtls WHERE role = 'doctor'";
 			
 			Statement stmt2 = con.createStatement();
 			
 			ResultSet rs1 = stmt1.executeQuery(qry1);
 			
 			ResultSet rs2 = stmt2.executeQuery(qry2);
 			
 			
 			if(rs1.next()==false){
 				out.println("No Patient is Available  For Now !...");
 			} else{%>
 				<table>
 				     <tr><th> </th><th> Name </th><th> Age </th><th> BloodG </th><th> Date </th><th> Time </th></tr> <%
 				   
 				     do{%>
 				          <tr><td><input type="radio" name="patiBook" value="<%= rs1.getInt(1) %>"/></td><td><%= rs1.getString(2)%></td><td> <%= rs1.getInt(3)%></td>
 				          <td> <%= rs1.getString(5)%></td><td> <%= rs1.getDate(6)%></td><td> <%= rs1.getTime(7)%></td></tr>
 				          <% 
 				    	 
 				     }while(rs1.next());%>
 				     
 				</table> </br><% //out.println("<b>Total transaction with us till now is : </b>"+" "+" "+ sum +"/-");%></br><%
 			}

 			%> </br> <h6>List Of Available Doctors</h6> <%
 			
 			if(rs2.next()==false){
 				out.println("No Doctor is Available!...");
 			} else{%>
 				<table>
 				     <tr><th> u_id </th><th> Name </th><th> Specialization </th></tr> <%
 				   
 				     do{%>
 				          <tr><td><input type="radio" name="docBook" value="<%= rs2.getInt(1) %>"/></td><td><%= rs2.getString(2)%></td><td><%= rs2.getString(7)%></td></tr>
 				          <% 
 				    	 
 				     }while(rs2.next());%>
 				     
 				</table> </br><% //out.println("<b>Total transaction with us till now is : </b>"+" "+" "+ sum +"/-");%></br><%
 			}
 			
 			
 			
         } catch(Exception e){
        	 e.getStackTrace();
         }
        	
         %></br></br>
	
	
	
	Book Appointment : <button type="submit" name="appointment" value="Sappointment">Book</button>
	
	</form>
	<a href="http://localhost:8008/ZOHO_HOSPITAL/jsp/Receptionist.jsp">Go to previous page</a>
	 </br></br></br></br></br></br></br></br></br></br></br></br></br>
<div class="container-fluid p-1 bg-success text-center text-white">
	<p>@copyright Zoho Hospitals</p>
</div>

<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>