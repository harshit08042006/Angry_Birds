package io.github.AngryBird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class GamePlayScreen implements Screen {
    private boolean isBirdDragged;
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
    private Vector2 catapultposition;
    private final Vector2 touchPosition;
    private float launchMultiplier;
    private World world;
    private Box2DDebugRenderer debugRenderer;
//    void createRedBirdBody()
//    {
//        BodyDef bodyDef = new BodyDef();
//        bodyDef.type = BodyDef.BodyType.StaticBody;
//        bodyDef.position.set(2.7f, 3.5f);
//        redBirdBody = world.createBody(bodyDef);
//        CircleShape circleShape = new CircleShape();
//        circleShape.setRadius(0.5f);
//        FixtureDef fixtureDef = new FixtureDef();
//        fixtureDef.shape = circleShape;
//        fixtureDef.density = 1f;
//        fixtureDef.friction = 0f;
//        fixtureDef.restitution = 0.5f;
//        Fixture fixture = redBirdBody.createFixture(fixtureDef);
//        circleShape.dispose();
//    }

    public GamePlayScreen(Main angryBird) {
        world=new World(new Vector2(0, -9.8f), true);
        debugRenderer = new Box2DDebugRenderer();
        this.angryBird=angryBird;
        batch = new SpriteBatch();
        viewport=new FitViewport(16, 9);
        background = new Texture("angryBirdGameBackground1.jpg");
        redBird = new RedBird(world, 2.7f, 3.5f);
//        blackBird = new BlackBird(0, 0);
//        yellowBird = new YellowBird(0, 0);
        catapult = new Catapult();
        pig = new Pig(0, 0, 0);
        chiefPig = new ChiefPig(0, 0, 0);
        kingPig = new KingPig(0, 0, 0);
        blueBlock = new BlueBlock(0, 0, 0);
        brownBlock = new BrownBlock(0 ,0, 0);
        greyBlock = new GreyBlock(0, 0, 0);
        redDummy=new Texture("redDummy.png");
        greenDummy=new Texture("greenDummy.png");
        pause_button = new Texture("pause_button_blue.png");
        touchPosition = new Vector2();
        catapultposition = new Vector2(2, 2);
        launchMultiplier = 5.0f;
//        createRedBirdBody();

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        touchPosition.set(Gdx.input.getX(), Gdx.input.getY());
        viewport.unproject(touchPosition);

        if(touchPosition.x>2.7f&&touchPosition.x<3.7f&&touchPosition.y>3.5f&&touchPosition.y<4.5f){
            if(Gdx.input.isTouched()){
                redBird.launch();
            }
        }
        if(Gdx.input.isTouched() && isBirdDragged){
            redBird.setPosition(touchPosition.x, touchPosition.y);
        }
        if(!Gdx.input.isTouched() && isBirdDragged){
            Vector2 launchVelocity = new Vector2(catapultposition).sub(redBird.getPosition()).scl(launchMultiplier);
            Bird.launch(launchVelocity);
            isBirdDragged = false;
        }
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
        Vector2 redBirdPosition=redBird.getPosition();

        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        batch.draw(background, 0, 0, viewport.getWorldWidth(), viewport.getWorldHeight());
        catapult.draw(batch, 2, 2, 1.5f, 2);
        redBird.draw(batch, redBird.getBody().getPosition().x-0.5f, redBird.getBody().getPosition().y-0.5f, 1, 1);

//        redBird.draw(batch, redBird.getTexture());
//        yellowBird.draw(batch, 1, 2, 1, 1);
//        blackBird.draw(batch, 0.1f, 2, 1, 1);
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
        world.step(1/60f, 6, 2);
        debugRenderer.render(world, viewport.getCamera().combined);


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
