package io.github.AngryBird;

import java.io.*;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class GameState implements Serializable {
    private static final long serialVersionUID = 1L;

    public ArrayList<BirdState> BirdStates;
    public ArrayList<PigState> PigStates;
    public ArrayList<BlockState> BlockStates;

    public ArrayList<Bird> Birds_Saved;
    public ArrayList<BasePig> Pigs_Saved;
    public int currentindex;
    public int level;



}
