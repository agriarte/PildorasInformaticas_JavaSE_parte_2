package ComponentesSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjemploJTextArea {
        public static void main(String[] args) {
            MarcoVideo106 miMarco = new MarcoVideo106() ;
            miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

    class MarcoVideo106 extends JFrame{
        public MarcoVideo106() throws HeadlessException {
            setBounds(600,300,600,400);
            add (new LaminaVideo106());
            setVisible(true);
        }
    }
    class LaminaVideo106 extends JPanel{
        public LaminaVideo106() {
            JTextArea miAreaTexto = new JTextArea(7,25);
            //para que tenga barras de desplazamiento se agrega el JTextArea a un panel especial
            //así cuando el texto llega al final del area aparecen barras
            JScrollPane miScrollPane = new JScrollPane(miAreaTexto);
            miAreaTexto.setLineWrap(true);//salto de linea automatico
            add(miScrollPane);// ojo! se agrega el nuevo Panel

            JButton miBoton = new JButton("boton");
            miBoton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(miAreaTexto.getText());
                }
            });
            add(miBoton);
        }
    }

