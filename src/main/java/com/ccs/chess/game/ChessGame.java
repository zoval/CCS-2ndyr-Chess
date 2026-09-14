package com.ccs.chess.game;

import com.ccs.chess.model.Board;

/**
 * Entry point for game orchestration. Rule enforcement will be added here.
 */
public final class ChessGame {
    private final Board board;

    public ChessGame() {
        this(Board.standard());
    }

    public ChessGame(Board board) {
        this.board = board;
    }

    public Board board() {
        return board;
    }
}
