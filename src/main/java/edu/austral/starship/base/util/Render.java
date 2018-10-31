package edu.austral.starship.base.util;

import edu.austral.starship.base.model.Asteroid;
import edu.austral.starship.base.model.Bullet;
import edu.austral.starship.base.model.Entity;
import edu.austral.starship.base.model.Spaceship;
import processing.core.PGraphics;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;

public class Render implements Visitor {

    PGraphics pGraphics;
    PImage pImage;


    @Override
    public void visitSS(Spaceship spaceship) {
        pGraphics.image(pImage,spaceship.getPosition().getX(),spaceship.getPosition().getY(),30,30);
//        generateRRSpaceship(spaceship);
    }

    @Override
    public void visitAsteroid(Asteroid asteroid) {
        generateRRAsteroid(asteroid);
    }

    @Override
    public void visitBullet(Bullet bullet) {
        generateRRBullet(bullet);
    }

    private RenderResult generateRRSpaceship(Spaceship spaceship){
        return new RenderResult();
    }

    private RenderResult generateRRAsteroid(Asteroid asteroid){
        return new RenderResult();
    }

    private RenderResult generateRRBullet(Bullet bullet){
        return new RenderResult();
    }

    public List<RenderResult> render(List<Entity> entities){
        return null;
    }

    public void paint(List<Entity> entities, PGraphics pGraphics, PImage image) {
        this.pGraphics=pGraphics;
        this.pImage=image;
        for (Entity entity: entities) {
            entity.accepts(this);
        }
    }
}
