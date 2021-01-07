package com.game.rps;

import com.game.rps.engine.GameRunner;
import com.game.rps.uix.SimpleUserInterface;

public final class RpsApplication {
    public static void main(String[] args) {
        new GameRunner(new SimpleUserInterface()).run();
    }
}
