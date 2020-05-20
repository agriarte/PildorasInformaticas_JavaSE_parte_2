package Video193MVC.Modelo;

import java.sql.*;

public class Conexion {
    Connection miConexion = null;

    public Conexion() {

    }

    public Connection getMiConexion() {
        try {
            miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionpedidos", "root", "");

        } catch (SQLException throwables) {
            System.out.println("error clase conexion");
            throwables.printStackTrace();
        }
        return miConexion;
    }
}
