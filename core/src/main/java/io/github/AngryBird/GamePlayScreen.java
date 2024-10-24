package io.github.AngryBird;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GamePlayScreen implements Screen {
    private Texture background;
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
    private Main angryBird;
    private SpriteBatch batch;
    private FitViewport viewport;
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
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
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
