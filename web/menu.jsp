<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty login}">
    <a href="login.jsp">Login</a>
</c:if>

<c:if test="${not empty login}">
    <a href="AccountServlet?action=logout">Logout</a>
    <a href="AccountServlet?action=list">ListClientes</a>
    <a href="AccountServlet?action=list">ListVehiculos</a>
    <a href="AccountServlet?action=list">ListVentas</a>
    <a href="insertClient.jsp">Inserte un vehiculo</a>
    <a href="insertVehiculo.jsp">Inserte una venta</a>
    <a href="insertVenta.jsp">Inserte un cliente</a>
</c:if>
<hr/>