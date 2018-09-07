package interfacesGraficas;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Locale;

public class LetrasEnLocal {
    public static void main(String[] args) {
        String[] misFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String fuentes: misFuentes) {
            System.out.println(fuentes);
        }
    }
}
