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

import static com.badlogic.gdx.graphics.g3d.particles.ParticleChannels.Color;

public class Save_Exit_Screen implements Screen {
    private Main angryBird;
    private Texture Background;
    private Texture Save_Button;
    private Texture Exit_Button;
    private Texture Home_Button;
    private FitViewport viewport;
    private SpriteBatch batch;
    private Vector2 touchPosition;

    private static final float SAVE_BUTTON_WIDTH=1;
    private static final float EXIT_BUTTON_WIDTH=1;
    private static final float HOME_BUTTON_WIDTH=1;
    private static final float SAVE_BUTTON_HEIGHT=1;
    private static final float EXIT_BUTTON_HEIGHT=1;
    private static final float HOME_BUTTON_HEIGHT = 1;
    private static final float SAVE_BUTTON_xCOORDINATE = 1;
    private static final float EXIT_BUTTON_xCOORDINATE = 3;
    private static final float HOME_BUTTON_xCOORDINATE = 5;
    private static final float SAVE_BUTTON_yCOORDINATE = 1;
    private static final float EXIT_BUTTON_yCOORDINATE = 1;
    private static final float HOME_BUTTON_yCOORDINATE = 1;

    public Save_Exit_Screen(Main angryBird) {
        this.angryBird=angryBird;
        viewport = new FitViewport(800, 600, new OrthographicCamera());
        batch=new SpriteBatch();
        viewport=new FitViewport(8, 5);
        touchPosition=new Vector2();
        Background=new Texture("level_Screen_Background.jpg");
        Save_Button=new Texture("save_button.jpg");
        Exit_Button=new Texture("exit_button.jpg");
        Home_Button = new Texture("home_button.jpg");
    }
    @Override
    public void show(){
    }

    @Override
    public void render(float delta){
        touchPosition.set(Gdx.input.getX(), Gdx.input.getY());
        viewport.unproject(touchPosition);

        if(touchPosition.x>SAVE_BUTTON_xCOORDINATE&&touchPosition.x<SAVE_BUTTON_xCOORDINATE+SAVE_BUTTON_WIDTH&&touchPosition.y>SAVE_BUTTON_yCOORDINATE&&touchPosition.y<SAVE_BUTTON_yCOORDINATE+SAVE_BUTTON_HEIGHT){
            if(Gdx.input.justTouched()) {
                this.dispose();
            }
        }


        if(touchPosition.x>EXIT_BUTTON_xCOORDINATE &&touchPosition.x<EXIT_BUTTON_xCOORDINATE+EXIT_BUTTON_WIDTH&&touchPosition.y>EXIT_BUTTON_yCOORDINATE&&touchPosition.y<EXIT_BUTTON_yCOORDINATE+EXIT_BUTTON_HEIGHT){
            if(Gdx.input.justTouched()) {
                Gdx.app.exit();
            }
        }

        if(touchPosition.x>HOME_BUTTON_xCOORDINATE &&touchPosition.x<HOME_BUTTON_xCOORDINATE+HOME_BUTTON_WIDTH&&touchPosition.y>HOME_BUTTON_yCOORDINATE&&touchPosition.y<HOME_BUTTON_yCOORDINATE+HOME_BUTTON_HEIGHT){
            if(Gdx.input.justTouched()) {
                this.dispose();
            }
        }

        ScreenUtils.clear(com.badlogic.gdx.graphics.Color.BLACK);
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        batch.draw(Background, 0, 0, viewport.getWorldWidth(), viewport.getWorldHeight());
        batch.draw(Save_Button, SAVE_BUTTON_xCOORDINATE, SAVE_BUTTON_yCOORDINATE, SAVE_BUTTON_WIDTH, SAVE_BUTTON_HEIGHT);
        batch.draw(Exit_Button, EXIT_BUTTON_xCOORDINATE, EXIT_BUTTON_yCOORDINATE, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
        batch.draw(Home_Button, HOME_BUTTON_xCOORDINATE, HOME_BUTTON_yCOORDINATE, HOME_BUTTON_WIDTH, HOME_BUTTON_HEIGHT);
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


