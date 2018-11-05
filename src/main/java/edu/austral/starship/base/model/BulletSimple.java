package edu.austral.starship.base.model;

import edu.austral.starship.base.collision.CollisionHandler;
import edu.austral.starship.base.util.Visitor;
import edu.austral.starship.base.vector.Vector2;

public class BulletSimple extends Bullet {


    public BulletSimple(Vector2 direction, Vector2 position, double health) {

        super(direction, position, health);
        setDamage(20);
        setSize(10);
    }

    @Override
    public void accepts(Visitor visitor) {
        visitor.visitBullet(this);
    }




}
