package io.github.AngryBird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import static com.badlogic.gdx.graphics.g3d.particles.ParticleChannels.Color;

/** First screen of the application. Displayed after the application is created. */
public class FirstScreen implements Screen {
    private Texture backGround;
    private Texture playButton;
    private Texture exitButton;
    private Main angryBird;
    private FitViewport viewport;
    private SpriteBatch batch;
    private Vector2 touchPosition;
    private static final float PLAY_BUTTON_WIDTH=2;
    private static final float EXIT_BUTTON_WIDTH=2;
    private static final float PLAY_BUTTON_HEIGHT=1;
    private static final float EXIT_BUTTON_HEIGHT=1;
    private static final float PLAY_BUTTON_X_COORDINATE=5;
    private static final float EXIT_BUTTON_X_COORDINATE=1;
    private static final float PLAY_BUTTON_Y_COORDINATE=0.5f;
    private static final float EXIT_BUTTON_Y_COORDINATE=0.5f;
    public FirstScreen(Main angryBird) {
        this.angryBird=angryBird;
        batch=new SpriteBatch();
        viewport=new FitViewport(16, 9);
        touchPosition=new Vector2();
        backGround=new Texture("angryBirdBackground.png");
        playButton=new Texture("playButton.png");
        exitButton=new Texture("exitButton.png");
    }
    @Override
    public void show() {
        // Prepare your screen here.
    }

    @Override
    public void render(float delta) {
        // Draw your screen here. "delta" is the time since last render in seconds.
        touchPosition.set(Gdx.input.getX(), Gdx.input.getY());
        viewport.unproject(touchPosition);
        if(touchPosition.x>EXIT_BUTTON_X_COORDINATE&&touchPosition.x<EXIT_BUTTON_X_COORDINATE+EXIT_BUTTON_WIDTH&&touchPosition.y>EXIT_BUTTON_Y_COORDINATE&&touchPosition.y<EXIT_BUTTON_Y_COORDINATE+EXIT_BUTTON_HEIGHT)
        {
            if(Gdx.input.justTouched()) {
                Gdx.app.exit();
            }
        }
        if(touchPosition.x>PLAY_BUTTON_X_COORDINATE&&touchPosition.x<PLAY_BUTTON_X_COORDINATE+PLAY_BUTTON_WIDTH&&touchPosition.y>PLAY_BUTTON_Y_COORDINATE&&touchPosition.y<PLAY_BUTTON_Y_COORDINATE+PLAY_BUTTON_HEIGHT){
            if(Gdx.input.justTouched()) {
                angryBird.setScreen(new New_Load_GameScreen(angryBird));
                //angryBird.setScreen();
            }
        }
        ScreenUtils.clear(com.badlogic.gdx.graphics.Color.BLACK);
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        batch.draw(backGround, 0, 0, viewport.getWorldWidth(), viewport.getWorldHeight());
        batch.draw(playButton, PLAY_BUTTON_X_COORDINATE, PLAY_BUTTON_Y_COORDINATE, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
        batch.draw(exitButton, EXIT_BUTTON_X_COORDINATE, EXIT_BUTTON_Y_COORDINATE, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        // Resize your screen here. The parameters represent the new window size.
        viewport.update(width, height, true);
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
    }
}
