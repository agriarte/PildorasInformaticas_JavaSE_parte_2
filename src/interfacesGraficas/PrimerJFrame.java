package interfacesGraficas;

import javax.swing.*;

public class PrimerJFrame {
    public static void main(String[] args) {
        JFrame miVentana = new JFrame();
        miVentana.setSize(600,350);
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miVentana.setLocation(600,400);
        miVentana.setVisible(true);
    }
}
