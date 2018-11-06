package edu.austral.starship.base.model;

import edu.austral.starship.base.collision.CollisionHandler;
import edu.austral.starship.base.util.Type;
import edu.austral.starship.base.util.Visitor;
import edu.austral.starship.base.vector.Vector2;

import java.util.ArrayList;
import java.util.List;

public abstract class Bullet extends Entity implements BulletObservable, CollisionHandler {
    private List<BulletObserver> observers=new ArrayList<>();
    private double damage;
    private Type type;


    public Bullet(Vector2 direction, Vector2 position, double health) {
        super(direction, position, health);
    }

    public Bullet(Vector2 direction, Vector2 position, double health, List<BulletObserver> observers, double damage) {
        super(direction, position, health);
        this.observers = observers;
        this.damage = damage;
    }

    public Bullet(Vector2 direction, Vector2 position, double health, double damage) {
        super(direction, position, health);
        this.damage = damage;
    }

    @Override
    public void addObserver(BulletObserver observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(BulletObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyEvent(int score) {
        for (BulletObserver o:observers) {
            o.updateBullet(score);
        }
    }

    public List<BulletObserver> getObservers() {
        return observers;
    }

    public void setObservers(List<BulletObserver> observers) {
        this.observers = observers;
    }

    @Override
    public void handleCollision(CollisionHandler collisionHandler) {
        collisionHandler.handleABullet(this);
    }

    @Override
    public void handleAsteroid(Asteroid asteroid) {
        notifyEvent(1);
        this.setHealth(0.0);
    }

    @Override
    public void handleSpaceship(Spaceship spaceship) {
        for (BulletObserver observer:
             observers) {
            PlayerSpaceship playerSpaceship=(PlayerSpaceship) observer;
            if (!playerSpaceship.getSpaceship().equals(spaceship)){
                notifyEvent(2);
                this.setHealth(0.0);
            }
        }

    }

    @Override
    public void handleABullet(Bullet bullet) {
        this.setHealth(0.0);
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void accepts(Visitor visitor) {
        visitor.visitBullet(this);
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
