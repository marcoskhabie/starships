package edu.austral.starship.base.model;

import edu.austral.starship.base.vector.Vector2;

import java.util.ArrayList;
import java.util.List;

public abstract class Bullet extends Entity implements BulletObservable{
    private List<BulletObserver> observers=new ArrayList<>();
    private double damage;


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
}
