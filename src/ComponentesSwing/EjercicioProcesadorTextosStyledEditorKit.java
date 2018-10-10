package ComponentesSwing;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjercicioProcesadorTextosStyledEditorKit {
    public static void main(String[] args) {
        MarcoProcesadorTextosStyled miMarco = new MarcoProcesadorTextosStyled();


    }
}

class MarcoProcesadorTextosStyled extends JFrame{
    public MarcoProcesadorTextosStyled() throws HeadlessException {
        setBounds(600,300,600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new LaminaProcesadorTextosStyled());
        setVisible(true);
    }
}

class LaminaProcesadorTextosStyled extends JPanel{
    //JTextPane tiene mas configuraciones que JTextArea que para este ejemplo nos interesa usar.
    //permite hacer ediciones y poner barra de Scroll
    JTextPane areaTextPane;
    JMenu fuente,estilo,tamagno;

    public LaminaProcesadorTextosStyled() {
        setLayout(new BorderLayout());
        JPanel laminaMenu = new JPanel();

        //---- Barra y menus
        JMenuBar barraMenu = new JMenuBar();
        fuente = new JMenu("Fuente");
        estilo = new JMenu("Estilo");
        tamagno = new JMenu("Tamaño");

        configurarMenuStyled("Arial","fuente","Arial",1,14);
        configurarMenuStyled("Courier","fuente","Courier",1,14);
        configurarMenuStyled("Verdana","fuente","Verdana",1,14);

        configurarMenuStyled("Negrita","estilo","",Font.BOLD,14);
        configurarMenuStyled("Cursiva","estilo","",Font.ITALIC,14);

        configurarMenuStyled("12","tamaño","",1,12);
        configurarMenuStyled("14","tamaño","",1,14);
        configurarMenuStyled("18","tamaño","",1,18);
        configurarMenuStyled("22","tamaño","",1,22);


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

    public void configurarMenuStyled(String itemMenu, String menu, String tipoLetra, int estilos, int tamagnos) {
        //este método va añadiendo los items para cada menú según los parámetros que recibe
        JMenuItem elemMenu = new JMenuItem(itemMenu);
        if (menu=="fuente") {
            fuente.add(elemMenu);
            elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction ("cambiaLetra" , tipoLetra));
        }
        else if (menu=="estilo") {
            estilo.add(elemMenu);
            if (estilos==Font.BOLD) elemMenu.addActionListener(new StyledEditorKit.BoldAction());
            if (estilos==Font.ITALIC) elemMenu.addActionListener(new StyledEditorKit.ItalicAction());
        }
        else if (menu=="tamaño") {
            tamagno.add(elemMenu);
            elemMenu.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño",tamagnos));
        }

    }


}
