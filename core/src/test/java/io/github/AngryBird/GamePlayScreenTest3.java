package io.github.AngryBird;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GamePlayScreenTest3 {
    @BeforeEach
    void setUp() {
    }

    @Test
    public void testdurability() {
        Block block = new Block(3);
        assertEquals(3, block.getDurability());
    }
}
