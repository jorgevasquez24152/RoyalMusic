package model.util;

import model.util.DBConnection;
import Model.pojo.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBMethods extends DBConnection {

    //public boolean autenticacion(String username, String password) {
    public boolean autenticacion(Object objeto) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        User sesionUser = (User)objeto;
        
        try {
            String consulta = "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
            pst = getConexion().prepareStatement(consulta);
            
            pst.setString(1, sesionUser.getUsername());
            pst.setString(2, sesionUser.getPassword());

            //pst.setString(1, username);
            //pst.setString(2, password);
            
            rs = pst.executeQuery();

            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    String userFinded = rs.getString(i);
                    if (sesionUser.getUsername() == userFinded) {
                    }
                }
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    String passwordFinded = rs.getString(i);
                    if (sesionUser.getPassword() == passwordFinded) {
                    }
                }
                return true;
            }

        } catch (Exception ex) {
            System.err.println("Error 1: " + ex);
            Logger.getLogger(DBMethods.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (getConexion() != null) {
                    getConexion().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }

            } catch (Exception ex) {
                System.err.println("Error 2: " + ex);
                Logger.getLogger(DBMethods.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    // Metodo para probar funcionamiento de la autenticacion y verificacion
    //public static void main(String[] args) {
    //    DBMethods co = new DBMethods();
    //    System.out.println(co.autenticacion("jadmin", "Royalmusic1901"));
    //}

    public boolean registrar(int id_user, String name, String lastname, String username, String password) {
        PreparedStatement pst = null;

        try {
            String consulta = "INSERT INTO USERS (ID_USER, NAME, LASTNAME, USERNAME, PASSWORD) VALUES (?, ?, ?, ?, ?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, id_user);
            pst.setString(2, name);
            pst.setString(3, lastname);
            pst.setString(4, username);
            pst.setString(5, password);

            int insertedRegistry = pst.executeUpdate();
            if (insertedRegistry == 1) {
                return true;
            }

        } catch (Exception ex) {
            System.err.println("Error 1: " + ex);
            Logger.getLogger(DBMethods.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (getConexion() != null) {
                    getConexion().close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception ex) {
                System.err.println("Error 2: " + ex);
                Logger.getLogger(DBMethods.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    // Metodo para probar funcionamiento de la inserción y verificacion
    //public static void main(String[] args) {
    //    DBMethods co = new DBMethods();
    //    System.out.println(co.registrar(3, "Yuliana", "Estrada", "yulianae", "123456"));
    //}
    
}
