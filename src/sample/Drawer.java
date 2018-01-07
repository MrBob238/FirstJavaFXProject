package sample;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

/**
 * Created by Vladimir on 07.01.2018.
 */
public class Drawer {
    boolean isMousePressed;

    public void drawOnMousePressed(Canvas canvas, GraphicsContext graphicsContext){
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
    }
}
