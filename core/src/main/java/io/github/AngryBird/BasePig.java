package io.github.AngryBird;

public abstract class BasePig {
    private int health;
    private int x;
    private int y;
    public BasePig(int health, int x, int y) {
        this.health = health;
        this.x = x;
        this.y = y;
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
