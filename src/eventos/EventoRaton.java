package eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//
//Ejemplo de eventos Raton usando Interfaz
//
public class EventoRaton {
    public static void main(String[] args) {
        MarcoEventoRaton miMarcoEventoRaton = new MarcoEventoRaton();
        miMarcoEventoRaton.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        miMarcoEventoRaton.addMouseListener(new OyenteEventosRaton());
    }
}
class MarcoEventoRaton extends JFrame{
    public MarcoEventoRaton() throws HeadlessException {
        setBounds(50,50,600,300);
        setVisible(true);
    }
}

class OyenteEventosRaton implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouseClicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mousePressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouseReleased");    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouseEntered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouseExited");
    }
}