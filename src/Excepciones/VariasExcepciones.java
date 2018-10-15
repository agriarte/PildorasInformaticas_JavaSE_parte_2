package Excepciones;

import javax.swing.*;

public class VariasExcepciones {
    public static void main(String[] args) {
        try {
            division();
        }catch (ArithmeticException e){
            System.out.println("división por 0");
            System.out.println("nombre de excepcion " + e.getClass().getName());
        }catch (NumberFormatException e){
            System.out.println("valor numérico no válido");
            System.out.println("nombre de excepcion " + e.getClass().getName());
        }

    }

    static void division() {
        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce dividendo"));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce divisor"));
        System.out.println("El resultado es: " + num1/num2);
    }
}
