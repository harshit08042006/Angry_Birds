package io.github.AngryBird;

public abstract class Block {
    int x;
    int y;
    int durability;
    public Block(int x, int y, int durability) {
        this.x = x;
        this.y = y;
        this.durability = durability;
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

    public void setDurability(int durability) {
        this.durability = durability;
    }
}
