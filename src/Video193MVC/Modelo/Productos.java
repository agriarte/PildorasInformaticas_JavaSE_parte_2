package Video193MVC.Modelo;

public class Productos {

    private String seccion,nombrearticulo,fecha,paisdeorigen,precio;

    public Productos() {
        //al instanciar la clase inicialmente valores vacíos
        seccion = "";
        nombrearticulo = "";
        fecha = "";
        paisdeorigen = "";
        precio = "";
    }


    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getNombrearticulo() {
        return nombrearticulo;
    }

    public void setNombrearticulo(String nombrearticulo) {
        this.nombrearticulo = nombrearticulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPaisdeorigen() {
        return paisdeorigen;
    }

    public void setPaisdeorigen(String paisdeorigen) {
        this.paisdeorigen = paisdeorigen;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
