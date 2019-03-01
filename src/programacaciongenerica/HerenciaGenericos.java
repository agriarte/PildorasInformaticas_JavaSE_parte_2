package programacaciongenerica;

public class HerenciaGenericos{
    public static void main(String[] args) {

        //esta parte es la tipica de herencia de poo. Clase jefe extiende de empleado y por tanto un jefe es un empleado
        //no hay error
        Empleado empleado400;
        Jefe sara = new Jefe("Sara",23,3000);
        empleado400 = sara;


        //en cambio si usamos la clase VariosTipos para crear objetos Empleado y Jefe no funciona la herencia


        VariosTipos<Empleado> empleado500= new VariosTipos<Empleado>();
        VariosTipos<Jefe> ivan = new VariosTipos<Jefe>();

        VariosTipos.imprimirTrabajador(empleado500);// no da error
        VariosTipos.imprimirTrabajador(ivan); // da error porque creando así las instancias un jefe no es un empleado

        //para que no de error se ha de usar el parámetro comodín ? en el método imprimir trabajador

        VariosTipos<Empleado> empleado501= new VariosTipos<Empleado>();
        VariosTipos<Jefe> ivan2 = new VariosTipos<Jefe>();

        VariosTipos.imprimirTrabajador(empleado501);// no da error
        VariosTipos.imprimirTrabajador2(ivan2);
    }

}


class VariosTipos<T> {
    private T primero;
    public VariosTipos() {
        primero=null;
    }

    public T getPrimero() {
        return primero;
    }

    public void setPrimero(T primero) {
        this.primero = primero;
    }

    public static void imprimirTrabajador(VariosTipos<Empleado> e) {
        Empleado primero = e.getPrimero();
        System.out.println(primero);
    }

        public static void imprimirTrabajador2(VariosTipos<? extends Empleado> e){
            Empleado primero = e.getPrimero();
            System.out.println(primero);
    }
}

class Empleado{
    private String nombre;
    private int edad;
    private double sueldo;

    public Empleado(String nombre, int edad, double sueldo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
    }

    private String dameDatos(){
        return "El empleado se llama " + nombre + " . Tiene " + edad + " años y un sueldo de " + sueldo;
    }
}

class Jefe extends Empleado{

    public Jefe(String nombre, int edad, double sueldo) {
        super(nombre, edad, sueldo);
    }

    double incentivo ( double inc){
        return inc;
    }
}
