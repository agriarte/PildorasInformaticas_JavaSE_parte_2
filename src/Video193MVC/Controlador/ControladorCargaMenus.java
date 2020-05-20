package Video193MVC.Controlador;

import Video193MVC.Modelo.CargarMenus;
import Video193MVC.Vista.MarcoMVC;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;

public class ControladorCargaMenus extends WindowAdapter {
    //esta clase pone en comunicacion MarcoMVC con CargaMenus
    private MarcoMVC miJframe;
    //instancia de cargaMenus para tener acceso a ejecutaConsultas()
    CargarMenus obj = new CargarMenus();
    //array con las 2 columnas de combos
    private ResultSet[] resultadoCombos;

    public ControladorCargaMenus(MarcoMVC miJframe) {
        this.miJframe = miJframe;
    }

    @Override
    //Invoked the first time a window is made visible.
    public void windowOpened(WindowEvent e) {
        System.out.println("window opened");
        //inicializar array de combos
        resultadoCombos = new ResultSet[2];

        resultadoCombos=obj.ejecutaConsultas();


       try {
           //resultadoCombos[0].previous();
           //resultadoCombos[1].previous();
           //solucion rara, este es un programa poco ortodoxo
           miJframe.getSeccionesJCombo().addItem(resultadoCombos[0].getString(1));
           miJframe.getPaisesJCombo().addItem(resultadoCombos[1].getString(1));

           while (resultadoCombos[0].next()){
               miJframe.getSeccionesJCombo().addItem(resultadoCombos[0].getString(1));
           }
           while (resultadoCombos[1].next()){
               miJframe.getPaisesJCombo().addItem(resultadoCombos[1].getString(1));
           }
       }catch (Exception ev){
           System.out.println("algun error");
       }

    }
}
