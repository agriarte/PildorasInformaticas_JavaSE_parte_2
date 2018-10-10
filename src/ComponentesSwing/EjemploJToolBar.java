package ComponentesSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EjemploJToolBar {
    public static void main(String[] args) {
        MarcoJToolBar miMarco = new MarcoJToolBar();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
   }

class MarcoJToolBar extends JFrame{
    JPanel miLamina;
    public MarcoJToolBar() throws HeadlessException {
        setBounds(600,300,500,350);
        miLamina = new JPanel();
        add(miLamina);

        EventoColorFondo2 colorAzul = new EventoColorFondo2("Azul", Color.BLUE, new ImageIcon("src/imagenes/coche-negro.png"));
        EventoColorFondo2 colorRojo = new EventoColorFondo2("Rojo", Color.RED, new ImageIcon("src/imagenes/llave-pequena.png"));
        EventoColorFondo2 colorVerde = new EventoColorFondo2("Verde", Color.GREEN, new ImageIcon("src/imagenes/nube-pequena.png"));

        JToolBar miJToolBar = new JToolBar();
        miJToolBar.add(colorAzul);
        miJToolBar.add(colorRojo);
        miJToolBar.add(colorVerde);
        //añadir la barra al Marco
        add(miJToolBar,BorderLayout.NORTH);

    }

    //
    //una vez mas se usa una clase interna para tener alcance al contenido de la clase Lamina
    //
    private class EventoColorFondo2 extends AbstractAction {
        public EventoColorFondo2(String nombre, Color miColor, Icon miIcono) {
            //AbstractAction define propiedades para objetos Action, los valores se pasan con pares putValues
            //los objetos con interfaz Action tienen una coleccion de constantes de clase donde guardar
            //nombre, descripcion, icono, tecla, ...
            //formato values, putValue guarda, getValue obtiene valor
            putValue(Action.NAME, nombre); //si hay icono el nombre no es visible
            putValue(Action.SMALL_ICON, miIcono);
            putValue(Action.SHORT_DESCRIPTION, "Pone la lámina del color " + nombre);
            putValue("miColorJPanel", miColor);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            //cuando se produce un evento este método se ejecuta
            Color c = (Color) getValue("miColorJPanel");
            miLamina.setBackground(c);

            System.out.println("Evento que ha disparado la accion: " + getValue(Action.NAME));
            System.out.println(getValue(Action.SHORT_DESCRIPTION));
        }
    }
}



