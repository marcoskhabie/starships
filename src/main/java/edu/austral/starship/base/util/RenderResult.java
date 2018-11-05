package edu.austral.starship.base.util;

import edu.austral.starship.base.collision.CollisionHandler;
import edu.austral.starship.base.collision.Collisionable;
import processing.core.PImage;

import java.awt.*;

public class RenderResult implements Collisionable<RenderResult> {
    private PImage image;
    private Shape shape;
    CollisionHandler collisionHandler;

    public RenderResult(PImage image, Shape shape, CollisionHandler collisionHandler) {
        this.image = image;
        this.shape = shape;
        this.collisionHandler = collisionHandler;
    }

    @Override
    public Shape getShape() {
        return shape;
    }

    @Override
    public void collisionedWith(RenderResult collisionable) {
        collisionHandler.handleCollision(collisionable.collisionHandler);
    }

    public PImage getImage() {
        return image;
    }

    public void setImage(PImage image) {
        this.image = image;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public CollisionHandler getCollisionHandler() {
        return collisionHandler;
    }

    public void setCollisionHandler(CollisionHandler collisionHandler) {
        this.collisionHandler = collisionHandler;
    }
}
