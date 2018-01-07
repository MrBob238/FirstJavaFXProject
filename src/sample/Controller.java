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

    public void initialize() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.GREEN);
        graphicsContext.fillOval(0, 0, 100, 80);
        btn1.setStyle("-fx-border-color: black; -fx-border-width: 1");

        ArrayList<ColorWithName> colors = new ArrayList<>();
        colors.add(new ColorWithName(Color.RED, "RED"));
        colors.add(new ColorWithName(Color.GREEN, "GREEN"));
        colors.add(new ColorWithName(Color.BLUE, "BLUE"));
        colors.add(new ColorWithName(Color.YELLOW, "YELLOW"));
        colors.add(new ColorWithName(Color.PINK, "PINK"));

        ColorPalette palette = new ColorPalette(colors,buttonBox, graphicsContext, lbl1);

        Drawer drawer = new Drawer();
        drawer.drawOnMousePressed(canvas, graphicsContext);
    }

    public void onClick() {
        btn1.clearBackground();
        btn1.clearCanvas(canvas);
        lbl1.setText("" + i);
        i++;
    }
}
