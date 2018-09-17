package eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Ejemplo de varios eventos con AbstractAction

public class VariasFuentes {
    public static void main(String[] args) {
        MarcoVariasFuentes mimarcoVariasFuentes = new MarcoVariasFuentes();
        mimarcoVariasFuentes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoVariasFuentes extends JFrame{
    public MarcoVariasFuentes() throws HeadlessException {
        setBounds(50,50,800,500);
        add(new LaminaVariasFuentes());
        setVisible(true);
    }
}

class LaminaVariasFuentes extends JPanel {


    public LaminaVariasFuentes() {
        EventoColorFondo colorAzul = new EventoColorFondo("Boton Azul",Color.BLUE);
        EventoColorFondo colorRojo = new EventoColorFondo("Rojo",Color.RED);
        EventoColorFondo colorVerde = new EventoColorFondo("Verde",Color.GREEN);

        //al crear cada boton se usa un constructor que recibe objetos por parámetro
        //este objeto hereda de AbstractAction para controlar eventos
        add(new JButton(colorAzul));
        add(new JButton(colorRojo));
        add(new JButton(colorVerde));

        //
        //Lectura de eventos de teclado
        //
        //1º Crear Mapa de Entrada
        //Registrar entrada de teclado cuando el foco está en la ventana
        InputMap mapaEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        //2º Crear Combinaciones de teclas
        KeyStroke teclaAzul = KeyStroke.getKeyStroke("ctrl A");
        //3º Asignar combinaciones de teclas a objeto-descripción
        mapaEntrada.put(teclaAzul,"fondo azul");
        //4º Asignar objeto-descripción a acción
        //crear objeto ActionMap y con su método put asigna la accion colorAzul al KeyStroke a través de la clave "fondo azul"
        ActionMap mapaAccion = getActionMap();
        mapaAccion.put("fondo azul", colorAzul);

        //las otras 2 teclas
        //tecla para rojo
        KeyStroke teclaRoja = KeyStroke.getKeyStroke("ctrl R");
        mapaEntrada.put(teclaRoja,"fondo rojo");
        mapaAccion.put("fondo rojo", colorRojo);

        //Tecla para verde
        // método simplificado
        //si necesito asignar 2 teclas para el mismo evento duplico KeyStroke
        mapaEntrada.put(KeyStroke.getKeyStroke("ctrl V"),"fondo verde");
        mapaEntrada.put(KeyStroke.getKeyStroke("ctrl G"),"fondo verde");
        mapaAccion.put("fondo verde", colorVerde);
    }
    //
    //una vez mas se usa una clase interna para tener alcance al contenido de la clase Lamina
    //
    private class EventoColorFondo extends AbstractAction{
        public EventoColorFondo (String nombre, Color miColor){
            //los objetos con interfaz Action tienen una coleccion de constantes de clase donde guardar
            //nombre, descripcion, icono, tecla, ...
            //formato values, putValue guarda, getValue obtiene valor
            putValue(Action.NAME, nombre);
            putValue(Action.SHORT_DESCRIPTION, "Pone la lámina del color " + nombre);
            putValue("miColorJPanel", miColor);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //cuando se produce un evento este método se ejecuta
            Color c = (Color) getValue("miColorJPanel");
            setBackground(c);

            System.out.println("Evento que ha disparado la accion: " + getValue(Action.NAME));
            System.out.println(getValue(Action.SHORT_DESCRIPTION));
        }
    }
}






