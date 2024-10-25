package io.github.AngryBird;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class loadScreen implements Screen {
    private Main angryBird;
    private Texture Background;
    private Texture Game1_Button;
    private Texture Game2_Button;
    private Texture Game3_Button;
    private Texture SelectLevel_Button;
    private Texture backButton;
    private FitViewport viewport;
    private SpriteBatch batch;
    private Vector2 touchPosition;

    private static final float GAME1_BUTTON_WIDTH=4.5f;
    private static final float GAME2_BUTTON_WIDTH=4.5f;
    private static final float GAME3_BUTTON_WIDTH=4.5f;
    private static final float GAME1_BUTTON_HEIGHT=2;
    private static final float GAME2_BUTTON_HEIGHT=2;
    private static final float GAME3_BUTTON_HEIGHT=2;
    private static final float GAME1_BUTTON_xCOORDINATE = 5.8f;
    private static final float GAME2_BUTTON_xCOORDINATE = 5.8f;
    private static final float GAME3_BUTTON_xCOORDINATE = 5.8f;
    private static final float GAME1_BUTTON_yCOORDINATE = 4;
    private static final float GAME2_BUTTON_yCOORDINATE = 2.5f;
    private static final float GAME3_BUTTON_yCOORDINATE = 1;
    private static final float BACK_BUTTON_xCOORDINATE = 1;
    private static final float BACK_BUTTON_yCOORDINATE = 7.5f;

    public loadScreen(Main angryBird) {
        this.angryBird=angryBird;
        batch=new SpriteBatch();
        viewport=new FitViewport(16, 9);
        touchPosition=new Vector2();
        Background=new Texture("pause_background.jpg");
        Game1_Button=new Texture("game1_blue (1).png");
        Game2_Button=new Texture("game2_blue (1).png");
        Game3_Button=new Texture("game3_blue (1).png");
        backButton=new Texture("backButton1.png");
    }
    @Override
    public void show(){
    }

    @Override
    public void render(float delta){
        touchPosition.set(Gdx.input.getX(), Gdx.input.getY());
        viewport.unproject(touchPosition);

        if(touchPosition.x>GAME1_BUTTON_xCOORDINATE&&touchPosition.x<GAME1_BUTTON_xCOORDINATE+GAME1_BUTTON_WIDTH&&touchPosition.y>GAME1_BUTTON_yCOORDINATE&&touchPosition.y<GAME1_BUTTON_yCOORDINATE+GAME1_BUTTON_HEIGHT){
            if(Gdx.input.justTouched()) {
                angryBird.setScreen(new GamePlayScreen(angryBird));
            }
        }


        if(touchPosition.x>GAME2_BUTTON_xCOORDINATE&&touchPosition.x<GAME2_BUTTON_xCOORDINATE+GAME2_BUTTON_WIDTH&&touchPosition.y>GAME2_BUTTON_yCOORDINATE&&touchPosition.y<GAME2_BUTTON_yCOORDINATE+GAME3_BUTTON_HEIGHT){
            if(Gdx.input.justTouched()){
                angryBird.setScreen(new GamePlayScreen(angryBird));
            }
        }

        if(touchPosition.x>GAME3_BUTTON_xCOORDINATE&&touchPosition.x<GAME3_BUTTON_xCOORDINATE+GAME3_BUTTON_WIDTH&&touchPosition.y>GAME3_BUTTON_yCOORDINATE&&touchPosition.y<GAME3_BUTTON_yCOORDINATE+GAME3_BUTTON_HEIGHT){
            if(Gdx.input.justTouched()) {
                angryBird.setScreen(new GamePlayScreen(angryBird));
            }
        }
        if(touchPosition.x>BACK_BUTTON_xCOORDINATE&&touchPosition.x<BACK_BUTTON_xCOORDINATE+1&&touchPosition.y>BACK_BUTTON_yCOORDINATE&&touchPosition.y<BACK_BUTTON_yCOORDINATE+1)
        {
            if(Gdx.input.justTouched()) {
                angryBird.setScreen(new New_Load_GameScreen(angryBird));
            }
        }
        ScreenUtils.clear(com.badlogic.gdx.graphics.Color.BLACK);
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        batch.draw(Background, 0, 0, viewport.getWorldWidth(), viewport.getWorldHeight());
        batch.draw(Game1_Button, GAME1_BUTTON_xCOORDINATE, GAME1_BUTTON_yCOORDINATE, GAME1_BUTTON_WIDTH, GAME1_BUTTON_HEIGHT);
        batch.draw(Game2_Button, GAME2_BUTTON_xCOORDINATE, GAME2_BUTTON_yCOORDINATE, GAME2_BUTTON_WIDTH, GAME2_BUTTON_HEIGHT);
        batch.draw(Game3_Button, GAME3_BUTTON_xCOORDINATE, GAME3_BUTTON_yCOORDINATE, GAME3_BUTTON_WIDTH, GAME3_BUTTON_HEIGHT);
        batch.draw(backButton, BACK_BUTTON_xCOORDINATE, BACK_BUTTON_yCOORDINATE, 1, 1 );
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



