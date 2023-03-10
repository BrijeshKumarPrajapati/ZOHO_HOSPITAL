<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.sql.*" %>
     <%@ page import="com.connection.*"  %>
     <% int patientId = (int) request.getAttribute("PatientId");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consultation Page</title>
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
						aria-current="page" href="jsp/admin_login.jsp"><i class="fa-solid fa-right-to-bracket"></i> Admin</a></li>
						
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="jsp/doctor_login.jsp">Doctor</a></li>
						
						
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="jsp/user_login.jsp">User</a></li>
				</ul>
			</div>
		</div>
	</nav>	
	<form action="/ZOHO_HOSPITAL/docCONSULTATION" method="post"> <%
	
	         String patientName = null;
        		
         try{
        	
 			Connection con = Conn.getCon();
 			
 			System.out.println("Connection is : " + con);
 			Statement stmt1 = con.createStatement();
 			
 			String qry1 = "SELECT * FROM  testUser WHERE pId ="+patientId+" AND tStatus ="+0+"";
 			
 			String qry2 = "SELECT * FROM medicine ";
 			
 			String qry3 = "SELECT * FROM  patient WHERE pId ="+patientId+"";
 			
 			Statement stmt2 = con.createStatement();
 			
 			ResultSet rs1 = stmt1.executeQuery(qry1);
 			
 			ResultSet rs2 = stmt2.executeQuery(qry2);
 			
 			Statement stmt3 = con.createStatement();
 			
 			ResultSet rs3 = stmt3.executeQuery(qry3);
 			
 			
 			if(rs3.next()==false){
 				out.println("No Records Found !...");
 			} else{
 				patientName = rs3.getString(2);
 			}

 			if(rs1.next()==false){
 				out.println("No Records Found !...");
 			} else{%>
 				<table>
 				     <tr><th>Patient Id</th><th>....</th><th>Patient Name</th><th>....</th><th>Test ID</th><th>....</th><th>Test Name</th><th>....</th><th>Description</th></tr> <%
 				   
 				     do{%>
 				          <tr><td><input type="radio" name="testReport" value="<%= rs1.getInt(2) %>"/></td><td></td><td><%= patientName%></td><td></td><td><%= rs1.getInt(1)%></td><td></td><td> <%= rs1.getString(4)%></td>
 				          <td></td><td> <%= rs1.getString(5)%></td></tr>
 				          <% 
 				    	 
 				     }while(rs1.next());%>
 				     
 				</table>
 				<%
 			}  %> </br></br>
 			
 			 <h6>List Of Medicine</h6><%
 			
 			if(rs2.next()==false){
 				out.println("No Medicine Is Needed...");
 			} else{%>
 				<table>
 				     <tr><th> Medicine Id </th><th> Medicine Name </th></tr> <%
 				   
 				     do{%>
 				          <tr><td><input type="checkbox" name="medicine" value="<%= rs2.getInt(1) %>"/></td><td><%= rs2.getString(2)%></td></tr>
 				          <% 
 				    	 
 				     }while(rs2.next());%>
 				     
 				</table> </br></br><%
 			}
 			
         } catch(Exception e){
        	 e.getStackTrace();
         }
        	
         %>
           
           
           Send This Patient For Medicine : <button type="submit" name="consultationBook" value="consultationBook">Submit Final Consultation</button>
         </form></br></br>
	
	
	
	 </br></br></br></br></br>
<div class="container-fluid p-1 bg-success text-center text-white">
	<p>@copyright Zoho Hospitals</p>
</div>

<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>