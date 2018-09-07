package interfacesGraficas;

import javax.swing.*;
import java.awt.*;

public class EjercicioTipoLetra {
    static String tipo;
    public static void main(String[] args) {

        //preguntar tipografía
        tipo = JOptionPane.showInputDialog("Introduce que tipografía quieres");

        MarcoFuente2 miMarcoFuente2 = new MarcoFuente2();
        miMarcoFuente2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    static String getTipo(){
        return tipo;
    }


    //metodo que devuelve true si la tipografía existe, false si no existe
    static boolean existeTipo(String tipo2) {
        //consultar tipografía
        String[] misFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String fuentes: misFuentes) {
            if (EjercicioTipoLetra.getTipo().equals(fuentes)) return true;
        }
        return false;
    }

}

class MarcoFuente2 extends JFrame{
    public MarcoFuente2() {
        setBounds(300,300,800,450);
        LaminaFuente2 milaminaFuente2 = new LaminaFuente2();
        add(milaminaFuente2);
        setVisible(true);
    }
}

class LaminaFuente2 extends JPanel{

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        Graphics2D g2 = (Graphics2D) g;

        Font miLetra = new Font(EjercicioTipoLetra.getTipo(),Font.BOLD,40);
        g2.setFont(miLetra);
        g2.setPaint(Color.BLUE);
        if (EjercicioTipoLetra.existeTipo(EjercicioTipoLetra.getTipo())) {
        g2.drawString("Hola Letras " + EjercicioTipoLetra.getTipo(),20,100);
        }else { g2.drawString("No existe " + EjercicioTipoLetra.getTipo(),20,100);
        }

    }
}


