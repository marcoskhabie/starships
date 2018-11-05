package edu.austral.starship.base.model;

import edu.austral.starship.base.collision.CollisionHandler;
import edu.austral.starship.base.util.Visitor;
import edu.austral.starship.base.vector.Vector2;

public class Asteroid extends Entity {
    private Vector2 previousDirection = getDirection();
    private Asteroid previousAsteroid=null;
    public Asteroid(Vector2 direction, Vector2 position, double health) {
        super(direction, position, health);
    }



    @Override
    public void accepts(Visitor visitor) {
        visitor.visitAsteroid(this);
    }


    @Override
    public void handleCollision(CollisionHandler collisionHandler) {
        collisionHandler.handleAsteroid(this);
    }

    @Override
    public void handleAsteroid(Asteroid asteroid) {
       if (previousAsteroid != null) {
           if (previousAsteroid !=(asteroid)) {
               if (asteroid.getDirection().equals(previousDirection)) {
                   setDirection(asteroid.getPreviousDirection());
               } else {
                   setDirection(asteroid.getDirection());

               }
               previousAsteroid=asteroid;
           }
       }
       else {
           if (asteroid.getDirection().equals(previousDirection)) {
               setDirection(asteroid.getPreviousDirection());
           } else {
               setDirection(asteroid.getDirection());

           }
           previousAsteroid=asteroid;
       }


    }

    @Override
    public void handleSpaceship(Spaceship spaceship) {
       setHealth(0.0);
    }

    @Override
    public void handleABullet(Bullet bullet) {
        setHealth(getHealth()-bullet.getDamage());
    }

    @Override
    public void setDirection(Vector2 direction) {
        previousDirection =getDirection();
        super.setDirection(direction);
    }

    public Vector2 getPreviousDirection() {
        return previousDirection;
    }

    public void setPreviousDirection(Vector2 previousDirection) {
        this.previousDirection = previousDirection;
    }

    @Override
    public void advance() {
        setPosition(getPosition().add(getDirection().multiply((float) 2)));
    }

}
