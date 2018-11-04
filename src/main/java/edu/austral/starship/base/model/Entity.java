package edu.austral.starship.base.model;

import edu.austral.starship.base.collision.CollisionHandler;
import edu.austral.starship.base.util.Visitable;
import edu.austral.starship.base.vector.Vector2;

public abstract class Entity implements Visitable, CollisionHandler {
    private Vector2 direction;
    private Vector2 position;
    private double health;

    public Entity(Vector2 direction, Vector2 position, double health) {
        this.direction = direction;
        this.position = position;
        this.health = health;
    }


    public void advance() {
        position= position.add(direction);
    }

    public Vector2 getDirection() {
        return direction;
    }

    public void setDirection(Vector2 direction) {
        this.direction = direction;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public  boolean isOutOfBounds(float width,float height){
      if (position.getX()>width+50||position.getX()<-50||position.getY()>height+50||position.getY()<-50){
          return true;
      }
      else return false;
    }
}

