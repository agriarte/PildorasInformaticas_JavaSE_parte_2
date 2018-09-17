package eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class EjercecioEntradaDatos {
    public static void main(String[] args) {
        MarcoEjercicio1 miMarcoEjercicio1 = new MarcoEjercicio1();
        miMarcoEjercicio1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoEjercicio1 extends JFrame{
    public MarcoEjercicio1() throws HeadlessException {
        setBounds(50,50,600,400);
        setTitle("Entrada Datos");
        add(new LaminaMarcoEjercicio1());
        setVisible(true);

        }
}

class LaminaMarcoEjercicio1 extends JPanel{
    private JTextField campoTexto1,campoTexto2,campoTexto3;
    private JLabel etiq1,etiq2,etiq3;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        etiq1 = new JLabel("Usuario: ");
        etiq2 = new JLabel("Contraseña: ");
        etiq3 = new JLabel("email: ");

        campoTexto1 = new JTextField();
        campoTexto2 = new JTextField();
        campoTexto3 = new JTextField();

        campoTexto1.setBounds(250, 50, 120, 20);
        campoTexto2.setBounds(250, 80, 120, 20);
        campoTexto3.setBounds(250, 110, 120, 20);

        etiq1.setBounds(150, 50, 120, 20);
        etiq2.setBounds(150, 80, 120, 20);
        etiq3.setBounds(150, 110, 120, 20);


        add(campoTexto1);
        add(campoTexto2);
        add(campoTexto3);

        add(etiq1);
        add(etiq2);
        add(etiq3);

        EventosFocoEjercicio foco = new EventosFocoEjercicio();
        campoTexto1.addFocusListener(foco);
        campoTexto2.addFocusListener(foco);
        campoTexto3.addFocusListener(foco);
    }

        //
        //Clase interna para tener acceso a atributos de LaminaMarcoFoco
        //
        class EventosFocoEjercicio implements FocusListener {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {

                if (e.getSource()==campoTexto2) System.out.println(comprobarPassword(campoTexto2.getText()));
                if (e.getSource()==campoTexto3) System.out.println(comprobarEmail(campoTexto3.getText()));

            }
    }
    String comprobarPassword(String password){
       if  (password.length()<5 ) return "Contraseña debe tener 5 o mas caracteres";
       else return "contraseña OK";
    }

    String comprobarEmail(String email){
        int contadorArrobas=0;
        int contadorPuntos=0;
        //para comprobar email válido se comprueba que solo tengo una @ y al menos un punto
        for (int i = 0; i < email.length(); i++) {
            if (email.codePointAt(i)==64) contadorArrobas++;
            if (email.codePointAt(i)==46) contadorPuntos++;
        }

        System.out.println(contadorArrobas + " " + contadorPuntos);

        if ((contadorPuntos >= 1) && (contadorArrobas == 1)) {
            return "datos correctos";
        } else {
            return "error de entrada de email";
        }

    }
}

