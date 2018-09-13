package eventos;

import javax.swing.*;
import java.awt.*;

public class EventoRaton {
    public static void main(String[] args) {
        MarcoEventoRaton miMarcoEventoRaton = new MarcoEventoRaton();
        miMarcoEventoRaton.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
class MarcoEventoRaton extends JFrame{
    public MarcoEventoRaton() throws HeadlessException {
        setBounds(50,50,600,300);
        setVisible(true);
    }
}