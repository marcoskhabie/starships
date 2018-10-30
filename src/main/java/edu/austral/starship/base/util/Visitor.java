package edu.austral.starship.base.util;

import edu.austral.starship.base.model.Asteroid;
import edu.austral.starship.base.model.Bullet;
import edu.austral.starship.base.model.Spaceship;

public interface Visitor {
    void visitSS(Spaceship spaceship);
    void visitAsteroid(Asteroid asteroid);
    void visitBullet(Bullet bullet);
}
