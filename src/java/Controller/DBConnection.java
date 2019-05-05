package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    private static Connection conexion;

    public static Connection getConexion() {
        conexion = null;
        try {

            //  Carga el driver de la base de datos
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver de ORACLE cargado");

            String username = "ROYALMUSICDBA";
            String password = "123456";
            String url = "jdbc:oracle:thin:@localhost:1521:XE";

            conexion = DriverManager.getConnection(url, username, password);
            System.out.println("Conexión establecida");
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada");
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("Excepción: " + ex.getMessage());
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
}
