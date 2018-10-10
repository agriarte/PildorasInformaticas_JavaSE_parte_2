package DisposicionesAvanzadasSwing;

import javax.swing.*;
import java.awt.*;

public class EjemploSetLayoutNull {
    public static void main(String[] args) {
        MarcoDisposicionLibre2 miMarco = new MarcoDisposicionLibre2();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoDisposicionLibre extends JFrame{
    public MarcoDisposicionLibre() throws HeadlessException {
        setBounds(600,300,600,400);
        add(new LaminaDisposicionLibre2());
        setVisible(true);
    }
}

class LaminaDisposicionLibre extends JPanel{
    public LaminaDisposicionLibre() {
        setLayout(null);
        JLabel nombre = new JLabel("Nombre: ");

        JLabel apellido = new JLabel("Apellido: ");

        JTextField campoNombre = new JTextField();

        JTextField campoApellido = new JTextField();

        nombre.setBounds(20,20,80,10);
        campoNombre.setBounds(100,20,100,20);

        apellido.setBounds(20,60,80,10);
        campoApellido.setBounds(100,55,100,20);


        add(nombre);
        add(campoNombre);

        add(apellido);
        add(campoApellido);



    }
}