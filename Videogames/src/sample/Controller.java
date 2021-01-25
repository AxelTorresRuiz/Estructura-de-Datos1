package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sample.Estructuras.Busqueda;

import java.io.IOException;

public class Controller {
    @FXML
    TextField txtusuario;
    @FXML
    PasswordField txtpassword;
    String[][] arrayusuario=new String [3][3];
    @FXML protected void initialize(){
   arrayusuario[0][0]="Axel Torres";arrayusuario[0][1]="admin";arrayusuario[0][2]="123";
   arrayusuario[1][0]="Axel Torres2";arrayusuario[1][1]="admin2";arrayusuario[1][2]="1232";
   arrayusuario[2][0]="Chalan";arrayusuario[2][1]="chalan";arrayusuario[2][2]="chalan";
    }

    public void login(ActionEvent event){
ingresar();
    }
    public void enter(KeyEvent event){
        if(event.getCode()== KeyCode.ENTER){
ingresar();
        }
    }
    public void ingresar(){
        String u=txtusuario.getText();
        String p=txtpassword.getText();
       Busqueda busqueda=new Busqueda();
       int indice=busqueda.secuencial(arrayusuario,u,p);
        if(indice>=0){
            try {
             Main.NombreUsuario=arrayusuario[indice][0];
                Parent root = FXMLLoader.load(getClass().getResource("PantallaCobro.fxml"));
                Scene scene=new Scene(root);
                Main.stage.setScene(scene);
                Main.stage.setMaximized(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Videojuegos");
            alert.setContentText("Usuario o Datos Invalidos");
            alert.show();
        }
    }
}
