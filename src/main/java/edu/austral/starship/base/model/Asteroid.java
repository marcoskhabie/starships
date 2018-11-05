package edu.austral.starship.base.model;

import edu.austral.starship.base.collision.CollisionHandler;
import edu.austral.starship.base.util.Visitor;
import edu.austral.starship.base.vector.Vector2;

public class Asteroid extends Entity {
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
        setDirection(asteroid.getDirection());
    }

    @Override
    public void handleSpaceship(Spaceship spaceship) {
       setHealth(0.0);
    }

    @Override
    public void handleABullet(Bullet bullet) {
        setHealth(getHealth()-bullet.getDamage());
    }
}
