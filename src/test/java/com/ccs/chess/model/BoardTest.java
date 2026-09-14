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
// for ronniel only, run using $env:JAVA_HOME="C:\Users\Admin\AppData\Local\jdks\jdk-25.0.2"
//& "C:\Users\Admin\.maven\maven-3.9.15\bin\mvn.cmd" javafx:run
// for other persons mvn javafx:run or mvn clean compile