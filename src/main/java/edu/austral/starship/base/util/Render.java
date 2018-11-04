package edu.austral.starship.base.util;

import edu.austral.starship.base.model.Asteroid;
import edu.austral.starship.base.model.Bullet;
import edu.austral.starship.base.model.Entity;
import edu.austral.starship.base.model.Spaceship;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;

import java.util.HashMap;
import java.util.List;

public class Render implements Visitor {

    PGraphics graphics;
    PImage spaceshipImage;
    PImage asteroidImage;


    @Override
    public void visitSS(Spaceship spaceship) {
        float positionX=spaceship.getPosition().getX();
        float positionY=spaceship.getPosition().getY();

        graphics.pushMatrix();
        graphics.imageMode(PConstants.CENTER);
        graphics.translate(positionX, positionY);
        float angle = (float) (spaceship.getDirection().angle()+ Math.PI/2);
        graphics.rotate(angle);
        graphics.image(spaceshipImage,0,0,50,50);
        graphics.popMatrix();
//        generateRRSpaceship(spaceship);
    }

    @Override
    public void visitAsteroid(Asteroid asteroid) {
        float positionX=asteroid.getPosition().getX();
        float positionY=asteroid.getPosition().getY();

        graphics.pushMatrix();
        graphics.imageMode(PConstants.CENTER);
        graphics.translate(positionX, positionY);
        float angle = (float) Math.PI/4;
        graphics.rotate(angle);
        graphics.image(asteroidImage,0,0,50,50);
        graphics.popMatrix();
//        generateRRAsteroid(asteroid);
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

    public void paint(List<Entity> entities, PGraphics pGraphics, HashMap<String, PImage> images) {
        this.graphics =pGraphics;
        this.spaceshipImage =images.get("spaceship");
        this.asteroidImage =images.get("asteroid");
        for (Entity entity: entities) {
            entity.accepts(this);
        }
    }
}
