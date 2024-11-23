package io.github.AngryBird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.*;

public abstract class BasePig {
    private int health;
    private float x;
    private float y;
    private Body body;
    private Texture texture;
    public BasePig(World world, int health, float x, float y) {
        this.health = health;
        this.x = x;
        this.y = y;
        createPigBody(world, x, y);
        body.setUserData(this);
    }

    void createPigBody(World world, float x, float y)
    {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(x-0.5f, y-0.5f);
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
    public void reduceHealth(int damage)
    {
        health-=damage;
    }
    public boolean isDead()
    {
        if(health<=0)
            return true;
        else
            return false;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getHealth() {return health;}
    public float getX() {return x;}
    public float getY() {return y;}

    public void handlePigHit() {
        health = 0;
    }
    public Body getBody() {
        return body;
    }

    public void dispose() {
        texture.dispose();
    }
}
