package com.mygdx.game.core.chess;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.CONFIG;
import com.mygdx.game.core.mouseStateT;
import com.mygdx.game.piece.Empty;
import com.mygdx.game.vector2i;

public class ChessInputManager  {

    mouseStateT mouseState;
    private Chess chess;

    public ChessInputManager(Chess ichess){
        chess = ichess;
        mouseState = mouseStateT.let;
    }

    private Cell mapClicktoCell(int x, int y){
        x -= CONFIG.CHESS_BOARD_X;
        y -= CONFIG.CHESS_BOARD_Y;
        x /= CONFIG.CELL_WIDTH;
        y /= CONFIG.CELL_HEIGHT;
        return chess.getBoard().getPieces()[y][x];
    }



    public void input(int x, int y){

        if(!Gdx.input.isTouched() && mouseState == mouseStateT.pressed){
            Cell currCell = mapClicktoCell(x,y);
            chess.clickCell(currCell);
            mouseState = mouseStateT.let;

        }
        /// *** gdy wcisnieto *** ////
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            mouseState = mouseStateT.pressed;
        }
    }
}
