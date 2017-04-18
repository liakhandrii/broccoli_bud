//JavaScript, use pictures as buttons, sends and receives values to/from the Rpi
//These are all the buttons
var b0 = 24;
var b1 = 27;
var b2 = 25;
var b3 = 28;

var button_0 = document.getElementById("button_" + b0);
var button_1 = document.getElementById("button_" + b1);
var button_2 = document.getElementById("button_" + b2);
var button_3 = document.getElementById("button_" + b3);


//this function sends and receives the pin's status
function change_pin (pin, status) {
	//this is the http request
	var request = new XMLHttpRequest();
	request.open( "GET" , "gpio.php?pin=" + pin + "&status=" + status );
	request.send(null);
	//receiving information
	request.onreadystatechange = function () {
		if (request.readyState == 4 && request.status == 200) {
			return (parseInt(request.responseText));
		}
	//test if fail
		else if (request.readyState == 4 && request.status == 500) {
			alert ("server error");
			return ("fail");
		}
	//else 
		else { return ("fail"); }
	}
}

//these are all the button's events, it just calls the change_pin function and updates the page in function of the return of it.
button_0.addEventListener("click", function () { 
	//if red
	if ( button_0.alt === "off" ) {
		//use the function
		var new_status = change_pin ( b0, 1);
		if (new_status !== "fail") { 
			button_0.alt = "on"
			button_0.src = "data/img/green/green_" + b0 + ".png"; 
			return 0;
			}
		}
	//if green
	if ( button_0.alt === "on" ) {
		//use the function
		var new_status = change_pin ( b0, 0);
		if (new_status !== "fail") { 
			button_0.alt = "off"
			button_0.src = "data/img/red/red_" + b0 + ".png"; 
			return 0;
			}
		}
} );
	
button_1.addEventListener("click", function () { 
	//if red
	if ( button_1.alt === "off" ) {
		//use the function
		var new_status = change_pin ( b1, 1);
		if (new_status !== "fail") { 
			button_1.alt = "on"
			button_1.src = "data/img/green/green_" + b1 + ".png"; 
			return 0;
			}
		}
	//if green
	if ( button_1.alt === "on" ) {
		//use the function
		var new_status = change_pin ( b1, 0);
		if (new_status !== "fail") { 
			button_1.alt = "off"
			button_1.src = "data/img/red/red_" + b1 + ".png"; 
			return 0;
			}
		}
} );
	
button_2.addEventListener("click", function () { 
	//if red
	if ( button_2.alt === "off" ) {
		//use the function
		var new_status = change_pin ( b2, 1);
		if (new_status !== "fail") { 
			button_2.alt = "on"
			button_2.src = "data/img/green/green_" + b2 + ".png"; 
			return 0;
			}
		}
	//if green
	if ( button_2.alt === "on" ) {
		//use the function
		var new_status = change_pin ( b2, 0);
		if (new_status !== "fail") { 
			button_2.alt = "off"
			button_2.src = "data/img/red/red_" + b2 + ".png"; 
			return 0;
			}
		}
} );
	
button_3.addEventListener("click", function () { 
	//if red
	if ( button_3.alt === "off" ) {
		//use the function
		var new_status = change_pin ( b3, 1);
		if (new_status !== "fail") { 
			button_3.alt = "on"
			button_3.src = "data/img/green/green_" + b3 + ".png"; 
			return 0;
			}
		}
	//if green
	if ( button_3.alt === "on" ) {
		//use the function
		var new_status = change_pin ( b3, 0);
		if (new_status !== "fail") { 
			button_3.alt = "off"
			button_3.src = "data/img/red/red_" + b3 + ".png"; 
			return 0;
			}
		}
} );
