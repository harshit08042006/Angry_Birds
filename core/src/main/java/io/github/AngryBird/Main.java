package io.github.AngryBird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    //Hello

    @Override
    public void create() { setScreen(new FirstScreen(this));
    }
}
