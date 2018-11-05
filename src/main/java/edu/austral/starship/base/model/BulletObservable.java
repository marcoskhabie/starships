package edu.austral.starship.base.model;

public interface BulletObservable {
    void addObserver(BulletObserver observer);
    void deleteObserver(BulletObserver observer);
    void notifyEvent(int score);
}
