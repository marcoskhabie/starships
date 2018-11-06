package edu.austral.starship.base.model;

import edu.austral.starship.base.util.Type;
import edu.austral.starship.base.util.Visitor;
import edu.austral.starship.base.vector.Vector2;

import java.util.List;

public class BulletMissile extends Bullet {
    public BulletMissile(Vector2 direction, Vector2 position, double health) {
        super(direction, position, health);
        setDamage(500);
        setSize(40);
        setType(Type.TYPE1);
    }



}
