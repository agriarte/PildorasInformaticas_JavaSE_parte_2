package Video193MVC.Vista;

import Video193MVC.Controlador.ControladorBotonEjecutar;
import Video193MVC.Controlador.ControladorCargaMenus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MarcoMVC extends JFrame {
    private JComboBox seccionesJCombo;

    private JComboBox paisesJCombo;

    private JTextArea resultados;

    public MarcoMVC() {
        //creacion de la vista: botones,JComboBox,etc

        setTitle("Consulta Articulos");

        setBounds(500,300,400,400);

        setLayout(new BorderLayout());

        JPanel menus=new JPanel();

        menus.setLayout(new FlowLayout());

        seccionesJCombo=new JComboBox();

        seccionesJCombo.setEditable(false);

        seccionesJCombo.addItem("Todos");

        paisesJCombo =new JComboBox();

        paisesJCombo.setEditable(false);

        paisesJCombo.addItem("Todos");

        resultados= new JTextArea(4,50);

        resultados.setEditable(false);

        add(resultados);

        menus.add(seccionesJCombo);

        menus.add(paisesJCombo);

        add(menus, BorderLayout.NORTH);

        add(resultados, BorderLayout.CENTER);

        JButton botonConsulta=new JButton("Buscar");
        botonConsulta.addActionListener(new ControladorBotonEjecutar(this));

        add(botonConsulta, BorderLayout.SOUTH);

        //windows listener que escucha cuando se abre la ventana
        addWindowListener(new ControladorCargaMenus(this));
    }

    public JComboBox getSeccionesJCombo() {
        return seccionesJCombo;
    }

    public void setSeccionesJCombo(JComboBox seccionesJCombo) {
        this.seccionesJCombo = seccionesJCombo;
    }

    public JComboBox getPaisesJCombo() {
        return paisesJCombo;
    }

    public void setPaisesJCombo(JComboBox paisesJCombo) {
        this.paisesJCombo = paisesJCombo;
    }

    public JTextArea getResultados() {
        return resultados;
    }

    public void setResultados(JTextArea resultados) {
        this.resultados = resultados;
    }
}
