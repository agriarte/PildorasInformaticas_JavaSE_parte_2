package Calculadora_Videos99a103;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Calculadora {
    public static void main(String[] args) {
        MarcoCalculadora miMarco = new MarcoCalculadora();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}

class MarcoCalculadora extends JFrame{
    public MarcoCalculadora() throws HeadlessException {
        setTitle("Calculadora_Videos99a103");
        setBounds(500,300,450,300);
        PanelCalculadora miLamina = new PanelCalculadora();
        add(miLamina);

        //crear icono de ventana que también será válido si se crea .JAR o .EXE
        Toolkit miHardware=Toolkit.getDefaultToolkit();
        URL rutaImagen = MarcoCalculadora.class.getResource("calculadora.png");
        Image miIcono = miHardware.getImage(rutaImagen);
        setIconImage(miIcono);
    }
}

class PanelCalculadora extends JPanel{
    JPanel numeracion;
    JButton pantalla;//boton que se usa como JText porque no lo hemos visto todavía
    boolean comienzo=true;//boolena para controlar que pantalla contiene un 0

    private String ultimaOperacion="";//almacena operacion pulsada
    private double resultado;//acumula resultado de las operaciones que vamos haciendo

    double ultimoValor;

    //el panel tiene un BorderLayout, en el BorderNorth va la pantalla,
    //en el BorderCenter va dentro un GridLayout con la botonera
    public PanelCalculadora() {
        setLayout(new BorderLayout());
        //como pantalla un JButton ocupará el ancho del BorderLayout
        pantalla = new JButton("0");
        pantalla.setEnabled(false);//inhabilita la pulsación de botón, ahora parece un Text
        add(pantalla,BorderLayout.NORTH);

        numeracion = new JPanel();
        numeracion.setLayout(new GridLayout(4,4));

        //la instancia de la clase oyente e para números
        InsertarNumero insertar = new InsertarNumero();
        // la instancia para operaciones
        Operacion realizarOperacion = new Operacion();


        ponerBoton("7",insertar);
        ponerBoton("8",insertar);
        ponerBoton("9",insertar);
        ponerBotonOperaciones("x",realizarOperacion);
        ponerBoton("4",insertar);
        ponerBoton("5",insertar);
        ponerBoton("6",insertar);
        ponerBotonOperaciones("/",realizarOperacion);
        ponerBoton("1",insertar);
        ponerBoton("2",insertar);
        ponerBoton("3",insertar);
        ponerBotonOperaciones("+",realizarOperacion);
        ponerBoton("0",insertar);
        ponerBoton(",",insertar);
        ponerBotonOperaciones("=",realizarOperacion);
        ponerBotonOperaciones("-",realizarOperacion);

        add(numeracion,BorderLayout.CENTER);
    }

    //crea botones numéricos, le añade la accion, añade boton al panel
    private void ponerBoton (String textoBoton, InsertarNumero oyente){
        JButton boton= new JButton(textoBoton);

        boton.addActionListener(oyente);

        numeracion.add(boton);
    }

    //crea botones operacios, le añade la accion, añade boton al panel
    private void ponerBotonOperaciones (String textoBoton, Operacion oyente){
        JButton boton= new JButton(textoBoton);

        boton.addActionListener(oyente);

        numeracion.add(boton);
    }

    //
    //clases internas
    //
    //cuando un boton tiene de oyente esta clase, al pulsarlo recibirá "e" donde podremos sacar el nombre
    private class InsertarNumero implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //cada vez que su pulsa un boton e.getAction nos da el valor del texto del boton
            String entrada = e.getActionCommand();

            //evita el 0 de la izquierda
            //si true el primer numero sobreescribirá lo que haya en pantalla
            //si false los numeros se van añadiendo a la pantalla
            if (comienzo) {
                pantalla.setText(entrada);
                comienzo=false;
            } else{
            //introducir la tecla pulsada en el display
            pantalla.setText(pantalla.getText()+entrada);
            }
            //almacenar el ultimo valor que haya en la pantalla cada vez que se pulsa un numero
            //este dato salvado siempre tendrá un numero de x cifras mientras se pulsen solo numeros
            ultimoValor=Double.parseDouble(pantalla.getText());
        }



    }

    //logica de operaciones
    private class Operacion implements ActionListener{

        private String ultimaOperacion;
        private int contador;//variable truco para saber si es la primera vez que se pulsa una operacion

        @Override
        public void actionPerformed(ActionEvent e) {
            //obtener nombre operacion pulsada
            String operacionPulsada = e.getActionCommand();

            //logica de la suma
            //1-al pulsar operador SUMA la var. resultado se incrementa con ultimo valor
            //2-se imprime en pantalla el resultado
            //3-true en comienzo reseteará la pantalla
            //(la primera vez que se pulsa SUMA resultado = 0 , ultimoValor = primer valor entrado)
            //(la segunda vez que se pulsa SUMA resultado = ultimo valor , ultimoValor = segundo valor entrado)
            if (operacionPulsada.equals("+")) {
                resultado += ultimoValor;
                pantalla.setText("" + resultado);
                ultimaOperacion="+";
            } else if (operacionPulsada.equals("x")) {
                //capturar el valor en pantalla
                Double valor = Double.parseDouble(pantalla.getText());
                //si es la primera vez que pulso X, contador será igual a 0, entonces me interesa que resultado valga
                //lo que haya en pantalla. Este truco en esa condición ultimo valor es 0 y resultado *= ultimoValor
                //sería igual a 0, para la segunda vez que pulso x como ya existe un valor previo de ultimoValor
                //podría aplicar la multiplicación
                if (contador == 0) resultado = valor;
                else resultado *= ultimoValor;

                pantalla.setText("" + resultado);
                ultimaOperacion = "x";
                contador++;
            } else if (operacionPulsada.equals("-")) {
                //misma lógica que X
                Double valor = Double.parseDouble(pantalla.getText());
                if (contador == 0) resultado = valor;
                else resultado -= ultimoValor;

                pantalla.setText("" + resultado);
                ultimaOperacion="-";
                contador++;
            } else if (operacionPulsada.equals("/")) {
                //misma lógica que X
                Double valor = Double.parseDouble(pantalla.getText());
                if (contador == 0) resultado = valor;
                else resultado /= ultimoValor;

                pantalla.setText("" + resultado);
                ultimaOperacion="/";
                contador++;

            } else {
                //este else se ejecuta al pulsar =
                //si lo ultimo fue una suma...
                if (ultimaOperacion.equals("+")) resultado += ultimoValor;
                //si lo ultimo fue una multiplicacion...
                if (ultimaOperacion.equals("x")) {resultado *= ultimoValor; contador=0;}

                if (ultimaOperacion.equals("-")) {resultado -= ultimoValor; contador=0;}

                if (ultimaOperacion.equals("/")) {resultado /= ultimoValor; contador=0;}



                pantalla.setText("" + resultado);
                //ultimoValor sirve para que no incremente el resultado con + despues de pulsar =
                //si no se entiende ver video 103, minuto 10
                ultimoValor=0;
                }

                    comienzo=true; //si true resetear pantalla



                }
            }
}



