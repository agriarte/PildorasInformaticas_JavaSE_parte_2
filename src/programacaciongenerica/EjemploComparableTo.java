package programacaciongenerica;

public class EjemploComparableTo {
    public static void main(String[] args) {

        String nombres[] = {"Sara", "Antonio", "Maria","Alberto"};

        System.out.println(comparaArrays.getMenor(nombres));

    }
}

//compareTo extiende de Comparable
//Returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
//CompareTo devuelve 0 si son iguales, valor positivo si es menor, valor negativo si es menor
class comparaArrays {

    public static <T extends Comparable> T getMenor(T[] elArray) {

        T objetoMenor = elArray[0]; // inicialmente se supone como menor el array 0


        //en el bucle se va comparando valor 0 con el resto del array. Si encuentra un nuevo valor menor lo sobreescribe
        for (int i = 1; i < elArray.length; i++) {
            if (objetoMenor.compareTo(elArray[i]) > 0) {//
                objetoMenor = elArray[i];
            }
        }
        return objetoMenor;

    }
}

