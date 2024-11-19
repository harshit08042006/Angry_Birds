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

    public Bird(World world, float x, float y, int impact, float speed, String texturepath) {
        this.position = new Vector2(x, y);
        this.velocity = new Vector2(0, 0);
        this.speed = speed;
        this.impact = impact;
        this.launched = false;
        this.texture = new Texture(texturepath);
        createBirdBody(world, x, y);
    }
    void createBirdBody(World world, float x, float y)
    {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(x, y);
        body = world.createBody(bodyDef);
        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(0.5f);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circleShape;
        fixtureDef.density = 1f;
        fixtureDef.friction = 0f;
        fixtureDef.restitution = 0.5f;
        Fixture fixture = body.createFixture(fixtureDef);
        circleShape.dispose();
    }

    public void setPosition(float x, float y) {
        position.set(x, y);
    }

    public Vector2 getPosition(){
        return position;
    }

    public static void launch(Vector2 launchVelocity){
        velocity.set(launchVelocity.scl(speed));
        launched = true;
    }
    public void launch()//I will improve the function just to check everything is working or not
    {
        body.setType(BodyDef.BodyType.DynamicBody);
        body.applyLinearImpulse(1f, 0, position.x, position.y, true);
    }

    public void draw(SpriteBatch batch, Texture texture){
        batch.draw(texture, position.x, position.y, 1, 1);
    }

    public void update_vel(float deltatime){
        if (launched){
            velocity.y = velocity.y - 9.8f*deltatime;
            position.add(velocity.x*deltatime, velocity.y*deltatime);
        }
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
}
