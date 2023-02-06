<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="com.connection.Conn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doc Service</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
	integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
	
	<script src="https://code.jquery.com/jquery-3.6.3.js" 
integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" 
crossorigin="anonymous"></script>

<script src="/ZOHO_HOSPITAL/js/referPatient.js"></script>

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
	
	<form action="/ZOHO_HOSPITAL/docOBSERVATION" method="post"> <%
        		
        		String mobile =request.getParameter("userDoc");
	            int patientId =0;
	            int n=0;
        
         try{
        	 
        	/*Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
 			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Demo@123");
 			*/
 			Connection con = Conn.getCon();
 			System.out.println("Connection is : " + con);
 			Statement stmt1 = con.createStatement();
 			
 			
 			String qry1 = "SELECT * FROM  patient p WHERE  p.pId in (SELECT pId FROM booking b WHERE b.u_id= (SELECT u_id FROM user_dtls ud WHERE ud.mobile="+mobile+")) AND pStatus ="+0+"";
 			String qry2 = "SELECT * FROM test ";
 			String qry3 = "SELECT * FROM  testUser tu WHERE  tu.pId in (SELECT pId FROM booking b WHERE b.u_id= (SELECT u_id FROM user_dtls ud WHERE ud.mobile="+mobile+")) AND tStatus="+1+" ORDER BY time DESC";
 			String qry4 = "SELECT * FROM user_dtls WHERE role = 'doctor' And mobile != "+mobile+"";
 			
 			Statement stmt2 = con.createStatement();
 			ResultSet rs1 = stmt1.executeQuery(qry1);
 			ResultSet rs2 = stmt2.executeQuery(qry2);
 			Statement stmt3 = con.createStatement();
 			ResultSet rs3 = stmt3.executeQuery(qry3);
 			Statement stmt4 = con.createStatement();
 			ResultSet rs4 = stmt4.executeQuery(qry4);
 			Statement stmt5 = con.createStatement();
 			ResultSet rs5 = stmt5.executeQuery(qry1);
 			
 			%> </br><%

 			if(rs1.next()==false){
 				out.println("No Appoinments Till Now !...");
 			} else{%>
 				<table>
 				     <tr><th>Patient Id</th><th>....</th><th>Patient Name</th><th>....</th><th>Patient Age</th><th>....</th><th>Patient Blood Group</th><th>....</th><th>Registration  Date</th><th>....</th><th>Registration Time</th></tr> <%
 				   do{%>
 				          <tr><td><input type="radio" name="obeservation" value="<%= rs1.getInt(1) %>"/></td><td></td><td><%= rs1.getString(2)%></td><td></td><td> <%= rs1.getInt(3)%></td>
 				          <td></td><td> <%= rs1.getString(5)%></td><td></td><td> <%= rs1.getDate(6)%></td><td></td><td> <%= rs1.getTime(7)%></td></tr>
 				          <% 
 				    }while(rs1.next());%>
 				     
 				</table>
 				<%
 			}  %> </br></br>
 			
 			
 			
 			
 			
 			 <h6>List Of Pathology Test </h6><%
 			if(rs2.next()==false){
 				out.println("No Test Is Needed...");
 			} else{%>
 				<table>
 				     <tr><th> Test Id </th><th> Test Name </th></tr> <%
 				   do{%>
 				          <tr><td><input type="checkbox" name="testBook" value="<%= rs2.getInt(1) %>"/></td><td><%= rs2.getString(2)%></td></tr>
 				          <% 
 				    }while(rs2.next());%>
 				</table> <%
 				
 				}%></br></br>
 				
 				
 				
 				
 				
 				<h6>List Of latest Consulted Patients</h6><%
 			
 			if(rs3.next()==false){
 				out.println("No Patient Is Visited...");
 			} else{%>
 				<table>
 				     <tr><th> Patient Id </th><th> Test Name </th><th> Description </th></tr> <%
 				   
 				     do{
 				     if(n<5){%>
 				     
 				     <tr><td><%= rs3.getInt(2)%></td><td><%= rs3.getString(4)%></td><td><%= rs3.getString(5)%></td></tr>
 				          <% }
 				     n++;
 				    	 
 				     }while(rs3.next());%>
 				     
 				</table><% 
 				
 			} %> </br></br></br>
 				
 				
 				
 				
 				
 				  	 <h6> Refer Patient To Another  Doctor </h6>
 				 
 				<% if(rs5.next()==false){
 				out.println("No Patients to  refer!...");
 			} else{%>
 				<table>
 				     <tr><th>Patient Id</th><th>....</th><th>Patient Name</th></tr> <%
 				   
 				     do{%>
 				          <tr><td><input type="radio" id="referPati" name="referPati" value="<%= rs5.getInt(1) %>"/></td><td></td><td><%= rs5.getString(2)%></td>
 				          </tr>
 				          <% 
 				    }while(rs5.next());%>
 				     
 				</table>
 				<%
 			}  %> </br></br>
 				 
 				 
 				 <%
 				 
 			if(rs4.next()==false){
 				out.println("No Doctor Is Available For Referal");
 			} else{%>
 				<table>
 				     <tr><th> Doctor Id </th><th>  Doctor Name </th><th>  Doctor's Specialization </th></tr> <%
 				   do{%>
 				          <tr><td><input type="radio" id="referDoc" name="referDoc" value="<%= rs4.getInt(1) %>"/></td><td><%= rs4.getString(2)%></td><td><%= rs4.getString(7)%></td></tr>
 				          <% 
 				    }while(rs4.next());%>
 				</table> <%
 				
 				}%>
 				
 				
 				</br></br> 
 				
 				
 				<%

 				
         } catch(Exception e){
        	 e.getStackTrace();
         }
        	
         %>
         
         <button type="button" onclick="referPatient();">Refer Patient</button></br></br>
           Send This Patient For Testing : <button type="submit" name="pathologyBook" value="pathologyBook">Send In Pathology</button>
         </form></br></br>
         
       
       
        
         
        <!--   <a href="seeConsultation.jsp">Go to Consultation Page</a></br> -->
        <a href ="seeConsultation.jsp">See Pathology Report</a></br>
        
        <a href="historyInput.jsp">See Patient History</a>
    
	</br></br></br></br></br></br></br></br></br></br></br></br></br>

<div class="container-fluid p-1 bg-success text-center text-white">
	<p>@copyright Zoho Hospital</p>
</div>
<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
</html>