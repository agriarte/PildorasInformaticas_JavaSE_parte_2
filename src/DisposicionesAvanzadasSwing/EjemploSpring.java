package DisposicionesAvanzadasSwing;

import javax.swing.*;
import java.awt.*;

public class EjemploSpring {
    public static void main(String[] args) {
        MarcoSpring miMarco = new MarcoSpring();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);

    }
}

class MarcoSpring extends JFrame {
    public MarcoSpring() throws HeadlessException {
        setBounds(300,400,1000,350);
        add(new LaminaSpring());

    }
}
class LaminaSpring extends JPanel {
    public LaminaSpring() {
        JButton boton1 = new JButton("Boton 1");
        JButton boton2 = new JButton("Boton 2");
        JButton boton3 = new JButton("Boton 3");

        SpringLayout miLayout = new SpringLayout();
        setLayout(miLayout);

        add(boton1);
        add(boton2);
        add(boton3);

        Spring miMuelle = Spring.constant(0,10,100);

        //son 5 parametros: los 2 primeros se refieren al destino del muelle
        //1 - borde izquierdo del 2 - componente muelle
        //3 - que muelle usar, en este ejemplo hay solo uno
        //4 y 5 se refieren al borde izquierdo del componente contenedor Jpanel, la lamina se
        // representa como (this)
        miLayout.putConstraint(SpringLayout.WEST,boton1,miMuelle,SpringLayout.WEST,this);
        miLayout.putConstraint(SpringLayout.WEST,boton2,miMuelle,SpringLayout.EAST,boton1);
        miLayout.putConstraint(SpringLayout.WEST,boton3,miMuelle,SpringLayout.EAST,boton2);
        miLayout.putConstraint(SpringLayout.EAST,this,miMuelle,SpringLayout.EAST,boton3);


    }
}