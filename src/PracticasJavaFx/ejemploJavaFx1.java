package PracticasJavaFx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ejemploJavaFx1 extends Application {
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button miBoton = new Button("Click aqui");
        miBoton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("has pulsado el boton");
            }
        });

        // creacion del Pane
        StackPane raiz = new StackPane();
        raiz.getChildren().add(miBoton);
        //creacion escena
        Scene escena = new Scene(raiz,500,300);
        //primaryStage es el escenario, añadimos la escena al escenario
        primaryStage.setScene(escena);
        primaryStage.show();


    }
}
