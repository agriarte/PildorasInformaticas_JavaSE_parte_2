package ComponentesSwing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ejemploJSpinner {
    public static void main(String[] args) {
        MarcoJSpinner miMarco = new MarcoJSpinner();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoJSpinner extends JFrame{
    public MarcoJSpinner() throws HeadlessException {
        setBounds(600,300,600,400);
        add(new LaminaJSpinner());
        setVisible(true);
    }
}

class LaminaJSpinner extends JPanel{
    public LaminaJSpinner() {

        // JSpinner básico
        JSpinner miJSpinner = new JSpinner();
        add(miJSpinner);

        miJSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println(miJSpinner.getValue());
            }
        });

        // JSpinner con array de Strings
        String meses[] = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        JSpinner miJSpinner2 = new JSpinner(new SpinnerListModel(meses));
        //tamaño
        miJSpinner2.setPreferredSize(new Dimension(80,20));
        miJSpinner2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println(miJSpinner2.getValue());
            }
        });
        add(miJSpinner2);

        // JSpinner numérico mas desarrollado

        JSpinner miJSpinner3 = new JSpinner(new SpinnerNumberModel(25,-20,150,5));
        miJSpinner3.setPreferredSize(new Dimension(40,20));
        miJSpinner3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println(miJSpinner3.getValue());
            }
        });
        add(miJSpinner3);
    }
}
