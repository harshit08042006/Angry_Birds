package io.github.AngryBird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
public class ChiefPig extends BasePig{
    Texture img=new Texture("chiefPig.png");
    public ChiefPig(int health, int x, int y) {
        super(health, x, y);
    }
    public void draw(SpriteBatch batch, float x, float y, float sizeX, float sizeY) {
        if(!isDead()) {
            batch.draw(img, x, y, sizeX, sizeY);
        }
    }
}
