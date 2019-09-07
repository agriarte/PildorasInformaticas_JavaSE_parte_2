package Colecciones;

import java.util.Objects;

//video 168
//HASHCODE (ES CONFUSO) Cada objeto genera su propio hashcode . Si dos objetos generan hashcodes diferentes ,
//los objetos son diferentes . Si dos objetos tienen el mismo hashcode pueden todavía ser diferentes
// y hay que comprobar con el método equals para confirmar su igualdad.

//hashCode se usa conjuntamente con equals. Se hace override de estos 2 métodos y se indica que atributo de objeto
//es el que lo hace único. (En el caso de Libros su ISBN, en un banco su Num Cuenta). El asistente de Intellij nos
//creará el "equals" correcto para detectar cuando son iguales

public class ColeccionesVideo167 {
    public static void main(String[] args) {
        Libro libro1 = new Libro("Java SE", "Juan", 24);
        Libro libro2 = new Libro("Java SE", "Juan2", 24);

        if (libro1.equals(libro2)) {
            System.out.println("son iguales");
            System.out.println(libro1.hashCode());
            System.out.println(libro2.hashCode());
        } else {
            System.out.println("no son iguales");
            System.out.println(libro1.hashCode());
            System.out.println(libro2.hashCode());
        }


    }
}

class Libro {
    private String titulo;
    private String autor;
    private int isbn;

    public Libro(String titulo, String autor, int isbn) {
        titulo = titulo;
        autor = autor;
        this.isbn = isbn;
    }

    public String getDatos() {
        return "Titulo: " + titulo + ". Autor:" + autor + ". ISBN: " + isbn;
    }


    /*
    //sobre escritura del método equals para que detecte que 2 objetos son iguales mirando ISBN
    public boolean equals(Object obj) {
        //comprobar que el objeto recibido es instancia de Libro
        if (obj instanceof Libro) {
            if (this.isbn == ((Libro) obj).isbn) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return isbn == libro.isbn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}

