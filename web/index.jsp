<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Royal Music</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header>
            <h1>Bienvenido a Royal Music</h1>
        </header>

        <center>
            <img src="Images/equalizer-153212_1280.png" alt="" height="350" width="500"/>
        </center>
    
        <aside>
            <h2>Iniciar sesion</h2>
            <form action="InicioSesion" method="post">
                <label for="username">Usuario</label>
                <input type="text" name="username" /><br>
                <label for="pass">Contraseña</label>
                <input type="password" name="pass" /><br>
                <input type="submit" name="Iniciar sesion" />
            </form>
            <a href="register.jsp">Registrame</a>
        </aside>
        <footer>
            <h3>Politécnico Colombiano Jaime Isaza Cadavid</h3>
        </footer>
    </body>
</html>
