package ComponentesSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;

public class EjemploJPopupMenu {
    public static void main(String[] args) {
        MarcoJPopup miMarco = new MarcoJPopup();


    }
}

class MarcoJPopup extends JFrame{
    public MarcoJPopup() throws HeadlessException {
        setBounds(600,300,600,400);
        add(new LaminaJPopup());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class LaminaJPopup extends JPanel{
    JMenuItem opcionRojo,opcionAzul,opcionVerde;
    public LaminaJPopup() {
        //instancia de clase menu emergente
        JPopupMenu emergente = new JPopupMenu();
        //crear items, sus respectivos oyentes y agregar al menu emergente
        opcionRojo = new JMenuItem("color Rojo ");
        opcionRojo.addActionListener(new OyenteItems());
        emergente.add(opcionRojo);

        emergente.add (new JPopupMenu.Separator());

        opcionAzul = new JMenuItem("color Azul");
        opcionAzul.addActionListener(new OyenteItems());
        emergente.add(opcionAzul);

        emergente.add (new JPopupMenu.Separator());

        opcionVerde = new JMenuItem("color Verde");
        opcionVerde.addActionListener(new OyenteItems());
        emergente.add(opcionVerde);

        emergente.add (new JPopupMenu.Separator());

        //agrega a la lamina el menu emergente creado
        setComponentPopupMenu(emergente);



    }
    private class OyenteItems implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if ( e.getSource()== opcionRojo ) {
               setBackground(Color.RED);
            }

            if ( e.getSource()== opcionAzul) {
                setBackground(Color.BLUE);
            }

            if ( e.getSource()== opcionVerde) {
                setBackground(Color.GREEN);
            }

        }
    }
}