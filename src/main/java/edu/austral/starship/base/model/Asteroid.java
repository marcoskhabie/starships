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

    }

    @Override
    public void handleAsteroid(Asteroid asteroid) {

    }

    @Override
    public void handleSpaceship(Spaceship spaceship) {

    }

    @Override
    public void handleABullet(Bullet bullet) {

    }
}
