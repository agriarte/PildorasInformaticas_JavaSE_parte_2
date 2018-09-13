package eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventoTeclado {
    public static void main(String[] args) {
        MarcoEventoTeclado miMarcoEventoTeclado = new MarcoEventoTeclado();
        miMarcoEventoTeclado.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        miMarcoEventoTeclado.addKeyListener(new OyenteEventoTeclado());
    }
}

class MarcoEventoTeclado extends JFrame{
    public MarcoEventoTeclado() throws HeadlessException {
        setBounds(100,100,600,300);
        setVisible(true);
    }
}

class OyenteEventoTeclado implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("tecla soltada");
        System.out.println(e.getKeyCode());//devuelve 0 porque la tecla ya ha sido soltada
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("tecla pulsada: " + e.getKeyChar() + " code: " + e.getKeyCode() );
        if (e.getKeyCode()==74) System.out.println("e.getKeyCode 74 - has pulsado la tecla J keyCode 74");
        if (e.getKeyCode()==KeyEvent.VK_C) System.out.println("e.getKeyCode()==KeyEvent.VK_C - has pulsado tecla C");
        System.out.println("Leyedo e.getKeyText(e.getKeyCode()) " + e.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("tecla tecleada");
        System.out.println(e.getKeyCode());
    }
}
