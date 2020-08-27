<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Capturar exceções</title>
<link href="https://fonts.googleapis.com/css2?family=Fira+Code&display=swap" rel="stylesheet">
<link rel="stylesheet" href="assets/fontStyles.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
 	<a href="../index.jsp" > Página Inicial </a><br>
	<h1>Capturar exceções com jquery</h1>
	<input type="text" placeholder="Valor informado" id="txtvalor">
	<input type="button" onclick="testeExcecao()" value="Testar exceção">

	<script type="text/javascript">
		function testeExcecao() {
			let valorInformado = ($('#txtvalor').val());
			
			$.ajax({
				method: "POST",
				url: "capturarExcecoes", // vamo mandar pra uma servlet
				data: { valorParam: valorInformado }
			}).always(function(response) {
				alert(response);
			});
		}
	</script>
</body>
</html>