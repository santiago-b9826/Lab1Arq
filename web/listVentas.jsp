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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Ventas</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
            <h1>Lista de Ventas</h1>
            <table border="1" align="center"  class="table table-hover">
                <thead>
                <tr>
                    <th>Placa y ciudad</th>
                    <th>Número de documento</th>
                    <th>Número de venta</th>
                    <th>Total de venta</th>
                    <th>Cantidad</th>
                    <th>Fecha</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
        <c:forEach var="a" items="${ventas}">
            <tr>
                <td>${a.placaCiudad}</td>
                <td>${a.ventasPK.numDocumento}</td>
                <td>${a.ventasPK.numVenta}</td>
                <td>${a.totalVenta}</td>
                <td>${a.cantidad}</td>
                <td>${a.fecha}</td>                
                <td><a onclick="return confirm('Esta seguro?')" href="VentasServlet?action=delete&numDocumento=${a.ventasPK.numDocumento}&numVenta=${a.ventasPK.numVenta}" >
                        Delete</a>   </td>
            </tr>         

            <hr/>      
            <hr/>
        </c:forEach>        
    </table>
</body>
</html>
