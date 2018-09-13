package eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//
//Ejemplo de eventos Raton usando Clase Adaptadora
//
public class EventoRaton2 {
    public static void main(String[] args) {
        MarcoEventoRaton2 miMarcoEventoRaton2 = new MarcoEventoRaton2();
        miMarcoEventoRaton2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        miMarcoEventoRaton2.addMouseListener(new OyenteEventosRaton2());

    }
}
class MarcoEventoRaton2 extends JFrame{
    public MarcoEventoRaton2() throws HeadlessException {
        setBounds(50,50,600,300);
        setVisible(true);
    }
}

class OyenteEventosRaton2 extends MouseAdapter {
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse Pressed");
        System.out.println("X = " + e.getX() + " Y= " + e.getY());
        System.out.println("getPoint = " + e.getPoint());
        System.out.println("getClickCount = " + e.getClickCount());

        System.out.println(e.getModifiersEx());//1024 boton1, 4096 boton 2

        if (e.getModifiersEx()==InputEvent.BUTTON1_DOWN_MASK) System.out.println("BTN1 Pulsado");
        if (e.getModifiersEx()==InputEvent.BUTTON3_DOWN_MASK) System.out.println("BTN2 Pulsado");

    }
}
