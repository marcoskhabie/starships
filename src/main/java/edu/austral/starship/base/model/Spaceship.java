package edu.austral.starship.base.model;

import edu.austral.starship.base.collision.CollisionHandler;
import edu.austral.starship.base.util.Type;
import edu.austral.starship.base.util.Visitor;
import edu.austral.starship.base.vector.Vector2;

import java.util.ArrayList;
import java.util.List;

import static edu.austral.starship.base.controlers.CustomGameFramework.map;

public class Spaceship extends Entity implements SpaceshipObservable  {


    private List<SpaceshipObserver> observers;
    private List<Gun> guns;
    private Gun selectedGun;
    private float velocity=1;
    private Type type;

    public Spaceship(Vector2 direction, Vector2 position, double health) {
        super(direction, position, health);
        observers=new ArrayList<>();
        guns=new ArrayList<>();
    }

    @Override
    public void accepts(Visitor visitor) {
        visitor.visitSS(this);
    }

    @Override
    public void addObserver(SpaceshipObserver observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(SpaceshipObserver observer) {
    observers.remove(observer);
    }

    @Override
    public void notifyEvent(double damage) {
        for (SpaceshipObserver o:observers) {
            o.UpdateSpaceship(damage);
        }
    }


    public Spaceship(Vector2 direction, Vector2 position, double health, List<Gun> guns) {
        super(direction, position, health);
        observers=new ArrayList<>();
        this.guns = guns;
        this.selectedGun = guns.get(0);
    }

    public Spaceship(Vector2 direction, Vector2 position, double health, List<Gun> guns, Gun selectedGun) {
        super(direction, position, health);
        this.observers=new ArrayList<>();
        this.guns = guns;
        this.selectedGun = selectedGun;
    }

    public List<SpaceshipObserver> getObservers() {
        return observers;
    }

    public void setObservers(List<SpaceshipObserver> observers) {
        this.observers = observers;
    }

    public List<Gun> getGuns() {
        return guns;
    }

    public void setGuns(List<Gun> guns) {
        this.guns = guns;
    }

    public Gun getSelectedGun() {
        return selectedGun;
    }

    public void setSelectedGun(Gun selectedGun) {
        this.selectedGun = selectedGun;
    }

    @Override
    public void handleCollision(CollisionHandler collisionHandler) {
        collisionHandler.handleSpaceship(this);
    }

    @Override
    public void handleAsteroid(Asteroid asteroid) {
        notifyEvent(100.0);
    }

    @Override
    public void handleSpaceship(Spaceship spaceship) {

    }

    @Override
    public void handleABullet(Bullet bullet) {
        PlayerSpaceship bulletObserver=(PlayerSpaceship)bullet.getObservers().get(0);
        if (!observers.contains(bulletObserver)){
            double damage=bullet.getDamage();
            notifyEvent(damage);
        }
    }

    @Override
    public void advance() {
//        if (getHealth()<=0.0){
//            map.deleteEntity(this);
//        }

    }

    public void addVelocity(){
        if (velocity<5){
            velocity= (float) (velocity+0.1);
        }
    }
    @Override
    public boolean isOutOfBounds(float width, float height) {
        return false;
    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
