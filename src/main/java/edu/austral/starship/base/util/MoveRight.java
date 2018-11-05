package edu.austral.starship.base.util;

import edu.austral.starship.base.model.PlayerSpaceship;
import edu.austral.starship.base.vector.Vector2;

public class MoveRight implements Function{
    @Override
    public void action(PlayerSpaceship playerSpaceship) {
        Vector2 actualDirection= playerSpaceship.getSpaceship().getDirection().unitary();
        playerSpaceship.getSpaceship().setDirection(actualDirection.add(Vector2.vectorFromModule(actualDirection.module(), (float) (actualDirection.angle()+0.15)).unitary()));
    }

    @Override
    public void releaseAction(PlayerSpaceship playerSpaceship) {

    }
}
