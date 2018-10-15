package Excepciones;

import javax.swing.*;

public class compruebaEmail {
    public static void main(String[] args) {
        String mail = JOptionPane.showInputDialog("Introduce Email: ");

        examinaMail(mail);
    }

    static void examinaMail(String mail) {
        int arroba=0;
        boolean punto = false;
        if (mail.length()<=3){
            //ejemplo poco real de uso de excepciones, solo para uso didáctico
            //la idea es crear un excepcion en cualquier lugar del código con throw que lanzará una
            //excepcion y detendrá el flujo
            ArrayIndexOutOfBoundsException miExcepcion = new ArrayIndexOutOfBoundsException();
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
