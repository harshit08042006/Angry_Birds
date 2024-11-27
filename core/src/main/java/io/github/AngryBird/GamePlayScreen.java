package io.github.AngryBird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


public class GamePlayScreen implements Screen {
    int current_bird_index;
    public LinkedHashMap<Body, Vector2> bodiesToMove=new LinkedHashMap<>();
    public ArrayList<Block> blocks=new ArrayList<>();
    public ArrayList<BasePig> pigs=new ArrayList<>();
    public ArrayList<Bird> birds=new ArrayList<>();
    public ArrayList<Body> bodiesToDestroy = new ArrayList<>();
    private ListenerClass listener;
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
    private BlueBlock blueBlock4;
    private BlueBlock blueBlock5;
    private BlueBlock blueBlock6;
    private BrownBlock brownBlock1;
    private BrownBlock brownBlock2;
    private BrownBlock brownBlock3;
    private BrownBlock brownBlock4;
    private GreyBlock greyBlock1;
    private GreyBlock greyBlock2;
    private Texture redDummy;
    private Texture greenDummy;
    private Main angryBird;
    private SpriteBatch batch;
    private FitViewport viewport;
    private Vector2 catapultposition;
    private Vector2 touchPosition;
    private float launchMultiplier;
    private World world;
    private Box2DDebugRenderer debugRenderer;
    private ShapeRenderer shapeRenderer;
    private int level;
    void setUpLevel1()
    {
        world=new World(new Vector2(0, -9.8f), true);
        //world.setContactListener(listener);
        debugRenderer = new Box2DDebugRenderer();
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        viewport=new FitViewport(16, 9);
        background = new Texture("angryBirdGameBackground1.jpg");
        redBird = new RedBird(world, 2.2f, 3.2f);
        blackBird = new BlackBird(world, 0.1f, 2);
        yellowBird = new YellowBird(world, 1, 2);
        catapult = new Catapult();
        pig = new Pig(world, 1, 14, 3.9f);
        chiefPig = new ChiefPig(world, 2, 12, 4.9f);
//        kingPig = new KingPig(world, 3, 10, 3.9f);
        blueBlock1 = new BlueBlock(world, 12, 3, 1);
        blueBlock2 = new BlueBlock(world, 12, 4, 1);
        brownBlock1 = new BrownBlock(world, 14, 3, 2);
//        greyBlock1 = new GreyBlock(world, 10, 3, 3);
        birds.add(redBird);
        birds.add(yellowBird);
        birds.add(blackBird);
        blocks.add(blueBlock1);
        blocks.add(blueBlock2);
//        blocks.add(greyBlock1);
        blocks.add(brownBlock1);
        pigs.add(pig);
        pigs.add(chiefPig);
//        pigs.add(kingPig);
        redDummy=new Texture("redDummy.png");
        greenDummy=new Texture("greenDummy.png");
        pause_button = new Texture("pause_button_blue.png");
        touchPosition = new Vector2();
        catapultposition = new Vector2(2, 2);
        createGroundBody();
        createRightWall();
        createLeftWall();
        createCeiling();
        launchMultiplier = 5.0f;
    }
    void setUpLevel2()
    {
        world=new World(new Vector2(0, -9.8f), true);
        //world.setContactListener(listener);
        debugRenderer = new Box2DDebugRenderer();
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        viewport=new FitViewport(16, 9);
        background = new Texture("angryBirdGameBackground1.jpg");
        redBird = new RedBird(world, 2.2f, 3.2f);
        blackBird = new BlackBird(world, 0.1f, 2);
        yellowBird = new YellowBird(world, 1, 2);
        catapult = new Catapult();
        pig = new Pig(world, 1, 10, 6.9f);
        chiefPig = new ChiefPig(world, 2, 12, 7.9f);
        kingPig = new KingPig(world, 3, 14, 3.9f);
        blueBlock1 = new BlueBlock(world, 12, 3, 1);
        blueBlock2 = new BlueBlock(world, 12, 4, 1);
        blueBlock3 = new BlueBlock(world, 12, 5, 1);
        blueBlock4 = new BlueBlock(world, 12, 6, 1);
        blueBlock5 = new BlueBlock(world, 12, 7, 1);
        brownBlock1 = new BrownBlock(world, 10, 3, 2);
        brownBlock2 = new BrownBlock(world, 10, 4, 2);
        brownBlock3 = new BrownBlock(world, 10, 5, 2);
        brownBlock4 = new BrownBlock(world, 10, 6, 2);
        greyBlock1 = new GreyBlock(world, 14, 3, 3);
        birds.add(redBird);
        birds.add(yellowBird);
        birds.add(blackBird);
        pigs.add(pig);
        pigs.add(chiefPig);
        pigs.add(kingPig);
        blocks.add(blueBlock1);
        blocks.add(blueBlock2);
        blocks.add(blueBlock3);
        blocks.add(blueBlock4);
        blocks.add(blueBlock5);
        blocks.add(brownBlock1);
        blocks.add(brownBlock2);
        blocks.add(brownBlock3);
        blocks.add(brownBlock4);
        blocks.add(greyBlock1);
        redDummy=new Texture("redDummy.png");
        greenDummy=new Texture("greenDummy.png");
        pause_button = new Texture("pause_button_blue.png");
        touchPosition = new Vector2();
        catapultposition = new Vector2(2, 2);
        createGroundBody();
        createRightWall();
        createLeftWall();
        createCeiling();
        launchMultiplier = 5.0f;
        current_bird_index = 0;
    }
    public void setUpLevel3()
    {
        world=new World(new Vector2(0, -9.8f), true);
        debugRenderer = new Box2DDebugRenderer();
        shapeRenderer = new ShapeRenderer();
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
        birds.add(redBird);
        birds.add(yellowBird);
        birds.add(blackBird);
        pigs.add(pig);
        pigs.add(chiefPig);
        pigs.add(kingPig);
        blocks.add(blueBlock1);
        blocks.add(blueBlock2);
        blocks.add(blueBlock3);
        blocks.add(brownBlock1);
        blocks.add(brownBlock2);
        blocks.add(brownBlock3);
        blocks.add(greyBlock1);
        blocks.add(greyBlock2);
        redDummy=new Texture("redDummy.png");
        greenDummy=new Texture("greenDummy.png");
        pause_button = new Texture("pause_button_blue.png");
        touchPosition = new Vector2();
        catapultposition = new Vector2(2, 2);
        createGroundBody();
        createRightWall();
        createLeftWall();
        createCeiling();
        launchMultiplier = 5.0f;
    }
    public void createGroundBody()
    {
        BodyDef groundBodyDef = new BodyDef();
        groundBodyDef.position.set(new Vector2(8, 1));
        Body groundBody = world.createBody(groundBodyDef);
        PolygonShape groundBox = new PolygonShape();
        groundBox.setAsBox(8, 1);
        groundBody.createFixture(groundBox, 0.0f);
        groundBody.setUserData("ground");
        groundBox.dispose();
    }
    public void createRightWall()
    {
        BodyDef wallBodyDef = new BodyDef();
        wallBodyDef.position.set(new Vector2(16+0.5f, 4.5f));
        Body wallBody = world.createBody(wallBodyDef);
        PolygonShape wallBox = new PolygonShape();
        wallBox.setAsBox(0.5f, 4.5f);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = wallBox;
        fixtureDef.density = 1f;
        fixtureDef.friction = 0f;
        fixtureDef.restitution = 0.0f;
        Fixture fixture = wallBody.createFixture(fixtureDef);
        wallBody.setUserData("ground");
        wallBox.dispose();
    }
    public void createLeftWall()
    {
        BodyDef wallBodyDef = new BodyDef();
        wallBodyDef.position.set(new Vector2(-0.5f, 4.5f));
        Body wallBody = world.createBody(wallBodyDef);
        PolygonShape wallBox = new PolygonShape();
        wallBox.setAsBox(0.5f, 4.5f);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = wallBox;
        fixtureDef.density = 1f;
        fixtureDef.friction = 0f;
        fixtureDef.restitution = 0.0f;
        Fixture fixture = wallBody.createFixture(fixtureDef);
        wallBody.setUserData("wall");
        wallBox.dispose();
    }
    public void createCeiling()
    {
        BodyDef groundBodyDef = new BodyDef();
        groundBodyDef.position.set(new Vector2(8, 9f+0.5f));
        Body groundBody = world.createBody(groundBodyDef);
        PolygonShape groundBox = new PolygonShape();
        groundBox.setAsBox(8, 0.5f);
        groundBody.createFixture(groundBox, 0.0f);
        groundBody.setUserData("ceiling");
        groundBox.dispose();
    }
    private boolean allPigsDefeated() {
        for (BasePig pig : pigs) {
            if (pig.getHealth() > 0) {
                return false;
            }
        }
        return true;
    }

    private GameState saveCurrentGameState() {
        GameState gameState = new GameState();
        gameState.BirdStates = new ArrayList<>();
        gameState.PigStates = new ArrayList<>();
        gameState.BlockStates = new ArrayList<>();

        for (Bird bird : birds){
            BirdState birdState = new BirdState();
            birdState.x = bird.getBody().getPosition().x;
            birdState.y = bird.getBody().getPosition().y;
            birdState.velocityX = bird.getBody().getLinearVelocity().x;
            birdState.velocityY = bird.getBody().getLinearVelocity().y;
            birdState.impact = bird.getImpact();
            gameState.BirdStates.add(birdState);
        }

        for(BasePig pig : pigs){
            PigState pigstate = new PigState();
            pigstate.x = pig.getBody().getPosition().x;
            pigstate.y = pig.getBody().getPosition().y;
            pigstate.health = pig.getHealth();
            pigstate.Type = pig.getPigType();
            gameState.PigStates.add(pigstate);
        }

        for (Block block : blocks){
            BlockState blockstate = new BlockState();
            blockstate.x = block.getBody().getPosition().x;
            blockstate.y = block.getBody().getPosition().y;
            blockstate.Type = block.getBlockType();
            blockstate.durability = block.getDurability();
            gameState.BlockStates.add(blockstate);
        }
        gameState.level = level;
        return gameState;
    }


    private void saveCurrentGame() {
        GameState gameState = new GameState();
        gameState.BirdStates = new ArrayList<>();
        gameState.PigStates = new ArrayList<>();
        gameState.BlockStates = new ArrayList<>();

        for (Bird bird : birds){
            BirdState birdState = new BirdState();
            birdState.x = bird.getBody().getPosition().x;
            birdState.y = bird.getBody().getPosition().y;
            birdState.velocityX = bird.getBody().getLinearVelocity().x;
            birdState.velocityY = bird.getBody().getLinearVelocity().y;
            birdState.impact = bird.getImpact();
            gameState.BirdStates.add(birdState);
        }

        for(BasePig pig : pigs){
            PigState pigstate = new PigState();
            pigstate.x = pig.getBody().getPosition().x;
            pigstate.y = pig.getBody().getPosition().y;
            pigstate.health = pig.getHealth();
            pigstate.Type = pig.getPigType();
            gameState.PigStates.add(pigstate);
        }

        for (Block block : blocks){
            BlockState blockstate = new BlockState();
            blockstate.x = block.getBody().getPosition().x;
            blockstate.y = block.getBody().getPosition().y;
            blockstate.Type = block.getBlockType();
            blockstate.durability = block.getDurability();
            gameState.BlockStates.add(blockstate);
        }

        gameState.level = level;
        System.out.println("Current level: " + level);
        String filename = "savegame" + level + ".dat";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(gameState);
            System.out.println("Game saved successfully to " + filename + "!");
        } catch (IOException e) {
            System.err.println("Failed to save game: " + e.getMessage());
        }

    }

    public void restoreSavedGame(GameState gameState) {
        world.setContactListener(new ListenerClass(this));
        if (gameState != null) {
            birds.clear();
            for (BirdState birdState : gameState.BirdStates) {
                if (birdState.impact == 1) {
                    RedBird redBird1 = new RedBird(world, birdState.x, birdState.y);
                    redBird1.getBody().setTransform(birdState.x, birdState.y, 0);
                    redBird1.getBody().setLinearVelocity(birdState.velocityX, birdState.velocityY);
                    birds.add(redBird1);
                }
                else if (birdState.impact == 2){
                    YellowBird yellowBird1 = new YellowBird(world, birdState.x, birdState.y);
                    yellowBird1.getBody().setTransform(birdState.x, birdState.y, 0);
                    yellowBird1.getBody().setLinearVelocity(birdState.velocityX, birdState.velocityY);
                    birds.add(yellowBird1);
                }
                else {
                    BlackBird blackBird1 = new BlackBird(world, birdState.x, birdState.y);
                    blackBird1.getBody().setTransform(birdState.x, birdState.y, 0);
                    blackBird1.getBody().setLinearVelocity(birdState.velocityX, birdState.velocityY);
                    birds.add(blackBird1);
                }
            }



            pigs.clear();
            for (PigState pigState : gameState.PigStates) {
                if (pigState.Type.equals("ChiefPig")){
                    if (pigState.health>0) {
                        ChiefPig chiefPig1 = new ChiefPig(world, pigState.health, pigState.x, pigState.y);
                        chiefPig1.getBody().setTransform(pigState.x, pigState.y, 0);
                        chiefPig1.setHealth(pigState.health);
                        pigs.add(chiefPig1);
                    }
                }
                else if (pigState.Type.equals("Pig")){
                    if (pigState.health>0) {
                        Pig pig1 = new Pig(world, pigState.health, pigState.x, pigState.y);
                        pig1.getBody().setTransform(pigState.x, pigState.y, 0);
                        pig1.setHealth(pigState.health);
                        pigs.add(pig1);
                    }
                }
                else {
                    if (pigState.health>0) {
                        KingPig kingPig1 = new KingPig(world, pigState.health, pigState.x, pigState.y);
                        kingPig1.getBody().setTransform(pigState.x, pigState.y, 0);
                        kingPig1.setHealth(pigState.health);
                        pigs.add(kingPig1);
                    }
                }
            }

            blocks.clear();
            for(BlockState blockstate : gameState.BlockStates){
                if (blockstate.Type.equals("BlueBlock")) {
                    if (blockstate.durability>0) {
                        BlueBlock blueBlock = new BlueBlock(world, blockstate.x, blockstate.y, blockstate.durability);
                        blueBlock.getBody().setTransform(blockstate.x, blockstate.y, 0);
                        blocks.add(blueBlock);
                    }
                }
                else if(blockstate.Type.equals("BrownBlock")){
                    if (blockstate.durability>0) {
                        BrownBlock brownBlock = new BrownBlock(world, blockstate.x, blockstate.y, blockstate.durability);
                        brownBlock.getBody().setTransform(blockstate.x, blockstate.y, 0);
                        blocks.add(brownBlock);
                    }
                }
                else {
                    if(blockstate.durability>0) {
                        GreyBlock greyBlock = new GreyBlock(world, blockstate.x, blockstate.y, blockstate.durability);
                        greyBlock.getBody().setTransform(blockstate.x, blockstate.y, 0);
                        blocks.add(greyBlock);
                    }
                }
            }


        }

        else {
            System.out.println("Gamestate is null");
        }
    }


    public GamePlayScreen(Main angryBird, int level) {
        listener=new ListenerClass(this);
        this.angryBird=angryBird;
        this.level = level;
        if(level==1)
        {
            setUpLevel1();
        }
        if(level==2)
        {
            setUpLevel2();
        }
        if(level==3)
        {
            setUpLevel3();
        }
    }

    public GamePlayScreen(Main angryBird, GameState gameState){
        this.angryBird = angryBird;
        this.world = new World(new Vector2(0, -9.8f), true);
        this.viewport=new FitViewport(16, 9);
        this.touchPosition = new Vector2();
        batch = new SpriteBatch();
        catapult = new Catapult();
        debugRenderer = new Box2DDebugRenderer();
        shapeRenderer = new ShapeRenderer();
        background = new Texture("angryBirdGameBackground1.jpg");
        this.level = gameState.level;
        launchMultiplier = 5.0f;

        listener=new ListenerClass(this);
        createGroundBody();

        redDummy=new Texture("redDummy.png");
        greenDummy=new Texture("greenDummy.png");
        pause_button = new Texture("pause_button_blue.png");
        catapultposition = new Vector2(2, 2);

        if (gameState != null) {
            restoreSavedGame(gameState);
        } else {
            angryBird.setScreen(new New_Load_GameScreen(angryBird));
        }
    }

    public void drawTrajectory(Vector2 initialPosition, Vector2 initialVelocity, float timeStep, int numSteps) {
        shapeRenderer.setProjectionMatrix(viewport.getCamera().combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.BLACK);
        float g = world.getGravity().y;

        for (int i = 0; i < numSteps; i++) {
            float t = i * timeStep;
            float x = initialPosition.x + initialVelocity.x * t;
            float y = initialPosition.y + initialVelocity.y * t + 0.5f * g * t * t;
            shapeRenderer.circle(x, y, 5f);
        }

        shapeRenderer.end();
    }
    @Override
    public void show() {
        world.setContactListener(listener);
    }
    @Override
    public void render(float v) {



        for(Map.Entry<Body, Vector2> i: bodiesToMove.entrySet())
        {
            i.getKey().setTransform(i.getValue().x, i.getValue().y, 0);
        }
        bodiesToMove.clear();
        if(birds.isEmpty()&& !allPigsDefeated())
        {
            angryBird.setScreen(new LoseScreen(angryBird));
        }
        touchPosition.set(Gdx.input.getX(), Gdx.input.getY());
        viewport.unproject(touchPosition);
        float maxDragDistance=1.5f;
        Vector2 birdInitialPosition=new Vector2(2.2f, 3.2f);
        if (Gdx.input.isTouched()) {
            if (birds.get(0).getIsDragged() || (touchPosition.dst(birdInitialPosition) < 1.0f)) { // Start dragging if touch is near the bird
                birds.get(0).setIsDragged(true);
                Vector2 dragVector = touchPosition.cpy().sub(birdInitialPosition);
                if (dragVector.len() > maxDragDistance){
                    dragVector.setLength(maxDragDistance);
                }
                Vector2 launchVector = birdInitialPosition.cpy().sub(birds.get(0).getBody().getPosition());
                float launchSpeed = Math.min(launchVector.len() * 20.0f, 30.0f);
                float launchAngle = launchVector.angleRad();
                Vector2 launchVelocity = new Vector2(
                    (float) Math.cos(launchAngle) * launchSpeed,
                    (float) Math.sin(launchAngle) * launchSpeed
                );
//                drawTrajectory(birds.get(current_bird_index).getPosition(), launchVelocity, 0.05f, 10);
                birds.get(0).getBody().setTransform(birdInitialPosition.cpy().add(dragVector), 0);
            }
        }


        if(!birds.isEmpty()) {
            if (!Gdx.input.isTouched() && birds.get(0).getIsDragged()) {

                Vector2 launchVector = birdInitialPosition.cpy().sub(birds.get(current_bird_index).getBody().getPosition());
                float launchSpeed = Math.min(launchVector.len() * 20.0f, 30.0f);
                float launchAngle = launchVector.angleRad();

                Vector2 launchVelocity = new Vector2(
                    (float) Math.cos(launchAngle) * launchSpeed,
                    (float) Math.sin(launchAngle) * launchSpeed
                );
                birds.get(0).getBody().setType(BodyDef.BodyType.DynamicBody);
                birds.get(0).getBody().setLinearVelocity(launchVelocity);
                birds.get(0).setIsDragged(false);
            }
        }


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
                GameState gameState1 = saveCurrentGameState();
                angryBird.setScreen(new PauseScreen(angryBird, gameState1));
            }
        }

        if (allPigsDefeated()) {
            angryBird.setScreen(new WinScreen(angryBird));
            return;
        }

        batch.setProjectionMatrix(viewport.getCamera().combined);

        batch.begin();
        batch.draw(background, 0, 0, viewport.getWorldWidth(), viewport.getWorldHeight());
        catapult.draw(batch, 2, 2, 1.5f, 2);
        for(Bird bird: birds)
        {
            bird.draw(batch, bird.getBody().getPosition().x-0.5f, bird.getBody().getPosition().y-0.5f, 1, 1);
        }
        for(Block block: blocks)
        {
            block.draw(batch, block.getBody().getPosition().x-0.5f, block.getBody().getPosition().y-0.5f, 1, 1);
        }
        for(BasePig pig: pigs)
        {
            pig.draw(batch, pig.getBody().getPosition().x-0.5f, pig.getBody().getPosition().y-0.5f, 1, 1);
        }
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

        debugRenderer.render(world, viewport.getCamera().combined);
        world.step(1/60f, 6, 2);
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

    }
}
