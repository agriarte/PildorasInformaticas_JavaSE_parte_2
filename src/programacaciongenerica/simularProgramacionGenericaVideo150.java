package programacaciongenerica;

public class simularProgramacionGenericaVideo150 {
    //este ejemplo simula un ArraList genérico sin usar la programación genérica a partir de Java 5
    //se pueden guardar objetos de cualquier tipo dentro. El único incoveniente es que se ha de castear
    //Como siempre en Javano se pueden guardar objetos de diferente tipo en el mismo array

    public static void main(String[] args) {
        MiArrayList archivos = new MiArrayList(3); //crear instancia de array de Z objetos

        //### con STRINGS
        /*archivos.agregarElementos("Maria");
        archivos.agregarElementos("Juan");
        archivos.agregarElementos("Manuel");

        String nombrePersona = (String) archivos.getObjeto(0);
        System.out.println(nombrePersona);*/

        //### con INTEGERS
        /*archivos.agregarElementos(new Integer(2));
        archivos.agregarElementos(new Integer(2));
        archivos.agregarElementos(new Integer(2));
        Integer numero = (Integer) archivos.getObjeto(0);
        System.out.println(numero);*/

        //### con INT
        archivos.agregarElementos(2);
        archivos.agregarElementos(3);
        archivos.agregarElementos(4);
        int numero = (int) archivos.getObjeto(0);
        System.out.println(numero);

    }
}

class MiArrayList{
private Object[] DatosElemento; // el array guardará objetos del tipo objeto es decir de cualquier tipo: String, Integer, File, etc
private int i=0;//indice del arraylist personalizado

    public MiArrayList(int z){
        DatosElemento= new Object[z];
    }

    public Object getObjeto (int indice){
        return DatosElemento[indice];
    }

    public void agregarElementos(Object o){
        DatosElemento[i]=o;
        i++;
    }
}
