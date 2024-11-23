package io.github.AngryBird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

public class BlackBird extends Bird {
    private Texture black_texture = new Texture("blackBird.png");
    public BlackBird(World world, float x, float y) {
        super(world, x,  y, 3, 0.8f, "blackBird.png") ;
    }
    public void draw(SpriteBatch batch, float x, float y, float sizeX, float sizeY) {
        batch.draw(black_texture, x, y, sizeX, sizeY);
    }
    public void boost(){
        if (launched){
            velocity.scl(1.5f);
        }
    }
}


