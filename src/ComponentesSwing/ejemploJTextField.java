package ComponentesSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ejemploJTextField {
    public static void main(String[] args) {
        MarcoJTextField miMarco = new MarcoJTextField();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoJTextField extends JFrame{
    public MarcoJTextField() throws HeadlessException {
        setBounds(600,300,600,400);
        add(new laminaJText());
        setVisible(true);
    }
}

class laminaJText extends JPanel{
    JTextField cuadroTexto1,cuadroTexto2;
    public laminaJText() {
        cuadroTexto1 = new JTextField(20);
        JButton miBoton = new JButton("Obtener Texto");
        cuadroTexto2 = new JTextField(20);

        miBoton.addActionListener(new ObtenerTexto());
        add(cuadroTexto1);
        add(miBoton);
        add(cuadroTexto2);
    }

    private class ObtenerTexto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            cuadroTexto2.setText(cuadroTexto1.getText());
        }
    }
}




