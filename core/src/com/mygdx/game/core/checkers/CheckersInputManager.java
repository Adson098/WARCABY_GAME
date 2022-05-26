package com.mygdx.game.core.checkers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.CONFIG;
import com.mygdx.game.core.mouseStateT;

public class CheckersInputManager {

    mouseStateT mouseState;
    private Checkers chess;

    public CheckersInputManager(Checkers ichess){
        chess = ichess;
        mouseState = mouseStateT.let;
    }

    private int[] mapClicktoCell(int x, int y){
        x -= CONFIG.CHESS_BOARD_X;
        y -= CONFIG.CHESS_BOARD_Y;
        x /= CONFIG.CELL_WIDTH;
        y /= CONFIG.CELL_HEIGHT;
        return new int[]{y,x};
    }



    public void input(int x, int y){

        if(!Gdx.input.isTouched() && mouseState == mouseStateT.pressed){
           // Cell currCell = mapClicktoCell(x,y);
           // chess.clickCell(currCell);
            mouseState = mouseStateT.let;

        }
        /// *** gdy wcisnieto *** ////
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            mouseState = mouseStateT.pressed;
        }
    }
}
