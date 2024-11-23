package io.github.AngryBird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

public class Pig extends BasePig{
    Texture img=new Texture("pig.png");

    public Pig(World world, int health, float x, float y) {
        super(world, health, x, y);
    }
    public void draw(SpriteBatch batch, float x, float y, float sizeX, float sizeY) {
        if(!isDead()) {
            batch.draw(img, x, y, sizeX, sizeY);
        }
    }
}

