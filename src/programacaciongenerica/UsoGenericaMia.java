package programacaciongenerica;

//objetos genérixos por convección se usa la letra K,T o U. Se puede usar cualquier nombre o letra.

public class UsoGenericaMia{
    public static void main(String[] args) {

        //####  generica usando Strings
        GenericaMia<String> stringGenericaMia = new GenericaMia<String>();
        stringGenericaMia.setObjeto("hola");

        System.out.println(stringGenericaMia.getObjeto());


        //#### generica usando objetos Persona
        GenericaMia<Persona> miObjeto= new GenericaMia<Persona>();

        Persona ella = new Persona("Maria");
        miObjeto.setObjeto(ella);

        System.out.println(miObjeto.getObjeto().toString());

    }
}

class Persona{
    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}



class GenericaMia<T> {
    private T objeto;

    public GenericaMia() {
        objeto = null;
    }

    public void setObjeto(T nuevoValor) {
        objeto = nuevoValor;
    }

    public T getObjeto() {
        return objeto;
    }
}
