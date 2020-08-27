<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página pai</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
 	<a href="../index.jsp" > Página Inicial </a><br>
	<h1>Página pai load jquery</h1>
	<input type="button" value="Carregar página" onclick="carregar();">
	
	<div id="mostrarPaginaFilha"> <!-- carregamento  da pagina -->
	
	</div>
</body>
	
	<script type="text/javascript">
		function carregar() {
			$("#mostrarPaginaFilha").load('paginaFilha.jsp'); // carrega a pagina filha com JQuery
		}
	</script>
	
</html>