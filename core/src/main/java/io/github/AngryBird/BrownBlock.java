package io.github.AngryBird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BrownBlock {
    Texture img=new Texture("brownBlock.png");
    public void draw(SpriteBatch batch, int x, int y, int sizeX, int sizeY) {
        batch.draw(img,x,y,sizeX,sizeY);
    }
}
