package FicherosExternos;

import java.io.File;
import java.io.IOException;

public class CreandoDirectorios {
    public static void main(String[] args) {

        //crear un directorio: nuevo objeto File con ruta y el nombre de la carpeta que queremos crear
        File directorio = new File("G:\\JAVA\\PildorasInformaticas\\JAVA_SE\\Ejercicios2\\CarpetaCreadaPorJava");
        //mkdir hace makedir de la ruta del objeto File
        directorio.mkdir();

        //para crear un archivo es proceso es similar, en lugar de nombre de carpeta pondremos el nombre del archivo
        //nuevo a crear. Si ya existe ese nombre no hará nada
        File archivo = new File("G:\\JAVA\\PildorasInformaticas\\JAVA_SE\\Ejercicios2\\CarpetaCreadaPorJava\\ejemplo.xlsx");
        try {
            archivo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
