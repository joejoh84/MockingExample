package com.example.uppgift2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameTest {
    @Test
    void FrameRollWithKnockedDownPins2Plus2ShouldReturnScore4(){
        Game bg = new Game();

        bg.roll(2);
        bg.roll(2);

        assertThat(bg.score()).isEqualTo(4);
    }
}
