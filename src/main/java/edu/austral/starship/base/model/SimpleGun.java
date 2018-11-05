package edu.austral.starship.base.model;

import java.util.Timer;

public class SimpleGun extends Gun {
    public SimpleGun() {
        super( 1000);
    }


    @Override
    public Bullet fireConcrete(PlayerSpaceship playerSpaceship) {
        Spaceship spaceship=playerSpaceship.getSpaceship();
        Bullet result= new BulletSimple(spaceship.getDirection().multiply((float) 5),spaceship.getPosition(),spaceship.getHealth());
        result.addObserver(playerSpaceship);
        return result;
    }
}
