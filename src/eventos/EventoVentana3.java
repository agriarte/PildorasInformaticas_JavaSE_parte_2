package eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

public class EventoVentana3 {
    public static void main(String[] args) {
        MarcoVentana3 miMarcoVentana3 = new MarcoVentana3();
        miMarcoVentana3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

class MarcoVentana3 extends JFrame{
    public MarcoVentana3() throws HeadlessException {
        setBounds(50, 50, 600, 400);
        addWindowStateListener(new EventosMarcoVentana3());
        setVisible(true);
    }
}

class EventosMarcoVentana3 implements WindowStateListener{

    @Override
    public void windowStateChanged(WindowEvent e) {
        System.out.println("Ventana ha cambiado de estado");

        //el objeto e a través del método getNewState nos devuelve los cambios de estado de la ventana
        System.out.println(e.getNewState());
        if (e.getNewState()==Frame.MAXIMIZED_BOTH) System.out.println("Ventana Maximizada");
        if (e.getNewState()==Frame.ICONIFIED) System.out.println("Ventana Minimizada");

    }
}
