package com.mygdx.game.engine;
public interface GameState {

    void create();
    void render();
    void dispose();
    void input();
    void update(double deltaTime);
}