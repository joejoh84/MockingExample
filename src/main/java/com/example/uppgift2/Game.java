package com.example.uppgift2;

public class Game {
    private static final int GAME_FRAMES = 10;
    private static final int FRAME_ROLL_LIMIT = 3;

    private int frameCount;
    private int roll;
    private int[][] FRAME;

    public Game() {
        setupGame();
    }

    public void roll(int knockedDownPins) {

        handleRoll(knockedDownPins);


    }

    private void handleRoll(int knockedDownPins) {
        FRAME[frameCount][roll] = knockedDownPins;

        if (frameCount > 0) {
            if (roll++ >= FRAME_ROLL_LIMIT - 2 || knockedDownPins == 10) {
                frameCount--;
                roll = 0;
            }
        } else if (((FRAME[frameCount][0] + knockedDownPins) == 10) || FRAME[frameCount][0] == 10) {
            if (roll++ >= FRAME_ROLL_LIMIT - 1)
                roll = 0;
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
        var lastFrameBonus = FRAME[frameIndex][2];
        if (frameIndex < 9) {
            if (FRAME[frameIndex + 1][0] == 10) {
                val = ((x + y) + (x + y));
            } else {
                val = determineBonus(frameIndex, x, y, lastFrameBonus);
            }
        } else {
            val = x + y;
        }

        return val;
    }

    private int determineBonus(int frameIndex, int x, int y, int lastFrameBonus) {
        return calculateBonus(frameIndex, x, y, lastFrameBonus);
    }

    private int calculateBonus(int frameIndex, int x, int y, int lastFrameBonus) {
        int val = x + y;

        if (lastFrameBonus > 0 && x != 10 || FRAME[frameIndex + 1][0] + FRAME[frameIndex + 1][1] == 10)
            val = frameIndex == 0 ? (x + (x + lastFrameBonus) + lastFrameBonus) : (x + x) + y;

        if (x == 10) {
            val = (x + (y + lastFrameBonus)) + (y + lastFrameBonus);
        }

        return val;
    }

    private void setupGame() {
        FRAME = new int[GAME_FRAMES][FRAME_ROLL_LIMIT];
        frameCount = GAME_FRAMES - 1;
    }
}
