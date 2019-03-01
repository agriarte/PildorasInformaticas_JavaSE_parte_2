package programacaciongenerica;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class UsoEmpleados {
    public static void main(String[] args) {

        //ArrayList reserva en memoria espacio para 10 elementos. Para optimizar recursos si nuestro
        // arrayList sabemos que será menor podemos usar método trimToSize() para ajustar a una
        // cantidad menor. Si por el contrario sabemos que vamos a guardar mas elementos podemos agrandar
        // el tamaño del arrayList para evitar cálculos y procesos de duplicar espacios de memoria
        // usando ensureCapacity. Esto solo tiene sentido en máquinas muy pequeñas
        //
        // listaEmpleados.trimToSize(); ajusta a tamaño real
        // listaEmpleados.trimToSize(); devuelve número de alementos
        // listaEmpleados.ensureCapacity(14); agrandar a este tamaño

        ArrayList<Empleados> listaEmpleados = new ArrayList<Empleados>();

        listaEmpleados.add(new Empleados("Juanito", 1500, 2000, 10, 22));
        listaEmpleados.add(new Empleados("Chucho", 1800, 2002, 6, 9));
        listaEmpleados.add(new Empleados("León", 2100, 1999, 3, 7));
        listaEmpleados.add(new Empleados("Benavente", 1400, 1994, 1, 12));

        // reemplazo de elementos. set no añade, reemplaza un elemento por otro en la posición indice
        listaEmpleados.set(1, new Empleados("Izar", 1500, 2001, 11, 25));

        // obtener elemento posicion indice con get
        System.out.println("uso de get > " + listaEmpleados.get(1).getDatosEmpleado());

        // eleminar elemento con remove(indice)
        listaEmpleados.remove(3);

        //recorrer ArrayList usando de manera secuencial con size
        for (int i = 0; i < listaEmpleados.size(); i++) {
            System.out.println(listaEmpleados.get(i).getDatosEmpleado());
        }

        //recorrer ArrayList con foreach
        for (Empleados e : listaEmpleados) {
            System.out.println(e.getDatosEmpleado());
        }

        //copiar ArrayList en un Array convencional. Se usa toArray
        //1- crear Array de tipo Empleados con tamaño obtenido con size().
        Empleados[] arrayEmpleados = new Empleados[listaEmpleados.size()];
        //2-copia ArrayList en el Array especificado
        listaEmpleados.toArray(arrayEmpleados);

        System.out.println("Array convencional");
        for (Empleados e: arrayEmpleados ) {
            System.out.println(e.getDatosEmpleado());
        }

        ////####################
        // video 149 Iterators
        // Interfaz con 3 métodos principales hasNext, next, remove

        //crear objeto Iterator con la "colección" listaEmpleados.
        System.out.println("#iterador#");
        Iterator<Empleados> empleadosIterator = listaEmpleados.iterator();

        while (empleadosIterator.hasNext()){
            System.out.println(empleadosIterator.next().getDatosEmpleado());
        }


    }
}

class Empleados {
    private String nombre;
    private double sueldo;
    private int agno;
    private int mes;
    private int dia;
    private GregorianCalendar calendario;
    private int Id;
    private static int IdSiguiente = 0;// Esto es un campo de clase. Pertenece a la propia clase

    public Empleados(String nombre, double sueldo, int agno, int mes, int dia) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.agno = agno;
        this.mes = mes;
        this.dia = dia;
        calendario = new GregorianCalendar(agno, mes, dia);
        Id = IdSiguiente;
        IdSiguiente++;
    }

    public String getDatosEmpleado() {
        return "El empleado " + nombre + " con ID " + Id + " tiene un sueldo de " + sueldo + " y antigüedad desde " + agno;
    }


}
