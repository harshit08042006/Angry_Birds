package io.github.AngryBird;


import com.badlogic.gdx.physics.box2d.*;

public abstract class Block {
    Body body;
    int x;
    int y;
    int durability;

    public Block(World world, int x, int y, int durability) {
        this.x = x;
        this.y = y;
        this.durability = durability;
        createBlockBody(world, x, y);
        body.setUserData(this);
    }
    void createBlockBody(World world, float x, float y)
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
        fixtureDef.restitution = 0.2f;
        Fixture fixture = body.createFixture(fixtureDef);
        circleShape.dispose();
    }
    public boolean isCollapsed(){
        if(durability <= 0)
            return true;
        else
            return false;
    }
    public void reduceDurability(int damage){
        durability -= damage;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDurability() {
        return durability;
    }
    public Body getBody() {
        return body;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public void handleBlockHit() {
        durability=0;
    }
}
