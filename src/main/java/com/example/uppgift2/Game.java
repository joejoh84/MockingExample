package com.example.uppgift2;

import java.util.Arrays;

public class Game {
    private static final int GAME_FRAMES = 10;
    private static final int FRAME_ROLL_LIMIT = 2;

    private int frameCount;
    private int roll;
    private int[][] FRAME;
    private int spareBonus;
    private int spareFrame;

    public Game() {
        setupGame();
    }

    public void roll(int knockedDownPins) {
        if (frameCount >= 0) {
            FRAME[frameCount][roll] = knockedDownPins;
            if (roll++ >= FRAME_ROLL_LIMIT - 1 || knockedDownPins == 10) {
                roll = 0;
                frameCount--;
            }
        }
        if (frameCount == -1) {
            System.out.printf("Game over, your total score: %d\r", score());
            setupGame();
        }

    }

    public int score() {
        return getFramesScore();
    }

    private int getFramesScore() {
        int score = 0;
        for (int i = GAME_FRAMES - 1; i >= 0; i--) {
            score += calculateScore(i, FRAME[i][0], FRAME[i][1]);
        }
        return score;
    }

    private int calculateScore(int frameIndex, int x, int y) {
        int val = 0;
        if (frameIndex < 9) {
            if (FRAME[frameIndex + 1][0] == 10) {
                val = ((x + y) + (x + y));
            } else
                val = (FRAME[frameIndex + 1][0] + FRAME[frameIndex + 1][1] == 10) ? (x + x) + y : x + y;
        } else
            val = x + y;
        return val;
    }

    private void setupGame() {
        FRAME = new int[GAME_FRAMES][FRAME_ROLL_LIMIT];
        frameCount = GAME_FRAMES - 1;
    }
}
