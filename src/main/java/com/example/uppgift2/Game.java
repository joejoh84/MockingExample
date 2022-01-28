package com.example.uppgift2;

public class Game {
    private static final int GAME_FRAMES = 10;
    private static final int FRAME_ROLL_LIMIT = 2;

    private int frameCount;
    private int roll;
    private int[][] FRAME;

    public Game() {
        FRAME = new int[GAME_FRAMES][FRAME_ROLL_LIMIT];
        frameCount = GAME_FRAMES - 1;
    }

    public void roll(int knockedDownPins) {
        if (roll++ < FRAME_ROLL_LIMIT && frameCount > -1)
            FRAME[frameCount][roll-1] = knockedDownPins;

    }

    public int score() {
        return FRAME[frameCount][0] + FRAME[frameCount][1];
    }
}
