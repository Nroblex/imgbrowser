<?php
	header("HTTP/1.1 200 OK");
	ini_set("allow_url_fopen", 1);
	$json = file_get_contents('http://localhost:9091/img/images/picture');
	
	echo $json;
	
	//$obj = json_decode($json);
	//echo $obj->imgArray;
?>

