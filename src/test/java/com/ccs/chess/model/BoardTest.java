package com.ccs.chess.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class BoardTest {
    @Test
    void standardBoardHasEightByEightDimensions() {
        Board board = Board.standard();

        assertEquals(8, board.width());
        assertEquals(8, board.height());
    }

    @Test
    void dimensionsMustBePositive() {
       IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> new Board(0, 8)
);

assertEquals("Board dimensions must be positive", exception.getMessage());
    }
}
