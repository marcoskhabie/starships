package edu.austral.starship.base.model;

public class RapidGun extends Gun {
    public RapidGun() {
        super(10);
        setName("RAPID");
        setMaxAmmo();
    }

    @Override
    public Bullet fireConcrete(PlayerSpaceship playerSpaceship) {
        Spaceship spaceship=playerSpaceship.getSpaceship();
        Bullet result= new BulletSimple(spaceship.getDirection().multiply((float) 5),spaceship.getPosition().add(spaceship.getDirection().multiply((float) 10)),spaceship.getHealth());
        result.addObserver(playerSpaceship);
        return result;
    }

    @Override
    public void setMaxAmmo() {
        setAmmo(500);
    }
}
