package com.ccs.chess.ui;

import com.ccs.chess.game.ChessGame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public final class ChessApplication extends Application {
    @Override
    public void start(Stage stage) {
        ChessGame game = new ChessGame();
        BorderPane root = new BorderPane(new Label(
                "CCS Chess - " + game.board().width() + "x" + game.board().height() + " board"));
        stage.setTitle("CCS Chess");
        stage.setScene(new Scene(root, 640, 480));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
