import javax.swing.*;
import java.awt.*;

// ###### SIN ACABAR #####
// #######################
public class EjercicioCalculadora {
    public static void main(String[] args) {
        MarcoCalculadora miMarco = new MarcoCalculadora();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);

    }
}

class MarcoCalculadora extends JFrame{
    public MarcoCalculadora() throws HeadlessException {
        setTitle("Calculadora_Videos99a103");
        setBounds(50,50,300,300);
        add(new PanelResultado());
        add(new TeclasCalculadora(),BorderLayout.SOUTH);
    }
}

class TeclasCalculadora extends JPanel{
    JButton btn00,btn01,btn02,btn03,btn04,btn05,btn06,btn07,btn08,btn09;
    JButton btnSumar,btnRestar,btnMultiplicar,btnDividir,btnIgual,btnBorrar,btnDecimal,btnSignoMenos,btnVacio1,btnVacio2;
    public TeclasCalculadora() {

        //definir tipo layout
        setLayout(new GridLayout(5,4,5,5));

        //crear botones
        btn09 = new JButton("9");
        btn08 = new JButton("8");
        btn07 = new JButton("7");
        btn06 = new JButton("6");
        btn05 = new JButton("5");
        btn04 = new JButton("4");
        btn03 = new JButton("3");
        btn02 = new JButton("2");
        btn01 = new JButton("1");
        btn00 = new JButton("0");

        btnSumar = new JButton("+");
        btnRestar = new JButton("-");
        btnDividir = new JButton("/");
        btnMultiplicar = new JButton("*");
        btnIgual = new JButton("=");
        btnBorrar = new JButton("C");
        btnDecimal = new JButton(",");
        btnSignoMenos = new JButton("+-");
        btnVacio1= new JButton(" ");
        btnVacio2= new JButton(" ");

        //se va añadiendo en orden un elemento en cada celda
        add(btnBorrar);add(btnVacio1);add(btnVacio2);add(btnDividir);
        add(btn07);add(btn08);add(btn09);add(btnMultiplicar);
        add(btn04);add(btn05);add(btn06);add(btnRestar);
        add(btn01);add(btn02);add(btn03);add(btnSumar);
        add(btnSignoMenos);add(btn00);add(btnDecimal);add(btnIgual);
    }
}

class PanelResultado extends JPanel{
    JTextField resultado,operadores;
    public PanelResultado() {

        resultado=new JTextField();
        operadores=new JTextField();
        resultado.setBounds(20,20,260,20);
        operadores.setBounds(20,40,260,20);
        operadores.setBackground(Color.ORANGE);
        resultado.setBackground(Color.GRAY);
        add(resultado);
        add(operadores);


    }
}
