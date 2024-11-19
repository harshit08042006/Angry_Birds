package io.github.AngryBird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GreyBlock extends Block{
    Texture img=new Texture("greyBlock.png");
    public GreyBlock(int x, int y, int durability){
        super(x,y,durability);
    }
    public void draw(SpriteBatch batch, float x, float y, float sizeX, float sizeY) {
        if(!isCollapsed()) {
            batch.draw(img, x, y, sizeX, sizeY);
        }
    }
}
