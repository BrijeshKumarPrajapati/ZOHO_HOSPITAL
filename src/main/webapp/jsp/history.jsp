<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="com.connection.Conn" %>
<%  double mobile = (double) request.getAttribute("Mobile");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>History</title>
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

	<form> <%
                       int patientId = 0;
                       int testCost=0;
                       int medicineCost=0;
                       int registrationCost=0;
                       int total =0;
                       int i=0;
                      
         try{
        	 
 			Connection con = Conn.getCon();
 			System.out.println("Connection is : " + con);
 			
 			
 			Statement stmt1 = con.createStatement();
 			String qry1 = "SELECT * FROM  patient WHERE pMobile = "+mobile+"";
 			ResultSet rs1 = stmt1.executeQuery(qry1);
 			
 			
 			if(rs1.next()==false){
 				out.println("No Records Found !...");registrationCost=0;
 				
 			} else{ %><h6>History Of <%= rs1.getString(2)%>  having patient Id "<%= rs1.getInt(1)%>"</h6><%
 					patientId = rs1.getInt(1);
 			}  %> </br></br>
 			
 			
         
         </br> <h6> List Of Test and Test Reports </h6> <%


     Statement stmt2 = con.createStatement();
	 String qry2 = "SELECT * FROM  testUser WHERE pId = "+patientId+" AND tStatus = "+1+"";
	 ResultSet rs2 = stmt2.executeQuery(qry2);


 			
 			if(rs2.next()==false){
 				out.println("No Previous Records Are Available!...");
 				registrationCost=0;
 				
 			} else{%>
 				<table>
 				     <tr><th> Test Name </th><th> Discription </th> <th> Test Charge </th> <th> Date </th> <th> Time </th></tr> <%
 				   
 				     do{%>
 				          <tr><td><%= rs2.getString(4)%> </td><td><%= rs2.getString(5)%></td><td><%= rs2.getString(3)%></td> <td> <%= rs2.getDate(8) %> </td> <td> <%= rs2.getTime(9)%> </td></tr>
 				          <% 
 				          
 				          testCost= testCost + rs2.getInt(3);
 				          i++;
 				    	 
 				     }while(rs2.next());%>
 				     
 				</table> </br></br></br>
 				<%
 			}
 			
 		%>
            <h6>List Of Medicine </h6>
 		
 			<%
 			 Statement stmt3 = con.createStatement();
 			 String qry3 = "SELECT * FROM  medicineUser WHERE pId = "+patientId+" AND mStatus="+1+"";
 			 ResultSet rs3 = stmt3.executeQuery(qry3);	
 			System.out.print(i);
 			if(rs3.next()==false){
 				out.println("No Previous Medicine Report Is Available!...");
 				registrationCost=0;
 			} else{%>
 				<table>
 				     <tr><th> Medicine Name </th><th> Medicine Charge </th> <th> Date </th> <th> Time </th></tr> <%
 				   
 				     do{%>
 				          <tr><td><%= rs3.getString(2)%> </td><td><%= rs3.getInt(4)%> </td> <td> <%= rs3.getDate(6) %> </td> <td> <%= rs3.getTime(7)%> </td></tr>
 				          <% 
 				          
 				          medicineCost= medicineCost + rs3.getInt(4);
 				          i++;
 				    	
 				     }while(rs3.next());%>
 				     
 				</table> </br></br><%
 			}
 			
 			if(i>0){
 				registrationCost=500;
 			}
 			 total = registrationCost + testCost + medicineCost;%> </br> <%
 			out.println("Registration Charge is: "+registrationCost+"/-");%> </br><% 
 			out.println("Total Test Charges: "+ testCost+"/-");%> </br> <% 
 			out.println("Total Medicine Charges: "+medicineCost+"/-");%> </br> <% 
 			out.println("Total Payble Amount Is : "+total+"/-");
 			
         } catch(Exception e){
        	 e.getStackTrace();
         }
        	
         %></br></br>  
           <button type="button" onclick = "myPrint()"> Print HIstory</button>
         </form></br></br>
	
	





</br></br></br></br></br></br></br></br></br></br></br></br>
<div class="container-fluid p-1 bg-success text-center text-white">
	<p>@copyright Zoho Hospitals</p>
</div>
<script type="text/javascript">

function myPrint(){
	window.print();
}

</script>

<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>