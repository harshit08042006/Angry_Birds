package io.github.AngryBird;

import com.badlogic.gdx.physics.box2d.*;
import io.github.AngryBird.BasePig;
import io.github.AngryBird.Bird;
import io.github.AngryBird.Block;


public class ListenerClass implements ContactListener {
    private boolean isBird(Fixture fixture){
        return fixture.getBody().getUserData() instanceof Bird;
    }

    private boolean isPig(Fixture fixture){
        return fixture.getBody().getUserData() instanceof BasePig;
    }

    private boolean isBlock(Fixture fixture){
        return fixture.getBody().getUserData() instanceof Block;
    }
    public void beginContact(Contact contact) {
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();
        if (isBird(fixA) && isPig(fixB)) {
            HandlePigHit((BasePig) fixB.getBody().getUserData());
            GamePlayScreen2.bodiesToDestroy.add(fixB.getBody());
//            GamePlayScreen.bodiesToDestroy.add(fixB.getBody());
        } else if (isBird(fixA) && isBlock(fixB)) {
            HandleBlockHit((Block) fixB.getBody().getUserData());
            GamePlayScreen2.bodiesToDestroy.add(fixB.getBody());
//            GamePlayScreen.bodiesToDestroy.add(fixB.getBody());
        }

    }
    private void HandleBlockHit(Block block) {
        block.handleBlockHit();
    }

    private void HandlePigHit(BasePig pig) {
        pig.handlePigHit();
    }
    public void endContact(Contact contact) {}

    @Override
    public void preSolve(Contact contact, Manifold manifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse contactImpulse) {

    }
}

