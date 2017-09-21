

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
