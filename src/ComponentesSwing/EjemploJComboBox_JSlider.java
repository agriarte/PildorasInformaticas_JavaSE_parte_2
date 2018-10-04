package ComponentesSwing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjemploJComboBox_JSlider {
    public static void main(String[] args) {
        MarcoJComboBox miMarco = new MarcoJComboBox();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoJComboBox extends JFrame{
    public MarcoJComboBox() {
        setBounds(600,300,600,400);
        add(new LaminaJComboBox());
        setVisible(true);
    }
}

class LaminaJComboBox extends JPanel{
    JLabel texto;
    JComboBox miJComboBox;
    JSlider miJSlider;
    public LaminaJComboBox() {
        setLayout(new BorderLayout());

        texto = new JLabel("En breve aprenderemos JavaFx");
        texto.setFont(new Font("Serif", Font.PLAIN,18));
        add(texto, BorderLayout.CENTER);

        JPanel superior = new JPanel();


        /*
        2 formas de rellenar un JComboBox, 1 con addItem

        miJComboBox = new JComboBox();
        miJComboBox.addItem("Serif");
        miJComboBox.addItem("SansSerif");
        miJComboBox.addItem("Monospaced");
        miJComboBox.addItem("Calibri");
        miJComboBox.addItem("Dialog");*/

        // 2 con constructor pasándole un array
        String[] misItems = {"Serif","SansSerif","Monospaced","Calibri","Dialog"};
        miJComboBox = new JComboBox(misItems);
        miJComboBox.addActionListener(new eventosJComboBox());

        superior.add(miJComboBox);



        //
        //creación de JSlider
        //constructor de 3 argumentos, valor mínimo, máximo, y valor inicial
        miJSlider= new JSlider(8,36,18);
        miJSlider.setMajorTickSpacing(4);//pintar rallitas grandes de separación cada 8
        miJSlider.setMinorTickSpacing(2);//pintar rallitas pequeñas de separación cada 2
        miJSlider.setPaintTicks(true);//si true se ven las rallitas
        miJSlider.setPaintLabels(true);//si true pinta números min-max

        miJSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //con getValue obtenemos el valor actual del JSlide
                texto.setFont(new Font((String) miJComboBox.getSelectedItem(),Font.PLAIN,miJSlider.getValue()));
            }
        });

        superior.add(miJSlider);//añadir al panel superior

        add(superior,BorderLayout.NORTH);//añade panel superior al North del BorderLayout
    }
    private class eventosJComboBox implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            texto.setFont(new Font((String) miJComboBox.getSelectedItem(),Font.PLAIN,miJSlider.getValue()));
        }
    }
}