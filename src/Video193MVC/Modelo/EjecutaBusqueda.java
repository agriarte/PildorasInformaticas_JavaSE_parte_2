package Video193MVC.Modelo;

public class EjecutaBusqueda {
    private String seleccion;


    public String consultaBBDD(String seccion,String pais) {
        seleccion="";

        System.out.println("consultaBBDD");
        System.out.println(seccion + " , " + pais);
        //si seccion NO es Todos y el pais = Todos
        if (!seccion.equals("Todos") && pais.equals("Todos")){
            seleccion= "Has escogido Seccion";
        } else  if (seccion.equals("Todos") && !pais.equals("Todos")){
            seleccion= "Has escogido Pais";
        } else  if (!seccion.equals("Todos") && !pais.equals("Todos")){
            seleccion= "Has escogido Seccion y Pais";
        }  if (seccion.equals("Todos") && pais.equals("Todos")){
            seleccion= "No Has escogido nad";
        }


        return seleccion;
    }
}
