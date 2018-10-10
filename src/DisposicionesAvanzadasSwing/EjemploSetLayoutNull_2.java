package DisposicionesAvanzadasSwing;

import javax.swing.*;
import java.awt.*;

public class EjemploSetLayoutNull_2 {

    public static void main(String[] args) {
        MarcoDisposicionLibre2 miMarco = new MarcoDisposicionLibre2();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoDisposicionLibre2 extends JFrame{
    public MarcoDisposicionLibre2() throws HeadlessException {
        setBounds(600,300,600,400);
        add(new LaminaDisposicionLibre2());
        setVisible(true);
    }
}

class LaminaDisposicionLibre2 extends JPanel{
    public LaminaDisposicionLibre2() {
        setLayout(new EnColumnas());
        JLabel nombre = new JLabel("Nombre: ");

        JLabel apellido = new JLabel("Apellido: ");

        JTextField campoNombre = new JTextField();

        JTextField campoApellido = new JTextField();


        add(nombre);
        add(campoNombre);

        add(apellido);
        add(campoApellido);

    }
}

class EnColumnas implements LayoutManager{

    //coordenadas iniciales
    private int x;
    private int y;
    //contador adicional, se usa para contar componentes y hacer salto de linea cada vez que llevamos 2
    //con % si resto = 0 es par
    int contador=0;

    @Override
    public void addLayoutComponent(String name, Component comp) {

    }

    @Override
    public void removeLayoutComponent(Component comp) {

    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return null;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return null;
    }

    @Override
    public void layoutContainer(Container miContainer) {
        //Logica para colocar parejas de contenedores en columnas de a 2
        //sirve para n elementos

        //ancho del layout contenedor
        int d = miContainer.getWidth();

        x=d/2;//centro de la pantalla
        y=20;

        //n contador componentes hay ( botones, fields, etc)
        int n = miContainer.getComponentCount();

        for (int i = 0; i < n; i++) {
            contador++;//cada vez que sea par se reinician valores x,y para ponerlos por columnas

            //a cada vuelta de bucle c almacena cada uno de los componentes
            Component c = miContainer.getComponent(i);
            //se posiciona en el Panel
            c.setBounds(x-100,y,100,20);// con x-100 centramos aproximandamente los dos componentes
            x+=100;
            if (contador%2==0){
                x=d/2;//nueva pareja -> nuevamente x al centro de pantalla
                y+=100;
            }
        }
    }
}