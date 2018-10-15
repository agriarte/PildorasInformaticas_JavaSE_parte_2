package Excepciones;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

public class fallo1 {
    public static void main(String[] args) {
        MarcoFallo1 miMarco = new MarcoFallo1();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);

    }
}

class MarcoFallo1 extends JFrame{
    public MarcoFallo1() throws HeadlessException {
        setBounds(600,300,600,400);
        setTitle("práctica de excepciones");
        add(new LaminaFallo1());
    }
}

class LaminaFallo1 extends JPanel{
    private Image imagen;
    public LaminaFallo1() {

        //Para abrir una imagen se utilizan las clasee File y ImageIO
        File miImagen = new File("src/interfacesGraficas/figuraas.jpg");
        try {
            imagen = ImageIO.read(miImagen);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("imagen no encontrada");
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // si no encuentra imagen será Null
        if (imagen==null) {
            g.drawString("Mensaje en Panel: imagen no encontrada", 50,50);

            } else {
            //método drawImage de la clase Graphics para pintar la imagen
            g.drawImage(imagen, 50, 50, null);

            g.copyArea(50, 50, 220, 220, 400, 220);
        }
    }
}


