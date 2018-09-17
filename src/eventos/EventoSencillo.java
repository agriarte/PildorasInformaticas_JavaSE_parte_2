package eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoSencillo {
    public static void main(String[] args) {
        MarcoBotonesColores miMarco = new MarcoBotonesColores();
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoBotonesColores extends JFrame{
    public MarcoBotonesColores() throws HeadlessException {
        setTitle("Boton cambia color");
        setBounds(700,300,500,300);
        LaminaBotonesColores miLamina = new LaminaBotonesColores();
        add(miLamina);
    }
}

class LaminaBotonesColores extends JPanel implements ActionListener {
    JButton botonAzul = new JButton("Azul");
    JButton botonRojo = new JButton("Rojo");
    JButton botonVerde = new JButton("Verde");

    public LaminaBotonesColores() {
        add(botonAzul);
        add(botonRojo);
        add(botonVerde);

        //al añadir el actionListener a cada botón, cada vez que se pulse actionPerformed recibe
        //un objeto donde obtener el nombre del botón pulsado
        botonAzul.addActionListener(this);
        botonRojo.addActionListener(this);
        botonVerde.addActionListener(this);
    }

    //único método de la interfaz ActionListener,
    @Override
    public void actionPerformed(ActionEvent e) {

        //e es el evento desencadenante. getSource nos devuelve el nombre del objeto que dispara el evento.
        Object botonPulsado = e.getSource();
        if (botonPulsado==botonRojo) setBackground(Color.RED);
        if (botonPulsado==botonAzul) setBackground(Color.BLUE);
        if (botonPulsado==botonVerde) setBackground(Color.GREEN);
    }
}
