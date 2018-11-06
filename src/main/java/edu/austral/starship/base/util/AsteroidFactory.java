package edu.austral.starship.base.util;

import edu.austral.starship.base.controlers.CustomGameFramework;
import edu.austral.starship.base.model.Asteroid;
import edu.austral.starship.base.vector.Vector2;

import java.util.Random;

public class AsteroidFactory {

    public  Asteroid newAsteroid(float width, float height){
        Random random= new Random();
        Vector2 direction;
        Vector2 position;
        int side= random.nextInt(4);
        float x;
        float y;
        float xd;
        float yd;
        //arriba
        if (side==0){
            x=random.nextInt((int) width);
            y=0;
            xd=random.nextInt(2)-1;
            yd=1;
        }
        //abajo
        else if(side==1){
            x=random.nextInt((int) width);
            y=height;
            xd=random.nextInt(2)-1;
            yd=-1;

        }
        //izquierda
        else if(side==2){
            x=0;
            y=random.nextInt((int) height);
            xd=1;
            yd=random.nextInt(2)-1;
        }
        //derecha
        else {
            x=width;
            y=random.nextInt((int) height);
            xd=-1;
            yd=random.nextInt(2)-1;
        }

        position= new Vector2(x,y);
        direction=new Vector2(xd,yd).unitary();
        return new Asteroid(direction,position,500);
    }
}
