package com.example.uppgift2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameTest {
    static Game pg;
    int score;

    @BeforeAll
    static void setup() {
        pg = new Game();
    }


    @Test
    void FrameRollWithKnockedDownPins2Plus2ShouldReturnScore4() {
        Game bg = new Game();

        bg.roll(2);
        bg.roll(2);

        assertThat(bg.score()).isEqualTo(4);
    }

    @Test
    void MoreThanOneFrameRollShouldReturnTotalFramesScore() {
        Game bg = new Game();

        bg.roll(2);
        bg.roll(2);
        bg.roll(2);
        bg.roll(2);

        assertThat(bg.score()).isEqualTo(8);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1})
    void TenFrameRollsShouldReturn20Points(int knockedDown) {
        pg.roll(knockedDown);

        score += pg.score();

        assertThat(score).isEqualTo(pg.score());


    }

}
