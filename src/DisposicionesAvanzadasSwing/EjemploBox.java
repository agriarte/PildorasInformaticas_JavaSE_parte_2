package DisposicionesAvanzadasSwing;

import javax.swing.*;
import java.awt.*;

//este ejercicio crea 3 box horizontales contenidos dentro de otro vertical
//es una manera mas precisa de diseñar las interfaces gráficas

public class EjemploBox {
    public static void main(String[] args) {
        MarcoEjercicioBox miMarco = new MarcoEjercicioBox();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}


class MarcoEjercicioBox extends JFrame{
    public MarcoEjercicioBox() throws HeadlessException {
        setBounds(600,300,600,400);

        //---- Box 1

        JLabel nombreUsuario = new JLabel("Nombre: ");
        JTextField campoUsuario = new JTextField(10);
        campoUsuario.setMaximumSize(campoUsuario.getPreferredSize());//tamaño maximo = valor fijado al crearlo(10)

        Box boxUsuario = Box.createHorizontalBox();
        boxUsuario.add(nombreUsuario);
        boxUsuario.add(Box.createHorizontalStrut(10));// separacion pixeles
        boxUsuario.add(campoUsuario);

        //----- Box 2

        JLabel pass = new JLabel("Contraseña: ");
        JTextField campoPass = new JTextField(10);
        campoPass.setMaximumSize(campoUsuario.getPreferredSize());//tamaño maximo = valor fijado al crearlo(10)

        Box boxPass = Box.createHorizontalBox();
        boxPass.add(pass);
        boxPass.add(Box.createHorizontalStrut(10));// separacion pixeles
        boxPass.add(campoPass);

        //----- Box 3

        JButton boton1 = new JButton("OK");
        JButton boton2 = new JButton("CANCELAR");

        Box boxBotones = Box.createHorizontalBox();
        boxBotones.add(boton1);
        boxBotones.add(Box.createGlue());// separacion pixeles
        boxBotones.add(boton2);

        //----  Box 4 , este Vertical

        Box cajaVertical = Box.createVerticalBox();

        cajaVertical.add(boxUsuario);
        cajaVertical.add(boxPass);
        cajaVertical.add(boxBotones);


        //cajaVertical contiene los 3 Box horizontales
        //finalmente se añaden al Marco para que sean Visibles
        add(cajaVertical);

    }
}

