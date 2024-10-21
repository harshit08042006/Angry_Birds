package io.github.AngryBird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class YellowBird extends Bird {
    Texture img=new Texture("yellowBird.png");
    public YellowBird(int x, int y) {
        super(x, y);
    }
    public void draw(SpriteBatch batch, int x, int y, int sizeX, int sizeY) {
        batch.draw(img,x,y,sizeX,sizeY);
    }
}
