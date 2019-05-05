<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter"%>
<%@page isErrorPage="true" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1 >Ufff que pena ocurrio un error en la aplicación</h1>
        <%
            String mensage = (String) request.getAttribute("mensage");
            if (mensage != null) {
                out.print("El mensaje de error es: ");
                out.print(mensage + "<br/>" );
            }
            String trazaPila = (String) request.getAttribute("trazaPila");
            if (trazaPila != null) {
                out.print("La traza de la pila es: " + "<br/>");
                out.print(trazaPila);
            }
        %>
    </body>
</html>
