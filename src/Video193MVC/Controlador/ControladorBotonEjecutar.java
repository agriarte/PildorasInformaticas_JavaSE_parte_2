package Video193MVC.Controlador;

import Video193MVC.Modelo.EjecutaBusqueda;
import Video193MVC.Vista.MarcoMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//se implementa ActionListener para que escuche eventos de pulsar boton
public class ControladorBotonEjecutar implements ActionListener {

    private MarcoMVC miFrame;
    private EjecutaBusqueda ejecutaBusqueda = new EjecutaBusqueda();


    public ControladorBotonEjecutar(MarcoMVC miFrame) {
        this.miFrame = miFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String seleccionSeccion= (String) miFrame.getSeccionesJCombo().getSelectedItem();
        String seleccionPais= (String) miFrame.getPaisesJCombo().getSelectedItem();

        miFrame.getResultados().append(ejecutaBusqueda.consultaBBDD(seleccionSeccion,seleccionPais));
        miFrame.getResultados().append("\n");

    }
}
