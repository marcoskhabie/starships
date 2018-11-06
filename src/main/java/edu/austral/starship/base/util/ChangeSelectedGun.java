package edu.austral.starship.base.util;

import edu.austral.starship.base.model.Gun;
import edu.austral.starship.base.model.PlayerSpaceship;
import edu.austral.starship.base.model.Spaceship;

import javax.swing.*;
import java.util.List;

public class ChangeSelectedGun implements Function {
    private long lastChange=0;
    @Override
    public void action(PlayerSpaceship playerSpaceship) {

        if (System.currentTimeMillis()-lastChange>100) {


            Spaceship spaceship = playerSpaceship.getSpaceship();
            List<Gun> guns = spaceship.getGuns();
            Gun selectedGun = spaceship.getSelectedGun();
            int actualIndex = guns.indexOf(selectedGun);
            if (actualIndex == guns.size() - 1) {
                spaceship.setSelectedGun(guns.get(0));
            } else {
                spaceship.setSelectedGun(guns.get(actualIndex + 1));
            }

            lastChange=System.currentTimeMillis();
        }
    }

    @Override
    public void releaseAction(PlayerSpaceship playerSpaceship) {

    }
}
