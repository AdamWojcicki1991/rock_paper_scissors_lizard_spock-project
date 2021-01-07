package com.game.rps.uix;

import com.game.rps.model.Move;
import com.game.rps.model.GameDefinition;
import com.game.rps.model.RoundResult;
import com.game.rps.model.Statistics;

public interface UserInterface {
    void printMenu();

    void printShortMenu();

    void informRound(GameDefinition definition, Move playerMove, Move enemyMove, RoundResult result);

    void informGame(GameDefinition definition, Statistics statistics);

    void printRound(int number, GameDefinition definition, Statistics statistics);

    void printValidCharacters();

    void printErrorMessage();

    void printConfirmation(String confirmationType);

    void thankYou(String username);

    String getUserName();

    char getValidCharacter();

    int getRoundCount();

    boolean confirmExit();

    boolean confirmNewGame();
}
