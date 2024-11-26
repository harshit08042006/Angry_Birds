package io.github.AngryBird;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class Bird {
    private Vector2 position;
    public static Vector2 velocity;
    private static float speed;
    private int impact;
    public static boolean launched;
    private Texture texture;
    private Body body;
    private boolean isDragged;
    public Bird(World world, float x, float y, int impact, float speed, String texturepath) {
        this.position = new Vector2(x, y);
        this.velocity = new Vector2(0, 0);
        this.speed = speed;
        this.impact = impact;
        this.launched = false;
        this.texture = new Texture(texturepath);
        isDragged = false;
        createBirdBody(world, x, y);
        body.setUserData(this);
    }
    void createBirdBody(World world, float x, float y)
    {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(x+0.5f, y+0.5f);
        body = world.createBody(bodyDef);
        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(0.5f);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circleShape;
        fixtureDef.density = 1f;
        fixtureDef.friction = 0f;
        fixtureDef.restitution = 0.2f;
        Fixture fixture = body.createFixture(fixtureDef);
        circleShape.dispose();
    }

    public void setPosition(float x, float y) {
        position.set(x, y);
    }


    public static void launch(Vector2 launchVelocity){
        velocity.set(launchVelocity.scl(speed));
        launched = true;
    }
    public void launch()
    {
        body.setType(BodyDef.BodyType.DynamicBody);
        body.applyLinearImpulse(5.2f, 5.2f, body.getPosition().x, body.getPosition().y, true);
    }

    public void draw(SpriteBatch batch, float x, float y, float sizeX, float sizeY) {
    }


    public void update_vel(float deltatime){
        if (launched){
            velocity.y = velocity.y - 9.8f*deltatime;
            position.add(velocity.x*deltatime, velocity.y*deltatime);
        }
    }

    public void setIsDragged(boolean dragged)
    {
        isDragged = dragged;
    }
    public boolean getIsDragged()
    {
        return isDragged;
    }
    public Body getBody() {
        return body;
    }
    public int getImpact(){
        return impact;
    }

    public void dispose(){
        texture.dispose();
    }
    public Texture getTexture(){
        return texture;}
}
