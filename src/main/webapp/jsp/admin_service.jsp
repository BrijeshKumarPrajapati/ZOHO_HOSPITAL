<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Service</title>
 <%@ page import="java.sql.*" %>
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
	
	<h5>Register New Employee</h5>
	<a href="docReg.jsp">Register Doctor</a></br>
	<a href="pathReg.jsp">Register Pathologist</a></br>
	<a href="pharmReg.jsp">Register Pharmasist</a></br>
	<a href="recReg.jsp">Register Receptionist</a></br></br></br>
<%
try{ 
	Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Demo@123");
		System.out.println("Connection is : " + con);
		
		
		Statement stmt1 = con.createStatement();
		String qry1 = "SELECT * FROM  user_dtls";
		ResultSet rs1 = stmt1.executeQuery(qry1);  %> </br><%

		if(rs1.next()==false){
			out.println("No Employee...New Employee Needed");
		} else{ %>
			<table>
			     <tr><th>Doctor Id</th><th>.</th><th>Doctor Name</th><th>.</th><th>Specialization</th></tr> <%
			  do{%>
			       <% if(rs1.getString(5).equals("doctor")){ %>
			          <tr><td><%= rs1.getInt(1) %></td><td></td><td><%= rs1.getString(2)%></td><td></td><td> <%= rs1.getString(7)%></td></tr>
			          <%  
			     } 
			     }while(rs1.next());%>
			     
			</table>
			<%
		}  %> </br><%
		
		
		ResultSet rs2 = stmt1.executeQuery(qry1);
		
		if(rs2.next()==false){
			out.println("No Employee...New Employee Needed");
		} else{ %>
			<table>
			     <tr><th>Pathologist Id</th><th>.</th><th>Pathologist Name</th><th>.</th><th>Specialization</th></tr> <%
			     do{%>
			              <% if(rs2.getString(5).equals("path")){ %>
			                     <tr><td><%= rs2.getInt(1) %></td><td></td><td><%= rs2.getString(2)%></td><td></td><td> <%= rs2.getString(7)%></td></tr>
			                             <%  
			     } 
			     }while(rs2.next());%> 
			</table>
			<%
		}  %> </br> <% 
		
		
       ResultSet rs3 = stmt1.executeQuery(qry1);
		
		if(rs3.next()==false){
			out.println("No Employee...New Employee Needed");
		} else{ %>
			<table>
			     <tr><th>Pharmasist Id</th><th>.</th><th>Pharmasist Name</th><th>.</th><th>Specialization</th></tr> <%
			     do{%>
			              <% if(rs3.getString(5).equals("pharma")){ %>
			                     <tr><td><%= rs3.getInt(1) %></td><td></td><td><%= rs3.getString(2)%></td><td></td><td> <%= rs3.getString(7)%></td></tr>
			                             <%  
			     } 
			     }while(rs3.next());%> 
			</table>
			<%
		}  %> </br> <%
		
		
     ResultSet rs4 = stmt1.executeQuery(qry1);
		
		if(rs4.next()==false){
			out.println("No Employee...New Employee Needed");
		} else{ %>
			<table>
			     <tr><th>Receptionist Id</th><th>.</th><th>Receptionist Name</th><th>.</th><th>Specialization</th></tr> <%
			     do{%>
			              <% if(rs4.getString(5).equals("receptionist")){ %>
			                     <tr><td><%= rs4.getInt(1) %></td><td></td><td><%= rs4.getString(2)%></td><td></td><td> <%= rs4.getString(7)%></td></tr>
			                             <%  
			     } 
			     }while(rs4.next());%> 
			</table>
			<%
		}  
		%> </br></br> <%
 } catch(Exception e){
	 e.getStackTrace();
 }	
 %> </br></br></br>
	 
	 <h5>Get Patient History</h5>
	<a href="historyInput.jsp">Patient History</a></br></br></br></br>
	
	
	
	
	
	
	<h5>Add and Update Pathology, Medicine</h5>
	 <form action="/ZOHO_HOSPITAL/testUPDATE" method="post">
      <h6>Add New Test</h6>
      Test Name: <input type ="text" name="testAddName"/></br></br>
      Test Price    : <input type="number" name="testAddPrice"/></br></br>
      Submit Details : <button type="submit" name="testSubmit" value="testSubmit">Add New Test</button></br></br>
     
      
      <h6>Update Price Of Test</h6>
      Enter Test Name: <input type="text" name="testItem"/></br></br>
      Enter New Test Price: <input type="number" name="oldPrice"/></br></br>
      Submit :<button type="submit" name="updateTestSubmit" value="updateTestSubmit">Update New Test Price</button></br></br>
     </form>
	
	
	
	<form action="/ZOHO_HOSPITAL/medicineUPDATE" method="post">
      <h6>Add New Medicine</h6>
      Medicine Name: <input type ="text" name="medicineAddName"/></br></br>
      Medicine Price    : <input type="number" name="medicineAddPrice"/></br></br>
      Submit Details : <button type="submit" name="medicineSubmit" value="medicineSubmit">Add New Medicine</button></br></br>
     
      
      <h6>Update Price Of Medicine</h6>
      Enter Medicine Name: <input type="text" name="testItem"/></br></br>
      Enter New Medicine Price: <input type="number" name="oldPrice"/></br></br>
      Submit :<button type="submit" name="updateMedicineSubmit" value="updateMedicineSubmit">Update New Medicine Price</button></br></br>
     </form> </br></br>
	
	<div class="container-fluid p-1 bg-success text-center text-white">
	<p>@copyright Zoho Hospital</p>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</div>
</body>
</html>