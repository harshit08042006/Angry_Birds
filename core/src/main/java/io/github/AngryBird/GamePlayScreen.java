package io.github.AngryBird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;

import java.util.ArrayList;


public class GamePlayScreen implements Screen {

    public static ArrayList<Body> bodiesToDestroy = new ArrayList<>();
    private Texture background;
    private Texture pause_button;
    private RedBird redBird;
    private BlackBird blackBird;
    private YellowBird yellowBird;
    private Catapult catapult;
    private Pig pig;
    private ChiefPig chiefPig;
    private KingPig kingPig;
    private BlueBlock blueBlock1;
    private BlueBlock blueBlock2;
    private BlueBlock blueBlock3;
    private BrownBlock brownBlock1;
    private BrownBlock brownBlock2;
    private BrownBlock brownBlock3;
    private GreyBlock greyBlock1;
    private GreyBlock greyBlock2;
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
    private Body groundBody;
    private ShapeRenderer shapeRenderer;
//    void createRedBirdBody()
//    {
//        BodyDef bodyDef = new BodyDef();
//        bodyDef.type = BodyDef.BodyType.StaticBody;
//        bodyDef.position.set(2.7f, 3.5f);
//        redBirdBody = world.createBody(bodyDef);
//        CircleShape circleShape = new CircleShape();
//        circleShape.setRadius(0.5f);
//        FixtureDef fixtureDef = new FixtureDef();6
//        fixtureDef.shape = circleShape;
//        fixtureDef.density = 1f;
//        fixtureDef.friction = 0f;
//        fixtureDef.restitution = 0.5f;
//        Fixture fixture = redBirdBody.createFixture(fixtureDef);
//        circleShape.dispose();
//    }
    public void createGroundBody()
    {
        BodyDef groundBodyDef = new BodyDef();
        groundBodyDef.position.set(new Vector2(8, 1));
        Body groundBody = world.createBody(groundBodyDef);
        PolygonShape groundBox = new PolygonShape();
        groundBox.setAsBox(8, 1);
        groundBody.createFixture(groundBox, 0.0f);
        groundBox.dispose();
    }

    public GamePlayScreen(Main angryBird) {
        world=new World(new Vector2(0, -9.8f), true);
        debugRenderer = new Box2DDebugRenderer();
        shapeRenderer = new ShapeRenderer();
        this.angryBird=angryBird;
        batch = new SpriteBatch();
        viewport=new FitViewport(16, 9);
        background = new Texture("angryBirdGameBackground1.jpg");
        redBird = new RedBird(world, 2.2f, 3.2f);
        blackBird = new BlackBird(world, 0.1f, 2);
        yellowBird = new YellowBird(world, 1, 2);
        catapult = new Catapult();
        pig = new Pig(world, 1, 14, 3.9f);
        chiefPig = new ChiefPig(world, 2, 12, 5.9f);
        kingPig = new KingPig(world, 3, 10, 4.9f);
        blueBlock1 = new BlueBlock(world, 12, 2, 1);
        blueBlock2 = new BlueBlock(world, 12, 3, 1);
        blueBlock3 = new BlueBlock(world, 12, 4, 1);
        brownBlock1 = new BrownBlock(world, 14, 3, 2);
        brownBlock2 = new BrownBlock(world, 10, 2, 2);
        brownBlock3 = new BrownBlock(world, 12, 2, 2);
        greyBlock1 = new GreyBlock(world, 14, 2, 3);
        greyBlock2 = new GreyBlock(world, 10, 3, 3);
        redDummy=new Texture("redDummy.png");
        greenDummy=new Texture("greenDummy.png");
        pause_button = new Texture("pause_button_blue.png");
        touchPosition = new Vector2();
        catapultposition = new Vector2(2, 2);
        createGroundBody();
        launchMultiplier = 5.0f;

//        world.setContactListener(new ContactListener(){
//            @Override
//            public void beginContact(Contact contact){
//                Fixture fixA = contact.getFixtureA();
//                Fixture fixB = contact.getFixtureB();
//
//                if(isBird(fixA) && isPig(fixB)){
//                    HandlePigHit((Pig) fixB.getBody().getUserData());
//                    bodiesToDestroy.add(fixB.getBody());
//                }
//                else if (isBird(fixA) && isBlock(fixB)){
//                    HandleBlockHit((Block) fixB.getBody().getUserData());
//                    bodiesToDestroy.add(fixB.getBody());
//                }
//            }
//
//            @Override
//            public void endContact(Contact contact) {}
//
//            @Override
//            public void preSolve(Contact contact, Manifold oldManifold) {}
//
//            @Override
//            public void postSolve(Contact contact, ContactImpulse impulse){}
//        });

    }
    @Override
    public void show() {
        world.setContactListener(new ListenerClass());
    }



    private boolean isBird(Fixture fixture){
        return fixture.getBody().getUserData() instanceof Bird;
    }

    private boolean isPig(Fixture fixture){
        return fixture.getBody().getUserData() instanceof Pig;
    }

    private boolean isBlock(Fixture fixture){
        return fixture.getBody().getUserData() instanceof Block;
    }

    private void HandleBlockHit(Block block) {
        block.handleBlockHit();
    }

    private void HandlePigHit(Pig pig) {
        pig.handlePigHit();
    }





    @Override
    public void render(float v) {
        touchPosition.set(Gdx.input.getX(), Gdx.input.getY());
        viewport.unproject(touchPosition);
        float maxDragDistance=1.5f;
        Vector2 birdInitialPosition=new Vector2(2.2f, 3.2f);
        if (Gdx.input.isTouched()) {
            if (redBird.getIsDragged() || (touchPosition.dst(birdInitialPosition) < 1.0f)) { // Start dragging if touch is near the bird
                redBird.setIsDragged(true);
                Vector2 dragVector = touchPosition.cpy().sub(birdInitialPosition);
                if (dragVector.len() > maxDragDistance){
                    dragVector.setLength(maxDragDistance);
                }
                redBird.getBody().setTransform(birdInitialPosition.cpy().add(dragVector), 0);
            }
        }
        if(!Gdx.input.isTouched() && redBird.getIsDragged()){
//            Vector2 launchVelocity = new Vector2(catapultposition).sub(redBird.getPosition()).scl(5.0f);
//            redBird.getBody().setLinearVelocity(launchVelocity);
            redBird.launch();
            redBird.setIsDragged(false);
        }

//        if (redBird.getIsDragged()) {
//            shapeRenderer.setProjectionMatrix(viewport.getCamera().combined);
//            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//            shapeRenderer.setColor(Color.WHITE);
//
//            Vector2 velocity = birdInitialPosition.cpy().sub(touchPosition).scl(launchMultiplier);
//            Vector2 position = birdInitialPosition.cpy();
//
//            for (int i = 0; i < 100; i++) {
//                position.add(velocity.cpy().scl(1 / 60f));
//                velocity.add(0, world.getGravity().y * (1 / 60f));
//                shapeRenderer.circle(position.x, position.y, 1);
//            }
//
//            shapeRenderer.end();
//        }

//        if(touchPosition.x>2.2f&&touchPosition.x<3.2f&&touchPosition.y>3.2f&&touchPosition.y<4.2f){
//            if(Gdx.input.isTouched()){
//                redBird.launch();
//            }
//        }
//        if(Gdx.input.isTouched() && isBirdDragged){
//            Vector2 touchPosition = viewport.unproject(new Vector2(Gdx.input.getX(), Gdx.input.getY()));
//            redBird.getBody().setTransform(touchPosition, 0);
//        }

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


        world.step(1/60f, 6, 2);


        batch.setProjectionMatrix(viewport.getCamera().combined);

        batch.begin();
        batch.draw(background, 0, 0, viewport.getWorldWidth(), viewport.getWorldHeight());
        catapult.draw(batch, 2, 2, 1.5f, 2);
        redBird.draw(batch, redBird.getBody().getPosition().x-0.5f, redBird.getBody().getPosition().y-0.5f, 1, 1);

//        redBird.draw(batch, redBird.getTexture());
        yellowBird.draw(batch, yellowBird.getBody().getPosition().x-0.5f, yellowBird.getBody().getPosition().y-0.5f, 1, 1);
        blackBird.draw(batch, blackBird.getBody().getPosition().x-0.5f, blackBird.getBody().getPosition().y-0.5f, 1, 1);
        blueBlock1.draw(batch, blueBlock1.getBody().getPosition().x-0.5f, blueBlock1.getBody().getPosition().y-0.5f, 1, 1);
        blueBlock2.draw(batch, blueBlock2.getBody().getPosition().x-0.5f, blueBlock2.getBody().getPosition().y-0.5f, 1, 1);
        blueBlock3.draw(batch, blueBlock3.getBody().getPosition().x-0.5f, blueBlock3.getBody().getPosition().y-0.5f, 1, 1);
        brownBlock1.draw(batch, brownBlock1.getBody().getPosition().x-0.5f, brownBlock1.getBody().getPosition().y-0.5f, 1, 1);
        brownBlock2.draw(batch, brownBlock2.getBody().getPosition().x-0.5f, brownBlock2.getBody().getPosition().y-0.5f, 1, 1);
        brownBlock3.draw(batch, brownBlock3.getBody().getPosition().x-0.5f, brownBlock3.getBody().getPosition().y-0.5f, 1, 1);
        greyBlock1.draw(batch, greyBlock1.getBody().getPosition().x-0.5f, greyBlock1.getBody().getPosition().y-0.5f, 1, 1);
        greyBlock2.draw(batch, greyBlock2.getBody().getPosition().x-0.5f, greyBlock2.getBody().getPosition().y-0.5f, 1, 1);
        chiefPig.draw(batch, chiefPig.getBody().getPosition().x - 0.5f, chiefPig.getBody().getPosition().y - 0.5f, 1, 1);
        pig.draw(batch, pig.getBody().getPosition().x - 0.5f, pig.getBody().getPosition().y - 0.5f, 1, 1);
        kingPig.draw(batch, kingPig.getBody().getPosition().x - 0.5f, kingPig.getBody().getPosition().y - 0.5f, 1, 1);
        batch.draw(pause_button, 0.2f, 7, 2, 2);
        batch.draw(redDummy, 13.8f, 0.1f, 1, 1);
        batch.draw(greenDummy, 14.9f, 0.1f, 1, 1);

        for (Body body : bodiesToDestroy) {
            world.destroyBody(body);
        }
        bodiesToDestroy.clear();
        batch.end();

//        shapeRenderer.setProjectionMatrix(viewport.getCamera().combined);
//        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//        shapeRenderer.setColor(Color.RED);
//        Vector2 velocity = birdInitialPosition.cpy().sub(touchPosition).scl(launchMultiplier);
//        Vector2 position = birdInitialPosition.cpy();
//        for (int i = 0; i < 100; i++) {
//            position.add(velocity.scl(1 / 60f));
//            velocity.add(0, world.getGravity().y * (1 / 60f));
//            shapeRenderer.circle(position.x, position.y, 0.1f);
//        }
//        shapeRenderer.end();
//        for (Body body : bodiesToDestroy) {
//            if (body.getUserData() instanceof BasePig) {
//                BasPig pig = (Pig) body.getUserData();
//                pig.dispose();
//            }
//            world.destroyBody(body);
//        }
        bodiesToDestroy.clear();
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
        background.dispose();
        pause_button.dispose();
        redDummy.dispose();
        greenDummy.dispose();
        batch.dispose();
        shapeRenderer.dispose();
        debugRenderer.dispose();
        world.dispose();
    }
}
