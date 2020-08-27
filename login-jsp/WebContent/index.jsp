<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display&display=swap" rel="stylesheet">
    <meta charset="UTF-8">
    <title>Home</title>
    <link href="resources/css/index_styles.css"rel="stylesheet">
</head>
<body>
    <form class="container" action="LoginServlet" method="post">
        <input autocomplete="off" type="text" id="login" name="login" aria-label="login" placeholder="LOGIN"> 
        <input autocomplete="off" type="password" id="senha" name="senha" aria-label="senha" placeholder="SENHA"/>
        <button type="submit">LOGAR</button>
    </form>
</body>
</html>