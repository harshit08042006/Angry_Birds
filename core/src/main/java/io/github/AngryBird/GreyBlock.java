package io.github.AngryBird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

public class GreyBlock extends Block{
    Texture img=new Texture("greyBlock.png");
    public GreyBlock(World world, float x, float y, int durability){
        super(world, x,y,durability);
        this.BlockType = "GreyBlock";
    }
    public void draw(SpriteBatch batch, float x, float y, float sizeX, float sizeY) {
        if(!isCollapsed()) {
            batch.draw(img, x, y, sizeX, sizeY);
        }
    }
}
