

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
        <title>Lista de clientes</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <h1>Lista de clientes</h1>
        <table border="1" align="center"  class="table table-hover">
                <thead>
                <tr>
                    <th>Tipo de Documento</th>
                    <th>Número de documento</th>
                    <th>Nombre</th>
                    <th>Telefono</th>
                    <th>Email</th>
                    <th>Dirección</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
        <c:forEach var="a" items="${clientes}">
            <tr>
                <td>${a.clientePK.tipoDocumento}</td>
                <td>${a.clientePK.numDocumento}</td>
                <td>${a.nombre}</td>
                <td>${a.telefono}</td>
                <td>${a.email}</td>
                <td>${a.direccion}</td>                
                <td><a onclick="return confirm('Esta seguro?')" href="ClienteServlet?action=delete&numDocumento=${a.clientePK.numDocumento}
                       &tipoDocumento=${a.clientePK.tipoDocumento}">Delete</a></td>
            </tr>         

            <hr/>      
            <hr/>
          
        </c:forEach>        
    </table>
    </body>
</html>
