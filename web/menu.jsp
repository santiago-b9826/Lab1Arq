<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty login}">
    <a href="login.jsp">Login</a>
</c:if>

<c:if test="${not empty login}">
    <a href="AccountServlet?action=logout">Cerrar sesión ||</a>
    <a href="ClienteServlet?action=list">Listar Clientes ||</a>
    <a href="VehiculoServlet?action=list">Listar Vehiculos ||</a>
    <a href="VentasServlet?action=list">Listar Ventas ||</a>
    <a href="insertClient.jsp">Inserte un cliente ||</a>
    <a href="insertVehiculo.jsp">Inserte un vehiculo ||</a>
    <a href="insertVenta.jsp">Inserte una venta ||</a>
    <a href="buscarVehiculo.jsp">Búsqueda de vehiculo ||</a>
</c:if>
<hr/>