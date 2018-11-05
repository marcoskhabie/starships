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

    public void keyRleased(Integer key){
        if (playerKeys.containsKey(key)){
            playerKeys.get(key).releaseAction(playerSpaceship);
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

    public Map<Integer, Function> getPlayerKeys() {
        return playerKeys;
    }

    public void setPlayerKeys(Map<Integer, Function> playerKeys) {
        this.playerKeys = playerKeys;
    }
}
