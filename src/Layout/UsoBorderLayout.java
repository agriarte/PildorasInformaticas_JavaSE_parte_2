package Layout;

import javax.swing.*;
import java.awt.*;

public class UsoBorderLayout {
    public static void main(String[] args) {
        MarcoLayouts2 miMarco = new MarcoLayouts2();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}
class MarcoLayouts2 extends JFrame{
    public MarcoLayouts2() throws HeadlessException {
        setTitle("Disposiciones");
        setBounds(600,350,600,300);
        PanelConLayout2 lamina = new PanelConLayout2();
        add(lamina);
    }
}
class PanelConLayout2 extends JPanel{
    public PanelConLayout2() {

        //Border Layout
        //setLayout(new BorderLayout()); //constructor simple
        setLayout(new BorderLayout(10,10)); //constructor con parámetros gap
        //añadir botones con el metodo add que permite parámetro de selección de zona del BorderLaoyout
        add(new JButton("Amarillo"),BorderLayout.NORTH);
        add(new JButton("Rojo"),BorderLayout.SOUTH);
        add(new JButton("Azul"),BorderLayout.EAST);
        add(new JButton("Verde"),BorderLayout.WEST);
        add(new JButton("Naranja"),BorderLayout.CENTER);
    }

}
