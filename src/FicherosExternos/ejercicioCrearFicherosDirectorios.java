package FicherosExternos;

import javax.swing.*;
import java.io.*;

public class ejercicioCrearFicherosDirectorios {
    public static void main(String[] args) {
        //entrada nombre carpeta
        String carpeta = (JOptionPane.showInputDialog("Introduce nombre de carpeta"));
        System.out.println(carpeta);
        String archivo = (JOptionPane.showInputDialog("Introduce nombre de archivo TXT"));
        System.out.println(archivo);
        String contenido = (JOptionPane.showInputDialog("Introduce texto del archivo"));
        System.out.println(contenido);



        //crear un directorio: nuevo objeto File con ruta y el nombre de la carpeta que queremos crear
        File directorio = new File("G:\\JAVA\\PildorasInformaticas\\JAVA_SE\\Ejercicios2\\" + carpeta );
        //mkdir hace makedir de la ruta del objeto File
        directorio.mkdir();

        //para crear un archivo es proceso es similar, en lugar de nombre de carpeta pondremos el nombre del archivo
        //nuevo a crear. Si ya existe ese nombre no hará nada
        File miarchivo = new File("G:\\JAVA\\PildorasInformaticas\\JAVA_SE\\Ejercicios2\\" + carpeta + File.separator + archivo);
        try {
            miarchivo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            //crear flujo o archivo vacio donde guardar el objeto
            //writeObject escribe un objeto en el flujo
            //muy importante que el objeto implemente Serializable
            FileWriter flujoSalida = new FileWriter( "G:\\JAVA\\PildorasInformaticas\\JAVA_SE\\Ejercicios2\\" + carpeta + File.separator + archivo);
            flujoSalida.write(contenido);
            flujoSalida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
