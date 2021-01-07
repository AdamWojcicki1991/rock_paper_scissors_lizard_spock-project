package com.game.rps.engine;

import com.game.rps.model.Move;
import com.game.rps.model.RoundResult;
import com.game.rps.model.Statistics;
import com.game.rps.uix.UserInterface;
import com.game.rps.model.GameDefinition;
import com.game.rps.strategy.EnemyStrategy;
import com.game.rps.strategy.PlayerStrategy;

public final class Round {
    private final int number;
    private final Statistics statistics;
    private final PlayerStrategy playerStrategy;
    private final EnemyStrategy enemyStrategy;
    private final RoundResolver roundResolver;
    private final UserInterface userInterface;
    private final GameDefinition definition;

    public Round(final GameDefinition definition, final Statistics statistics, final UserInterface userInterface) {
        this.number = statistics.getRounds() + 1;
        this.statistics = statistics;
        this.userInterface = userInterface;
        this.definition = definition;
        this.playerStrategy = new PlayerStrategy(userInterface);
        this.enemyStrategy = new EnemyStrategy();
        this.roundResolver = new RoundResolver();
    }

    public RoundResult play() {
        Move enemyMove = enemyStrategy.getMove();
        Move playerMove = playerStrategy.getMove();
        RoundResult result = roundResolver.resolve(playerMove, enemyMove);

        if (result != RoundResult.NEW && result != RoundResult.EXIT) {
            userInterface.informRound(definition, playerMove, enemyMove, result);
            updateStatistics(result);
            userInterface.printRound(number, definition, statistics);
        }
        return result;
    }

    private void updateStatistics(RoundResult result) {
        switch (result) {
            case WIN:
                statistics.incrementWins();
                statistics.incrementRounds();
                break;
            case LOSE:
                statistics.incrementLoses();
                statistics.incrementRounds();
                break;
            case DRAW:
                statistics.incrementDraws();
                statistics.incrementRounds();
                break;
        }
    }
}
