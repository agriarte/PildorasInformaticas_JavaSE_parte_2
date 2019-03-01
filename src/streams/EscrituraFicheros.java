package streams;

import java.io.FileWriter;
import java.io.IOException;

public class EscrituraFicheros {

    public static void main (String[] args) {
        Escritura creaArchivo = new Escritura();
        creaArchivo.escribiendo();
    }




}

class Escritura {

    public void escribiendo() {
        String texto = "Estamos escribiendo a través de Strings 3";
        try {
            FileWriter escritura = new FileWriter("G:/JAVA/PildorasInformaticas/JAVA_SE/Ejercicios2/src/streams/textoescrito.txt");

            for (int i = 0; i < texto.length(); i++) {
                escritura.write(texto.charAt(i));
            }

            escritura.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
