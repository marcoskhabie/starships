package edu.austral.starship.base.model;

public class PlayerSpaceship implements SpaceshipObserver,BulletObserver {

    private Player player;
    private Spaceship spaceship;

    public PlayerSpaceship(Player player, Spaceship spaceship) {
        this.player = player;
        this.spaceship = spaceship;
        spaceship.addObserver(this);
        spaceship.setType(player.getType());
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Spaceship getSpaceship() {
        return spaceship;
    }

    public void setSpaceship(Spaceship spaceship) {
        this.spaceship = spaceship;
    }

    @Override
    public void updateBullet(int score) {
        player.setScore(player.getScore()+score);
    }

    @Override
    public void UpdateSpaceship(double damage) {
        if (!spaceship.isDead()){
            spaceship.setHealth(spaceship.getHealth()-damage);
            if (spaceship.getHealth()<=0.0){
                player.setLives(player.getLives()-1);
        }

       }



    }
}
