package FicherosExternos;

import java.io.File;

public class AccesoRutas {
    public static void main(String[] args) {

        //para asegurar compatibilidad entre S.O. es recomendable substituir las barras invertidas por la constante
        //estática File.separator ej: "G:" + File.separator + "JAVA" + File.separator + " etc...
        File directorio = new File("G:\\JAVA\\PildorasInformaticas\\JAVA_SE\\Ejercicios2");

        //imprimir ruta
        System.out.println("path " + directorio.getAbsolutePath());

        //imprimir array que almacena contenido del directorio, tanto archivos como carpetas
        String[] nombres = directorio.list();

        for (int i = 0; i < nombres.length; i++) {
            System.out.println(nombres[i]);

            //para crear nuevo objeto File de un subdirectorio
            File f = new File(directorio.getAbsolutePath(),nombres[i]);
            //si es un subdirectorio, bucle que lee su contenido, si es archivo se ignora este código
            if (f.isDirectory()){
                String[] archivos_subcarpeta = f.list();
                for (int j = 0; j <archivos_subcarpeta.length ; j++) {
                    System.out.println(archivos_subcarpeta[j]);
                }
            }
        }

    }
}

