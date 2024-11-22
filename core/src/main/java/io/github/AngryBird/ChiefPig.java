package io.github.AngryBird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

public class ChiefPig extends BasePig{
    Texture img=new Texture("chiefPig.png");
    public ChiefPig(World world, int health, int x, int y) {
        super(world, health, x, y);
    }
    public void draw(SpriteBatch batch, float x, float y, float sizeX, float sizeY) {
        if(!isDead()) {
            batch.draw(img, x, y, sizeX, sizeY);
        }
    }
}
