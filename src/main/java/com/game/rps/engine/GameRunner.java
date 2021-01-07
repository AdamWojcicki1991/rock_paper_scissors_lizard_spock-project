package com.game.rps.engine;

import com.game.rps.model.GameResult;
import com.game.rps.uix.UserInterface;

public final class GameRunner {
    private final UserInterface userInterface;

    public GameRunner(final UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void run() {
        Game game = new Game(userInterface);
        GameResult gameResult = game.start();

        while (gameResult == GameResult.NEXT) {
            gameResult = new Game(userInterface).start();
        }
        userInterface.thankYou(game.getUsername());
    }
}
