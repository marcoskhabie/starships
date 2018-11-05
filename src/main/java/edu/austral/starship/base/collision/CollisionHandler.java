package edu.austral.starship.base.collision;

import edu.austral.starship.base.model.Asteroid;
import edu.austral.starship.base.model.Bullet;
import edu.austral.starship.base.model.Spaceship;
import edu.austral.starship.base.util.Visitable;

public interface CollisionHandler extends Visitable {
    void handleCollision(CollisionHandler collisionHandler);
    void handleAsteroid(Asteroid asteroid);
    void handleSpaceship(Spaceship spaceship);
    void handleABullet(Bullet bullet);
}
