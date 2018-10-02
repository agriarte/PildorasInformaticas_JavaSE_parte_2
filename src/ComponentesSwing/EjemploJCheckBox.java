package ComponentesSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjemploJCheckBox {
    public static void main(String[] args) {
        MarcoVideo107 miMarco = new MarcoVideo107();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoVideo107 extends JFrame {
    public MarcoVideo107() throws HeadlessException {
        setBounds(600,300,600,400);
        add (new LaminaVideo107());
        setVisible(true);
    }
}

class LaminaVideo107 extends JPanel{
    JCheckBox checkNegrita,checkItalica;
    JLabel miJlabel;

    public LaminaVideo107() {
        //Sobre un BorderLayout (5 zonas: norte, sur, este, oeste y centro
        //se añaden un JPanel al North y otro al South
        //estos nuevos paneles son por defecto del tipo FlowLayout (aliniados en Horizontal)

        setLayout(new BorderLayout(10, 10));

        miJlabel = new JLabel("Hola alumnos de Java");
        miJlabel.setFont(new Font("Courier",Font.PLAIN,24));

        JPanel superior = new JPanel();
        JPanel inferior = new JPanel();

        superior.add(miJlabel);

        checkNegrita = new JCheckBox("Negrita");
        checkItalica = new JCheckBox("Itálica");

        checkNegrita.addActionListener(new ManejaChecks());
        checkItalica.addActionListener(new ManejaChecks());

        inferior.add(checkNegrita);
        inferior.add(checkItalica);

        add(superior,BorderLayout.NORTH);
        add(inferior,BorderLayout.SOUTH);

    }

    //logica del programa
    //un evento de tipo click que comprueba si algun checkBox es activo y cambia la Font
    //PLAIN = 0, BOLD = 1, ITALIC = 2, BOLD + ITALIC = 3;
    private class ManejaChecks implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int negrita_italica=0;
            if (checkNegrita.isSelected())  negrita_italica+=1;
            if (checkItalica.isSelected()) negrita_italica+=2;
            miJlabel.setFont(new Font("Corier",negrita_italica,24));
        }
    }

}
