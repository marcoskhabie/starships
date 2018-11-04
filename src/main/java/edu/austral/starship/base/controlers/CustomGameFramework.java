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

import java.util.*;

public class CustomGameFramework implements GameFramework {
    private int x=0;
    private int y=0;
    private int number=0;
    private List<PlayerControler> playerControlerList=new ArrayList<>();
    private CollisionEngine collisionEngine= new CollisionEngine();
    private Painter painter;
    private Render render= new Render();
    private AsteroidFactory asteroidFactory=new AsteroidFactory();
    private Map map= new Map();
    private HashMap<String,PImage> images= new HashMap();
    private float width=1000;
    private float height=500;
    private int amountOfAsteroids=10;
    private PImage bg;
    private Random random=new Random();



    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {

        windowsSettings.setSize((int)width, (int) height).enableHighPixelDensity();


        Player player1 = new Player("Mark");

        Vector2 center= new Vector2(width/2,height/2);
        Vector2 up= new Vector2(0,-1);


        //asteroids
//        for (int i = 0; i < amountOfAsteroids; i++) {
//            map.addAsteroid(asteroidFactory.newAsteroid(width,height));
//        }

        //player1
        Spaceship spaceship= new Spaceship(up,center,100.0);
        PlayerSpaceship playerSpaceship1=new PlayerSpaceship(player1,spaceship);
        map.addEntity(spaceship);
        map.addPlayer(playerSpaceship1);
        //player 1 keys
        HashMap<Integer, Function> player1Keys= new HashMap<>();
        player1Keys.put(PConstants.UP,new MoveForward());
        player1Keys.put(PConstants.DOWN,new MoveBack());
        player1Keys.put(PConstants.RIGHT,new MoveRight());
        player1Keys.put(PConstants.LEFT,new MoveLeft());

        playerControlerList.add(new PlayerControler(player1Keys,playerSpaceship1));

        //images
        PImage spaceshipImage= imageLoader.load("/Users/marcoskhabie/projects/starships/src/main/java/edu/austral/starship/base/util/images/heroship.png");
        PImage asteroidImage= imageLoader.load("/Users/marcoskhabie/projects/starships/src/main/java/edu/austral/starship/base/util/images/Asteroid-PNG-Transparent.png");

//        bg=imageLoader.load("/Users/marcoskhabie/projects/starships/src/main/java/edu/austral/starship/base/util/images/photo-1528484701073-2b22dc76649e.jpeg");
        bg=imageLoader.load("/Users/marcoskhabie/projects/starships/src/main/java/edu/austral/starship/base/util/images/Galaxy-Background-4-768x432.jpg");
        bg.resize((int)width, (int) height);
        System.out.println(bg.pixelDensity);

        images.put("spaceship",spaceshipImage);
        images.put("asteroid", asteroidImage);

    }

    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {
        List<Entity> entitiesToRemove=new ArrayList<>();

        graphics.background(bg);
        graphics.imageMode(PConstants.CENTER);

        for (Integer key : keySet) {

            for (PlayerControler pc:playerControlerList) {
                pc.onPressedKey(key);
            }
        }

        if (map.getAmountOfAsteroids()<20){
            map.addAsteroid(asteroidFactory.newAsteroid(width,height));
        }

        render.paint(map.getEntities(),graphics,images);


        for (Entity entity :map.getEntities()) {
            if (entity.isOutOfBounds(width,height)){
                entitiesToRemove.add(entity);
            }
                entity.advance();
        }

        for (Entity e : entitiesToRemove) {
            e.accepts(map);
        }


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
