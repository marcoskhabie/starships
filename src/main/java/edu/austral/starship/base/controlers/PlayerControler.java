package edu.austral.starship.base.controlers;

import edu.austral.starship.base.model.PlayerSpaceship;
import edu.austral.starship.base.util.Function;
import processing.core.PConstants;

import java.util.Map;

public class PlayerControler {

    private Map<Integer, Function> playerKeys;
    private PlayerSpaceship playerSpaceship;

    public void onPressedKey(Integer key){
       if (playerKeys.containsKey(key)){
           playerKeys.get(key).action(playerSpaceship);
       }
    }


    public PlayerControler(Map<Integer, Function> playerKeys, PlayerSpaceship playerSpaceship) {
        this.playerKeys = playerKeys;
        this.playerSpaceship = playerSpaceship;
    }

    public PlayerSpaceship getPlayerSpaceship() {
        return playerSpaceship;
    }

    public void setPlayerSpaceship(PlayerSpaceship playerSpaceship) {
        this.playerSpaceship = playerSpaceship;
    }
}
