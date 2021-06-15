package sample.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.Main;
import sample.models.Conexion;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login {
private Conexion conexion;
@FXML
    TextField txtuser;
@FXML
    PasswordField txtpass;
@FXML protected void initialize(){
conexion=new Conexion();
}

    public void Simulador(ActionEvent event) throws IOException, SQLException {
       String email=txtuser.getText();
       String pass=txtpass.getText();

        ResultSet resultSet= conexion.consultar("select * from users where email ='"+email+"' and password='"+ pass +"'");
        System.out.println("select * from users where email ='"+email+"' and password='"+ pass +"'");
        if (resultSet!=null) {
int cont=0;
while (resultSet.next()){
    Alert alert=new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Bienvenido" + resultSet.getObject("name"));
    alert.setContentText(" bienvenido ");
    alert.show();
    cont++;

}
if (cont==0){
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setContentText("Credenciales no validas");
    alert.show();
}else {
    Parent root= FXMLLoader.load(getClass().getResource("../Simulador/simulador.fxml"));
    Scene scene= new Scene(root);
    Main.stage.setScene(scene);
}//else

        }//llaveprimerif


    }
    public void info(ActionEvent event) throws IOException, SQLException {
        String email=txtuser.getText();
        String pass=txtpass.getText();

        ResultSet resultSet= conexion.consultar("select * from users where email ='"+email+"' and password='"+ pass +"'");
        System.out.println("select * from users where email ='"+email+"' and password='"+ pass +"'");
        if (resultSet!=null) {
            int cont=0;
            while (resultSet.next()){
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Bienvenido" + resultSet.getObject("name"));
                alert.setContentText(" bienvenido ");
                alert.show();
                cont++;

            }
            if (cont==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Credenciales no validas");
                alert.show();
            }else {
                 Parent root= FXMLLoader.load(getClass().getResource("../Centro_de_Atencion/centro_de_atenciones.fxml"));
                 Scene scene= new Scene(root);
                Main.stage.setScene(scene);
            }//else

        }//llaveprimerif
    }
    public void sintomas (ActionEvent event) throws IOException, SQLException {
        String email=txtuser.getText();
        String pass=txtpass.getText();

        ResultSet resultSet= conexion.consultar("select * from users where email ='"+email+"' and password='"+ pass +"'");
        System.out.println("select * from users where email ='"+email+"' and password='"+ pass +"'");
        if (resultSet!=null) {
            int cont=0;
            while (resultSet.next()){
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Bienvenido" + resultSet.getObject("name"));
                alert.setContentText(" bienvenido ");
                alert.show();
                cont++;

            }
            if (cont==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Credenciales no validas");
                alert.show();
            }else {
                 Parent root= FXMLLoader.load(getClass().getResource("../Sintomas/sintomas.fxml"));
                Scene scene= new Scene(root);
                Main.stage.setScene(scene);
            }//else

        }//llaveprimerif



    }
    public void informacion(ActionEvent event) throws IOException, SQLException {
        String email=txtuser.getText();
        String pass=txtpass.getText();

        ResultSet resultSet= conexion.consultar("select * from users where email ='"+email+"' and password='"+ pass +"'");
        System.out.println("select * from users where email ='"+email+"' and password='"+ pass +"'");
        if (resultSet!=null) {
            int cont=0;
            while (resultSet.next()){
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Bienvenido" + resultSet.getObject("name"));
                alert.setContentText(" bienvenido ");
                alert.show();
                cont++;

            }
            if (cont==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Credenciales no validas");
                alert.show();
            }else {
                 Parent root= FXMLLoader.load(getClass().getResource("../Informacion/informacion.fxml"));
                Scene scene= new Scene(root);
                Main.stage.setScene(scene);
            }//else

        }//llaveprimerif


    }
    public void vacuna(ActionEvent event) throws SQLException, IOException {
        String email=txtuser.getText();
        String pass=txtpass.getText();

        ResultSet resultSet= conexion.consultar("select * from users where email ='"+email+"' and password='"+ pass +"'");
        System.out.println("select * from users where email ='"+email+"' and password='"+ pass +"'");
        if (resultSet!=null) {
            int cont=0;
            while (resultSet.next()){
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Bienvenido" + resultSet.getObject("name"));
                alert.setContentText(" bienvenido ");
                alert.show();
                cont++;

            }
            if (cont==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Credenciales no validas");
                alert.show();
            }else {
                    Parent root= FXMLLoader.load(getClass().getResource("../Vacuna/vacuna.fxml"));
                Scene scene= new Scene(root);
                Main.stage.setScene(scene);
            }//else

        }//llaveprimerif
    }
    public void citas(ActionEvent event) throws SQLException, IOException {
        String email=txtuser.getText();
        String pass=txtpass.getText();

        ResultSet resultSet= conexion.consultar("select * from users where email ='"+email+"' and password='"+ pass +"'");
        System.out.println("select * from users where email ='"+email+"' and password='"+ pass +"'");
        if (resultSet!=null) {
            int cont=0;
            while (resultSet.next()){
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Bienvenido" + resultSet.getObject("name"));
                alert.setContentText(" bienvenido ");
                alert.show();
                cont++;

            }
            if (cont==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Credenciales no validas");
                alert.show();
            }else {
                Parent root= FXMLLoader.load(getClass().getResource("../Citas/citas.fxml"));
                Scene scene= new Scene(root);
                Main.stage.setScene(scene);
            }//else

        }//llaveprimerif
    }
}
