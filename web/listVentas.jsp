<%-- 
    Document   : listVentas
    Created on : 17/09/2017, 12:36:59 PM
    Author     : Santiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Ventas</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <h1>Lista de Ventas</h1>
        <c:forEach var="a" items="${ventas}">
           |${a.placaciudad}| |${a.numdocumento}| |${a.numventa}||${a.totalventa}||${a.cantidad}||${a.fecha}|
           <a onclick="return confirm('Esta seguro?')" href="VentasServlet?action=delete&id=${a.placaciudad}">Delete</a>        
           <hr/>
        </c:forEach>        
        
    </body>
</html>
