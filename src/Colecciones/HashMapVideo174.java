package Colecciones;

import java.util.HashMap;
import java.util.Map;

public class HashMapVideo174 {
    public static void main(String[] args) {

        //HashMap es una colección de tipo mapa que tiene el formato K,V. Clave, valor.
        //clave es un número único que no puede estar repetido que identifica el valor-
        //Valor puede ser un genérico o  cualquier clase que creemos
        //En el ejemplo se guarada una lista de empleados usando un mapa con clave no numérica

        HashMap<String, Empleado> listaEmpleados = new HashMap<String, Empleado>();

        listaEmpleados.put("100",new Empleado("Juan"));
        listaEmpleados.put("200",new Empleado("Antonio"));
        listaEmpleados.put("300",new Empleado("Pepe"));
        listaEmpleados.put("400",new Empleado("Maria"));

        System.out.println(listaEmpleados);

        //eliminar un registro usando su clave
        listaEmpleados.remove("200");

        System.out.println(listaEmpleados);

        //sobreescribir un elemento. Si asigno la misma clave, se sobreescribe el valor
        //Maria desaparece por Ana
        listaEmpleados.put("400",new Empleado("Ana"));

        //Map.Entry y entrySet
        //Map.Entry almacena un set ( conjunto de par clave valor de ). entrySet devuelve un conjunto clave valor
        //Recorremos con un foreach la lista empleados y obtenemos el setEntry que guardamos en una variable Map.Entry

        for (Map.Entry<String, Empleado> personaEmpleado : listaEmpleados.entrySet() ) {
            String clave = personaEmpleado.getKey();
            Empleado valor = personaEmpleado.getValue();

            System.out.println("Clave : " + clave + " Valor : " + valor);

        }

    }
}

class Empleado {
    private int salario;
    private String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
        this.salario = 2000;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "salario=" + salario +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
