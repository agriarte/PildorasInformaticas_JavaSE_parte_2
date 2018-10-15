package Excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EntradaDatos {
    public static void main(String[] args) {
        System.out.println("Qué deseas hacer?");
        System.out.println("1- Introducir Datos");
        System.out.println("2- Salir del programa");

        Scanner entrada = new Scanner (System.in);

        int decision = entrada.nextInt();

        if (decision==1){
            try {
                pedirDatos();
                //captura objeto error e
            } catch (InputMismatchException e){
                System.out.println("dato erróneo");
            }

        } else {
            System.out.println("Adios");
            System.exit(0);
        }

        entrada.close();
        System.out.println("Hemos terminado");
    }

    static void pedirDatos() throws InputMismatchException {
        Scanner entrada = new Scanner (System.in);
        System.out.println("Introduce tu nombre");
        String nombre = entrada.nextLine();
        System.out.println("Introduce tu edad");
        int edad = entrada.nextInt();
        System.out.println("Hola " + nombre + ". El año que viene tendrás " + (edad+1) + " años");
        entrada.close();

    }

}
