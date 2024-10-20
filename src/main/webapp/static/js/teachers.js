function fetchTeachersFromJSON() {
    let lastName = $('#searchInput').val().trim();
    
    let ajaxRequest = new XMLHttpRequest();
    ajaxRequest.open('GET', `/TeachersWebApp/TeacherSearchJSONController?searchInput=${lastName}`, true);
    ajaxRequest.send();

    ajaxRequest.onreadystatechange = function() {
        if (ajaxRequest.readyState == 4) {
            if (ajaxRequest.status == 200) {
                handleResults(JSON.parse(ajaxRequest.responseText));
            } else {
                alert('ERROR');
            }
        }
    }
}

function handleResults(response) {
    let teachersList = response;

    if (jQuery.isEmptyObject(response)) {
    	$(".teachers-list").html("No teacher is found");
    } else {   
	    let output = "<tr><th>Id</th><th>Όνομα</th><th>Επώνυμο</th></tr>";
	
	    for (let teacher of teachersList) {
	        output += "<tr><td>"
	        + teacher.id
	        + "</td><td>"
	        + teacher.firstName
	        + "</td><td>"
	        + teacher.lastName
	        + "</td></tr>";
	    }
	
	    $(".teachers-list").html(output);
    }
}