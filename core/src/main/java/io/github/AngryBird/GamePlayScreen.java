package io.github.AngryBird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GamePlayScreen implements Screen {
    private Texture background;
    private Texture pause_button;
    private RedBird redBird;
    private BlackBird blackBird;
    private YellowBird yellowBird;
    private Catapult catapult;
    private Pig pig;
    private ChiefPig chiefPig;
    private KingPig kingPig;
    private BlueBlock blueBlock;
    private BrownBlock brownBlock;
    private GreyBlock greyBlock;
    private Texture redDummy;
    private Texture greenDummy;
    private Main angryBird;
    private SpriteBatch batch;
    private FitViewport viewport;
    private final Vector2 touchPosition;
    public GamePlayScreen(Main angryBird) {
        this.angryBird=angryBird;
        batch = new SpriteBatch();
        viewport=new FitViewport(16, 9);
        background = new Texture("angryBirdGameBackground1.jpg");
        redBird = new RedBird(0, 0);
        blackBird = new BlackBird(0, 0);
        yellowBird = new YellowBird(0, 0);
        catapult = new Catapult();
        pig = new Pig(0, 0);
        chiefPig = new ChiefPig(0, 0);
        kingPig = new KingPig(0, 0);
        blueBlock = new BlueBlock();
        brownBlock = new BrownBlock();
        greyBlock = new GreyBlock();
        redDummy=new Texture("redDummy.png");
        greenDummy=new Texture("greenDummy.png");
        pause_button = new Texture("pause_button_blue.png");
        touchPosition = new Vector2();
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        touchPosition.set(Gdx.input.getX(), Gdx.input.getY());
        viewport.unproject(touchPosition);
        //Logic for dummy buttons
        if(touchPosition.x>13.8f&&touchPosition.x<14.8f&&touchPosition.y>0.1f&&touchPosition.y<1.1f){
            if(Gdx.input.isTouched()){
                angryBird.setScreen(new LoseScreen(angryBird));
            }
        }
        if(touchPosition.x>14.9f&&touchPosition.x<15.9f&&touchPosition.y>0.1f&&touchPosition.y<1.1f){
            if(Gdx.input.isTouched()){
                angryBird.setScreen(new WinScreen(angryBird));
            }
        }

        if(touchPosition.x>0.2f&&touchPosition.x<2.2f&&touchPosition.y>7&&touchPosition.y<9){
            if(Gdx.input.justTouched()) {
                angryBird.setScreen(new PauseScreen(angryBird));
            }
        }
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        batch.draw(background, 0, 0, viewport.getWorldWidth(), viewport.getWorldHeight());
        catapult.draw(batch, 2, 2, 1.5f, 2);
        redBird.draw(batch, 2.25f, 3.2f, 1, 1);
        yellowBird.draw(batch, 1, 2, 1, 1);
        blackBird.draw(batch, 0.1f, 2, 1, 1);
        brownBlock.draw(batch, 10, 2, 1, 1);
        greyBlock.draw(batch, 10, 3, 1, 1);
        blueBlock.draw(batch, 10, 4, 1, 1);
        kingPig.draw(batch, 10, 4.9f, 1, 1);
        brownBlock.draw(batch, 12, 2, 1, 1);
        blueBlock.draw(batch, 12, 3, 1, 1);
        blueBlock.draw(batch, 12, 4, 1, 1);
        blueBlock.draw(batch, 12, 5, 1, 1);
        chiefPig.draw(batch, 12, 5.9f, 1, 1);
        greyBlock.draw(batch, 14, 2, 1, 1);
        brownBlock.draw(batch, 14, 3, 1, 1);
        pig.draw(batch, 14, 3.9f, 1, 1);
        batch.draw(pause_button, 0.2f, 7, 2, 2);
        batch.draw(redDummy, 13.8f, 0.1f, 1, 1);
        batch.draw(greenDummy, 14.9f, 0.1f, 1, 1);
        batch.end();

    }

    @Override
    public void resize(int i, int i1) {
        viewport.update( i, i1, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
