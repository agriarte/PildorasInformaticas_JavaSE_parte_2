package Colecciones;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListVideo171 {
    public static void main(String[] args) {


        LinkedList<String> paises = new LinkedList<String>();

        paises.add("España");
        paises.add("Francia");
        paises.add("Italia");
        paises.add("Irlanda");

        LinkedList<String> capitales = new LinkedList<String>();

        capitales.add("Madrid");
        capitales.add("Paris");
        capitales.add("Roma");
        capitales.add("Dublin");

        ListIterator<String> itPaises = capitales.listIterator();
        ListIterator<String> itCapitales = capitales.listIterator();


        //bucle que recorre iterador de paises
        //mientras haya un siguiente pais{
        //   Si (hay una siguiente capital avanza posicion en Paises
        //   Añade a paises ( la siguiente capital y avanza posicion de iterador }
        while (itPaises.hasNext()){
            if (itCapitales.hasNext()) itPaises.next();
            paises.add(itCapitales.next());
        }

        //ahora lista paises tiene sus capitales
        System.out.println(paises);

        //eliminar elementos pares de la lista capitales. Este método funciona si los elementos son pares
        //ahora el cursor está al final. Para volverlo al inicio se puede volver a iniciar. No he encontrado un
        //método de setear iterador a posición concreta

        itCapitales = capitales.listIterator();

        while (itCapitales.hasNext()){
            itCapitales.next();
            if (itCapitales.hasNext()) {
                itCapitales.next();
                itCapitales.remove();
            }
        }

        System.out.println(capitales);


    }
}
