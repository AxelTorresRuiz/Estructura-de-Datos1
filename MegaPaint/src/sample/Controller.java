package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Controller {

   @FXML
    Canvas lienzo;
   GraphicsContext context;
   @FXML
    ColorPicker colorpiker;
   Color colorpincel=Color.BLACK;
   @FXML protected void initialize(){

       context=lienzo.getGraphicsContext2D();
       context.setFill(Color.BLUE);
       context.fillRect(10,20,100,50);
       context.setFill(Color.RED);
       context.strokeRect(200,150,200,100);
       context.setFill(Color.GREEN);
       context.fillOval(350,350,50,50);
       context.strokeLine(20,50,lienzo.getWidth(),lienzo.getHeight());

       }

    public void cambiarcolor(ActionEvent event){
        colorpincel=colorpiker.getValue();
    }

    public void borrar(MouseEvent event){
        context.setFill(Color.WHITESMOKE);
        context.fillRect(0,0,lienzo.getWidth(),lienzo.getHeight());
    }
       public void arrastrar(MouseEvent event){
       context.setFill(colorpincel);
       context.fillOval(event.getX(),event.getY(),10,10);
       }


}
