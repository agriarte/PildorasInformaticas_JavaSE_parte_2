package Colecciones;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListVideo170 {
    public static void main(String[] args) {
        //crear colección LinkedList
        LinkedList<String> personas = new LinkedList<String>();

        //add contenido a la colección
        personas.add("Juan");
        personas.add("Pedro");
        personas.add("Maria");
        personas.add("Pepe");

        //tamaño de Colección
        System.out.println("Tamaño LinkedList = " + personas.size());

        //foreach para imprimir Colección
        for (String persona : personas) {
            System.out.println(persona);
        }

        ListIterator<String> it = personas.listIterator();

        //el iterador inicialmente está en el inicio
        //avanza una posición
        it.next();
        //añade un registro en la posición actual ( entre el primer y segundo nombre)
        it.add("Fulano");
        it.toString();

        //foreach para imprimir Colección
        for (String persona : personas) {
            System.out.println(persona);
        }

    }
}
