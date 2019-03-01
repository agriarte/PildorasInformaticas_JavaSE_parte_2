package streams;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class AccesoLecturaFichero {
    public static void main(String[] args) {
        LeerFichero acceso_externo = new LeerFichero();
        acceso_externo.leeDatos();

    }

}

class LeerFichero {
    public void leeDatos(){
        try {
            //FileReader devuelve un flujo de código UNICode de un archivo
            //para convertirlo a caracteres con un simple casteo se soluciona

            FileReader entrada = new FileReader("G:/JAVA/PildorasInformaticas/JAVA_SE/Ejercicios2/src/streams/texto.txt");

            int caracter=entrada.read();
            char letra = (char) caracter;

            //read va tomando uno a uno los códigos del archivo. Cuando no hay mas devuelve -1
            while (caracter!=-1){
                letra = (char) caracter;
                System.out.print(letra);
                caracter=entrada.read();

            }
            entrada.close();

            // es obligatorio capturar las excepciones que lanzan FileReader y Read
        } catch (java.io.IOException e) {
            e.printStackTrace();
            System.out.println("FICHERO NO ENCONTRADO!");
        }

    }

}
