package ComponentesSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjemploJButton {
    public static void main(String[] args) {
        MarcoJButton miMarco = new MarcoJButton();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoJButton extends JFrame{
    public MarcoJButton() throws HeadlessException {
        setBounds(600,300,600,400);
        add(new laminaJButton());
        setVisible(true);
    }
}

class laminaJButton extends JPanel{
    public laminaJButton() {
        JButton miBoton = new JButton("Boton");
        miBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("has pulsado boton");
            }
        });
        add(miBoton);
    }
}

