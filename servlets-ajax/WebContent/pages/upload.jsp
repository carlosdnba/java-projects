<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
	<input type="file" id="input" name="file" onchange="uploadFile()">
	<img alt="Imagem" src="" id="target" height="400px">
</body>
<script type="text/javascript">

	function uploadFile() {
		var target = document.querySelector("#target");
		var file = document.querySelector("#input").files[0];
		
		var reader = new FileReader();
		
		reader.onloadend = function() {
			target.src = reader.result;
		}
		
		if(file) {
			reader.readAsDataURL(file);

// 			--- upload ajax ---
			$.ajax({
				method: "POST",
				url: "/servlets-ajax/pages/fileUpload",
				data: {
					fileUpload: target.src
				}
			}).done(function(response) {
				alert("Sucesso: " + responde);
			}).fail(function(xhr, status, errorThrown) {
				alert("Error: " + xhr.responseText);
			});
			
		} else {
			target.src="";
		}
	}
</script>
</html>