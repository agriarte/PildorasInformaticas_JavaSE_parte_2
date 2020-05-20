package Video188_JDBC;

import javax.swing.*;



import java.awt.*;
import java.sql.*;

import java.awt.event.*;



public class Aplicacion_Consulta {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        JFrame mimarco=new Marco_Aplicacion();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mimarco.setVisible(true);


    }

}



class Marco_Aplicacion extends JFrame{
    private Connection miConexion;

    private PreparedStatement enviaConsultaSeccion;

    private PreparedStatement enviaConsultaPais;

    private PreparedStatement enviaConsultaTodos;

    private final String consultaSeccion="SELECT NOMBREARTICULO, SECCION, PRECIO, PAISDEORIGEN FROM articulos WHERE SECCION=?";

    private final String consultaPais="SELECT NOMBREARTICULO, SECCION, PRECIO, PAISDEORIGEN FROM articulos WHERE PAISDEORIGEN=?";

    private final String consultaTodos="SELECT NOMBREARTICULO, SECCION, PRECIO, PAISDEORIGEN FROM articulos WHERE SECCION=? AND"
            + " PAISDEORIGEN=?";

    private JComboBox secciones;

    private JComboBox paises;

    private JTextArea resultado;

    public Marco_Aplicacion(){

        setTitle ("Consulta BBDD");

        setBounds(500,300,400,400);

        setLayout(new BorderLayout());

        JPanel menus=new JPanel();

        menus.setLayout(new FlowLayout());

        secciones=new JComboBox();

        secciones.setEditable(false);

        secciones.addItem("Todos");

        paises=new JComboBox();

        paises.setEditable(false);

        paises.addItem("Todos");

        resultado= new JTextArea(4,50);

        resultado.setEditable(false);

        add(resultado);

        menus.add(secciones);

        menus.add(paises);

        add(menus, BorderLayout.NORTH);

        add(resultado, BorderLayout.CENTER);

        JButton botonConsulta=new JButton("Consulta");

        add(botonConsulta, BorderLayout.SOUTH);

        botonConsulta.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub

                ejecutaConsulta();

            }
       });

        //------------CONEXIÓN CON BBDD-------------------------------------

        try{

            miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionpedidos", "root", "");

            Statement sentencia =miConexion.createStatement();
            //---CARGA JCOMBOBOX SECCIONES------

            //para cargar items de los combos SELECT DISTINCT omite duplicados. De esta forma creará fácilmente
            //el listado de SECCION y PAISES.
            //Aqui se hacen 2 consultas, una para SECCION y otra para PAIS. Se poblarán los 2 JcomboBox con resultados
            String consulta="SELECT DISTINCT SECCION FROM articulos";

            ResultSet rs=sentencia.executeQuery(consulta);

            while(rs.next()){

                secciones.addItem(rs.getString(1));

            }

            rs.close();


            //---CARGA JCOMBOBOX PAISES-----

            consulta="SELECT DISTINCT PAISDEORIGEN FROM articulos";

            rs=sentencia.executeQuery(consulta);

            while(rs.next()){

                paises.addItem(rs.getString(1));

            }

            rs.close();


        }catch(Exception e){



        }

    }

    private void ejecutaConsulta(){

        ResultSet rs=null;

        try{

            resultado.setText("");

            String seccion=(String)secciones.getSelectedItem();

            String pais=(String)paises.getSelectedItem();

            if(!seccion.equals("Todos") && pais.equals("Todos")){
                System.out.println(">>>>>>>>>>>>>seccion\n"+consultaSeccion);
                System.out.println(seccion);
                System.out.println(pais);

                enviaConsultaSeccion=miConexion.prepareStatement(consultaSeccion);

                enviaConsultaSeccion.setString(1, seccion);

                rs=enviaConsultaSeccion.executeQuery();

            }else if(seccion.equals("Todos") && !pais.equals("Todos")){
                System.out.println(">>>>>>>>>>>>>pais\n"+consultaPais);
                System.out.println(seccion);
                System.out.println(pais);

                enviaConsultaPais=miConexion.prepareStatement(consultaPais);

                enviaConsultaPais.setString(1, pais);

                rs=enviaConsultaPais.executeQuery();

            }else if(!seccion.equals("Todos") && !pais.equals("Todos")){
                System.out.println(">>>>>>>>>>>>>2 condiciones\n"+consultaTodos);
                System.out.println(seccion);
                System.out.println(pais);

                enviaConsultaTodos=miConexion.prepareStatement(consultaTodos);

                enviaConsultaTodos.setString(1, seccion);

                enviaConsultaTodos.setString(2, pais);

                rs=enviaConsultaTodos.executeQuery();

            }else if(seccion.equals("Todos") && pais.equals("Todos")){
                System.out.println(">>>>>>>>>>>>>todos\n"+"SELECT NOMBREARTICULO, SECCION, PRECIO, PAISDEORIGEN FROM articulos");
                System.out.println(seccion);
                System.out.println(pais);

                enviaConsultaTodos=miConexion.prepareStatement("SELECT NOMBREARTICULO, SECCION, PRECIO, PAISDEORIGEN FROM articulos");

                rs=enviaConsultaTodos.executeQuery();

            }

            while(rs.next()){
                //imprime las 4 columnas de la búsqueda

                resultado.append(rs.getString(1));

                resultado.append(", ");

                resultado.append(rs.getString(2));

                resultado.append(", ");

                resultado.append(rs.getString(3));

                resultado.append(", ");

                resultado.append(rs.getString(4));

                resultado.append("\n");

            }
            rs.close();


        }catch(Exception e){



        }

    }

}
