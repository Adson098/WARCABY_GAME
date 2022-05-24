package com.mygdx.game.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.CONFIG;
import com.mygdx.game.core.chess.Cell;
import com.mygdx.game.core.chess.Chess;
import com.mygdx.game.core.chess.ChessInputManager;
import com.mygdx.game.core.chess.ChessRenderer;
import com.mygdx.game.engine.GameState;

public class PlayState implements GameState {
    private ChessRenderer chessRenderer;
    private ChessInputManager chessInput;
    //private Board board;

    @Override
    public void create() {
        chessRenderer = new ChessRenderer();
        chessInput = new ChessInputManager(chessRenderer);
        //board = new Board();


    }

    @Override
    public void render() {
        chessRenderer.render();
    }


    @Override
    public void input() {
                int clickX = Gdx.input.getX();
                int clickY =Gdx.input.getY();
                if (clickX >= CONFIG.CHESS_BOARD_X && clickX <= CONFIG.CHESS_BOARD_X + (8 * CONFIG.CELL_WIDTH)) {
                    if (clickY >= CONFIG.CHESS_BOARD_Y && clickY <= CONFIG.CHESS_BOARD_Y + (8 * CONFIG.CELL_HEIGHT)) {
                        chessInput.input(clickX,clickY);
                    }
                }
    }

    @Override
    public void update(double deltaTime) {
    }
    @Override
    public void dispose(){
        System.out.println("playState dispose");
        chessRenderer.dispose();
    }

}