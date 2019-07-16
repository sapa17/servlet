// Run function when DOM Content has loaded
document.addEventListener('DOMContentLoaded', init);

// Function to run when DOM Content has loaded
function init(event) {

	// Get registration form and keep in global scope
	regForm = document.forms['registration'];
	
	

	// Listen for form submit
	regForm['register'].onclick = validateForm; 
}


function valdiateformat(){
	
}
// Function to validate form elements
function validateForm(event) {

	// Array to contain all error messages
	var errorMessages = Array();

	// If ID is empty
	if(!regForm['empID'].value) {
		errorMessages.push('* Please enter ID');
	}

	// If name is empty
	if(!regForm['empName'].value) {
		errorMessages.push('* Please enter employee name');
	}

	// If salary is empty
	if(!regForm['empSalary'].value) {
		errorMessages.push('* Please enter employee salary');
	}
	
	//If mobile is empty
	if(!regForm['empMobile'].value) {
		errorMessages.push('* Please enter your mobile');
	}
	
	//If address is empty
	if(!regForm['empAddress'].value) {
		errorMessages.push('* Please fill  your address');
	}

  // Show error messages
	displayErrors(errorMessages);
  
	// If there are errors
	if(errorMessages.length) {
		// Stop the form from submitting
		return false;
	}
  
  
}

function displayErrors(errors) {
	var errorBox = document.getElementById('errorMessages');
  
  // If there aren't any errors
	if(!errors.length) {
		errorBox.innerHTML = '';
    return false;
	}

	// Get reference to error box
	var errorBox = document.getElementById('errorMessages');

	// Prepare a container to hold the completed error message string
	var messageString = '<ul>';

	// Loop through each error to display
	for(var i=0; i<errors.length; i++) {
		messageString += '<li>' + errors[i] + '</li>';
	}

	messageString += '</ul>';

	errorBox.innerHTML = messageString;
}