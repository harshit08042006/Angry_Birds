package io.github.AngryBird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class RedBird extends Bird {
    private Texture red_texture = new Texture("redBird.png");
    public RedBird(float x, float y) {
        super(x,  y, 1, 1, "redBird.png") ;
    }
    public Texture getTexture(){
        return red_texture;
    }
}

