package io.github.AngryBird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GreyBlock extends Block{
    Texture img=new Texture("greyBlock.png");
    public void draw(SpriteBatch batch, float x, float y, float sizeX, float sizeY) {
        batch.draw(img,x,y,sizeX,sizeY);
    }
}
