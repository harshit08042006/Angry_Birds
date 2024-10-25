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

public class New_Load_GameScreen implements Screen {
    private final Main angryBird;
    private final Texture Background;
    private final Texture New_Game_Button;
    private final Texture Load_Game_Button;
    private final Texture Exit_Game_Button;
    private FitViewport viewport;
    private final SpriteBatch batch;
    private final Vector2 touchPosition;

    private static final float NEW_GAME_BUTTON_WIDTH=4.5f;
    private static final float LOAD_GAME_BUTTON_WIDTH=4.5f;
    private static final float EXIT_GAME_BUTTON_WIDTH=4.7f;
    private static final float NEW_GAME_BUTTON_HEIGHT=2;
    private static final float LOAD_GAME_BUTTON_HEIGHT=2;
    private static final float EXIT_GAME_BUTTON_HEIGHT = 2.8f;
    private static final float NEW_GAME_BUTTON_xCOORDINATE = 5.8f;
    private static final float LOAD_GAME_BUTTON_xCOORDINATE = 5.8f;
    private static final float EXIT_GAME_BUTTON_xCOORDINATE = 5.7f;
    private static final float NEW_GAME_BUTTON_yCOORDINATE = 4;
    private static final float LOAD_GAME_BUTTON_yCOORDINATE = 2.5f;
    private static final float EXIT_GAME_BUTTON_yCOORDINATE = 1;

    public New_Load_GameScreen(Main angryBird) {
        this.angryBird=angryBird;
        batch=new SpriteBatch();
        viewport=new FitViewport(16, 9);
        touchPosition=new Vector2();
        Background=new Texture("pause_background.jpg");
        New_Game_Button=new Texture("playgameblue (1).png");
        Load_Game_Button=new Texture("loadgameblue (1).png");
        Exit_Game_Button = new Texture("exitNew_blue (1).png");
    }
    @Override
    public void show(){
    }

    @Override
    public void render(float delta){
        touchPosition.set(Gdx.input.getX(), Gdx.input.getY());
        viewport.unproject(touchPosition);

        if(touchPosition.x>NEW_GAME_BUTTON_xCOORDINATE&&touchPosition.x<NEW_GAME_BUTTON_xCOORDINATE+NEW_GAME_BUTTON_WIDTH&&touchPosition.y>NEW_GAME_BUTTON_yCOORDINATE&&touchPosition.y<NEW_GAME_BUTTON_yCOORDINATE+NEW_GAME_BUTTON_HEIGHT){
            if(Gdx.input.justTouched()) {
                angryBird.setScreen(new LevelScreen(angryBird));
            }
        }

        if(touchPosition.x>LOAD_GAME_BUTTON_yCOORDINATE &&touchPosition.x<LOAD_GAME_BUTTON_xCOORDINATE+LOAD_GAME_BUTTON_WIDTH&&touchPosition.y>LOAD_GAME_BUTTON_yCOORDINATE&&touchPosition.y<LOAD_GAME_BUTTON_yCOORDINATE+LOAD_GAME_BUTTON_HEIGHT){
            if(Gdx.input.justTouched()) {
                this.dispose();
            }
        }
        if(touchPosition.x>EXIT_GAME_BUTTON_xCOORDINATE &&touchPosition.x<EXIT_GAME_BUTTON_xCOORDINATE+EXIT_GAME_BUTTON_WIDTH&&touchPosition.y>EXIT_GAME_BUTTON_yCOORDINATE&&touchPosition.y<EXIT_GAME_BUTTON_yCOORDINATE+EXIT_GAME_BUTTON_HEIGHT){
            if(Gdx.input.justTouched()) {
                Gdx.app.exit();
            }
        }



        ScreenUtils.clear(com.badlogic.gdx.graphics.Color.BLACK);
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        batch.draw(Background, 0, 0, viewport.getWorldWidth(), viewport.getWorldHeight());
        batch.draw(New_Game_Button, NEW_GAME_BUTTON_xCOORDINATE, NEW_GAME_BUTTON_yCOORDINATE, NEW_GAME_BUTTON_WIDTH, NEW_GAME_BUTTON_HEIGHT);
        batch.draw(Load_Game_Button, LOAD_GAME_BUTTON_xCOORDINATE, LOAD_GAME_BUTTON_yCOORDINATE, LOAD_GAME_BUTTON_WIDTH, LOAD_GAME_BUTTON_HEIGHT);
        batch.draw(Exit_Game_Button, EXIT_GAME_BUTTON_xCOORDINATE, EXIT_GAME_BUTTON_yCOORDINATE, EXIT_GAME_BUTTON_WIDTH, EXIT_GAME_BUTTON_HEIGHT);
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



