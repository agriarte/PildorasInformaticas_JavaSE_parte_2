package Colecciones;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IteratorsVideo169 {
    public static void main(String[] args) {
        Clientes cliente1 = new Clientes("Juan", "1", 1000);
        Clientes cliente2 = new Clientes("Ivan", "2", 2000);
        Clientes cliente3 = new Clientes("Pedro", "3", 3000);
        Clientes cliente4 = new Clientes("Pepe", "4", 4000);

        //colección HashSet características: no permite duplicados, no ordena, rapida, no acceso aleatorio
        Set<Clientes> clientesDelBanco = new HashSet<>();
        clientesDelBanco.add(cliente1);
        clientesDelBanco.add(cliente2);
        clientesDelBanco.add(cliente3);
        clientesDelBanco.add(cliente4);

        //interfaz de Iterator
        Iterator<Clientes> it = clientesDelBanco.iterator();

        // mientras haya un siguiente...
        while (it.hasNext()) {
            String nombre = it.next().getNombre();
            System.out.println(nombre);

            //eliminar un iterador (registro)
            if (nombre.equals("Pepe")) {
                it.remove();
            }
        }
    }

}

// clase Clientes está en ClientesBancariosVideo168

