<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter"%>
<%@page isErrorPage="true" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Royal Music Error</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1 >Ha ocurrido un error en la aplicación</h1>
        
        <%
            // metodo para traer las variables de sesion capturadas en servlet Login y mostrarlas
            String message = (String) request.getAttribute("message");
            if (message != null) {
                out.print("<b>" + "El mensaje de error es: " + "</b>" + "<br/>");
                out.print(message + "<br/>" );
            }
            String StackTrace = (String) request.getAttribute("StackTrace");
            if (StackTrace != null) {
                out.print("<b>" + "La traza de la pila es: " + "</b>" + "<br/>");
                out.print(StackTrace + "<br/>");
            }
        %>
    </body>
</html>
