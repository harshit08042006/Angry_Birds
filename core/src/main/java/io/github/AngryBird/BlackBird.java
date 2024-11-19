package io.github.AngryBird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BlackBird extends Bird {
    public BlackBird(float x, float y) {
        super(x,  y, 3, 0.8f, "blackBird.png") ;
    }

    public void boost(){
        if (launched){
            velocity.scl(1.5f);
        }
    }
}


