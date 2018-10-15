package Excepciones;

import javax.swing.*;
import java.util.Scanner;

public class ejemploFinally {
    static int figura;
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escribe una opción: \n 1- Cuadrado\n 2- Rectángulo\n 3- Triángulo\n 4- Círculo");

        try {
        figura = entrada.nextInt();

        } catch (Exception e){
            System.out.println("hay un error");
        } finally {
            //ejemplo poco práctico de uso de finally
            //se capture o no una excepción siempre se cerrará la conexión con Scanner
            entrada.close();
        }

        switch (figura){
            case 1:
                int lado = Integer.parseInt(JOptionPane.showInputDialog("Introduce el lado"));
                System.out.println("Área del cuadrado = "+ Math.pow(lado,2));
                break;
            case 2:
                int base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
                int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
                System.out.println("Área del rectángulo es " + base*altura);
                break;
            case 3:
                base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
                altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
                System.out.println("Área del triángulo es " + (base*altura)/2);
                break;
            case 4:
                int radio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio"));
                System.out.println("Área del círculo es " + Math.PI*(Math.pow(radio,2)));
                break;
                default:
                    System.out.println("Opción no es correcta");
        }
        int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu altura"));
        System.out.println("Si eres hombre tu altura ideal es " + (altura-110) + "Kg.");
        System.out.println("Si eres mujer tu altura ideal es " + (altura-120)  + "Kg.");
    }
}
