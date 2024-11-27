package io.github.AngryBird;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import java.util.ArrayList;
import java.util.Iterator;


public class ListenerClass implements ContactListener {
    private GamePlayScreen screen;
    public ListenerClass(GamePlayScreen screen) {
        this.screen = screen;
    }
    private boolean isBird(Fixture fixture){
        return fixture.getBody().getUserData() instanceof Bird;
    }

    private boolean isPig(Fixture fixture){
        return fixture.getBody().getUserData() instanceof BasePig;
    }
    private boolean isGround(Fixture fixture){
        return fixture.getBody().getUserData() instanceof String;

    }

    private boolean isBlock(Fixture fixture){
        return fixture.getBody().getUserData() instanceof Block;
    }
    public void beginContact(Contact contact) {
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();
        if(isBird(fixB) && isGround(fixA)){
            screen.birds.remove((Bird)fixB.getBody().getUserData());
            screen.bodiesToDestroy.add(fixB.getBody());
            if(!screen.birds.isEmpty())
            {
                screen.bodiesToMove.put(screen.birds.get(0).getBody(), new Vector2(2.7f, 3.7f));//2.9f, 3.5f
            }

        }
        if(isPig(fixB) && isGround(fixA)){
            screen.bodiesToDestroy.add(fixB.getBody());
        }
        if (isBird(fixA) && isPig(fixB)) {
            int newHealth=HandlePigHit((BasePig) fixB.getBody().getUserData(), ((Bird)fixA.getBody().getUserData()).getImpact());
            if(newHealth<=0)
            {
                screen.bodiesToDestroy.add(fixB.getBody());
            }
        }
        else if (isBird(fixA) && isBlock(fixB)) {
            int newDurability=HandleBlockHit((Block) fixB.getBody().getUserData(), ((Bird)fixA.getBody().getUserData()).getImpact());
            System.out.println(newDurability);
            if(newDurability<=0) {
                ArrayList<Block>blocks=screen.blocks;
                ArrayList<BasePig> pigs=screen.pigs;
                Vector2 position=fixB.getBody().getPosition();
                blocks.remove((Block)fixB.getBody().getUserData());
                System.out.println(blocks);
                screen.bodiesToDestroy.add(fixB.getBody());
                int count=1;
                System.out.println(count);
                Iterator<Block> iterator = blocks.iterator();
                while (iterator.hasNext()) {
                    Block b = iterator.next();
                    System.out.println(b);
                    if (b.getBody().getPosition().x == position.x && b.getBody().getPosition().y > position.y) {
                        System.out.println("hi");
                        int durability = b.handleBlockHit(1);
                        System.out.println(durability);
                        if (durability <= 0) {
                            System.out.println("hi1");
                            count++;
                            iterator.remove();
                            screen.bodiesToDestroy.add(b.getBody());
                        } else {
                            System.out.println("hello");
                            screen.bodiesToMove.put(b.getBody(), new Vector2(b.getBody().getPosition().x, b.getBody().getPosition().y-count));
                        }
                    }
                }
                Iterator<BasePig> iterator1 =pigs.iterator();
                while (iterator1.hasNext()) {
                    BasePig b = iterator1.next();
                    System.out.println(b);
                    if (b.getBody().getPosition().x == position.x && b.getBody().getPosition().y > position.y) {
                            if(b.getBody().getPosition().y-count==2.5f)
                            {
                                screen.bodiesToDestroy.add(fixB.getBody());
                            }
                            else {
                                screen.bodiesToMove.put(b.getBody(), new Vector2(b.getBody().getPosition().x, b.getBody().getPosition().y - count));
                            }
                        }
                    }


            }
        }

    }
    private int HandleBlockHit(Block block, int impact) {
        return block.handleBlockHit(impact);
    }

    private int HandlePigHit(BasePig pig, int impact) {
        return pig.handlePigHit(impact);
    }
    public void endContact(Contact contact) {}

    @Override
    public void preSolve(Contact contact, Manifold manifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse contactImpulse) {

    }
}
