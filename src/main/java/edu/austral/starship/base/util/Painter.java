package edu.austral.starship.base.util;

import edu.austral.starship.base.model.Asteroid;
import edu.austral.starship.base.model.Bullet;
import edu.austral.starship.base.model.Entity;
import edu.austral.starship.base.model.Spaceship;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.Math.cos;

public class Painter implements Visitor{

    private List<RenderResult> renderResults=new ArrayList<>();
    private PGraphics graphics;
    private RenderResult actual;
//    private float asteroidAngle = 0f;

    public void paint(List<RenderResult> renderResults, PGraphics graphics) {
        this.renderResults=renderResults;
        this.graphics=graphics;
        for (RenderResult r :
                renderResults) {
            actual=r;
            r.collisionHandler.accepts(this);
            drawBoundsOfCollider(graphics,r.getShape());
        }

    }

    @Override
    public void visitSS(Spaceship spaceship) {
        float positionX=spaceship.getPosition().getX();
        float positionY=spaceship.getPosition().getY();

        graphics.pushMatrix();
        graphics.imageMode(PConstants.CENTER);
        graphics.translate(positionX, positionY);
        float angle = (float) (spaceship.getDirection().angle()+ Math.PI/2);
        graphics.rotate(angle);
        graphics.image(actual.getImage(),0,0,50,50);
        graphics.popMatrix();
    }

    @Override
    public void visitAsteroid(Asteroid asteroid) {
        float positionX=asteroid.getPosition().getX();
        float positionY=asteroid.getPosition().getY();

        graphics.pushMatrix();
        graphics.imageMode(PConstants.CENTER);
        graphics.translate(positionX, positionY);
//        asteroidAngle += 0.01;
//        graphics.rotate(asteroidAngle);
        graphics.image(actual.getImage(),0,0,60,60);
        graphics.popMatrix();
    }

    @Override
    public void visitBullet(Bullet bullet) {
        float positionX=bullet.getPosition().getX();
        float positionY=bullet.getPosition().getY();

        graphics.pushMatrix();
        graphics.imageMode(PConstants.CENTER);
        graphics.translate(positionX, positionY);
        float angle = (float) (bullet.getDirection().angle()+ Math.PI/2);
        graphics.rotate(angle);
        graphics.image(actual.getImage(),0,0,bullet.getSize(),bullet.getSize());
        graphics.popMatrix();
    }

    private void drawBoundsOfCollider(PGraphics graphics, Shape shape)  {
        Rectangle bounds = shape.getBounds();
        float x = (float) bounds.getX();
        float y = (float) bounds.getY();
        float width = (float) bounds.getWidth();
        float height = (float) bounds.getHeight();
        graphics.point(x, y);
        graphics.point(x + width, y);
        graphics.point(x, y - height);
        graphics.point(x + width, y - height);
    }
}
