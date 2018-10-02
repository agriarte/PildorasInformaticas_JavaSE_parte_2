package ComponentesSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjercicioValidarEmailVideo104 {
    public static void main(String[] args) {
        Marco104 mimarco = new Marco104();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class Marco104 extends JFrame{
    public Marco104() {
        setBounds(50,50,640,480);
        setTitle("Ejercio 104");
        add(new Lamina104());
        setVisible(true);
    }
}

class Lamina104 extends JPanel{
    JTextField textoEntrada;
    JLabel textoSalida;
    JButton mi_boton;
    public Lamina104() {
        setLayout(new GridLayout(3,0));
        textoEntrada = new JTextField();
        mi_boton = new JButton("Validar Email");
        mi_boton.addActionListener(new ValidarEmail());
        textoSalida = new JLabel();
        add(textoEntrada);
        add(mi_boton);
        add(textoSalida);
    }

    private class ValidarEmail implements ActionListener{

        String email;
        int contadorArrobas;

        @Override
        public void actionPerformed(ActionEvent e) {
            email = textoEntrada.getText();

            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i)=='@') contadorArrobas++;
            }
            if (contadorArrobas==1) {
                textoSalida.setText("Email valido");
            }else{
                textoSalida.setText("Email incorrecto");
            }

        }
    }
}


