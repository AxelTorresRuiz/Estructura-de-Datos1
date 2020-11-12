package sample;

import Peces.Pez;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class Controller {
    @FXML
    TextField text1;
    @FXML
    ListView list1;
    @FXML
    ComboBox combo1;

    @FXML
    public void initialize() {
        combo1.getItems().removeAll(combo1.getItems());
        combo1.getItems().addAll("Trucha", "Carpa");
    }

    Pez pez = new Pez();
    String[] peces = new String[3];



    public void calcular(ActionEvent event) {
        if (text1.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerta Informativa");
            alert.setHeaderText("¡Alerta!");
            alert.setContentText("¡Hay campos faltantes por llenar!");
            alert.showAndWait();
        } else {
            double valor = Double.parseDouble(text1.getText());
            double X = (valor * .10);
            String Y = String.valueOf(X);
            String Z = pez.Por_nacimiento(valor);

            peces[0] = Z;
            peces[1] = String.valueOf(combo1.getValue().toString());
            peces[2] = Y;

        }//else


    }
    public void proceso(ActionEvent event){
        double valor = Double.parseDouble(text1.getText());
        list1.getItems().add("Este tipo de pescado "+peces[1]+" tiene natalidad "+valor+" por cria y "+peces[0]+" teniendo una taza de mortaliad al año de: "+peces[2]);
        text1.setText("");
    }

}
