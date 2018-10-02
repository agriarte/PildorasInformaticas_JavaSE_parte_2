package ComponentesSwing;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;

public class ManejoCuadroTexto {
    public static void main(String[] args) {
        MarcoVideo105 miMarco = new MarcoVideo105() ;
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoVideo105 extends JFrame{
    public MarcoVideo105() throws HeadlessException {
        setBounds(600,300,600,400);
        add (new LaminaVideo105());
        setVisible(true);
    }
}
class LaminaVideo105 extends JPanel{
    public LaminaVideo105() {
        JTextField miCuadroTexto = new JTextField(20);
        Document miDocument = miCuadroTexto.getDocument();
        miDocument.addDocumentListener(new EscuchaTexto());
        add(miCuadroTexto);
    }
    private class EscuchaTexto implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent e) {
            System.out.println("has entrado texto");

        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            System.out.println("has borrado texto");
        }

        @Override
        public void changedUpdate(DocumentEvent e) {

        }
    }
}