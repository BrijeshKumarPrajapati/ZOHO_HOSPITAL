<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pharmasist Page</title>

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
	<h5>Medicine Details</h5>
	
	
	<form action="/ZOHO_HOSPITAL/mediREPORT" method="post"> <%
        		
        		//String mobile =request.getParameter("userDoc");
			    int PatientId = 0;
                String PatientName= null;
        
         try{
        	 
        	Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
 			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Demo@123");
 			System.out.println("Connection is : " + con);
 			
 			
 			Statement stmt1 = con.createStatement();
 			String qry1 = "SELECT * FROM  medicineUser WHERE mStatus="+0+"";
 			ResultSet rs1 = stmt1.executeQuery(qry1);
 			
 			
 			
 			
 			if(rs1.next()==false){
 				out.println("No Records Found !...");
 			} else{%><h6>Prescription of Doctor For Patient Id= <%= rs1.getInt(1)%></h6>
 				<table>
 				     <tr><th>Medicine Id</th><th>....</th><th>Patient Id</th><th>....</th><th>Patient Name</th><th>....</th><th>Medicine Name</th><th>....</th></tr> <%
 				   
 				     do{%>
 				     
 				     <% PatientId = rs1.getInt(1);
 				     
 				      Statement stmt2 = con.createStatement();
 			          String qry2 = "SELECT * FROM  patient WHERE pId="+PatientId+"";
 			         ResultSet rs2 = stmt2.executeQuery(qry2); 
 			         if(rs2.next()){
 			        	 PatientName=rs2.getString(2);
 			        }
 			         
 			         %>
 				     
 				          <tr><td><%= rs1.getInt(3)%></td><td></td><td> <%= rs1.getInt(1)%></td><td></td><td> <%= PatientName%></td><td></td><td><%= rs1.getString(2) %></td></tr>
 				          <% 
 				    	 
 				     }while(rs1.next());%>
 				     
 				</table><%
 			}  %> </br></br>
 			<%
         } catch(Exception e){
        	 e.getStackTrace();
         }
        	
         %>
           These Medicines Are Handed Over To Patient : <button type="submit" name="MediReport" value="MediReport">Submit Medicine</button>
         </form></br></br>
	
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