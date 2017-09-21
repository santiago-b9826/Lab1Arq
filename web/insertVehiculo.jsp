
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserción de vehiculo</title>
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
            <form action="VehiculoServlet?action=insert" method="post" enctype="multipart/form-data">

                <table>
                    <tr>
                        <th>  <label><b>Placa:</b></label> </th>
                        <th> 
                            <input type="text"  class="form-control" name="placa" required=""/>
                        </th>
                    </tr>
                    <tr>
                        <th> <label><b>Ciudad:</b></label></th>
                        <th><input type="text" class="form-control" name="ciudad"
                                   required=""/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Modelo:</b></label></th>
                        <th><input type="number" class="form-control" name="modelo"
                                   required=""/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Marca:</b></label></th>
                        <th><input type="text" class="form-control" name="marca"
                                   required=""/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Referencia:</b></label></th>
                        <th><input type="text"  class="form-control" name="referencia"
                                   required=""/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Precio:</b></label></th>
                        <th><input type="number"  class="form-control" name="precio"
                                   required=""/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Especificaciones:</b></label></th>
                        <th><input type="text"  class="form-control" name="especificaciones"
                                   required=""/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Color:</b></label></th>
                        <th><input type="text"  class="form-control" name="color"
                                   required=""/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Seleccione la imagen deseada:</b></label></th>
                        <th><input type="file" class="form-control"  name="file"
                                   required=""/> </th>
                    </tr>

                    <div class="break"></div>                        
                    </div>
                    <tr>
                        <td colspan="2">
                            <input class="btn icon-btn btn-success" type="submit" name="action" value="insert">
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

    