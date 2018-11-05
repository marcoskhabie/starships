package edu.austral.starship.base.util;

import edu.austral.starship.base.model.Entity;
import processing.core.PGraphics;
import processing.core.PImage;

import java.util.HashMap;
import java.util.List;

public class Painter {

    private HashMap<String, PImage> images;

    public Painter(HashMap<String, PImage> images) {
        this.images = images;
    }

    public void paint(List<Entity> entities, PGraphics graphics) {

    }
}
