package eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class EventoVentana {
    public static void main(String[] args) {
        MarcoVentana miMarcoVentana = new MarcoVentana();
        miMarcoVentana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
class MarcoVentana extends JFrame{
    public MarcoVentana() throws HeadlessException {

        setBounds(300,300,600,350);
        addWindowListener(new EventosMarcoVentana());
        setVisible(true);
    }
}

class EventosMarcoVentana implements WindowListener{

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Window Opened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Window Closing");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Window Closed");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("Window Iconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("Window Deiconified");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Window Activated");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}