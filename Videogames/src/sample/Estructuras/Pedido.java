package sample.Estructuras;

import javafx.beans.property.SimpleStringProperty;

public class Pedido {
    SimpleStringProperty juego;
    SimpleStringProperty cantjuego;

public Pedido(String juego, String cantjuego){
    this.juego=new SimpleStringProperty(juego);
    this.cantjuego=new SimpleStringProperty(cantjuego);
    }

    public String getJuego() {
        return juego.get();
    }

    public SimpleStringProperty juegoProperty() {
        return juego;
    }

    public void setJuego(String juego) {
        this.juego.set(juego);
    }

    public String getCantjuego() {
        return cantjuego.get();
    }

    public SimpleStringProperty cantjuegoProperty() {
        return cantjuego;
    }

    public void setCantjuego(String cantjuego) {
        this.cantjuego.set(cantjuego);
    }
}
