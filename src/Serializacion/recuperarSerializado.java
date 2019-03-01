package Serializacion;

import java.io.*;

public class recuperarSerializado {
    //serialVersionUID -> numero de version o huella digital
    //recomendable asiganar un valor manualmente para que se pueda leer el archivo en otros programas
    //por defecto debería de coger el mismo valor pero si se hacen cambios puede variar y entonces dará
    //error en otras partes del programa
    private static final long serialVersionUID=1L;

    public static void main(String[] args) {



        try {
            ObjectInputStream miObjectInput = new ObjectInputStream(new FileInputStream("G:/JAVA/PildorasInformaticas/JAVA_SE/Ejercicios2/src/Serializacion/archivo.dat"));

            Empleados[] entradaObjeto = (Empleados[]) miObjectInput.readObject();
            miObjectInput.close();

            for (Empleados e: entradaObjeto) {
                System.out.println(e.toString());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
