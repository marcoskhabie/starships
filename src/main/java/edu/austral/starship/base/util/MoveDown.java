package edu.austral.starship.base.util;

import edu.austral.starship.base.model.PlayerSpaceship;
import edu.austral.starship.base.vector.Vector2;

public class MoveDown implements Function {
    @Override
    public void action(PlayerSpaceship playerSpaceship) {
        Vector2 actualPosition= playerSpaceship.getSpaceship().getPosition();
        playerSpaceship.getSpaceship().setPosition(actualPosition.add(new Vector2(0,1)));
    }
}
