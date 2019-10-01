package Colecciones;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetVideo173 {
    public static void main(String[] args) {


        //objeto vacio para comparar (es el mismo ojeto vacio para comparar con si mismo y no tener que poner argumentos)
        OtrosProductos comparadorProductos = new OtrosProductos();
        //ahora al crear la coleccion se envía un objeto comparador
        TreeSet<OtrosProductos> ordenaProductos = new TreeSet<OtrosProductos>(comparadorProductos);

        OtrosProductos productos1= new OtrosProductos(4,"jabón (corto)");
        OtrosProductos productos2= new OtrosProductos(1,"lejía (mediano)");
        OtrosProductos productos3= new OtrosProductos(7,"escoba (el mas largo)");

        ordenaProductos.add(productos1);
        ordenaProductos.add(productos2);
        ordenaProductos.add(productos3);

        for (OtrosProductos p: ordenaProductos) {
            System.out.println(p.getNumProducto() + " " + p.getDescripcion());
        }
    }
}

//con la interfaz Comparator podemos hacer ordenaciones personalizadas. En este ejemplo se ordena por la longitud
//de la descripción
class OtrosProductos implements Comparator<OtrosProductos> {
    private int numProducto;
    private String descripcion;

    public OtrosProductos() {
    }

    public OtrosProductos(int numProducto, String descripcion) {
        this.numProducto = numProducto;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getNumProducto() {
        return numProducto;
    }


    @Override
    public int compare(OtrosProductos o1, OtrosProductos o2) {
        //según longitud de caracteres devuelve 0, +1 o -1
        int carac1 = o1.getDescripcion().length();
        int carac2 = o2.getDescripcion().length();

        if (carac1<carac2) return -1;
        else if (carac1>carac2) return 1;
        else return 0;
    }
}

