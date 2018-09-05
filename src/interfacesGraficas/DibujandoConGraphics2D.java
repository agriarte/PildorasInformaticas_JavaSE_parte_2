package interfacesGraficas;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class DibujandoConGraphics2D {
    public static void main(String[] args) {
        MarcoDibujos2D marcoDibujos2D = new MarcoDibujos2D();
        marcoDibujos2D.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

class MarcoDibujos2D extends JFrame {

    public MarcoDibujos2D() {
        setBounds(300,300,800,500);
        setTitle("Dibujando en JFrame");

        LaminaDibujos2D miLamina = new LaminaDibujos2D();
        miLamina.setBackground(Color.ORANGE);
        add(miLamina);

        //IMPORTANTE. Antes de hacer visible se han de añadir los componentes
        setVisible(true);
    }
}


class LaminaDibujos2D extends JPanel{

    //Alerta: existe paintComponent y paintComponents,
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //casting para usar objetos Graphics como Graphics2D.
        //esto permite usar método draw de Graphics2
        Graphics2D g2 = (Graphics2D) g;

        Rectangle2D rectangulo = new Rectangle2D.Double(50,50,250,150);
        g2.setPaint(Color.BLUE);
        g2.draw(rectangulo);

        Rectangle2D rectangulo2 = new Rectangle2D.Double(350,50,250,150);
        BasicStroke miLapiz = new BasicStroke(3);
        g2.setStroke(miLapiz);
        g2.setPaint(Color.YELLOW);
        g2.draw(rectangulo2);

        Rectangle2D rectangulo3 = new Rectangle2D.Double(350,250,250,150);
        float miDash[] = {10.0f};
        BasicStroke miLapiz2 = new BasicStroke(6,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10,miDash,0);
        g2.setStroke(miLapiz2);
        g2.setPaint(Color.RED);
        g2.draw(rectangulo3);

        //Para hacer un relleno se escoge color con setPaint y se llama a metodo fill
        //g2.setPaint(Color.PINK);
        g2.setPaint(new Color(125,55,255));
        g2.fill(rectangulo2);
    }
}
