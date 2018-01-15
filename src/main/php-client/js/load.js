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
		
		var canv = document.createElement('canvas');
		var ctx = canv.getContext('2d');
		var img = document.getElementById('myImage');
		ctx.drawImage(img, 10, 10);
		canv.putImageData(jsonReply.imgArray, 10, 10);
		
		
		
		document.getElementById('myImage').src = "data:image/jpg;base64, " + jsonReply.imgArray;
		
	});
	
}