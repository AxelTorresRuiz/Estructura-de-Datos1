package sample.Vacuna;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import sample.Main;
import sample.models.Conexion;
import sample.models.fila;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class vacuna {

    @FXML
    TextField txtname, txtapellido, txtmail, txtage;
    @FXML Button btncancelar, btninsert;


    Conexion conexion;
    TableColumn colid=new TableColumn("id");
    TableColumn colname=new TableColumn("name");
    TableColumn colape=new TableColumn("last_name");
    TableColumn colage=new TableColumn("age");
    TableColumn colemail=new TableColumn("email");
    TableColumn colpass=new TableColumn("password");
    TableColumn colimg=new TableColumn("img_profile");
    TableColumn colEditar=new TableColumn("     ");
    TableColumn colEliminar=new TableColumn("      ");
    fila filaedit;
    @FXML
    TableView tabla;
    ObservableList<fila> datosTabla= FXCollections.observableArrayList();

    Callback<TableColumn<fila,String>, TableCell<fila,String>> celdaEditar =new Callback<TableColumn<fila, String>, TableCell<fila, String>>() {
        @Override
        public TableCell<fila, String> call(TableColumn<fila, String> filaStringTableColumn) {
           TableCell<fila,String> cell=new TableCell<fila,String>(){
               Button btnEditar= new Button("EDITAR");

               @Override
               protected void updateItem(String item, boolean empty) {
                   if (empty) {
                       setGraphic(null);
                       setText(null);
                   }else{

                       btnEditar.setOnAction(new EventHandler<ActionEvent>() {
                           @Override
                           public void handle(ActionEvent event) {
                               filaedit=getTableView().getItems().get(getIndex());
                               txtname.setText(filaedit.getName());
                               txtapellido.setText(filaedit.getLast_name());
                               txtmail.setText(filaedit.getEmail());
                               txtage.setText(filaedit.getAge());
                               btncancelar.setVisible(true);
                               btninsert.setText("ACTUALIZAR");
                           }//Llave del evento
                       });
                       setGraphic(btnEditar);
                       setText(null);
                   }
               }
           };
           return cell;
        }
    };

    Callback<TableColumn<fila,String>, TableCell<fila,String>> celdaEliminar =new Callback<TableColumn<fila, String>, TableCell<fila, String>>() {
        @Override
        public TableCell<fila, String> call(TableColumn<fila, String> filaStringTableColumn) {
            TableCell<fila,String> cell=new TableCell<fila,String>(){
                Button btnEliminar= new Button("Eliminar");

                @Override
                protected void updateItem(String item, boolean empty) {
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    }else{
                        btnEliminar.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                                alert.setTitle("Eliminar Registro");
                                alert.setContentText("¿Desea eliminar el registro?");
                                Optional<ButtonType> resultado=alert.showAndWait();
                                if (resultado.get()==ButtonType.OK){
                                    fila fila1=getTableView().getItems().get(getIndex());
                                    conexion.insmodel("delete from users where id ="+fila1.getId());
                                    try {
                                        recargar();
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }//Llave del evento
                        });
                        setGraphic(btnEliminar);
                        setText(null);
                    }
                }
            };
            return cell;
        }
    };


    @FXML protected void initialize() throws SQLException {
        conexion=new Conexion();
        colid.setMinWidth(50);
        colname.setMinWidth(50);
        colape.setMinWidth(50);
        colage.setMinWidth(50);
        colemail.setMinWidth(50);
        colpass.setMinWidth(50);
        colimg.setMinWidth(50);
        //LIGAR COLUNA CON FILA
        colid.setCellValueFactory(new PropertyValueFactory<fila,String>("id"));
        colname.setCellValueFactory(new PropertyValueFactory<fila,String>("name"));
        colape.setCellValueFactory(new PropertyValueFactory<fila,String>("last_name"));
        colage.setCellValueFactory(new PropertyValueFactory<fila,String>("age"));
        colemail.setCellValueFactory(new PropertyValueFactory<fila,String>("email"));
        colpass.setCellValueFactory(new PropertyValueFactory<fila,String>("password"));
        colimg.setCellValueFactory(new PropertyValueFactory<fila,String>("img_profile"));
        colEditar.setCellFactory(celdaEditar);
        colEliminar.setCellFactory(celdaEliminar);


        tabla.getColumns().addAll(colid,colname,colape,colage,colemail,colpass,colimg,colEditar,colEliminar);
        recargar();
        tabla.setItems(datosTabla);

    }
    public void recargar() throws  SQLException {
        ResultSet res=conexion.consultar("SELECT * from users order by id DESC");
        datosTabla.clear();
        if(res != null){
            while (res.next()){
                datosTabla.add(new fila(
                        res.getObject("id").toString(),
                        res.getObject("name").toString(),
                        res.getObject("last_name").toString(),
                        res.getObject("age").toString(),
                        res.getObject("email").toString(),
                        res.getObject("password").toString(),
                        res.getObject("img_profile").toString()
                ));
            }
        }

    }
    public void insertar(ActionEvent even) throws SQLException {
        if (btninsert.getText().equals("ACTUALIZAR")){
            String n = txtname.getText();
            String ap = txtapellido.getText();
            String m = txtmail.getText();
            String a = txtage.getText();
            conexion.insmodel("update users set " +
                    "name='"+n+"', " +
                    "last_name='"+ap+"'," +
                    "age='"+a+"'," +
                    "email='"+m+"' " +
                    "where id="+filaedit.getId());

            btninsert.setText("INSERTAR");
            txtname.setText("");txtapellido.setText("");txtmail.setText("");txtage.setText("");
            btncancelar.setVisible(false);

            recargar();
        }else {

            if (!txtname.getText().trim().equals("") && !txtapellido.getText().trim().equals("") && !txtmail.getText().trim().equals("") && !txtage.getText().trim().equals("")) {
                String n = txtname.getText();
                String na = txtname.getText();
                String ap = txtapellido.getText();
                String m = txtmail.getText();
                String a = txtage.getText();
                conexion.insmodel("INSERT INTO users(name, last_name, age, email, password, img_profile) VALUES ('" + n + "','" + ap + "','" + a
                        + "','" + m
                        + "','123','luis.jpg')");
                System.out.println("INSERT INTO users(name, last_name, age, email, password, img_profile) VALUES ('" + n + "','" + ap + "','" + a
                        + "','" + m
                        + "','123','luis.jpg')");

                txtname.setText("");
                txtapellido.setText("");
                txtmail.setText("");
                txtage.setText("");

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setContentText("Registro insertado correctamente");
                alert.show();
                recargar();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Favor de llenar todos los campos");
                alert.show();
            }//else
        }
    }
public void cancelar(ActionEvent event){
        if (filaedit!=null){
            btninsert.setText("INSERTAR");
            txtname.setText("");txtapellido.setText("");txtmail.setText("");txtage.setText("");
            btncancelar.setVisible(false);
        }
    }
public void volver(ActionEvent event) throws IOException {
    Parent root= FXMLLoader.load(getClass().getResource("../Login/login.fxml"));
    Scene scene= new Scene(root);
    Main.stage.setScene(scene);
}
}
