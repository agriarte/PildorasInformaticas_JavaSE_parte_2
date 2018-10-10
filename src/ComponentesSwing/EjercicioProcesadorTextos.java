package ComponentesSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjercicioProcesadorTextos {
    public static void main(String[] args) {
        MarcoProcesadorTextosStyled miMarco = new MarcoProcesadorTextosStyled();


    }
}

class MarcoProcesadorTextos extends JFrame{
    public MarcoProcesadorTextos() throws HeadlessException {
        setBounds(600,300,600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new LaminaProcesadorTextosStyled());
        setVisible(true);
    }
}

class LaminaProcesadorTextos extends JPanel{
    //JTextPane tiene mas configuraciones que JTextArea que para este ejemplo nos interesa usar.
    //permite hacer ediciones y poner barra de Scroll
    JTextPane areaTextPane;
    JMenu fuente,estilo,tamagno;

    public LaminaProcesadorTextos() {
        setLayout(new BorderLayout());
        JPanel laminaMenu = new JPanel();

        //---- Barra y menus
        JMenuBar barraMenu = new JMenuBar();
        fuente = new JMenu("Fuente");
        estilo = new JMenu("Estilo");
        tamagno = new JMenu("Tamaño");

        configurarMenu("Arial","fuente","Arial",1,14);
        configurarMenu("Courier","fuente","Courier",1,14);
        configurarMenu("Verdana","fuente","Verdana",1,14);

        configurarMenu("Negrita","estilo","",Font.BOLD,14);
        configurarMenu("Cursiva","estilo","",Font.ITALIC,14);

        configurarMenu("12","tamaño","",1,12);
        configurarMenu("14","tamaño","",1,14);
        configurarMenu("18","tamaño","",1,18);
        configurarMenu("22","tamaño","",1,22);


        barraMenu.add(fuente);
        barraMenu.add(estilo);
        barraMenu.add(tamagno);


        laminaMenu.add(barraMenu);
        //al North
        add(laminaMenu,BorderLayout.NORTH);
        //---------fin de menú

        //----- Aquí empieza el área de texto
        JPanel laminaTexto = new JPanel();

        areaTextPane = new JTextPane();

        add(areaTextPane,BorderLayout.CENTER);

    }

    public void configurarMenu ( String itemMenu, String menu, String tipoLetra, int estilos, int tamagnos) {
        //este método va añadiendo los items para cada menú según los parámetros que recibe
        JMenuItem elemMenu = new JMenuItem(itemMenu);
        if (menu=="fuente") fuente.add(elemMenu);
        else if (menu=="estilo") estilo.add(elemMenu);
        else if (menu=="tamaño") tamagno.add(elemMenu);

        //el actionlistener de cada Item
        elemMenu.addActionListener(new GestionaEventos(itemMenu,menu,tipoLetra,estilos,tamagnos));

    }
    private class GestionaEventos implements ActionListener{
        String itemMenu,menu,tipoLetra;
        int estilos,tamagnos;

        Font letraExistente;

        public GestionaEventos(String itemMenu, String menu, String tipoLetra, int estilos, int tamagnos) {
            this.itemMenu = itemMenu;
            this.menu = menu;
            this.tipoLetra = tipoLetra;
            this.estilos = estilos;
            this.tamagnos = tamagnos;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //obtener tipografía existente en el texto, para mantener otras características cuando se cambia una
            letraExistente=areaTextPane.getFont();

            //la lógica de estos If es que siempre preserva los otros valores del texto para poder cambiar solo
            //la característica seleccionada
            if (itemMenu=="Courier" || itemMenu=="Arial" || itemMenu=="Verdana"){
                estilos=letraExistente.getStyle();
                tamagnos=letraExistente.getSize();
            } else if (itemMenu=="Negrita" || itemMenu=="Cursiva") {
                //si previamente habia un estilo seleccionado y cogemos otro, será siempre Bold + Italic (=3)
                if(letraExistente.getStyle()==1 || letraExistente.getStyle()==2) estilos=3;
                tipoLetra=letraExistente.getFontName();
                tamagnos=letraExistente.getSize();
            } else if (itemMenu=="12" || itemMenu=="14" || itemMenu=="18" || itemMenu=="22"){
                tipoLetra=letraExistente.getFontName();
                estilos=letraExistente.getStyle();
            }

            areaTextPane.setFont(new Font(tipoLetra,estilos,tamagnos));

        }


    }

}
