/**
 * 
 */
 
 function referPatient()
	{
	      var patientId= $('#referPati').val();
	      var doctorId = $('#referDoc').val();
	      
	      
	      var referPat = {pId:'', 
	      user_Id:''
	      };
	      referPat.pId = patientId;
	      referPat.user_Id = doctorId;
	      
	     // consol.log(empDetails);
	     
	      let post = JSON.stringify(referPat)
	      const url = "/ZOHO_HOSPITAL/refer";
		  let xhr = new XMLHttpRequest()
	     
	      
	      xhr.open('POST', url, true);
		  xhr.setRequestHeader('Content-type', 'application/json; charset=UTF-8');
		  xhr.send(post);
	      
	      
	      
		  xhr.onload = function() {
			if (xhr.status === 200) {
				console.log("Post successfully created!")
				window.alert("The patient has been refered...");
				document.location.href = "http://localhost:8008/ZOHO_HOSPITAL/jsp/doctor_login.jsp";
				
			}
		 }
	      
	}