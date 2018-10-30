package edu.austral.starship.base.model;

import edu.austral.starship.base.vector.Vector2;

public abstract class Bullet extends Entity {

    public Bullet(Vector2 direction, Vector2 position, double health) {
        super(direction, position, health);
    }
}
