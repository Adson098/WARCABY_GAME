package com.mygdx.game.piece;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.core.checkers.Board;
import com.mygdx.game.core.checkers.colorT;


public class Queen extends piece {

    private Texture texture;
    private Sprite sprite;
    private colorT color;

    public Queen(colorT mcolor){
        color = mcolor;
    }

    @Override
    public int[] possibleMove(Board board, int indexPozycji) {
        return new int[0];
    }

    public colorT getColor(){
        return color;
    }

    public void dispose(){

    }

}
