package com.game.rps.engine;

import com.game.rps.model.Move;
import com.game.rps.model.RoundResult;

public class RoundResolver {
    public RoundResult resolve(Move playerMove, Move enemyMove) {
        if (playerMove == Move.NEW) return RoundResult.NEW;
        if (playerMove == Move.EXIT) return RoundResult.EXIT;
        if (playerMove == enemyMove) return RoundResult.DRAW;
        return ((playerMove == Move.ROCK && (enemyMove == Move.SCISSORS || enemyMove == Move.LIZARD)) ||
                (playerMove == Move.PAPER && (enemyMove == Move.ROCK || enemyMove == Move.SPOCK)) ||
                (playerMove == Move.SCISSORS && (enemyMove == Move.PAPER || enemyMove == Move.LIZARD)) ||
                (playerMove == Move.SPOCK && (enemyMove == Move.ROCK || enemyMove == Move.SCISSORS)) ||
                (playerMove == Move.LIZARD && (enemyMove == Move.PAPER || enemyMove == Move.SPOCK))) ? RoundResult.WIN : RoundResult.LOSE;
    }
}
