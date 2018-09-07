package interfacesGraficas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class ManejoDeImagenes {
    public static void main(String[] args) {
        MarcoImagenes miMarcoImagenes = new MarcoImagenes();
        miMarcoImagenes.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

class MarcoImagenes extends JFrame{
    public MarcoImagenes() {
        setBounds(300,300,800,500);
        setTitle("Imagenes en JFrame");

        LaminaImagenes miLamina = new LaminaImagenes();
        miLamina.setBackground(Color.ORANGE);
        add(miLamina);

        //IMPORTANTE. Antes de hacer visible se han de añadir los componentes
        setVisible(true);
    }
}

class LaminaImagenes extends JPanel{

    private Image imagen,imagen2;

    //Alerta: existe paintComponent y paintComponents,
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Para abrir una imagen se utilizan las clasee File y ImageIO
        File miImagen = new File("src/interfacesGraficas/figuras.jpg");
        try {
            imagen = ImageIO.read(miImagen);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //método drawImage de la clase Graphics para pintar la imagen
        g.drawImage(imagen,50,50,null);

        g.copyArea(50,50,220,220,400,0);

/*
        //#############
        // Otro ejemplo, copiar una parte de la lámina en mosaico
        File miImagen2 = new File("src/interfacesGraficas/iconoGIF.jpg");
        try {
            imagen2 = ImageIO.read(miImagen2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //obtener anchura y altura de imagen
        int anchuraImagen = imagen2.getWidth(this);
        int alturaImagen = imagen2.getHeight(this);

        g.drawImage(imagen2,0,0,null);

        for (int i = 0; i < 800 ; i++) {
            for (int j = 0; j < 500 ; j++) {
                g.copyArea(0,0,anchuraImagen,alturaImagen,anchuraImagen*i,alturaImagen*j);
            }
        }

*/
    }
}
