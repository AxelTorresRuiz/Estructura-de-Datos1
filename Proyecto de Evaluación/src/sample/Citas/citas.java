package sample.Citas;

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
import sample.models.filala;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class citas {
@FXML
    TextField txtname,txtemail,txtsick;
@FXML
    Button btninsert, btncancelar;

Conexion conexion;

    TableColumn colid=new TableColumn("id");
    TableColumn colname=new TableColumn("name");
    TableColumn colemail=new TableColumn("email");
    TableColumn colsick=new TableColumn("sick");
    TableColumn colEditar=new TableColumn("     ");
    TableColumn colEliminar=new TableColumn("      ");

    filala filaedit;
    @FXML
    TableView tabla;
    ObservableList<filala> datosTabla= FXCollections.observableArrayList();

    Callback<TableColumn<filala,String>, TableCell<filala,String>> celdaEditar =new Callback<TableColumn<filala, String>, TableCell<filala, String>>() {
        @Override
        public TableCell<filala, String> call(TableColumn<filala, String> filaStringTableColumn) {
            TableCell<filala,String> cell=new TableCell<filala, String>(){
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
                                txtemail.setText(filaedit.getEmail());
                                txtsick.setText(filaedit.getSick());
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


    Callback<TableColumn<filala,String>, TableCell<filala,String>> celdaEliminar =new Callback<TableColumn<filala, String>, TableCell<filala, String>>() {
        @Override
        public TableCell<filala, String> call(TableColumn<filala, String> filalaStringTableColumn) {
            TableCell<filala,String> cell=new TableCell<filala,String>(){
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
                                    filala fila1=getTableView().getItems().get(getIndex());
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
        colemail.setMinWidth(50);
        colsick.setMinWidth(50);
        colid.setCellValueFactory(new PropertyValueFactory<fila,String>("id"));
        colname.setCellValueFactory(new PropertyValueFactory<fila,String>("name"));
        colemail.setCellValueFactory(new PropertyValueFactory<fila,String>("email"));
        colsick.setCellValueFactory(new PropertyValueFactory<fila,String>("sick"));
        colEditar.setCellFactory(celdaEditar);
        colEliminar.setCellFactory(celdaEliminar);

      //  colEditar.setCellFactory(celdaEditar);
       // colEliminar.setCellFactory(celdaEliminar);


        tabla.getColumns().addAll(colid,colname,colemail,colsick,colEliminar,colEditar);
        recargar();
        tabla.setItems(datosTabla);
    }

    public void recargar() throws SQLException {
        ResultSet res=conexion.consultar("SELECT * from users order by id DESC");
        datosTabla.clear();
        if(res != null){
            while (res.next()){
                datosTabla.add(new filala(
                        res.getObject("id").toString(),
                        res.getObject("name").toString(),
                        res.getObject("email").toString(),
                        res.getObject("sick").toString()
                ));
            }
        }

    }//recargar

    public void insertar(ActionEvent even) throws SQLException {
        if (btninsert.getText().equals("ACTUALIZAR")){
            String n = txtname.getText();
            String m = txtemail.getText();
            String s = txtsick.getText();

            conexion.insmodel("update users set " +
                    "name='"+n+"', " +
                    "email='"+m+"' " +
                    "sick='"+s+"'," +
                    "where id="+filaedit.getId());

            btninsert.setText("INSERTAR");
            txtname.setText("");txtemail.setText("");txtsick.setText("");
            btncancelar.setVisible(false);

            recargar();
        }else {

            if (!txtname.getText().trim().equals("") && !txtemail.getText().trim().equals("") && !txtsick.getText().trim().equals("") ) {
                String n = txtname.getText();
                String m = txtemail.getText();
                String s = txtsick.getText();
                conexion.insmodel("INSERT INTO users(name,email,sick) VALUES ('" + n + "','" + m + "','" + s
                        + "')");

                txtname.setText("");
                txtemail.setText("");
                txtsick.setText("");


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
            txtname.setText("");txtemail.setText("");txtsick.setText("");
            btncancelar.setVisible(false);
        }
    }
    public void volver(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../Login/login.fxml"));
        Scene scene= new Scene(root);
        Main.stage.setScene(scene);
    }
}
