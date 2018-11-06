package edu.austral.starship.base.util;

import edu.austral.starship.base.model.Asteroid;
import edu.austral.starship.base.model.Bullet;
import edu.austral.starship.base.model.Entity;
import edu.austral.starship.base.model.Spaceship;
import edu.austral.starship.base.vector.Vector2;
import javafx.scene.shape.Circle;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.cos;
import static processing.core.PApplet.radians;

public class Render implements Visitor {
//
//    PGraphics graphics;
//    PImage spaceshipImage;
//    PImage asteroidImage;
//    PImage bulletImage;
    private Map<String,PImage> images;
    private List<RenderResult> renderResults;

    public Render(Map<String, PImage> images) {
        this.images = images;
    }

    @Override
    public void visitSS(Spaceship spaceship) {
//        float positionX=spaceship.getPosition().getX();
//        float positionY=spaceship.getPosition().getY();
//
//        graphics.pushMatrix();
//        graphics.imageMode(PConstants.CENTER);
//        graphics.translate(positionX, positionY);
//        float angle = (float) (spaceship.getDirection().angle()+ Math.PI/2);
//        graphics.rotate(angle);
//        graphics.image(spaceshipImage,0,0,50,50);
//        graphics.popMatrix();
        renderResults.add(generateRRSpaceship(spaceship));
    }

    @Override
    public void visitAsteroid(Asteroid asteroid) {
//        float positionX=asteroid.getPosition().getX();
//        float positionY=asteroid.getPosition().getY();
//
//        graphics.pushMatrix();
//        graphics.imageMode(PConstants.CENTER);
//        graphics.translate(positionX, positionY);
//        float angle = (float)cos( Math.PI/42);
//        graphics.rotate(angle);
//        graphics.image(asteroidImage,0,0,50,50);
//        graphics.popMatrix();
        renderResults.add(generateRRAsteroid(asteroid));
    }

    @Override
    public void visitBullet(Bullet bullet) {

//        float positionX=bullet.getPosition().getX();
//        float positionY=bullet.getPosition().getY();
//
//        graphics.pushMatrix();
//        graphics.imageMode(PConstants.CENTER);
//        graphics.translate(positionX, positionY);
//        graphics.image(spaceshipImage,0,0,10,10);
//        graphics.popMatrix();
        renderResults.add(generateRRBullet(bullet));
    }

    private RenderResult generateRRSpaceship(Spaceship spaceship){
        PImage image= images.get("spaceship"+ spaceship.getType());
        float size=spaceship.getSize();
        Vector2 position= spaceship.getPosition();
        Shape shape= new Rectangle2D.Float(position.getX()-((size-10)/2),position.getY()+((size-10)/2),size-10,size-10);
        return new RenderResult(image,shape,spaceship);
    }

    private RenderResult generateRRAsteroid(Asteroid asteroid){
        PImage image= images.get("asteroid");
        float size=asteroid.getSize();
        Vector2 position= asteroid.getPosition();
//        Shape shape=new Ellipse2D.Float(position.getX()-20,position.getY()+20,size-10,size-10);
        Shape shape= new Rectangle2D.Float(position.getX()-((size-10)/2),position.getY()+((size-10)/2),size-10,size-10);
        return new RenderResult(image,shape,asteroid);
    }

    private RenderResult generateRRBullet(Bullet bullet){
        PImage image= images.get("bullet"+bullet.getType());
        Vector2 position= bullet.getPosition();
        float size=bullet.getSize();
        Shape shape= new Rectangle2D.Float(position.getX()-((size-5)/2),position.getY()+((size-5)/2),size-5,size-5);
        return new RenderResult(image,shape,bullet);
    }

    public List<RenderResult> render(List<Entity> entities){
        renderResults=new ArrayList<>();
        for (Entity e : entities) {
            e.accepts(this);
        }
        return renderResults;
    }

//    public void paint(List<Entity> entities, PGraphics pGraphics, HashMap<String, PImage> images) {
//        this.graphics =pGraphics;
//        this.spaceshipImage =images.get("spaceship");
//        this.asteroidImage =images.get("asteroid");
//        this.bulletImage =images.get("bullet");
//        for (Entity entity: entities) {
//            entity.accepts(this);
//        }
//    }
}
