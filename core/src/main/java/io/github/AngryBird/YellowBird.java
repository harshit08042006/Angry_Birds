package io.github.AngryBird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class YellowBird extends Bird {
    public YellowBird(float x, float y) {
        super(x,  y, 2, 1.5f, "yellowBird.png") ;
    }

    public void boost(){
        if (launched){
            velocity.scl(1.5f);
        }
    }
}
