package edu.austral.starship.base.model;

public class PlayerSpaceship {

    private Player player;
    private Spaceship spaceship;

    public PlayerSpaceship(Player player, Spaceship spaceship) {
        this.player = player;
        this.spaceship = spaceship;
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
}
