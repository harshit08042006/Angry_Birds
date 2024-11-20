package io.github.AngryBird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.*;

public abstract class BasePig {
    private int health;
    private int x;
    private int y;
    private Body body;
    private Texture texture;
    public BasePig(int health, int x, int y) {
        this.health = health;
        this.x = x;
        this.y = y;
    }

    void CreatePigBody(World world, float x, float y)
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
    public int getX() {return x;}
    public int getY() {return y;}
}
