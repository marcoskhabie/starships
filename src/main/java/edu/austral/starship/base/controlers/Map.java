package edu.austral.starship.base.controlers;

import edu.austral.starship.base.model.Entity;
import edu.austral.starship.base.model.Player;
import edu.austral.starship.base.model.PlayerSpaceship;

import java.util.ArrayList;
import java.util.List;

public class Map {

    List<Entity> entities;
    List<PlayerSpaceship> playerSpaceships;

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

    public void deleteEntity(Entity entity){
        entities.remove(entity);
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
}
