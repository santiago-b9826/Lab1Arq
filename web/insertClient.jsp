
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserción de cliente</title>
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
            <form action="ClienteServlet?action=insert" method="post">

                <table>
                    <tr>
                        <th>  <label><b>Tipo de documento:</b></label> </th>
                        <th> 
                            <input type="text" maxlength="5" class="form-control" name="tipodoc" required=""/>
                        </th>
                    </tr>
                    <tr>
                        <th> <label><b>Número de documento:</b></label></th>
                        <th><input type="number"  class="form-control" name="numdoc"
                                   required=""/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Nombre:</b></label></th>
                        <th><input type="text"  class="form-control" name="nombre"
                                   required=""/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Dirección:</b></label></th>
                        <th><input type="text"  class="form-control" name="direccion"
                                   required=""/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Telefono:</b></label></th>
                        <th><input type="number" p class="form-control" name="telefono"
                                   required=""/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Email:</b></label></th>
                        <th><input type="email"  class="form-control" name="email"
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

