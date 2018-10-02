package ComponentesSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjercicioJRadioButton {
    public static void main(String[] args) {
        MarcoVideo108 miMarco = new MarcoVideo108();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoVideo108 extends JFrame{
    public MarcoVideo108() throws HeadlessException {
        setBounds(600,300,600,400);
        add(new LaminaVideo108());
        setVisible(true);
    }
}

class LaminaVideo108 extends JPanel{
    private JRadioButton btn1,btn2,btn3;

    public LaminaVideo108() {
        ButtonGroup miGrupo = new ButtonGroup();
        btn1 = new JRadioButton("masculino");
        btn2 = new JRadioButton("femenino");
        btn3 = new JRadioButton("neutro");

        btn1.addActionListener(new ManejaJRadioButton());
        btn2.addActionListener(new ManejaJRadioButton());
        btn3.addActionListener(new ManejaJRadioButton());

        miGrupo.add(btn1);
        miGrupo.add(btn2);
        miGrupo.add(btn3);

        add(btn1);
        add(btn2);
        add(btn3);

    }

    private class ManejaJRadioButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            // 2 formas de detectar pulsacion 
            if (btn1.isSelected()) System.out.println("Masculino");
            if (btn2.isSelected()) System.out.println("Masculino");
            if (btn3.isSelected()) System.out.println("Masculino");

            if (e.getSource()==btn1) System.out.println("Masculino");
            if (e.getSource()==btn2) System.out.println("Femenino");
            if (e.getSource()==btn3) System.out.println("Neutro");

        }
    }
}