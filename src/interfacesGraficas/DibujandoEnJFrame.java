package interfacesGraficas;

import javax.swing.*;
import java.awt.*;

public class DibujandoEnJFrame {
    public static void main(String[] args) {
        MarcoDibujos marcoDibujos = new MarcoDibujos();
        marcoDibujos.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

class MarcoDibujos extends JFrame{

    public MarcoDibujos() {
        setBounds(300,300,800,450);
        setTitle("Dibujando en JFrame");

        LaminaDibujos miLamina = new LaminaDibujos();
        add(miLamina);

        //IMPORTANTE. Antes de hacer visible se han de añadir los componentes
        setVisible(true);
    }
}

class LaminaDibujos extends JPanel{

    //Alerta: existe paintComponent y paintComponents,
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawRect(20,20,300,200);
        g.drawLine(20,20,320,220);

        g.fillRoundRect(20,250,100,100,25,25);

        g.fillOval(450,20,150,250);

        //##### texto personilido  #####
        //añadiendo color al componente gráfico
        Color miColor = new Color(0,150,0);
        g.setColor(miColor);

        //Tipografía y tamaño
        Font miTipo = new Font("Verdana",Font.BOLD,20);
        g.setFont(miTipo);

        g.drawString("ejemplos draw",450,300);
    }

}
