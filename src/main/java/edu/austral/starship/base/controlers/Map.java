package edu.austral.starship.base.controlers;

import edu.austral.starship.base.model.*;
import edu.austral.starship.base.util.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Map implements Visitor {

    private List<Entity> entities;
    private List<PlayerSpaceship> playerSpaceships;
    private int amountOfAsteroids=0;


    public Map(List<Entity> entities, List<PlayerSpaceship> playerSpaceships) {
        this.entities = entities;
        this.playerSpaceships = playerSpaceships;
    }

    public Map() {
        this.entities= new ArrayList<>();
        this.playerSpaceships= new ArrayList<>();
    }

    public void addEntity(Entity entity){
        entities.add(entity);
    }

    public void addAsteroid(Asteroid asteroid){
        entities.add(asteroid);
        amountOfAsteroids++;
    }

    public void deleteEntity(Entity entity){

        entities.remove(entity);
    }

    public void deleteAsteroid(Asteroid asteroid){
        entities.remove(asteroid);
        amountOfAsteroids--;
    }
    public void addPlayer(PlayerSpaceship playerSpaceship){
        playerSpaceships.add(playerSpaceship);

    }

    public void deletePlayer(PlayerSpaceship playerSpaceship){
        playerSpaceships.remove(playerSpaceship);
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public List<PlayerSpaceship> getPlayerSpaceships() {
        return playerSpaceships;
    }

    public void setPlayerSpaceships(List<PlayerSpaceship> playerSpaceships) {
        this.playerSpaceships = playerSpaceships;
    }

    public void update(){
        for (Entity e:entities) {
            e.advance();
        }
    }

    public int getAmountOfAsteroids() {
        return amountOfAsteroids;
    }

    public void setAmountOfAsteroids(int amountOfAsteroids) {
        this.amountOfAsteroids = amountOfAsteroids;
    }

    @Override
    public void visitSS(Spaceship spaceship) {
        deleteEntity(spaceship);
    }

    @Override
    public void visitAsteroid(Asteroid asteroid) {
        deleteAsteroid(asteroid);
    }

    @Override
    public void visitBullet(Bullet bullet) {
        deleteEntity(bullet);
    }
}
