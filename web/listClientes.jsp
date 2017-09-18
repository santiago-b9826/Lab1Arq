<%-- 
    Document   : listClientes
    Created on : 17/09/2017, 12:36:01 PM
    Author     : Santiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de clientes</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <h1>Lista de clientes</h1>
        <c:forEach var="a" items="${clientes}">
           |${a.typedoc}| |${a.numdoc}| |${a.nombre}||${a.telefono}||${a.email}|||${a.direccion}|
           <a onclick="return confirm('Esta seguro?')" href="ClienteServlet?action=delete&id=${a.numdoc}">Delete</a>        
           <hr/>
        </c:forEach>        
        
    </body>
</html>
