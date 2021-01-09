package com.game.rps.strategy;

import com.game.rps.model.Move;

import java.util.Random;

public final class EnemyStrategy implements Strategy {
    private static final Random RANDOM = new Random();

    @Override
    public Move getMove() {
        return Move.get(RANDOM.nextInt(5));
    }
}
