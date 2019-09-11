package Colecciones;

import java.util.TreeSet;

public class TreeSetVideo172 {
    public static void main(String[] args) {

        //La forma mas sencilla de crear TreeSet. Esta colección sin nada mas ya ordena la lista alfabeticamente
        //solo hay un posible atributo o tipo de elemento. Si fuera una clase con varios atributos se usa el
        //override CompareTo y se envia el atributo por el que queremos ordenar.
        TreeSet<String> ordenaGente = new TreeSet<>();
        ordenaGente.add("Maria");
        ordenaGente.add("Antonio");
        ordenaGente.add("Juan");
        ordenaGente.add("Pedro");

        for (String personas : ordenaGente) {
            System.out.println(personas);
        }




    }
}
