<%-- 
    Document   : buscarVehiculo
    Created on : 18/09/2017, 03:28:13 PM
    Author     : Andrés Moreno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busqueda vehiculo</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <h1>Ingrese la placa del vehiculo que desea buscar</h1>
        <form action="VehiculoServlet?action=buscar" method="post">
            <table>
                    <tr>
                        <th>  <label><b>Placa:</b></label> </th>
                        <th> 
                            <input type="text" placeholder="Ingresar Placa " class="form-control" name="placa" required=""/>
                        </th>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input class="btn btn-info btn-lg" type="submit" name="action" value="Buscar">
                            <span class="glyphicon glyphicon-lock"></span>
                        </td>
                    </tr>
                </table>
        </form>
    </body>
</html>
