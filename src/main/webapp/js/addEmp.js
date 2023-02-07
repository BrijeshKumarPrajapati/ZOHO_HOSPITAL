/**
 * 
 **/

function submitForm() {
	var fullName = $('#name').val();
	var email = $('#email').val();
	var password = $('#pass').val();
	var role = $('#role').val();
	var mobile = $('#mobile').val();
	var age = $('#age').val();
	var specialization = $('#specialization').val();

	var empDetails = {
		name: '',
		email: '',
		password: '',
		role: '',
		mobile: '',
		age: '',
		specialization: ''
	};


	empDetails.name = fullName;
	empDetails.email = email;
	empDetails.password = password;
	empDetails.role = role;
	empDetails.mobile = mobile;
	empDetails.age = age;
	empDetails.specialization = specialization;
	// consol.log(empDetails);


	let post = JSON.stringify(empDetails)
	const url = "/ZOHO_HOSPITAL/Reg";
	let xhr = new XMLHttpRequest()


	xhr.open('POST', url, true);
	xhr.setRequestHeader('Content-type', 'application/json; charset=UTF-8');
	xhr.send(post);



	xhr.onload = function() {
		if (xhr.status === 200) {
			console.log("Post successfully created!")
			window.alert("New Employee Added Successfully...");
			document.location.href = "http://localhost:8008/ZOHO_HOSPITAL/jsp/admin_service.jsp";

		}
	}

}











