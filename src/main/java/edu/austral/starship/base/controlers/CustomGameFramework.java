package edu.austral.starship.base.controlers;

import com.sun.deploy.security.ValidationState;
import edu.austral.starship.base.collision.CollisionEngine;
import edu.austral.starship.base.framework.GameFramework;
import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.base.framework.WindowSettings;
import edu.austral.starship.base.model.*;
import edu.austral.starship.base.util.*;
import edu.austral.starship.base.vector.Vector2;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.event.KeyEvent;

import java.util.*;

import static edu.austral.starship.base.util.Type.TYPE0;
import static edu.austral.starship.base.util.Type.TYPE1;

public class CustomGameFramework implements GameFramework {
    private int x=0;
    private int y=0;
    private int number=0;
    private List<PlayerControler> playerControlerList=new ArrayList<>();
    private CollisionEngine<RenderResult> collisionEngine= new CollisionEngine<>();
    private Painter painter;
    private Render render;
    private AsteroidFactory asteroidFactory=new AsteroidFactory();
    public static Map map= new Map();
    private HashMap<String,PImage> images= new HashMap();
    private float width=1000;
    private float height=500;
    private int amountOfAsteroids=10;
    private PImage bg;
    private Random random=new Random();
    private List<Entity> entities=new ArrayList<>();



    int counter=0;
    int blinkingCounter=0;

    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {

        windowsSettings.setSize((int)width, (int) height);
//        windowsSettings.setSize((int)width, (int) height).enableHighPixelDensity();



        Vector2 center= new Vector2(width/2,height/2);
        Vector2 up= new Vector2(0,-1);


        //asteroids
//        for (int i = 0; i < amountOfAsteroids; i++) {
//            map.addAsteroid(asteroidFactory.newAsteroid(width,height));
//        }

        //player1
        Player player1 = new Player("MOMI", TYPE0);
        List<Gun> guns1= new ArrayList<>();
        guns1.add(new SimpleGun());
        guns1.add(new MissileGun());
        Spaceship spaceship1= new Spaceship(up,center,100.0,guns1);
        PlayerSpaceship playerSpaceship1=new PlayerSpaceship(player1,spaceship1);
        map.addEntity(spaceship1);
        map.addPlayer(playerSpaceship1);
        //player 1 keys
        HashMap<Integer, Function> player1Keys= new HashMap<>();
        player1Keys.put(PConstants.UP,new MoveForward());
        player1Keys.put(PConstants.DOWN,new MoveBack());
        player1Keys.put(PConstants.RIGHT,new MoveRight());
        player1Keys.put(PConstants.LEFT,new MoveLeft());
        player1Keys.put(java.awt.event.KeyEvent.VK_SPACE,new Fire());
        player1Keys.put(java.awt.event.KeyEvent.VK_ALT,new ChangeSelectedGun());

        playerControlerList.add(new PlayerControler(player1Keys,playerSpaceship1));

        //player2
        Player player2 = new Player("JOACO", TYPE1);
        List<Gun> guns2= new ArrayList<>();
        guns2.add(new SimpleGun());
        guns2.add(new MissileGun());
        Spaceship spaceship2= new Spaceship(up,center,100.0,guns2);
        PlayerSpaceship playerSpaceship2=new PlayerSpaceship(player2,spaceship2);
        map.addEntity(spaceship2);
        map.addPlayer(playerSpaceship2);
        //player 2 keys
        HashMap<Integer, Function> player2Keys= new HashMap<>();
        player2Keys.put(java.awt.event.KeyEvent.VK_W,new MoveForward());
        player2Keys.put(java.awt.event.KeyEvent.VK_S,new MoveBack());
        player2Keys.put(java.awt.event.KeyEvent.VK_D,new MoveRight());
        player2Keys.put(java.awt.event.KeyEvent.VK_A,new MoveLeft());
        player2Keys.put(java.awt.event.KeyEvent.VK_SHIFT,new Fire());
        player2Keys.put(java.awt.event.KeyEvent.VK_Q,new ChangeSelectedGun());
        playerControlerList.add(new PlayerControler(player2Keys,playerSpaceship2));

        //images
        PImage spaceshipImage1= imageLoader.load("edu/austral/starship/base/util/images/heroship.png");
        PImage spaceshipImage2= imageLoader.load("edu/austral/starship/base/util/images/heroship.png");
        PImage asteroidImage= imageLoader.load("edu/austral/starship/base/util/images/Asteroid-PNG-Transparent.png");
        PImage bulletImage1= imageLoader.load("edu/austral/starship/base/util/images/bullet1.png");
        PImage bulletImage2= imageLoader.load("edu/austral/starship/base/util/images/missile_PNG50.png");

        spaceshipImage2.filter(PConstants.INVERT);

        bg=imageLoader.load("/Users/marcoskhabie/projects/starships/src/main/java/edu/austral/starship/base/util/images/photo-1528484701073-2b22dc76649e.jpeg");
//        bg=imageLoader.load("/Users/marcoskhabie/projects/starships/src/main/java/edu/austral/starship/base/util/images/Galaxy-Background-4-768x432.jpg");
        bg.resize((int)width, (int) height);


        images.put("spaceship"+player1.getType(),spaceshipImage1);
        images.put("spaceship"+ player2.getType(),spaceshipImage2);
        images.put("asteroid", asteroidImage);
        images.put("bullet" + TYPE0, bulletImage1);
        images.put("bullet" + TYPE1, bulletImage2);

        render=new Render(images);
        painter=new Painter();

    }

    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {
        List<Entity> entitiesToRemove=new ArrayList<>();

        graphics.background(bg);
        graphics.imageMode(PConstants.CENTER);
//graphics.background(255);
        for (Integer key : keySet) {

            for (PlayerControler pc:playerControlerList) {
                pc.onPressedKey(key);
            }
        }

        if (map.getAmountOfAsteroids()<10){
            map.addAsteroid(asteroidFactory.newAsteroid(width,height));
        }


        entities = map.getEntities();

        for (Entity entity : entities) {
            if (entity.isOutOfBounds(width,height)||(entity.getHealth()<=0.0)){
                entitiesToRemove.add(entity);
            }
                entity.advance();
        }

        for (Entity e : entitiesToRemove) {
            e.accepts(map);
        }




        if (counter<30){
            for (Entity e : map.getEntitiesToBlink()) {
                entities.remove(e);
            }
        }
        else if (counter<=60){
            for (Entity e : map.getEntitiesToBlink()) {
                if (!entities.contains(e)){
                    entities.add(e);
                }
            }
            if (counter==60){
                counter=0;
                blinkingCounter++;
            }
        }

//        render.paint(map.getEntities(),graphics,images);

        List <RenderResult> renderResults=render.render(entities);

        painter.paint(renderResults,graphics);

        collisionEngine.checkCollisions(renderResults);


        if (blinkingCounter==4){
            for (Entity e : map.getEntitiesToBlink()) {
                e.setHealth(100);
                e.setDead(false);
                if (!entities.contains(e)){
                    entities.add(e);
                }
            }
            blinkingCounter=0;
            map.getEntitiesToBlink().clear();
        }
        counter++;
//        graphics.rect(x,y, 20,20);
//        graphics.rect(20,10,10,10);
//        graphics.text(number, 250, 100);
//        graphics.image(image, 0, 100,100,100);
    }

    @Override
    public void keyPressed(KeyEvent event) {

    }

    @Override
    public void keyReleased(KeyEvent event) {
        for (PlayerControler p:playerControlerList) {
            p.keyRleased(event.getKeyCode());

        }
    }


}
