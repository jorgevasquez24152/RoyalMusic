package model.util;

import model.util.DBConnection;
import model.pojo.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBMethods extends DBConnection {

    int id = 0;

    //public boolean authentication(String username, String password) {
    public boolean authentication(Object objeto) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        User sesionUser = (User) objeto;

        try {
            String consulta = "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, sesionUser.getUsername());
            pst.setString(2, sesionUser.getPassword());
            rs = pst.executeQuery();

            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    String userFinded = rs.getString(i);
                    if (sesionUser.getUsername().equals(userFinded)) {
                    }
                }
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    String passwordFinded = rs.getString(i);
                    if (sesionUser.getPassword().equals(passwordFinded)) {
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
    
    public int validateId() throws Exception {
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String consulta = "SELECT MAX (ID_USER) FROM USERS";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();

            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    id = rs.getInt(i);

                    return id;
                }
            }
        } catch (Exception ex) {
            System.err.println("Error 1: " + ex);
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
            }

            return id;
        }
    }

    public boolean register(Object objeto) {
        PreparedStatement pst = null;
        User addUser = (User) objeto;

        try {
            String consulta = "INSERT INTO USERS (ID_USER, IDENTIFICATION_TYPE, "
                    + "IDENTIFICATION_NUMBER, FIRSTNAME, MIDDLENAME, LASTNAME, "
                    + "SECOND_LASTNAME, PHONE_NUMBER, EMAIL, USERNAME, PASSWORD, "
                    + "PROFILE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst = getConexion().prepareStatement(consulta);
            validateId();
            pst.setInt(1, id + 1);
            pst.setString(2, addUser.getIdentification_type());
            pst.setString(3, addUser.getIdentification_number());
            pst.setString(4, addUser.getFirstname());
            pst.setString(5, addUser.getMiddlename());
            pst.setString(6, addUser.getLastname());
            pst.setString(7, addUser.getSecond_lastname());
            pst.setString(8, addUser.getPhone_number());
            pst.setString(9, addUser.getEmail());
            pst.setString(10, addUser.getUsername());
            pst.setString(11, addUser.getPassword());
            pst.setInt(12, 2);

            int insertedRegistry = pst.executeUpdate();
            if (insertedRegistry == 1) {
                return true;
            }
        } catch (Exception ex) {
            System.err.println("Error 1: " + ex);
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
            }
        }
        return false;
    }
    
    //  Metodo para probar funcionamiento de la authentication y verificacion
    //  public static void main(String[] args) {
    //      DBMethods co = new DBMethods();
    //      System.out.println(co.authentication("jadmin", "Royalmusic1901"));
    //  }
    
    //  Metodo para probar funcionamiento de la inserción y verificacion
    //  public static void main(String[] args) {
    //      DBMethods co = new DBMethods();
    //      System.out.println(co.register(3, "Yuliana", "Estrada", "yulianae", "123456"));
    //  }
    
    //  Metodo para probar funcionamiento de la validacion del ultimo id
    //  public static void main(String[] args) {
    //      DBMethods co = new DBMethods();
    //      try {
    //          int maxId = co.validateId();
    //          System.out.println("El id_user más alto es: " + maxId);
    //      } catch (Exception ex) {
    //          System.err.println("Error 3: " + ex);
    //      }
    //  }

}
