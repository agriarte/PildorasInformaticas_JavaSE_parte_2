package interfacesGraficas;

import javax.swing.*;
import java.awt.*;

public class PrimerFrame2 {
    public static void main(String[] args) {
        MiJFrame miVentana = new MiJFrame();
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MiJFrame extends JFrame {
    public MiJFrame() {

        //setSize(600, 350);//tamaño de ventana

        //setLocation(600, 400);//Coordenadas
        //setLocationRelativeTo(null);//si pasamos null situa la ventana en el centro

        setBounds(500,400,600,350);// coordenadas y tamaño de la ventana
        setTitle("Ventana de pruebas");//Titulo de ventana

        /**** para cambiar icono ****/
        Toolkit miSistema = Toolkit.getDefaultToolkit();
        Image miIcono = miSistema.getImage("iconoSatelite.png");
        setIconImage(miIcono);
        /*                          */

        //setResizable(false);//tamaño fijo o se puede cambiar
        //setExtendedState(MAXIMIZED_BOTH);//ventana a toda pantalla
        setVisible(true);// hacer visible la ventana, por defecto false
    }

}
