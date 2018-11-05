package edu.austral.starship.base.util;

import edu.austral.starship.base.collision.Collisionable;

import java.awt.*;

public class RenderResult implements Collisionable {
    @Override
    public Shape getShape() {
        return null;
    }

    @Override
    public void collisionedWith(Collisionable collisionable) {

    }
}
