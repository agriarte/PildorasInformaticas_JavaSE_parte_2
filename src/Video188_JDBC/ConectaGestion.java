package Video188_JDBC;

import java.sql.*;

public class ConectaGestion {
    public static void main(String[] args) {

        try {
            //1. Crear Conexión
            Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/almacen", "root", "");
            //2. Crear Statement
            Statement miSt = miCon.createStatement();
            //3. Ejecutar Instrucción SQL
            ResultSet miRS = miSt.executeQuery("SELECT * FROM piezas");
            //4. leer el ResultSet cargado
            System.out.println(">>> lectura base de datos");
            while (miRS.next()) {
                System.out.println(miRS.getString(2) + " " + miRS.getString(3) + " " + miRS.getString(4) );
            }


            //### ejemplo de modificar registro ###
            String insSQL = "UPDATE piezas SET precio=99 WHERE referencia='REF006'";
            miSt.executeUpdate(insSQL);


            //después de modificar base, miRs hace close(). Hay que volver a crearlo
            miRS = miSt.executeQuery("SELECT * FROM piezas");
            System.out.println(">>> registro modificado");
            while (miRS.next()) {
                System.out.println(miRS.getString(2) + " " + miRS.getString(3) + " " + miRS.getString(4) );
            }

            //### ejemplo de eliminar registros ###

            insSQL = "DELETE FROM piezas WHERE nombre = 'Termistor' ";
            miSt.executeUpdate(insSQL);

            //después de modificar base, miRs hace close(). Hay que volver a crearlo
            miRS = miSt.executeQuery("SELECT * FROM piezas");
            System.out.println(">>>> registro Termistor borrado");
            while (miRS.next()) {
                System.out.println(miRS.getString(2) + " " + miRS.getString(3) + " " + miRS.getString(4) );
            }

            //### ejemplo de insertar registro ###
            insSQL = "INSERT INTO piezas (referencia,nombre,precio) VALUES ('REF006','TERMISTOR',10)";
            miSt.executeUpdate(insSQL);
            //después de modificar base, miRs hace close(). Hay que volver a crearlo
            miRS = miSt.executeQuery("SELECT * FROM piezas");

            System.out.println(">>> registro Termistor creado");
            while (miRS.next()) {
                System.out.println(miRS.getString(2) + " " + miRS.getString(3) + " " + miRS.getString(4) );
            }


            miRS.close();
            miCon.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        /*
        try {
            // Prueba con sql remoto. Funciona!
            //https://www.db4free.net/about.php
            //agriarte Colores2019!

            // todo: show variables;
            //tabla piezas: id,referencia,nombre,precio


            //1. Crear Conexión
            Connection miCon = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/basedatospruebas", "agriarte", "Colores2019!");

            //2. Crear Statement
            Statement miSt = miCon.createStatement();
            //3. Ejecutar Instrucción SQL


            ResultSet miRS = miSt.executeQuery("SELECT * FROM piezas");
            //4. leer el ResultSet cargado
            while (miRS.next()){
                System.out.println(miRS.getString(3));
            }

            //ejemplo de insertar registro
            String insSQL="INSERT INTO piezas (referencia,nombre,precio) VALUES ('REF006','TERMISTOR',10)";
            miSt.executeUpdate(insSQL);

            System.out.println("registro insertado");

            miRS.close();
            miCon.close();
            

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    */

    }


}
