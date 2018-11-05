package edu.austral.starship.base.util;

import edu.austral.starship.base.model.PlayerSpaceship;
import edu.austral.starship.base.model.Spaceship;
import edu.austral.starship.base.vector.Vector2;

public class MoveForward implements Function {
    @Override
    public void action(PlayerSpaceship playerSpaceship) {

        Spaceship spaceship= playerSpaceship.getSpaceship();

        spaceship.addVelocity();

        Vector2 actualPosition= playerSpaceship.getSpaceship().getPosition();
        Vector2 actualDirection= playerSpaceship.getSpaceship().getDirection().unitary();

        spaceship.setPosition(actualPosition.add(actualDirection.multiply((float) spaceship.getVelocity())));
//        playerSpaceship.getSpaceship().setDirection(actualDirection.add(actualDirection).unitary());

        MoveBack.isOut(spaceship,actualPosition);
    }

    @Override
    public void releaseAction(PlayerSpaceship playerSpaceship) {
        playerSpaceship.getSpaceship().setVelocity(1);
        action(playerSpaceship);

    }


}
