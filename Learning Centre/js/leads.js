// $(document).ready(function(){
// 	showAll();
// });

function validate(){
	var name = document.forms.leadDetails.name.value;
	var email = document.forms.leadDetails.email.value;
	var number = document.forms.leadDetails.number.value;
    var course = document.forms.leadDetails.course.value;

	if (isAlpha(name)){
		if (isAlpha(category)){
			addLead();
			return true;
		}
	
	}
		
	return false;
}

function isAlpha(input) {
    var characters = /^[A-Za-z]+$/; // Regular Expression [ ] - Options , A-Z - A,B, C ... Z, ^ - Any 
    if (input.value.match(characters)) {
        return true;
    }
    return false;
}


function addLead() {
			
	var name = document.forms.leadDetails.name.value;
	var email = document.forms.leadDetails.email.value;
	var number = document.forms.leadDetails.number.value;
    var course = document.forms.leadDetails.course.value;
	const detail = JSON.stringify([email, number, course]);
	localStorage.setItem(name, detail);
	showAll();
}

function editLead() {
	var name = document.forms.leadDetails.name.value;
    let data = JSON.parse(localStorage.getItem(name));
	document.forms.leadDetails.email.value = data[0]
    document.forms.leadDetails.number.value = data[1]
    document.forms.leadDetails.course.value = data[2];
}

function deleteLead() {
	var name = document.forms.leadDetails.name.value;
	localStorage.removeItem(name);
	showAll();
    document.forms.leadDetails.name.value = null;
	document.forms.leadDetails.email.value = null;
	document.forms.leadDetails.number.value = null;
	document.forms.leadDetails.course.value = null;
}

function clearAll() {
	localStorage.clear();
	showAll();
	document.forms.leadDetails.name.value = null;
	document.forms.leadDetails.email.value = null;
	document.forms.leadDetails.number.value = null;
    document.forms.leadDetails.course.value = null;
}

// dynamically draw the table

function showAll() {

		var key = "";
		var list = "<tr><th>Name</th><th>Email</th><th>Number</th><th>Course</th></tr>\n";
		var i = 0;

		if (localStorage.length == 0) {
			list += "<tr><td><i>empty</i></td><td><i>empty</i></td><td><i>empty</i></td><td><i>empty</i></td></tr>\n";
		  } else {
			for (i = 0; i < localStorage.length; i++) {

			  key = localStorage.key(i);
			  let data = JSON.parse(localStorage.getItem(key));

			  list += "<tr><td>" + key + "</td>\n<td>" +
				data[0] + "</td>\n<td>" + data[1] + "</td>\n<td>" + data[2] + "</td></tr>\n";

			}
		}
		document.getElementById('list').innerHTML = list;

}
