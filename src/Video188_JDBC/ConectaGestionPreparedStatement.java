package Video188_JDBC;

import java.sql.*;

public class ConectaGestionPreparedStatement {
    public static void main(String[] args) {
        //truco para importar sin problemas de cotejamiento. En myphpadmin crear basedatos con utf8_unicode_ci
        //Con notepad++ abrir archivo csv y convertir a utf8(puede cambiar caracteres por XF3, es correcto)
        //Importar base datos en myphpadmin en utf8. Antes crear db y sus columnas vacias on utf8_unicode_ci

        try {
            //1. Crear Conexión
            Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionpedidos", "root", "");
            //2. Crear Statement
            //le marco que columnas almacenará. en este caso 3. Si quiero todas poner *
            String sentencia = "SELECT seccion,nombrearticulo,paisdeorigen FROM articulos WHERE seccion=? AND paisdeorigen=?";
            //String sentencia = "SELECT * FROM articulos WHERE seccion=? AND paisdeorigen=?";

            //los ? se reemplazan por los PreparedStatement
            PreparedStatement miPst = miCon.prepareStatement(sentencia);
            miPst.setString(1,"Confección");
            miPst.setString(2,"España");
            //3. Ejecutar sentencia SQL
            ResultSet miRS = miPst.executeQuery();
            //4. leer el ResultSet cargado
            System.out.println(">>> lectura base de datos");
            while (miRS.next()) {
                //El resultSet devuelve solo las columnas marcadas. El número de columna es sobre lo buscado no lo real de la tabla
                System.out.println(miRS.getString(1) + " " + miRS.getString(2) + " " + miRS.getString(3) );
            }



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}

