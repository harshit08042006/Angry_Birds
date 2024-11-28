package io.github.AngryBird;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GamePlayScreenTest2 {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testHealth() {
        BasePig pig = new BasePig(5);
        pig.handlePigHit(3);
        assertEquals(2, pig.getHealth());
    }
}
