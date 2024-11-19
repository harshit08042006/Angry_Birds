package io.github.AngryBird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

public class BlackBird extends Bird {
    public BlackBird(World world, float x, float y) {
        super(world, x,  y, 3, 0.8f, "blackBird.png") ;
    }

    public void boost(){
        if (launched){
            velocity.scl(1.5f);
        }
    }
}


