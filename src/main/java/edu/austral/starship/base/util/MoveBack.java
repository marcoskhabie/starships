package edu.austral.starship.base.util;

import edu.austral.starship.base.model.PlayerSpaceship;
import edu.austral.starship.base.model.Spaceship;
import edu.austral.starship.base.vector.Vector2;

public class MoveBack implements Function {
    @Override
    public void action(PlayerSpaceship playerSpaceship) {
        Vector2 actualPosition= playerSpaceship.getSpaceship().getPosition();
        Vector2 actualDirection= playerSpaceship.getSpaceship().getDirection().unitary();

        playerSpaceship.getSpaceship().setPosition(actualPosition.add(actualDirection.inverse()));
//        playerSpaceship.getSpaceship().setDirection(actualDirection.add(actualDirection.inverse()).unitary());
        isOutOfBounds(playerSpaceship.getSpaceship());
    }
    void isOutOfBounds(Spaceship spaceship){
        Vector2 actual=spaceship.getPosition();
        isOut(spaceship, actual);
    }

    static void isOut(Spaceship spaceship, Vector2 actual) {
        if (actual.getX()>1050){
            spaceship.setPosition(new Vector2(0,actual.getY()));
        }
        else if (actual.getX()<-50){
            spaceship.setPosition(new Vector2(1000,actual.getY()));
        }
        else if (actual.getY()>550){
            spaceship.setPosition(new Vector2(actual.getX(),0));
        }
        else if (actual.getY()<-50){
            spaceship.setPosition(new Vector2(actual.getX(),500));
        }
    }
}
