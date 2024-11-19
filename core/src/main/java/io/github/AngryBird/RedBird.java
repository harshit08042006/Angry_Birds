package io.github.AngryBird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class RedBird extends Bird {
    private Texture red_texture = new Texture("redBird.png");
    public RedBird(World world, float x, float y) {
        super(world, x,  y, 1, 1, "redBird.png") ;
    }

    public void draw(SpriteBatch batch, float x, float y, float sizeX, float sizeY) {
            batch.draw(red_texture, x, y, sizeX, sizeY);
        }
        public Texture getTexture(){
        return red_texture;
    }
}

