package edu.austral.starship.base.model;

import edu.austral.starship.base.util.Visitor;
import edu.austral.starship.base.vector.Vector2;

import java.util.ArrayList;
import java.util.List;

public class Spaceship extends Entity implements SpaceshipObservable  {


    private List<SpaceshipObserver> observers;
    private List<Gun> guns;
    private Gun selectedGun;

    public Spaceship(Vector2 direction, Vector2 position, double health) {
        super(direction, position, health);
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
    public void notifyEvent() {

        for (SpaceshipObserver o:observers) {
            o.UpdateSpaceship();
        }
    }

    public Spaceship(Vector2 direction, Vector2 position, double health, List<SpaceshipObserver> observers, List<Gun> guns, Gun selectedGun) {
        super(direction, position, health);
        this.observers = observers;
        this.guns = guns;
        this.selectedGun = selectedGun;
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
}
