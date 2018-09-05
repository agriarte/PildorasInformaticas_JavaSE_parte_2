package interfacesGraficas;

import javax.swing.*;
import java.awt.*;

public class EscribiendoEnMarco {
    public static void main(String[] args) {

        MarcoTexto miMarcoTexto = new MarcoTexto();
        miMarcoTexto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


//marco que define la ventana del programa
class MarcoTexto extends JFrame {

    public MarcoTexto() {
        setBounds(400, 200, 600, 250);
        setTitle("Escritura en JFrame");

        //agregar el panel al marco
        PrimerPanel miLamina = new PrimerPanel();
        add(miLamina);

        setVisible(true);
    }
}

//lamina donde se pintan textos y graficos
class PrimerPanel extends JPanel {

    public PrimerPanel() {
        //establecer color de fondo con clase interna anónima
        setBackground(new Color(0x22A1DC));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);



        //añadiendo color al componente gráfico
        Color miColor = new Color(0,150,0);
        g.setColor(miColor);

        //Tipografía y tamaño
        Font miTipo = new Font("Verdana",Font.BOLD,20);
        g.setFont(miTipo);

        //Finalmente pintar componente
        g.drawString("Primer Panel", 20, 30);
    }


}


