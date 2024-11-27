package io.github.AngryBird;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class GamePlayScreenTest {
//
//
//    @Test
//    public void TestPigHealthInitialization(){
//        Main AngryBird = new Main();
//        GamePlayScreen gamePlayScreen = new GamePlayScreen(AngryBird, 1);
//
//        for (BasePig pig : gamePlayScreen.pigs){
//            if (pig instanceof ChiefPig){
//                assertEquals(2, pig.getHealth());
//            }
//        }
//
//    }
//}

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GamePlayScreenTest {

    private GamePlayScreen gamePlayScreen;

    @Before
    public void setUp() {
        // Initialize the GamePlayScreen object
        // Mock or provide any required dependencies here
        gamePlayScreen = new GamePlayScreen();
        gamePlayScreen.initializeGameEntities(); // Call your initialization method
    }

    @Test
    public void testPigHealthInitialization() {
        // Assuming pigs are stored in a List<BasePig> called "pigs" in GamePlayScreen
        for (BasePig pig : gamePlayScreen.getPigs()) { // Add a getter for pigs if it's private
            int expectedHealth = pig.getPigType() == PigType.NORMAL ? 100 : 200; // Example logic
            assertEquals("Pig health is incorrect for type: " + pig.getPigType(), expectedHealth, pig.getHealth());
        }
    }
}

