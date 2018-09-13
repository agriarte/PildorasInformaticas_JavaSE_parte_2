package eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

//
// Ejemplo de MotionListener del raton, interfaz con 2 métodos,
// uno para movimiento, otro de arrastre típico con click
//
public class EventoRaton3 {
    public static void main(String[] args) {
    MarcoEventoRaton3 miMarcoEventoRaton3 = new MarcoEventoRaton3();
    miMarcoEventoRaton3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    miMarcoEventoRaton3.addMouseMotionListener(new OyenteEventosRaton3());

}
}
class MarcoEventoRaton3 extends JFrame{
    public MarcoEventoRaton3() throws HeadlessException {
        setBounds(50,50,600,300);
        setVisible(true);
    }
}

class OyenteEventosRaton3 implements MouseMotionListener{

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Arrastre");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("Moviendo Raton");
    }
}

