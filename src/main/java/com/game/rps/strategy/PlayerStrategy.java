package com.game.rps.strategy;

import com.game.rps.model.Move;
import com.game.rps.uix.UserInterface;

public final class PlayerStrategy implements Strategy {
    private final UserInterface userInterface;

    public PlayerStrategy(final UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Override
    public Move getMove() {
        switch (userInterface.getValidCharacter()) {
            case '1':
                return Move.ROCK;
            case '2':
                return Move.PAPER;
            case '3':
                return Move.SCISSORS;
            case '4':
                return Move.SPOCK;
            case '5':
                return Move.LIZARD;
            case 'x':
                return Move.EXIT;
            case 'n':
                return Move.NEW;
            default:
                return Move.INVALID;
        }
    }
}
