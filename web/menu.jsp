<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty login}">
    
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Concesionario de Autos</a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="login.jsp">Login</a></li>              
            </ul>
        </div>
    </nav>
</c:if>

<c:if test="${not empty login}">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Concesionario de Autos</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="manager.jsp">Home</a></li>
                <li><a href="AccountServlet?action=logout">Cerrar sesión</a></li>
                <li>   <a href="ClienteServlet?action=list">Listar Clientes</a></li>
                <li>   <a href="VehiculoServlet?action=list">Listar Vehiculos</a></li>
                <li>  <a href="VentasServlet?action=list">Listar Ventas</a></li>
                <li>   <a href="insertClient.jsp">Inserte un cliente</a></li>
                <li>   <a href="insertVehiculo.jsp">Inserte un vehiculo</a></li>
                <li>   <a href="insertVenta.jsp">Inserte una venta</a></li>
                <li>    <a href="buscarVehiculo.jsp">Búsqueda de vehiculo</a></li>
            </ul>
        </div>
    </nav>
</c:if>
<hr/>