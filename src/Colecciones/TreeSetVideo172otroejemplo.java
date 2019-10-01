package Colecciones;

import java.util.TreeSet;

public class TreeSetVideo172otroejemplo {
    public static void main(String[] args) {
        TreeSet<Productos> ordenaProductos = new TreeSet<>();

        Productos productos1= new Productos(4,"jabón");
        Productos productos2= new Productos(1,"lejía");
        Productos productos3= new Productos(7,"escoba");

        ordenaProductos.add(productos1);
        ordenaProductos.add(productos2);
        ordenaProductos.add(productos3);

        for (Productos p: ordenaProductos) {
            System.out.println(p.getNumProducto() + " " + p.getDescripcion());
        }
    }
}

//Al implementar la interfaz Comparable y hacer el override de compareTo se ordena la colección por el
//atributo numProducto
class Productos implements Comparable<Productos>{
    private int numProducto;
    private String descripcion;

    public Productos(int numProducto, String descripcion) {
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
    public int compareTo(Productos o) {
        //ordena automaticamente por numProducto.
        //return devuelve 0 si son iguales, o un número positivo o negativo que usa para ordenar
        System.out.println(this.numProducto - o.numProducto);
        return this.numProducto - o.numProducto;
        //para ordenar de mayor o menor.
        //return o.numProducto - this.numProducto;
    }
}
