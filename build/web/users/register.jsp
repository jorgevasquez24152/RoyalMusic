<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Royal Music</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="styles.css" rel="stylesheet" type="text/css"/>
        <link rel=”icon” type=”image/ico” href="Images/favicon.ico"/>
    </head>
    <body>
        <header>
            <h1>Bienvenido a Royal Music</h1>
        </header>
        
        <center>
            
            <h2>Registro de usuario</h2>
            <form action="Registration" method="post">
                <label for="identificationType">Tipo de identificación</label>
                <input list="idTypes" name="identificationType" />
                    <datalist id="idTypes">
                        <option value="Cedula">
                        <option value="Pasaporte">
                    </datalist><br>
                <label for="identificationNumber">Número de identificación</label>
                <input type="text" name="identificationNumber" /><br>
                <label for="firstname">Primer nombre</label>
                <input type="text" name="firstname" /><br>
                <label for="middlename">Segundo nombre</label>
                <input type="text" name="middlename" /><br>
                <label for="lastname">Primer apellido</label>
                <input type="text" name="lastname" /><br>
                <label for="secondLastname">Segundo apellido</label>
                <input type="text" name="secondLastname" /><br>
                <label for="phoneNumber">Teléfono</label>
                <input type="text" name="phoneNumber" /><br>
                <label for="email">Correo electrónico</label>
                <input type="text" name="email" /><br>
                <label for="username">Usuario</label>
                <input type="text" name="username" /><br>
                <label for="pass">Contraseña</label>
                <input type="password" name="pass" /><br>
                <input type="submit" name="FinalizarRegistro" value="Finalizar registro" />
            </form>
            <a href="../index.jsp">Iniciar sesión</a>
        </center>
    
        <aside>
            <img src="Images/equalizer-153212_1280.png" alt="" height="150" width="250"/>
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
