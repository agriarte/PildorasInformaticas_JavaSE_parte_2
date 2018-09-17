package eventos;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Varios_oyentes {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Marco_Principal mimarco=new Marco_Principal();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mimarco.setVisible(true);

    }

}

class Marco_Principal extends JFrame{

    public Marco_Principal(){

        setTitle("Múltiples oyentes");

        setBounds(1300,100,300,200);

        Lamina_Principal lamina=new Lamina_Principal();

        add(lamina);
    }

}

class Lamina_Principal extends JPanel{

    JButton boton_cerrar;

    public Lamina_Principal(){

        JButton boton_nuevo=new JButton("Nuevo");

        add(boton_nuevo);

        boton_cerrar=new JButton("Cerrar todo");

        add(boton_cerrar);

        //al pulsar le mandamos objeto CreaMarcos que a su vez llamará a MarcoNuevo para crear ventana
        boton_nuevo.addActionListener(new CreaMarcos());
    }

    private class CreaMarcos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            MarcoNuevo miMarco = new MarcoNuevo(boton_cerrar);//envio boton_cerrar a la clase MarcoNuevo para ponerlo a la escucha
            miMarco.setVisible(true);
        }
    }




}
//pasar botón cerrarTodo como parámetro a la clase MarcoNuevo y ponerlo a la escucha
//este boton viaja a esta clase pero no es visible ni le hacemos un add(boton_cerrar);
class MarcoNuevo extends JFrame{
    //variable estática común para todas las instancias que va contando número de ventanas
    private static int contador = 0;
    public MarcoNuevo(JButton boton) throws HeadlessException {
        contador++;
        setTitle("Ventana " + contador);
        setBounds(50*contador, 50*contador,350,200);
        //
        boton.addActionListener(new CierraTodo());//aqui es donde se pone a la escucha
    }

    private class CierraTodo implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //cierra ventana y libera memoria de ese proceso
            dispose();
        }
    }

}