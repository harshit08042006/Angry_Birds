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

public class LevelScreen implements Screen {
    private Main angryBird;
    private Texture Background;
    private Texture Level1_Button;
    private Texture Level2_Button;
    private Texture Level3_Button;
    private FitViewport viewport;
    private SpriteBatch batch;
    private Vector2 touchPosition;

    private static final float LEVEL1_BUTTON_WIDTH=1;
    private static final float LEVEL2_BUTTON_WIDTH=1;
    private static final float LEVEL3_BUTTON_WIDTH=1;
    private static final float LEVEL1_BUTTON_HEIGHT=1;
    private static final float LEVEL2_BUTTON_HEIGHT=1;
    private static final float LEVEL3_BUTTON_HEIGHT=1;
    private static final float LEVEL1_BUTTON_xCOORDINATE = 1;
    private static final float LEVEL2_BUTTON_xCOORDINATE = 3;
    private static final float LEVEL3_BUTTON_xCOORDINATE = 5;
    private static final float LEVEL1_BUTTON_yCOORDINATE = 1;
    private static final float LEVEL2_BUTTON_yCOORDINATE = 1;
    private static final float LEVEL3_BUTTON_yCOORDINATE = 1;


    public LevelScreen(Main angryBird) {
        this.angryBird=angryBird;
        viewport = new FitViewport(800, 600, new OrthographicCamera());
        batch=new SpriteBatch();
        viewport=new FitViewport(8, 5);
        touchPosition=new Vector2();
        Background=new Texture("level_Screen_Background.jpg");
        Level1_Button=new Texture("level1_button.png");
        Level2_Button=new Texture("level2_button.png");
        Level3_Button=new Texture("level3_button.png");
    }
    @Override
    public void show(){
    }

    @Override
    public void render(float delta){
        touchPosition.set(Gdx.input.getX(), Gdx.input.getY());
        viewport.unproject(touchPosition);

        if(touchPosition.x>LEVEL1_BUTTON_xCOORDINATE&&touchPosition.x<LEVEL1_BUTTON_xCOORDINATE+LEVEL1_BUTTON_WIDTH&&touchPosition.y>LEVEL1_BUTTON_yCOORDINATE&&touchPosition.y<LEVEL1_BUTTON_yCOORDINATE+LEVEL1_BUTTON_HEIGHT){
           if(Gdx.input.justTouched()) {
               angryBird.setScreen(new LoseScreen(angryBird));
            }
        }


        if(touchPosition.x>LEVEL2_BUTTON_xCOORDINATE&&touchPosition.x<LEVEL2_BUTTON_xCOORDINATE+LEVEL2_BUTTON_WIDTH&&touchPosition.y>LEVEL2_BUTTON_yCOORDINATE&&touchPosition.y<LEVEL2_BUTTON_yCOORDINATE+LEVEL2_BUTTON_HEIGHT){
            if(Gdx.input.justTouched()) {
                angryBird.setScreen(new WinScreen(angryBird));
            }
        }

        if(touchPosition.x>LEVEL3_BUTTON_xCOORDINATE&&touchPosition.x<LEVEL3_BUTTON_xCOORDINATE+LEVEL3_BUTTON_WIDTH&&touchPosition.y>LEVEL3_BUTTON_yCOORDINATE&&touchPosition.y<LEVEL3_BUTTON_yCOORDINATE+LEVEL3_BUTTON_HEIGHT){
            if(Gdx.input.justTouched()) {
                this.dispose();
            }
        }
        ScreenUtils.clear(com.badlogic.gdx.graphics.Color.BLACK);
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        batch.draw(Background, 0, 0, viewport.getWorldWidth(), viewport.getWorldHeight());
        batch.draw(Level1_Button, LEVEL1_BUTTON_xCOORDINATE, LEVEL1_BUTTON_yCOORDINATE, LEVEL1_BUTTON_WIDTH, LEVEL1_BUTTON_HEIGHT);
        batch.draw(Level2_Button, LEVEL2_BUTTON_xCOORDINATE, LEVEL2_BUTTON_yCOORDINATE, LEVEL2_BUTTON_WIDTH, LEVEL2_BUTTON_HEIGHT);
        batch.draw(Level3_Button, LEVEL3_BUTTON_xCOORDINATE, LEVEL3_BUTTON_yCOORDINATE, LEVEL3_BUTTON_WIDTH, LEVEL3_BUTTON_HEIGHT);
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


