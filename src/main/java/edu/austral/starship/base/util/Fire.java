package edu.austral.starship.base.util;

import edu.austral.starship.base.controlers.CustomGameFramework;
import edu.austral.starship.base.model.Bullet;
import edu.austral.starship.base.model.Gun;
import edu.austral.starship.base.model.PlayerSpaceship;

public class Fire implements Function {

    @Override
    public void action(PlayerSpaceship playerSpaceship) {
        Gun gun =playerSpaceship.getSpaceship().getSelectedGun();
        if (System.currentTimeMillis()-gun.getLastFire()>gun.getMillisUntilNext()){
            Bullet bullet=gun.fire(playerSpaceship);
            CustomGameFramework.map.addEntity(bullet);
        }

    }

    @Override
    public void releaseAction(PlayerSpaceship playerSpaceship) {

    }
}
