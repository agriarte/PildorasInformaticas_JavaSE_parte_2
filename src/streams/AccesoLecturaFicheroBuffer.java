package streams;

import java.io.BufferedReader;
import java.io.FileReader;

public class AccesoLecturaFicheroBuffer {
    public static void main(String[] args) {
        LeerFicheroBuffer acceso_externo = new LeerFicheroBuffer();
        acceso_externo.leeDatos();
    }
}

class LeerFicheroBuffer {
    public void leeDatos() {
        try {

            FileReader entrada = new FileReader("G:/JAVA/PildorasInformaticas/JAVA_SE/Ejercicios2/src/streams/texto.txt");
            BufferedReader miBuffer = new BufferedReader(entrada);

            String linea = "";


            //readline va leyendo linea a linea buscando \n o \r Si no encuentra por fin de archivo
            //devuelve null
            while (linea != null) {
                linea = miBuffer.readLine();
                if (linea!=null) System.out.println(linea);

            }
            entrada.close();

            // es obligatorio capturar las excepciones que lanzan FileReader y Read
        } catch (java.io.IOException e) {
            e.printStackTrace();
            System.out.println("FICHERO NO ENCONTRADO!");
        }

    }

}
