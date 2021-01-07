package com.game.rps.engine;

import com.game.rps.model.GameResult;
import com.game.rps.model.RoundResult;
import com.game.rps.model.Statistics;
import com.game.rps.uix.UserInterface;
import com.game.rps.model.GameDefinition;

public final class Game {
    private final UserInterface userInterface;
    private final Statistics statistics;
    private GameDefinition definition;

    public Game(final UserInterface userInterface) {
        this.userInterface = userInterface;
        this.statistics = new Statistics();
    }

    public GameResult start() {
        userInterface.printMenu();
        definition = getGameDefinition();
        RoundResult result = RoundResult.DRAW;
        while (shouldPlay(definition, result)) {
            result = new Round(definition, statistics, userInterface).play();
        }
        userInterface.informGame(definition, statistics);
        return (result == RoundResult.NEW) ? GameResult.NEXT : GameResult.END;
    }

    public String getUsername() {
        return definition.getUserName();
    }

    private boolean shouldPlay(GameDefinition definition, RoundResult result) {
        if (result == RoundResult.EXIT) return gameConfirm(definition, userInterface.confirmExit());
        if (result == RoundResult.NEW) return gameConfirm(definition, userInterface.confirmNewGame());
        return statistics.hasNextRound(definition.getRounds());
    }

    private boolean gameConfirm(GameDefinition definition, boolean confirm) {
        return (!confirm) && statistics.hasNextRound(definition.getRounds());
    }

    private GameDefinition getGameDefinition() {
        String userName = userInterface.getUserName();
        int roundCount = userInterface.getRoundCount();
        return new GameDefinition(userName, roundCount);
    }
}
