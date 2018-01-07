package sample;

import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import java.util.ArrayList;

/**
 * Created by Vladimir on 07.01.2018.
 */
public class ColorPalette {

    public ColorPalette(ArrayList<ColorWithName> colors, HBox buttonBox, GraphicsContext graphicsContext, Label lbl) {
        for (int i = 0; i < colors.size(); i++) {
            Button btn = new Button();
            btn.setBackground(new Background(new BackgroundFill(colors.get(i).getColor(), null, null)));
            buttonBox.getChildren().add(btn);
            int finalI = i;
            btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    lbl.setText(colors.get(finalI).getColorName()); //вывод текущего цвета
                    graphicsContext.setFill(colors.get(finalI).getColor()); //выбор текущего цвета

                    //покраска кнопки в текущий цвет
                    //btn1.setBackground(new Background((new BackgroundFill(colors.get(finalI).getColor(), null, null))));
                }
            });

        }

    }
}
