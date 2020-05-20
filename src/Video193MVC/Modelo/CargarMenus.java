package Video193MVC.Modelo;

import Video193MVC.Modelo.Conexion;
import Video193MVC.Modelo.Productos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CargarMenus {
    private Conexion miConexion;
    private ResultSet resultadosconsultas[];
    //ATENTO: se crea instancia de conexion para llamar a su método getConexion a través de un método creado en esta clase,
    //llamado ejecutaConsultas();

    public CargarMenus() {
        miConexion = new Conexion();
    }
    public ResultSet[] ejecutaConsultas() {
        Connection accesoBBDD = miConexion.getMiConexion();

        ResultSet resSec = null;
        ResultSet resPais = null;

        try {
            //ResultSet de seccion sin repetir por usar predicado DISTINCT O DISTINCTROW
            //el result contendrá solo la columna especificada, seccion. A las columnas del result se accede por indice
            Statement seccionesSt = accesoBBDD.createStatement();
            resSec= seccionesSt.executeQuery("SELECT DISTINCT SECCION FROM articulos");
            Statement paisesSt = accesoBBDD.createStatement();
            resPais= paisesSt.executeQuery("SELECT DISTINCT PAISDEORIGEN FROM articulos");

            //adelantar una posicion para luego atrasar. ???? cosa rara

            resSec.next();
            resPais.next();

            resultadosconsultas = new ResultSet[2];
            resultadosconsultas[0]= resSec;
            resultadosconsultas[1]= resPais;

            System.out.println("resultadosconsultas[0]= " +  resultadosconsultas[0].getString(1));
            System.out.println("resultadosconsultas[1]= " +  resultadosconsultas[1].getString(1));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return resultadosconsultas;
    }
}
