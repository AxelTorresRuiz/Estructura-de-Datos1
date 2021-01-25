package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Estructuras.Busqueda;
import sample.Estructuras.ItemPedido;
import sample.Estructuras.Pedido;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ControllerCobro {
    @FXML ComboBox combazo;
    @FXML TableView tabla;
    @FXML TextField txtCantJ,txtname,txtventa;
    @FXML Label nombrepedido;
    @FXML Label txtnameuser,lblventas;
    int[] ventas=new int[5];

    LinkedList<String>listajuegos=new LinkedList<>();
    TableColumn columnJuego=new TableColumn("VIDEOJUEGO");
    TableColumn columncantJuego=new TableColumn("CANTIDAD");
    ObservableList<Pedido> listapedidos= FXCollections.observableArrayList();

    Queue<ItemPedido>cola=new LinkedList<>();
    Stack<ItemPedido>pila =new Stack<>();

    int vector[]={5,2,1,8,3,9,7};

    String[][] videojuegos={
            {"Call of Duty","1600"},
            {"Super Mario Odyssey","1200"},
            {"Gran Turismo","500"},
            {"Halo","800"},
            {"Mario Kart","1100"},
            {"God of War","1000"},
            {"Gears of War","400"},
    };

    @FXML protected void initialize(){
        txtnameuser.setText(Main.NombreUsuario);
        columnJuego.setCellValueFactory(new PropertyValueFactory<Pedido,String>("juego"));
        columncantJuego.setCellValueFactory(new PropertyValueFactory<Pedido,String>("cantjuego"));

        tabla.getColumns().addAll(columnJuego,columncantJuego);

        tabla.setItems(listapedidos);

  //      listajuegos.add("Call Of Duty");
  //      listajuegos.add("Super Mario Odyssey");
  //      listajuegos.add("Gran Turismo");
  //      listajuegos.add("Halo");
  //      listajuegos.add("Mario Kart");
  //      listajuegos.add("God Of War");
  //      listajuegos.add("Gears Of War");

        for (int x=0;x<videojuegos.length;x++){
            listajuegos.add(videojuegos[x][0]);
        }




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
    int cont=0;
    public void insertarventa(ActionEvent event){
ventas[cont]=Integer.parseInt(txtventa.getText().toString());
cont++;
    }
    public void ordenarventa(ActionEvent event){
        Busqueda ordenar=new Busqueda();
        int[]ordenado=ordenar.burbuja(ventas);
      String todo="";
      for (int x=0;x<ordenado.length;x++) todo+= ", "+ordenado[x];
      lblventas.setText(todo);
    }
    public void ordenarjuegos(ActionEvent event){
        Busqueda ordenar=new Busqueda();
        combazo.getItems().clear();
        listajuegos.clear();
        String[][]ordenado=ordenar.burbujaArray(videojuegos);
        for (int x=0;x<ordenado.length;x++){
            listajuegos.add(ordenado[x][0]);
            combazo.getItems().add(ordenado[x][0]);
        }

    }
    public void OrdenarNombre(ActionEvent event){
        Busqueda Alfabetica=new Busqueda();
listajuegos.clear();
String[][]alfa=Alfabetica.burbujaAlfa(videojuegos);
for (int x=0;x<alfa.length;x++){
    listajuegos.add(alfa[x][0]);
//Intente hacer que ordenara alfabeticamente pero no me sale :(
    //Y no entendi los metodos de busqueda :(
    //Perdon por ser un mal estuadiante:(
}
    }

}
