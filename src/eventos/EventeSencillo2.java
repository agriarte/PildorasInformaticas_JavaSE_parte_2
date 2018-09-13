package eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//ejemplo un poco raro donde el oyente es un Objeto Color que implementa el ActionListener.
//el método actionPerformed del objeto Color será quien fije el color de fondo


public class EventeSencillo2 {
    public static void main(String[] args) {
        MarcoBotonesColores2 miMarco = new MarcoBotonesColores2();
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoBotonesColores2 extends JFrame {
    public MarcoBotonesColores2() throws HeadlessException {
        setTitle("Boton cambia color");
        setBounds(700,300,500,300);
        LaminaBotonesColores2 miLamina = new LaminaBotonesColores2();
        add(miLamina);
    }
}

class LaminaBotonesColores2 extends JPanel{
    JButton botonAzul = new JButton("Azul");
    JButton botonRojo = new JButton("Rojo");
    JButton botonVerde = new JButton("Verde");

    public LaminaBotonesColores2() {
        add(botonAzul);
        add(botonRojo);
        add(botonVerde);

        //objeto con el color que será de fondo, recibe el color deseado y su método actionPerformed fija el fondo
        ColorFondo azul = new ColorFondo(Color.BLUE);
        ColorFondo rojo = new ColorFondo(Color.RED);
        ColorFondo verde = new ColorFondo(Color.GREEN);

        botonAzul.addActionListener(azul);
        botonRojo.addActionListener(rojo);
        botonVerde.addActionListener(verde);
    }

    //clase interna
    private class ColorFondo implements ActionListener{
        private Color colorFondo;
        public ColorFondo (Color c){
            colorFondo=c;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            setBackground(colorFondo);
        }
    }
}

