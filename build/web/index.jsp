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
            <h1 id="tituloBienvenida">Bienvenido a Royal Music</h1>
        </header>

        <center>
            <img src="Images/equalizer-153212_1280.png" alt="" height="350" width="500"/>
        </center>
    
        <aside>
            <h2 id="tituloIniciarSesion">Iniciar sesion</h2>
            <form action="Login" method="post">
                <label for="username">Usuario</label>
                <input type="text" name="username" /><br>
                <label for="pass">Contraseña</label>
                <input type="password" name="pass" /><br>
                <input type="submit" name="IniciarSesion" value="Iniciar sesión" />
            </form>
            <a href="register.jsp">Registrame</a>
        </aside>
        <footer>
            <h2>Politécnico Colombiano Jaime Isaza Cadavid</h2>
            <h3>PPI 2019 1</h3>
            <p>Creado por:</p>
            <ul>
                <li>Valentina Cardona</li>
                <li>Yuliana Estrada</li>
                <li>Jorge Vasquez</li>
            </ul>
        </footer>
    </body>
</html>
