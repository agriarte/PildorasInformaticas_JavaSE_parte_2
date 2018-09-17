package eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class EventoFoco {
    public static void main(String[] args) {
        MarcoFoco miMarcoFoco = new MarcoFoco();
        miMarcoFoco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarcoFoco.setVisible(true);

    }
}
class MarcoFoco extends JFrame{
    public MarcoFoco() throws HeadlessException {
        setBounds(50,50,600,300);
        add(new LaminaMarcoFoco());
        }
}

class LaminaMarcoFoco extends JPanel{
    private JTextField campoTexto1,campoTexto2;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        campoTexto1 = new JTextField();
        campoTexto2 = new JTextField();
        campoTexto1.setBounds(50,50,120,20);
        campoTexto2.setBounds(50,80,120,20);
        add(campoTexto1);
        add(campoTexto2);
        EventosFoco foco = new EventosFoco();
        campoTexto1.addFocusListener(foco);

        campoTexto2.addFocusListener(foco);
    }

    //
    //Clase interna para tener acceso a atributos de LaminaMarcoFoco
    //
    class EventosFoco implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            if (e.getSource()==campoTexto1) System.out.println("Foco ha entrado campoTexto 1: " + e.getSource());
            if (e.getSource()==campoTexto2) System.out.println("Foco ha entrado campoTexto 2: " + e.getSource());
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (e.getSource()==campoTexto1) System.out.println("Foco ha salido campoTexto 1: " + e.getSource());
            if (e.getSource()==campoTexto2) System.out.println("Foco ha salido campoTexto 2: " + e.getSource());
        }
    }
}

