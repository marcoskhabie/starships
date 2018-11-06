package edu.austral.starship.base.model;

public interface SpaceshipObservable {
    void addObserver(SpaceshipObserver observer);
    void deleteObserver(SpaceshipObserver observer);
    void notifyEvent(double damage);
}
