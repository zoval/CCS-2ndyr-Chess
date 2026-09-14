package com.ccs.chess.ai;

import com.ccs.chess.game.ChessGame;

/**
 * Boundary for computer-player strategies.
 */
public interface MoveProvider {
    void chooseMove(ChessGame game);
}
