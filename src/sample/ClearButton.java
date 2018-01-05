package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

/**
 * Created by Vladimir on 04.01.2018.
 */
public class ClearButton extends Button {

    public void clearBackground() {
        this.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));
    }

    public void clearCanvas (Canvas canvas) {
        canvas.getGraphicsContext2D().setFill(Color.WHITESMOKE);
        canvas.getGraphicsContext2D().fillRect(0,0,canvas.getWidth(),canvas.getHeight());
    }

}


