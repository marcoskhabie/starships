package edu.austral.starship;

import edu.austral.starship.base.framework.GameFramework;
import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.base.framework.WindowSettings;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.event.KeyEvent;

import java.util.Set;

public class CustomGameFramework implements GameFramework {
    private int x=0;
    private int y=0;
    private int number=0;
    private PImage image;
    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
//        image= imageLoader.load("");
        windowsSettings
            .setSize(500, 500).enableHighPixelDensity();
    }

    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {

        for (Integer key : keySet) {
            switch (key){
                case PConstants.UP:
                    y -= 1;
                    break;
                case PConstants.DOWN:
                    y += 1;
                    break;
                case PConstants.LEFT:
                    x -= 1;
                    break;
                case PConstants.RIGHT:
                    x += 1;
                    break;
            }
        }
        graphics.rect(x,y, 20,20);
        graphics.rect(20,10,10,10);
        graphics.text(number, 250, 100);
//        graphics.image(image, 0, 100,100,100);
    }

    @Override
    public void keyPressed(KeyEvent event) {

    }

    @Override
    public void keyReleased(KeyEvent event) {

    }
}
