package sample.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import sample.Main;

import java.io.IOException;

public class login {
    public void Simulador(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../Simulador/simulador.fxml"));
        Scene scene= new Scene(root);
        Main.stage.setScene(scene);
    }
    public void info(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../Centro_de_Atencion/centro_de_atenciones.fxml"));
        Scene scene= new Scene(root);
        Main.stage.setScene(scene);
    }
    public void sintomas (ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../Sintomas/sintomas.fxml"));
        Scene scene= new Scene(root);
        Main.stage.setScene(scene);
    }
    public void informacion(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../Informacion/informacion.fxml"));
        Scene scene= new Scene(root);
        Main.stage.setScene(scene);
    }
}
