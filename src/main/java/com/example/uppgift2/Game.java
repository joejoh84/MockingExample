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
        roll = -1;
    }

    public void roll(int knockedDownPins) {
        if (frameCount >= 0) {
            if (roll++ >= FRAME_ROLL_LIMIT - 1) {
                roll = 0;
                frameCount--;
            }
            FRAME[frameCount][roll] = knockedDownPins;
        }

    }

    public int score() {
        return getFramesScore();
    }

    private int getFramesScore() {
        int score = 0;
        for (int i = GAME_FRAMES - 1; i >= 0; i--) {
            score += (FRAME[i][0] + FRAME[i][1]);
        }
        return score;
    }
}
