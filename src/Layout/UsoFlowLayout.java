package Layout;

import javax.swing.*;
import java.awt.*;

public class UsoFlowLayout {
    public static void main(String[] args) {
        MarcoLayouts miMarco = new MarcoLayouts();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}

class MarcoLayouts extends JFrame{
    public MarcoLayouts() throws HeadlessException {
        setTitle("Disposiciones");
        setBounds(600,350,600,300);
        PanelConLayout lamina = new PanelConLayout();

        //
        //Ejemplos de centrado usando la clase FlowLayout
        //
        //metodo 1//
        //FlowLayout disposicion = new FlowLayout(FlowLayout.LEFT);
        //lamina.setLayout(disposicion);

        //metodo 2//
        //lamina.setLayout(new FlowLayout(FlowLayout.RIGHT));

        add(lamina);
    }
}
class PanelConLayout extends JPanel{
    public PanelConLayout() {
        //metodo 3//
        //aplicando el FlowLayout directamente a la lámina
        //hya otro constructor que permite parámetro 2 distancia horizontal, parámetro 3 margen vertical
        setLayout(new FlowLayout(FlowLayout.RIGHT,30,30));

        add(new JButton("Amarillo"));
        add(new JButton("Rojo"));
        add(new JButton("Azul"));
    }

}
