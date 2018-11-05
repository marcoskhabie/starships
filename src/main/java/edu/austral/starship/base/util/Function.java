package edu.austral.starship.base.util;

import edu.austral.starship.base.model.PlayerSpaceship;

public interface Function {
        void action(PlayerSpaceship playerSpaceship);

        void releaseAction(PlayerSpaceship playerSpaceship);
}
