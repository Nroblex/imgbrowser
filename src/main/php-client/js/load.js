function loadImage(callback){
	
	
	var oRequest = new XMLHttpRequest();
	oRequest.overrideMimeType("application/json");
	oRequest.open("GET", "include/fetch.php", true);

	oRequest.onreadystatechange = function(){
		
		
		if (oRequest.readyState == 4 && oRequest.status == "200") {
            callback(oRequest.responseText);
        }
		
	}
	
	
	oRequest.send(null);
}

function randomImage(){
	
	loadImage(function(response){
		
		var jsonReply = JSON.parse(response);
		var pp = jsonReply[0].imgArray;
		var x = "1";
	});
	
}