package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Estructuras.ItemPedido;
import sample.Estructuras.Pedido;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ControllerCobro {
    @FXML ComboBox combazo;
    @FXML TableView tabla;
    @FXML TextField txtCantJ,txtname;
    @FXML Label nombrepedido;
    LinkedList<String>listajuegos=new LinkedList<>();
    TableColumn columnJuego=new TableColumn("VIDEOJUEGO");
    TableColumn columncantJuego=new TableColumn("CANTIDAD");
    ObservableList<Pedido> listapedidos= FXCollections.observableArrayList();

    Queue<ItemPedido>cola=new LinkedList<>();
    Stack<ItemPedido>pila =new Stack<>();

    @FXML protected void initialize(){
        columnJuego.setCellValueFactory(new PropertyValueFactory<Pedido,String>("juego"));
        columncantJuego.setCellValueFactory(new PropertyValueFactory<Pedido,String>("cantjuego"));

        tabla.getColumns().addAll(columnJuego,columncantJuego);

        tabla.setItems(listapedidos);

        listajuegos.add("Call Of Duty");
        listajuegos.add("Super Mario Odyssey");
        listajuegos.add("Gran Turismo");
        listajuegos.add("Halo");
        listajuegos.add("Mario Kart");
        listajuegos.add("God Of War");
        listajuegos.add("Gears Of War");
        for (int x=0;x<listajuegos.size();x++) combazo.getItems().add(listajuegos.get(x));

    }
    public void insertarPedido(ActionEvent event){
        String p=combazo.getSelectionModel().getSelectedItem().toString();
        String cj=txtCantJ.getText();
        listapedidos.add(new Pedido(p,cj));
    }

    public void guardarpedido(ActionEvent event) {
        String[][] items = new String[listapedidos.size()][2];
        for (int x = 0; x < items.length; x++) {
            items[x][0] = listapedidos.get(x).getJuego();
            items[x][1] = listapedidos.get(x).getCantjuego();
        }

        ItemPedido pedido = new ItemPedido(items, txtname.getText());
        cola.add(pedido);
    pila.add(pedido);
        listapedidos.clear();
        txtname.setText("");
    }

    public void finalizar(){
        ItemPedido pedido=cola.poll();
nombrepedido.setText(pedido.getNombre());
String[][] datos=pedido.getDatos();
for(int x=0;x<datos.length;x++){
    System.out.print(datos[x][0]);
    System.out.print(datos[x][1]);
    System.out.println();
}
    }

    public void statuscliente(ActionEvent event) {
        ItemPedido pedido = pila.pop();
        String[][] datos = pedido.getDatos();
        for (int x = 0; x < datos.length; x++) {
            Alert AlertType = new Alert(Alert.AlertType.INFORMATION);
            AlertType.setTitle("STATUS INFORMATION");
            AlertType.setContentText("Nombre: " + pedido.getNombre() + "---" +" Videojuego " + datos[x][0] + "---" +" Cantidad "+ datos[x][1]);
            AlertType.show();
        }
    }
}
