package Excepciones;

import javax.swing.*;

public class compruebaEmail2 {
    public static void main(String[] args) {
        String mail = JOptionPane.showInputDialog("Introduce Email: ");

        try {
            examinaMail(mail);
        } catch (ControlLongitud controlLongitud) {

            System.out.println("email demasiado corto");
            controlLongitud.printStackTrace();
        }
    }
    //EXCEPCION PERSONALIZADA
    //en este ejemplo se crea una clase que extiente de RuntimeException, ControlLongitud
    //esta clase será lanzada cuando se cumpla la condición del if, se lanza con throw (singular)
    //importante al declarar el método desde donde será lanzada usar throws ( plural )
    static void examinaMail(String mail) throws ControlLongitud {
        int arroba=0;
        boolean punto = false;
        if (mail.length()<=3){

            ControlLongitud miExcepcion = new ControlLongitud("email con 3 o menos caracteres");
            throw miExcepcion;

        }
        for (int i = 0; i < mail.length(); i++) {
            if (mail.charAt(i)=='@'){
                arroba++;
            }
            if (mail.charAt(i)=='.'){
                punto = true;
            }
        }

        if (arroba==1 && punto) {
            System.out.println("email correcto");
        } else {
            System.out.println("INCORRECTO!");
        }

    }
}

class ControlLongitud extends Exception{
    public ControlLongitud() {
    }

    //este metodo recibe un string con el texto que queramos para ampliar info del error
    public ControlLongitud(String mensajeError) {
        super(mensajeError);

    }
}
