package Serializacion;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.GregorianCalendar;

public class ejemploSerializar {
    public static void main(String[] args) {
        Empleados[] empleado = new Empleados[3];

        empleado[0] = new Empleados("Juan", 5000, 2018, 11, 23);
        empleado[1] = new Empleados("Pedro", 1000, 2010, 10, 5);
        empleado[2] = new Empleados("Ivan", 2000, 2014, 6, 13);

        try {
            //crear flujo o archivo vacio donde guardar el objeto
            //writeObject escribe un objeto en el flujo
            //muy importante que el objeto implemente Serializable
            ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream("G:/JAVA/PildorasInformaticas/JAVA_SE/Ejercicios2/src/Serializacion/archivo.dat"));
            flujoSalida.writeObject(empleado);
            flujoSalida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

class Empleados implements Comparable,Serializable {
    private final String nombre;
    private int id;
    private double sueldo;
    GregorianCalendar calendario;

    //numero de version o huella digital
    //recomendable asiganar un valor manualmente para que se pueda leer el archivo en otros programas
    //por defecto debería de coger el mismo valor pero si se hacen cambios puede variar y entonces dará
    //error en otras partes del programa
    private static final long serialVersionUID=1L;

    private static int id_siguiente = 1;// variable de clase, no pertenece a ninguna instancia.

    public Empleados(String nombre, double sueldo, int agno, int mes, int dia) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        calendario = new GregorianCalendar(agno, mes, dia);
        this.id = id_siguiente;
        id_siguiente++;
    }

    public void setSubeSueldo(double porcentaje) {
        double aumento = sueldo * porcentaje / 100;
        sueldo += aumento;
    }

    public String getDatosEmpleados() {
        return "El empleado " + nombre + " y tiene Id: " + id;
    }

    public GregorianCalendar getCalendario() {
        return calendario;
    }

    public double getSueldo() {

        return sueldo;
    }

    @Override
    public String toString() {
        return "Empleados{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", sueldo=" + sueldo +
                ", calendario=" + calendario +
                '}';
    }

    //método estático accesible sin instanciar
    public static int getId_siguiente() {
        return id_siguiente;
    }

    @Override
    public int compareTo(Object o) {
        Empleados otroEmpleado = (Empleados) o;
        if (this.sueldo < otroEmpleado.sueldo) return -1;
        if (this.sueldo > otroEmpleado.sueldo) return -1;
        return 0;
    }
}
