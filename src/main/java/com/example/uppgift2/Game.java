package com.example.uppgift2;

public class Game {
    private static final int GAME_FRAMES = 10;
    private static final int FRAME_ROLL_LIMIT = 2;

    private int frameCount;
    private int roll;
    private int[][] FRAME;

    public Game() {
        setupGame();
    }

    public void roll(int knockedDownPins) {
        if (frameCount >= 0) {
            FRAME[frameCount][roll] = knockedDownPins;
            if (roll++ >= FRAME_ROLL_LIMIT - 1) {
                roll = 0;
                frameCount--;
            }
        }
        if (frameCount == -1) {
            System.out.printf("Game over, your total score: %d", score());
            setupGame();
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

    private void setupGame(){
        FRAME = new int[GAME_FRAMES][FRAME_ROLL_LIMIT];
        frameCount = GAME_FRAMES - 1;
    }
}
