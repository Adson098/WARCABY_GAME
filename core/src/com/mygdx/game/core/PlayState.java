package com.mygdx.game.core;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.CONFIG;
import com.mygdx.game.core.checkers.CheckersInputManager;
import com.mygdx.game.core.checkers.CheckersRenderer;
import com.mygdx.game.engine.GameState;
import com.mygdx.game.engine.GameStateManager;

public class PlayState implements GameState {
    private CheckersInputManager chessInput;
    private GameStateManager gsm;
    private CheckersRenderer renderer;
    private int TimeForPlayer;

    public PlayState(GameStateManager gsm, int itimeForPlayer) {
        this.gsm = gsm;
        TimeForPlayer = itimeForPlayer;
        renderer = new CheckersRenderer();
    }

    @Override
    public void create() {
      //  chessRenderer = new ChessRenderer();
        //chessInput = new CheckersInputManager(chessRenderer);
        //board = new Board();


    }

    @Override
    public void render() {

        renderer.render();
    }


    @Override
    public void input() {
                int clickX = Gdx.input.getX();
                int clickY =Gdx.input.getY();
                if (clickX >= CONFIG.CHESS_BOARD_X && clickX <= CONFIG.CHESS_BOARD_X + (8 * CONFIG.CELL_WIDTH)) {
                    if (clickY >= CONFIG.CHESS_BOARD_Y && clickY <= CONFIG.CHESS_BOARD_Y + (8 * CONFIG.CELL_HEIGHT)) {
                      //  chessInput.input(clickX,clickY);
                    }
                }
    }

    @Override
    public void update(double deltaTime) {
    }
    @Override
    public void dispose(){
        System.out.println("playState dispose");
    }

}