package streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LeyendoEscribiendoArchivo {
    public static void main(String[] args) {

        //este sistema no es lo mas correcto, como no conocemos Colecciones nos limita mucho usar Arrays

        int contador = 0;

        //array donde clonar los bytes del archivo origen
        int bytesImagen[] = new int [839451];

        try {
            FileInputStream miFile = new FileInputStream("G:/JAVA/PildorasInformaticas/JAVA_SE/Ejercicios2/src/streams/foto.jpg");
            Boolean final_archivo=false;

            //cuando final_archivo == true...
            while (!final_archivo){
                int ByteImagenEntrada = miFile.read();

                //Si no hemos llegado al final del archivo escribe en array con su indice el valor para hacer copia
                if (ByteImagenEntrada!=-1) bytesImagen[contador]=ByteImagenEntrada;

                else final_archivo=true;// si fin de archivo salimos del bucle

                System.out.println(bytesImagen[contador]);
                contador++;
            }

            miFile.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(contador);

        CreaFichero(bytesImagen);

    }

    //recibe un array con el contenido del archivo
    //FileOutputStream crea el archivo clon vacio que secuencialmente va rellenando write
    static void CreaFichero (int arrayExterno[]){

        try {
            
            FileOutputStream miFile = new FileOutputStream("G:/JAVA/PildorasInformaticas/JAVA_SE/Ejercicios2/src/streams/escritura/fotoclon.jpg");

            for (int i = 0; i < arrayExterno.length; i++) {
                miFile.write(arrayExterno[i]);
            }
            miFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
