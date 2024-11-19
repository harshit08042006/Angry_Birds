package io.github.AngryBird;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

public class YellowBird extends Bird {
    public YellowBird(World world, float x, float y) {
        super(world, x,  y, 2, 1.5f, "yellowBird.png") ;
    }

    public void boost(){
        if (launched){
            velocity.scl(1.5f);
        }
    }

}
