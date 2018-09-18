package Layout;

import javax.swing.*;
import java.awt.*;

public class DosLaminas {
    public static void main(String[] args) {
        MarcoLayouts3 miMarco = new MarcoLayouts3();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}
class MarcoLayouts3 extends JFrame{
    public MarcoLayouts3() throws HeadlessException {
        setTitle("Disposiciones");
        setBounds(600,350,600,300);

        PanelConLayoutUno lamina1 = new PanelConLayoutUno();
        PanelConLayoutDos lamina2 = new PanelConLayoutDos();

        //importante, al agregar láminas, incicar posición
        add(lamina1,BorderLayout.SOUTH);
        add(lamina2,BorderLayout.NORTH);
    }
}

class PanelConLayoutUno extends JPanel{
    public PanelConLayoutUno() {

        //Border Layout
        //setLayout(new BorderLayout()); //constructor simple
        setLayout(new BorderLayout(10,10)); //constructor con parámetros gap
        //añadir botones con el metodo add que permite parámetro de selección de zona del BorderLaoyout

        add(new JButton("Azul"),BorderLayout.EAST);
        add(new JButton("Verde"),BorderLayout.WEST);
        add(new JButton("Naranja"),BorderLayout.CENTER);
    }

}

class PanelConLayoutDos extends JPanel{
    public PanelConLayoutDos(){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(new JButton("Amarillo"));
        add(new JButton("Rojo"));
    }
}
