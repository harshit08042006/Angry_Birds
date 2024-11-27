package io.github.AngryBird;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GamePlayScreenTest {

    private GamePlayScreen gamePlayScreen;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testPigHealthInitialization() {
        Bird bird = new Bird();
        assertEquals("Bird", bird.getName());
    }
}
