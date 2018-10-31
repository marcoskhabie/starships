package edu.austral.starship.base.controlers;

import edu.austral.starship.base.collision.CollisionEngine;
import edu.austral.starship.base.framework.GameFramework;
import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.base.framework.WindowSettings;
import edu.austral.starship.base.model.Entity;
import edu.austral.starship.base.model.Player;
import edu.austral.starship.base.model.PlayerSpaceship;
import edu.austral.starship.base.model.Spaceship;
import edu.austral.starship.base.util.*;
import edu.austral.starship.base.vector.Vector2;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.event.KeyEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class CustomGameFramework implements GameFramework {
    private int x=0;
    private int y=0;
    private int number=0;
    private PImage image;
    private List<PlayerControler> playerControlerList=new ArrayList<>();
    private CollisionEngine collisionEngine= new CollisionEngine();
    private Painter painter;
    private Render render= new Render();
    private Map map= new Map();


    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        Player player1 = new Player("Mark");

        Vector2 center= new Vector2(0,0);
        Vector2 up= new Vector2(0,-1);
        Spaceship spaceship= new Spaceship(up,center,100.0);

        PlayerSpaceship playerSpaceship1=new PlayerSpaceship(player1,spaceship);

        map.addEntity(spaceship);
        map.addPlayer(playerSpaceship1);

        //player 1 keys
        HashMap<Integer, Function> player1Keys= new HashMap<>();
        player1Keys.put(PConstants.UP,new MoveUp());
        player1Keys.put(PConstants.DOWN,new MoveDown());
        player1Keys.put(PConstants.RIGHT,new MoveRight());
        player1Keys.put(PConstants.LEFT,new MoveLeft());

        playerControlerList.add(new PlayerControler(player1Keys,playerSpaceship1));


        image= imageLoader.load("/Users/marcoskhabie/projects/starships/src/main/java/edu/austral/starship/base/util/images/heroship.png");
        windowsSettings
            .setSize(500, 500).enableHighPixelDensity();
    }

    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {


        for (Integer key : keySet) {
//            switch (key){
//                case PConstants.UP:
//                    y += 1;
//                    break;
//                case PConstants.DOWN:
//                    y -= 1;
//                    break;
//                case PConstants.LEFT:
//                    x -= 1;
//                    break;
//                case PConstants.RIGHT:
//                    x += 1;
//                    break;
//            }

            for (PlayerControler pc:playerControlerList) {
                pc.onPressedKey(key);
            }
        }

        render.paint(map.getEntities(),graphics,image);


        graphics.rect(x,y, 20,20);
        graphics.rect(20,10,10,10);
        graphics.text(number, 250, 100);
//        graphics.image(image, 0, 100,100,100);
    }

    @Override
    public void keyPressed(KeyEvent event) {

    }

    @Override
    public void keyReleased(KeyEvent event) {

    }
}
