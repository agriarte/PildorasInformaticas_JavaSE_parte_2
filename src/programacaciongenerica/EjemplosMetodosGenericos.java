package programacaciongenerica;

// 2 ejemplos de como usar un método genérico que acepta parámetros de cualquier tipo de objeto
// primero le mandamos un array de Strings y después un array de objetos Empleados
// el método ExaminaArrays devuelve el número de elementos del array del tipo que sea

public class EjemplosMetodosGenericos {
    public static void main(String[] args) {

        String nombres[] = {"Sara","Antonio","Maria"};

        System.out.println(ExaminaArrays.getElementos(nombres));

        Empleados[] listaEmpleados = new Empleados[4];
        listaEmpleados[0] = new Empleados("Juanito", 1500, 2000, 10, 22);
        listaEmpleados[1] = new Empleados("Chucho", 1800, 2002, 6, 9);
        listaEmpleados[2] = new Empleados("León", 2100, 1999, 3, 7);
        listaEmpleados[3] = new Empleados("Benavente", 1400, 1994, 1, 12);

        System.out.println(ExaminaArrays.getElementos(listaEmpleados));

    }
}

class ExaminaArrays{
    public static <T> String getElementos(T[] elArray){

        return "El array tiene " + elArray.length + " elementos";
    }
}
