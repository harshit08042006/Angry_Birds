package io.github.AngryBird;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

public class YellowBird extends Bird {
    private Texture yellow_texture = new Texture("yellowBird.png");
    public YellowBird(World world, float x, float y) {
        super(world, x,  y, 2, 1.5f, "yellowBird.png") ;
    }

    public void boost(){
        if (launched){
            velocity.scl(1.5f);
        }
    }
    public void draw(SpriteBatch batch, float x, float y, float sizeX, float sizeY) {
        batch.draw(yellow_texture, x, y, sizeX, sizeY);
    }

}
