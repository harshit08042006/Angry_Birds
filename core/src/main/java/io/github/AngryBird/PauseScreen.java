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


public class PauseScreen implements Screen{
    private final Main angryBird;
    private final Texture Background;
    private final Texture Save_Game_Button;
    private final Texture Resume_Game_Button;
    private final Texture Home_Game_Button;
    private FitViewport viewport;
    private final SpriteBatch batch;
    private final Vector2 touchPosition;

    private static final float RESUME_GAME_BUTTON_WIDTH=4.5f;
    private static final float SAVE_GAME_BUTTON_WIDTH=4.5f;
    private static final float HOME_GAME_BUTTON_WIDTH=4.5f;
    private static final float RESUME_GAME_BUTTON_HEIGHT=2;
    private static final float SAVE_GAME_BUTTON_HEIGHT=2;
    private static final float HOME_GAME_BUTTON_HEIGHT = 2;
    private static final float RESUME_GAME_BUTTON_xCOORDINATE = 5.8f;
    private static final float SAVE_GAME_BUTTON_xCOORDINATE = 5.8f;
    private static final float HOME_GAME_BUTTON_xCOORDINATE = 5.8f;
    private static final float RESUME_GAME_BUTTON_yCOORDINATE = 5;
    private static final float SAVE_GAME_BUTTON_yCOORDINATE = 3.5f;
    private static final float HOME_GAME_BUTTON_yCOORDINATE = 2;

    public PauseScreen(Main angryBird) {
        this.angryBird=angryBird;
        batch=new SpriteBatch();
        viewport=new FitViewport(16, 9);
        touchPosition=new Vector2();
        Background=new Texture("level_Screen_Background.jpg");
        Home_Game_Button=new Texture("home (1).png");
        Resume_Game_Button=new Texture("resume (1).png");
        Save_Game_Button = new Texture("save (1).png");
    }
    @Override
    public void show(){}
    @Override
    public void render(float delta){
        touchPosition.set(Gdx.input.getX(), Gdx.input.getY());
        viewport.unproject(touchPosition);

        if(touchPosition.x>RESUME_GAME_BUTTON_xCOORDINATE&&touchPosition.x<RESUME_GAME_BUTTON_xCOORDINATE+RESUME_GAME_BUTTON_WIDTH&&touchPosition.y>RESUME_GAME_BUTTON_yCOORDINATE&&touchPosition.y<RESUME_GAME_BUTTON_yCOORDINATE+RESUME_GAME_BUTTON_HEIGHT){
            if(Gdx.input.justTouched()) {
//                angryBird.setScreen(new GamePlayScreen(angryBird));
            }
        }

//        if(touchPosition.x>SAVE_GAME_BUTTON_yCOORDINATE &&touchPosition.x<SAVE_GAME_BUTTON_xCOORDINATE+SAVE_GAME_BUTTON_WIDTH&&touchPosition.y>SAVE_GAME_BUTTON_yCOORDINATE&&touchPosition.y<SAVE_GAME_BUTTON_yCOORDINATE+SAVE_GAME_BUTTON_HEIGHT){
//            if(Gdx.input.justTouched()) {
//                this.dispose();
//            }
//        }
        if(touchPosition.x>HOME_GAME_BUTTON_xCOORDINATE &&touchPosition.x<HOME_GAME_BUTTON_xCOORDINATE+HOME_GAME_BUTTON_WIDTH&&touchPosition.y>HOME_GAME_BUTTON_yCOORDINATE&&touchPosition.y<HOME_GAME_BUTTON_yCOORDINATE+HOME_GAME_BUTTON_HEIGHT){
            if(Gdx.input.justTouched()) {
                angryBird.setScreen(new New_Load_GameScreen(angryBird));
            }
        }



        ScreenUtils.clear(com.badlogic.gdx.graphics.Color.BLACK);
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        batch.draw(Background, 0, 0, viewport.getWorldWidth(), viewport.getWorldHeight());
        batch.draw(Resume_Game_Button, RESUME_GAME_BUTTON_xCOORDINATE, RESUME_GAME_BUTTON_yCOORDINATE, RESUME_GAME_BUTTON_WIDTH, RESUME_GAME_BUTTON_HEIGHT);
        batch.draw(Save_Game_Button, SAVE_GAME_BUTTON_xCOORDINATE, SAVE_GAME_BUTTON_yCOORDINATE, SAVE_GAME_BUTTON_WIDTH, SAVE_GAME_BUTTON_HEIGHT);
        batch.draw(Home_Game_Button, HOME_GAME_BUTTON_xCOORDINATE, HOME_GAME_BUTTON_yCOORDINATE, HOME_GAME_BUTTON_WIDTH, HOME_GAME_BUTTON_HEIGHT);
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
