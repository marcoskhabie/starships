package edu.austral.starship.base.util;

import edu.austral.starship.base.model.*;
import processing.core.PConstants;
import processing.core.PGraphics;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static edu.austral.starship.base.util.Constants.MAX_HEALTH;

public class Painter implements Visitor{

    private List<RenderResult> renderResults=new ArrayList<>();
    private PGraphics graphics;
    private RenderResult actual;
    private float width;
    private float height;

    public Painter(float width, float height) {
        this.width = width;
        this.height = height;
    }

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
        drawLifeBar(graphics,spaceship);
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

    private void drawLifeBar(PGraphics graphics, Spaceship spaceship) {
        float rectWidth=100;
        float rectHeight=20;
        float x;
        float y=rectHeight+60;

        if (spaceship.getType().equals(Type.TYPE0)){
            x=10;
        }
        else {
            x=width-rectWidth-10;
        }


            double health = spaceship.getHealth();
        // Change color
        if (health < MAX_HEALTH*0.25) {
            graphics.fill(255, 0, 0);
        } else if (health <MAX_HEALTH*0.5) {
            graphics.fill(255, 200, 0);
        } else {
           graphics.fill(0, 255, 0);
        }

        // Draw bar
        graphics.noStroke();
        // Get fraction 0->1 and multiply it by width of bar
        float drawWidth = (float) ((health / MAX_HEALTH) * rectWidth);
        graphics.rect(x, y, drawWidth, rectHeight);

        // Outline
        graphics.stroke(0);
        graphics.noFill();
        graphics.rect(x, y, rectWidth, rectHeight);
    }

    public void paintPlayerInfo(PGraphics graphics, List<PlayerSpaceship> playerSpaceships) {
        float fontSize= 15;
        float fontColor= 255;
        for (PlayerSpaceship p:playerSpaceships) {
           Player player= p.getPlayer();
           Spaceship spaceship=p.getSpaceship();
           Gun gun=spaceship.getSelectedGun();
           float x;
           float y=fontSize;
            graphics.textAlign(PConstants.LEFT);
            if (player.getType().equals(Type.TYPE0)){
               x=fontSize;
//               graphics.textAlign(PConstants.RIGHT);

           }
           else{
               x=width-player.getName().length()*fontSize+20;

           }

            graphics.textSize(fontSize);
            graphics.fill(fontColor);
            graphics.text(player.getName(), x, y);

            graphics.textSize(fontSize);
            graphics.fill(fontColor);
            graphics.text("SCORE: " + player.getScore(), x, y*2);

            graphics.textSize(fontSize);
            graphics.fill(fontColor);
            graphics.text("LIVES: " + player.getLives(), x, y*3);

            graphics.textSize(fontSize);
            graphics.fill(fontColor);
            graphics.text("GUN: " + gun.getName(), x, y*4);

            graphics.textSize(fontSize);
            graphics.fill(fontColor);
            graphics.text("AMMO: " + gun.getAmmo(), x, y*5);
        }

    }

    public void end(List<PlayerSpaceship> playerSpaceships) {
        Player winner = playerSpaceships.get(0).getPlayer();

        for (PlayerSpaceship ps :
                playerSpaceships) {
            Player player = ps.getPlayer();
            if (player.getScore()>winner.getScore()){
                winner=player;
            }
        }
        graphics.textAlign(PConstants.CENTER);
        graphics.textSize(100);
        graphics.fill(255);
        graphics.text(winner.getName()+"WINS!", width/2, height/2);


        graphics.textAlign(PConstants.CENTER);
        graphics.textSize(50);
        graphics.fill(255);
        graphics.text("PRESS R TO RESTART", width/2, height/2+75);
    }
}
