<%-- 
    Document   : listVehiculos
    Created on : 17/09/2017, 12:40:44 PM
    Author     : Santiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <h1>Lista de Vehiculos</h1>
        <c:forEach var="a" items="${vehiculos}">
           |${a.vehiculoPK.placa}| |${a.vehiculoPK.ciudad}| |${a.modelo}||${a.marca}||${a.referencia}||${a.precio}||${a.especificaciones}||${a.color}||${a.image}|
           <a onclick="return confirm('Esta seguro?')" href="VehiculoServlet?action=delete&placa=${a.vehiculoPK.placa}&ciudad=${a.vehiculoPK.ciudad}">Delete</a>
           <hr/>
        </c:forEach>        
        
    </body>
</html>
