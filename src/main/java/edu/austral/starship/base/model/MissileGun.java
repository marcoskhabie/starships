package edu.austral.starship.base.model;

public class MissileGun extends Gun {
    public MissileGun() {
        super(2000);
        setAmmo(3);
        setName("MISSILE");
    }

    @Override
    public Bullet fireConcrete(PlayerSpaceship playerSpaceship) {
        Spaceship spaceship=playerSpaceship.getSpaceship();
        Bullet result= new BulletMissile(spaceship.getDirection().multiply((float) 5),spaceship.getPosition().add(spaceship.getDirection().multiply((float) 10)),spaceship.getHealth());
        result.addObserver(playerSpaceship);
        return result;
    }

    @Override
    public void setMaxAmmo() {
        setAmmo(3);
    }
}
