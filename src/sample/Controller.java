package sample;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;


public class Controller {

    public HBox buttonBox;
    public ClearButton btn1;
    public Label lbl1;
    public Canvas canvas;
    public int i = 0;
    boolean isMousePressed;

    public void initialize() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.GREEN);
        graphicsContext.fillOval(0, 0, 100, 80);
        btn1.setStyle("-fx-border-color: black; -fx-border-width: 1");
        canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("pressed");
                isMousePressed = true;
            }
        });

        canvas.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("released");
                isMousePressed = false;
            }
        });

        canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("moved");
                if (isMousePressed) {
                    graphicsContext.fillOval(event.getX(), event.getY(), 3, 3);
                }
            }
        });
        ArrayList<Color> colors = new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.BLUE);
        colors.add(Color.YELLOW);
        colors.add(Color.PINK);

        for (int i = 0; i <colors.size(); i++) {
            Button btn = new Button();
            btn.setBackground(new Background(new BackgroundFill(colors.get(i),null,null)));
            buttonBox.getChildren().add(btn);
            int finalI = i;
            btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    lbl1.setText(colors.get(finalI).toString());
                    graphicsContext.setFill(colors.get(finalI));
                    btn1.setBackground(new Background((new BackgroundFill(colors.get(finalI),null,null))));
                }
            });

        }
    }

    public void onClick() {
        btn1.clearBackground();
        //btn1.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));
        //canvas.getGraphicsContext2D().setFill(Color.WHITESMOKE);
        //canvas.getGraphicsContext2D().fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        btn1.clearCanvas(canvas);
        System.out.println("Тык!");
        lbl1.setText("" + i);
        i++;
    }
}
