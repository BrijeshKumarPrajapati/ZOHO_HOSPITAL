/**
 * 
 */

function submitPatient() {
	
  var name = $('#patiName').val();
  var age = $('#patiAge').val();
  var mobile = $('#patiMobile').val();
  var bloodGroup = $('#patiBG').val();
	

	var patientDetails = {
	Name: name,
	Age: age,
	Mobile: mobile,
	BloodGroup: bloodGroup,
	};

	$.ajax({
	type: 'POST',
	url: '/ZOHO_HOSPITAL/pReg',
	contentType: 'application/json; charset=UTF-8',
	data: JSON.stringify(patientDetails),
	success: function(data) {
	console.log("Post successfully created!");
	window.alert("New Patient Added Successfully...");
	document.location.href = "http://localhost:8008/ZOHO_HOSPITAL/jsp/Receptionist.jsp";
	}
	});
	}
	
	
	
	