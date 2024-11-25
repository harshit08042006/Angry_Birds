package io.github.AngryBird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

public class BlueBlock extends Block{
    Texture img=new Texture("blueBlock.png");
    public BlueBlock(World world, float x, float y, int durability){
        super(world, x,y,durability);
    }
    public void draw(SpriteBatch batch, float x, float y, float sizeX, float sizeY) {
        if(!isCollapsed()) {
            batch.draw(img, x, y, sizeX, sizeY);
        }
    }
}
