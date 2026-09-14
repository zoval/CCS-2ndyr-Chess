package com.ccs.chess.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BoardTest {
    @Test
    void standardBoardHasEightByEightDimensions() {
        Board board = Board.standard();

        assertEquals(8, board.width());
        assertEquals(8, board.height());
    }

    @Test
    void dimensionsMustBePositive() {
        assertThrows(IllegalArgumentException.class, () -> new Board(0, 8));
    }
}
