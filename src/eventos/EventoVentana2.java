package eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class EventoVentana2 {public static void main(String[] args) {
    MarcoVentana2 miMarcoVentana2 = new MarcoVentana2();
    miMarcoVentana2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

}
}
class MarcoVentana2 extends JFrame{
    public MarcoVentana2() throws HeadlessException {

        setBounds(300,300,600,350);
        addWindowListener(new EventosMarcoVentana2());
        setVisible(true);
    }
}

//eventos de ventana usando clase adaptadora en lugar de interface
//la clase adaptadora implementa los interfaces pero no es necesario implementarlos todos
//ventaja: código más limpio
class EventosMarcoVentana2 extends WindowAdapter {
    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Ventana cerrada");
    }
}