package com.ccs.chess.model;

/**
 * Immutable board dimensions and coordinates used by the game model.
 */
public record Board(int width, int height) {
    public Board {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Board dimensions must be positive");
        }
    }

    public static Board standard() {
        return new Board(8, 8);
    }
}
