package project;

import java.applet.Applet;
import java.awt.*;


public class Main extends Applet {
    public void paint(Graphics g){
        Expo.drawHeading(g, "Quentin Snow and Alekkai", "Final Project");
        Draw.startScreen(g);
        // Draw.road(g);
        // project.Sprites.player.make(g);

    }
}
