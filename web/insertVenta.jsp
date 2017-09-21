
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserción de ventas</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <h1>Por favor llene todos los campos adecuadamente</h1>
        <div class="container well">
            <form action="VentasServlet?action=insert" method="post">

                <table>
                    <tr>
                        <th>  <label><b>Placa y ciudad:</b></label> </th>
                        <th> 
                            <input type="text"  class="form-control" name="placaciudad" required=""/>
                        </th>
                    </tr>
                    <tr>
                        <th> <label><b>Número de documento:</b></label></th>
                        <th><input type="number"  class="form-control" name="numdoc"
                                   required=""/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Número de venta:</b></label></th>
                        <th><input type="number"  class="form-control" name="numventa"
                                   required=""/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Total venta:</b></label></th>
                        <th><input type="number"  class="form-control" name="totalventa"
                                   required=""/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Cantidad:</b></label></th>
                        <th><input type="number" class="form-control" name="cantidad"
                                   required=""/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Fecha:</b></label></th>
                        <th><input type="date"class="form-control" name="fecha"
                                   required=""/> </th>
                    </tr>


                    <div class="break"></div>                        
                    </div>
                    <tr>
                        <td colspan="2">
                            <input class="btn icon-btn btn-success" type="submit" name="action" value="Insertar">
                            <span class="glyphicon glyphicon-ok-sign"></span>

                            <!--            <span class="glyphicons glyphicons-user-add img-circle text-success"></span>-->
                            <input class="btn btn-info btn-lg" type="reset" name="action" value="Reset">
                            <span class="glyphicon glyphicon-remove"></span>
                        </td>
                    </tr>
                </table>
            </form>   
            <br>
        </div>
    </body>
</html>

    