package ComponentesSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class EjemploJMenu {
    public static void main(String[] args) {
        MarcoJMenu miMenu = new MarcoJMenu();

    }
}

class MarcoJMenu extends JFrame{
    public MarcoJMenu() throws HeadlessException {
    setBounds(600,300,600,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    add(new LaminaJMenu());
    setVisible(true);
    }

}

class LaminaJMenu extends JPanel{
    public LaminaJMenu() {

        //primero crear barra soporte
        JMenuBar miJMenuBar = new JMenuBar();

        //---- Elementos del menú -------
        JMenu archivo = new JMenu("Archivo");
        JMenu edicion = new JMenu("Edición");
        JMenu herramientas = new JMenu("Herramientas");

        //añadir a la barra los menús
        miJMenuBar.add(archivo);
        miJMenuBar.add(edicion);
        miJMenuBar.add(herramientas);

        //---- Elementos del Archivo -------
        JMenuItem guardar = new JMenuItem("Guardar");
        JMenuItem guardarComo = new JMenuItem("Guardar como");

        //los Action Listener van como ya se ha visto
        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("has pulsado guardar");
            }
        });
        guardarComo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("has pulsado guardar como");
            }
        });

        //añadir a Archivo los items
        archivo.add(guardar);
        archivo.addSeparator();//separador entre items
        archivo.add(guardarComo);

        //---- Elementos de Edición -------
        JMenuItem copiar = new JMenuItem("Copiar");
        JMenuItem cortar = new JMenuItem("Cortar");
        JMenuItem pegar = new JMenuItem("Pegar");
        //añadir a Edición los items
        edicion.add(copiar);
        edicion.add(cortar);
        edicion.add(pegar);

        //---- Elementos de Herramientas -------
        JMenuItem opciones = new JMenuItem("Opciones");
        JMenu preferencias = new JMenu("Preferencias");

        JMenuItem pref1 = new JMenuItem("pref1");
        JMenuItem pref2 = new JMenuItem("pref2");
        JMenuItem pref3 = new JMenuItem("pref3");

        preferencias.add(pref1);
        preferencias.add(pref2);
        preferencias.add(pref3);

        herramientas.add(opciones);
        herramientas.addSeparator();
        herramientas.add(preferencias);


        //por último agregar la barra ya completa
        add(miJMenuBar);
    }
}
