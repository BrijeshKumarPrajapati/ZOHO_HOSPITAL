/**
 * 
 **/
 
 var empDetails = {

};


function submitForm()
	{
	      var fullName= $('input[name=Name]').val();
	      var email = $('input[name=Email]').val();
	      var password = $('input[name=Pass]').val();
	      var role = $('input[name=Role]').val();
	      var mobile = $('input[name=Mobile]').val();
	      var age = $('input[name=Age]').val();
	      var specialization = $('input[name=Specialization]').val();
	      var empDetails = {"name": fullName, "email": email, "password": password, "role": role, "mobile": mobile, "age": age, "specialization": specialization};
	     
	   
	      let post = JSON.stringify(empDetails)
	      const url = "/ZOHO_HOSPITAL/Reg";
		  let xhr = new XMLHttpRequest()
	      
	      
	      xhr.open('POST', url, true)
		  xhr.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
		  xhr.send(post);
	      
	      
	      
		  xhr.onload = function() {
			if (xhr.status === 200) {
				console.log("Post successfully created!")
				
			}
		 }
	      
	}









 
 
 