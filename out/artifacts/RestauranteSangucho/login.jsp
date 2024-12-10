
<%--
  Created by IntelliJ IDEA.
  User: ADMIN-ITQ
  Date: 25/11/2024
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formualrio de sesion </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h1 class="text-center mb-4">Formulario de login</h1>
    <form action="/RestauranteSangucho/loginServlet" method="post" class="p-4 border rounded bg-white shadow-sm">
        <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <input type="text" name="username" id="username" class="form-control" >
        </div>

        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" name="password" id="password" class="form-control" >
        </div>

        <div class="mb-3">
            <label for="role" class="form-label">Rol</label>
            <select name="role" id="role" class="form-select" >
                <option value="">Seleccione un rol</option>
                <option value="admin">Administrador</option>
                <option value="cocinero">Cocinero</option>
                <option value="mesero">Mesero</option>
            </select>
        </div>

        <div class="mb-3 text-center">
            <input type="submit" value="Enviar" class="btn btn-primary">
        </div>
    </form>

    <div class="text-center mt-3">
        <p><a class="btn btn-success" href="<%=request.getContextPath()%>/index.html">Ir al inicio</a></p>
    </div>
</div>

</body>
</html>
