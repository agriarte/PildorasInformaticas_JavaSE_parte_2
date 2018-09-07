package interfacesGraficas;

import javax.swing.*;
import java.awt.*;

public class TipoLetra {
    public static void main(String[] args) {
        MarcoFuente miMarcoFuente = new MarcoFuente();
        miMarcoFuente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoFuente extends JFrame{
    public MarcoFuente() {
        setBounds(300,300,800,450);
        LaminaFuente milaminaFuente = new LaminaFuente();
        add(milaminaFuente);
        setVisible(true);
    }
}

class LaminaFuente extends JPanel{
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        Font miLetra = new Font("Courier new",Font.BOLD,40);
        g2.setFont(miLetra);
        g2.setPaint(Color.CYAN);
        g2.drawString("Hola Letras",20,100);
    }
}
