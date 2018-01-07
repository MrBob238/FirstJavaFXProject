package sample;

import javafx.scene.paint.Color;

/**
 * Created by Vladimir on 07.01.2018.
 */
public class ColorWithName {
    private Color color;
    private String colorName;

    public ColorWithName (Color color, String colorName) {
        this.color = color;
        this.colorName = colorName;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}
